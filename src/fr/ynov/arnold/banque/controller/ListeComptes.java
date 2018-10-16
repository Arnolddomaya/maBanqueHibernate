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

import fr.ynov.guerny.banque.manager.ClientManager;
import fr.ynov.guerny.banque.model.Client;

@WebServlet("/comptes")
public class ListeComptes extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = (Logger) LogManager.getLogger(ListeComptes.class);
	//private static final org.apache.logging.log4j.Logger logger =  LogManager.getLogger(Client.class);

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		Client client = (Client)request.getSession().getAttribute("client");
		if (client != null) {
			logger.info("controller ListeComptes, Test client bien récupéré!");
			request.setAttribute("name", client.getName());
			request.setAttribute("accounts", client.getAccounts());
		}
		else { 
			logger.info("controller ListeComptes, Client loading fails!");
			Login.loginPath(request, response);
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/comptes.jsp");
		dispatcher.forward(request, response);
	}
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		RequestDispatcher loginDispatcher = getServletContext().getRequestDispatcher("/userLogin.jsp");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		Client client = ClientManager.loadClientByLoginAndPassword(login, password);
		if (client == null) {
			request.setAttribute("errorMsg", "login inexistant ou mdp invalid !!");
			loginDispatcher.forward(request, response);
		}
		else {
			request.setAttribute("name", client.getName());
			request.getSession().setAttribute("client", client);
			response.sendRedirect(request.getContextPath()+"/comptes");
		}
	}
}
