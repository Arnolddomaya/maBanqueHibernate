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

import fr.ynov.arnold.banque.manager.ClientManager;
import fr.ynov.arnold.banque.model.Account;
import fr.ynov.arnold.banque.model.Client;
import fr.ynov.arnold.banque.others.Jsp_path;
import fr.ynov.arnold.banque.others.Url_path;

@WebServlet(Url_path.NEW_ACCOUNT)
public class NewAccount extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1189563849922228285L;
	private static final Logger logger = (Logger) LogManager.getLogger(NewAccount.class);
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(Jsp_path.NEW_ACCOUNT);
		logger.info("Controller NewAccount, method doGet!");
		dispatcher.forward(request, response);	
	}
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		logger.info("Controller NewAccount, method doPost!");
		String label = request.getParameter("label");
		double solde = Double.parseDouble(request.getParameter("solde"));
		
		
		Account acc = new Account(label, solde);
		Client cli = (Client) request.getSession().getAttribute("client");
		cli.addToAccounts(acc);
		cli = ClientManager.updateClient(cli);
		
		request.getSession().setAttribute("client", cli);
		response.sendRedirect(request.getContextPath()+Url_path.ACCOUNT);
	}

}
