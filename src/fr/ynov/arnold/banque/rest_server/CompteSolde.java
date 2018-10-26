package fr.ynov.arnold.banque.rest_server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import fr.ynov.arnold.banque.manager.AccountManager;
import fr.ynov.arnold.banque.model.Account;
import fr.ynov.arnold.banque.others.Url_path;

@WebServlet(Url_path.SOLDE_AMOUNT)
public class CompteSolde extends HttpServlet{

	private static final Logger logger = (Logger) LogManager.getLogger(CompteSolde.class);
	private static final long serialVersionUID = -64749821244048296L;
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		logger.info("Servlet REST CompteSolde, Entry ok!");
		String msg = "";
		int compteId;
		try {
			compteId = Integer.parseInt(request.getParameter("id"));
			Account cpt = AccountManager.loadAccountById(compteId);
			msg = "{ \"id\":\""+ cpt.getId()+"\", \"solde\":\""+ cpt.getBalance()+"\" }";
			logger.info("in Try, Account found!");
		}
		catch(NumberFormatException | java.lang.NullPointerException e) {
			compteId = 0;
			msg = "No account found with this parameters!";
			logger.error("in Except, Account not found!");		
		}
		response.getWriter().println(msg);
	}
}
