package fr.ynov.arnold.banque.controller;




import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import fr.ynov.arnold.banque.manager.AccountManager;
import fr.ynov.arnold.banque.manager.ClientManager;
import fr.ynov.arnold.banque.model.Account;
import fr.ynov.arnold.banque.model.Client;
import fr.ynov.arnold.banque.model.Transaction;
import fr.ynov.arnold.banque.others.Jsp_path;
import fr.ynov.arnold.banque.others.Url_path;

@WebServlet(Url_path.TRANSACS)
public class TransactionsList extends HttpServlet{
	
	private static final long serialVersionUID = 3L;
	private static final Logger logger = (Logger) LogManager.getLogger(TransactionsList.class);
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(Jsp_path.TRANSACS);
		
		int comptId = Integer.parseInt(request.getParameter("comptId"));
		Account ac = AccountManager.loadAccountById(comptId);
		if (ac != null) {
			request.setAttribute("ac", ac);
			dispatcher.forward(request, response);
		}
		else {
			logger.info("controller TransactionsList, account loading fails!");
			Login.loginPath(request, response);
		}		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		logger.info("controller Transaction List method doPost : beginning!");
		int comptId = Integer.parseInt(request.getParameter("comptId")); 
		int	receiverId = Integer.parseInt(request.getParameter("receiverId"));
		double amount = Double.parseDouble(request.getParameter("amount"));
		String label = request.getParameter("label");
		
		Account receiver = AccountManager.loadAccountById(receiverId);
		if ( receiver == null || comptId == receiverId) {
			logger.error("Receiver account id not valid !");
			request.getSession().setAttribute("error", "Transaction impossible du compte "+ comptId+ " vers le compte "+ receiverId);
			response.sendRedirect(request.getContextPath()+Url_path.ACCOUNT);
			return;
		}
		
		if (amount <= 0) {
			
			logger.error("transaction amount not valid !");
			request.getSession().setAttribute("error", "Transaction impossible, le montant doit être supérieur à 0! ");
			response.sendRedirect(request.getContextPath()+Url_path.ACCOUNT);
			return;
		}
		//Mettre condition somme négative ou égale à zero
		
		
		Account sender = AccountManager.loadAccountById(comptId);
		
		sender.addToTransactions(new Transaction(-amount, label));
		receiver.addToTransactions(new Transaction(amount, label));
		
		AccountManager.updateAccount(sender);
		AccountManager.updateAccount(receiver);
		
		Client cli = ClientManager.loadClientById(sender.getAccountClient().getId());
		
		request.getSession().setAttribute("client", cli);
		request.getSession().setAttribute("success", "Transaction vers compte n°"+ receiverId + " bien effectué!");
		
		logger.info("Transaction creation : Success !");
		
		response.sendRedirect(request.getContextPath()+Url_path.ACCOUNT);
	}
}
