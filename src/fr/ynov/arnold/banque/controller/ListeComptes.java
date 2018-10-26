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

import fr.ynov.arnold.banque.model.Client;
import fr.ynov.arnold.banque.others.Jsp_path;
import fr.ynov.arnold.banque.others.Url_path;

@WebServlet(Url_path.ACCOUNT)
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
			response.sendRedirect(request.getContextPath()+Url_path.LOGIN);
			return;
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(Jsp_path.COMPTES);
		dispatcher.forward(request, response);
	}
}
