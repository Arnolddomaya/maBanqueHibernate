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
import fr.ynov.arnold.banque.others.Url_path;

@WebServlet(Url_path.DELETE_ACCOUNT)
public class Delete_account extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5256059245211550645L;
	private static final Logger logger = (Logger) LogManager.getLogger(Delete_account.class);
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		logger.info("Controller DeleteAccount, method doGet!");
		int  id = Integer.parseInt(request.getParameter("comptId"));
		Client cli;
		
		logger.info("compte Id :" + request.getParameter("comptId"));
		AccountManager.deleteAccount(id);
		
		cli = ClientManager.loadClientById(
				((Client)request.getSession().getAttribute("client")).getId()
				);
		request.getSession().setAttribute("client", cli);
		request.getSession().setAttribute("success", "Compte n°" + id +" bien rétirer de la liste!");
		response.sendRedirect(request.getContextPath()+Url_path.ACCOUNT);
		
	}
}
