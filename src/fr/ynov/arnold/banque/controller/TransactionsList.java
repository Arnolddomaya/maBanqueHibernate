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
import fr.ynov.arnold.banque.model.Account;
import fr.ynov.arnold.banque.model.Client;

@WebServlet("/transacs")
public class TransactionsList extends HttpServlet{
	
	private static final long serialVersionUID = 3L;
	private static final Logger logger = (Logger) LogManager.getLogger(TransactionsList.class);
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/transacs.jsp");
		
		int comptId = Integer.parseInt(request.getParameter("comptId"));
		Account ac = AccountManager.loadAccountById(comptId);
		if (ac != null) {
			request.setAttribute("libel", ac.getLibelle());
			request.setAttribute("transacs", ac.getTransactions());
			dispatcher.forward(request, response);
		}
		else {
			logger.info("controller TransactionsList, account loading fails!");
			Login.loginPath(request, response);
		}		
	}
}
