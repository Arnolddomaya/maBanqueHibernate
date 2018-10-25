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
import fr.ynov.arnold.banque.model.Client;
import fr.ynov.arnold.banque.others.Jsp_path;
import fr.ynov.arnold.banque.others.Url_path;


@WebServlet(urlPatterns= {"","/userLogin"})
public class Login extends HttpServlet{
	private static final long serialVersionUID = 2L;
	private static final Logger logger = (Logger) LogManager.getLogger(Login.class);

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(Jsp_path.LOGIN);
		logger.info("controller Login, method doGet!");
		dispatcher.forward(request, response);	
	}

	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		RequestDispatcher loginDispatcher = getServletContext().getRequestDispatcher(Jsp_path.LOGIN);
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		logger.info("controller Login, method doPost!");
		Client client = ClientManager.loadClientByLoginAndPassword(login, password);
		if (client == null) {
			request.setAttribute("errorMsg", "login inexistant ou mdp invalid !!");
			logger.info("controller Login, method doPost   Client not found");
			loginDispatcher.forward(request, response);
		}
		else {
			logger.error("Client found, client found, redirection to comptes path");
			request.getSession().setAttribute("client", client);
			//Attribuer une durée de la connexion ici fixé à 2 min
			request.getSession().setMaxInactiveInterval(2*60);
			response.sendRedirect(request.getContextPath()+Url_path.ACCOUNT);
		}
	}
	public static void loginPath(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath()+Url_path.ACCOUNT);
	}
}
