package fr.ynov.arnold.banque.rest_server;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ynov.arnold.banque.manager.AccountManager;
import fr.ynov.arnold.banque.model.Account;
import fr.ynov.arnold.banque.model.Transaction;
import fr.ynov.arnold.banque.others.Url_path;

@WebServlet(Url_path.CREATE_TRANSACS)
public class TransacCreation extends HttpServlet{

	private static final Logger logger = (Logger) LogManager.getLogger(TransacCreation.class);
	private static final long serialVersionUID = 1L;
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		logger.info("Servlet REST TransacCreation, Entry ok!");
		
		String msg = "";
		
		
		String label = request.getParameter("label");
		
		try {
			int senderId = Integer.parseInt(request.getParameter("sender")); 
			int	receiverId = Integer.parseInt(request.getParameter("receiver"));
			double amount = Double.parseDouble(request.getParameter("amount"));
			
			Account receiver = AccountManager.loadAccountById(receiverId);
			Account sender = AccountManager.loadAccountById(senderId);
			
			sender.addToTransactions(new Transaction(-amount, label));
			receiver.addToTransactions(new Transaction(amount, label));
			
			AccountManager.updateAccount(sender);
			AccountManager.updateAccount(receiver);
			
			msg = "{ \"senderId\":\""+senderId+ "\", \"receiverId\":\"" + receiverId+"\", \"amount\": \""+ amount+"\", \"label\":\""+label+ "\", \"trasactionStatus\": \"complete\"}";
		}
		catch(NumberFormatException | java.lang.NullPointerException e) {
			msg = "La transaction ne peut aboutir ! Verifiez les ids des comptes debiteur et créditeur!";
		}
		finally {
			response.getWriter().println(msg);
		}
		
	}
	
}
