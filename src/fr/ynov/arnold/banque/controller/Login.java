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
import fr.ynov.arnold.banque.others.AlertControl;
import fr.ynov.arnold.banque.others.Jsp_path;
import fr.ynov.arnold.banque.others.Url_path;


@WebServlet(urlPatterns= {"",Url_path.LOGIN})
public class Login extends HttpServlet{
	
	private static final long serialVersionUID = 2L;
	private static final Logger logger = (Logger) LogManager.getLogger(Login.class);

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(Jsp_path.LOGIN);
		logger.info("controller Login, method doGet!");
		
		request = AlertControl.sendAlert(request);
		dispatcher.forward(request, response);	
	}

	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		
		//Envoie directement sur les pages jsp, ne passe pas par les servlets.
		//RequestDispatcher loginDispatcher = getServletContext().getRequestDispatcher(request.getContextPath()+Jsp_path.LOGIN);
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		
		logger.info("controller Login, method doPost!");
		Client client = ClientManager.loadClientByLoginAndPassword(login, password);
		if (client == null) {
			request.setAttribute("errorMsg", "login inexistant ou mdp invalid !!");
			logger.info("controller Login, method doPost   Client not found");
			
			request.getSession().setAttribute("error", "Identifiant ou mot de passe inconrect ! ");
			response.sendRedirect(request.getContextPath()+Url_path.LOGIN);
		}
		else {
			logger.error("Client found, client found, redirection to comptes path");
			
			request.getSession().setAttribute("client", client);			
			request.getSession().setAttribute("success", "Indentification reussis!");
			
			
			//Attribuer une dur�e de la connexion ici fix� � 2 min
			request.getSession().setMaxInactiveInterval(2*60);
			response.sendRedirect(request.getContextPath()+Url_path.ACCOUNT);
		}
	}
	public static void loginPath(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath()+Url_path.ACCOUNT);
	}
}
