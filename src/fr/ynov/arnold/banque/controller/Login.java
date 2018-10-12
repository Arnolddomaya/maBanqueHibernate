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


@WebServlet("/userLogin")
public class Login extends HttpServlet{
	private static final long serialVersionUID = 2L;
	private static final Logger logger = (Logger) LogManager.getLogger(Client.class);

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/userLogin.jsp");
		dispatcher.forward(request, response);
	}

	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		RequestDispatcher loginDispatcher = getServletContext().getRequestDispatcher("/userLogin.jsp");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		logger.info("Dans doPost()");
		Client client = ClientManager.loadClientByLoginAndPassword(login, password);
		if (client == null) {
			request.setAttribute("errorMsg", "login inexistant ou mdp invalid !!");
			loginDispatcher.forward(request, response);
		}
		else {
			request.getSession().setAttribute("client", client);
			response.sendRedirect(request.getContextPath()+"/comptes");
		}
	}
}