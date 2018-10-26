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
import fr.ynov.arnold.banque.validations.PasswordValidations;

@WebServlet(Url_path.CHANGE_PASS)
public class ChangePassword extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2101873765037511769L;
	private static final Logger logger = (Logger) LogManager.getLogger(ChangePassword.class);

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(Jsp_path.CHANGE_PASS);
		logger.info("Controller ChangePassword, method doGet!");
		dispatcher.forward(request, response);	
	}
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		logger.info("Controller ChangePassword, method doPost!");
		Client cli = (Client) request.getSession().getAttribute("client");
		String pass =request.getParameter("pass"), confirm = request.getParameter("confirm"), oldPass = request.getParameter("oldPass");
		if (cli.getPassword().equals(confirm) && PasswordValidations.check(pass, confirm)) {
			
		}
	}
}
