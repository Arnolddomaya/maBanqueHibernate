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
		String pass = request.getParameter("pass"), confirm = request.getParameter("confirm"), oldPass = request.getParameter("oldPass");
		
		//logger.info("oldPass: "+ oldPass + ", pass: "+ pass + ", confirm :"+confirm);
		
		if (!cli.getPassword().equals(oldPass)) {
			logger.info("Ancien mot de pass incorrect !!!");
			AlertControl.setErrorAlertAndRedirect(request, response, "Ancien Mot de passe inconrect! ", Url_path.CHANGE_PASS);
			return;
		}
		if (!PasswordValidations.goodLength(pass)) {
			logger.info("Nouveau mot de pass trop court  !!!");
			AlertControl.setErrorAlertAndRedirect(request, response, "le nouveau mot de pass trop court, taille >= 8 ! ", Url_path.CHANGE_PASS);
			return;
		}
		if (!PasswordValidations.majExists(pass)) {
			logger.info("Nouveau mot de pass ne contient pas de majuscules  !!!");
			AlertControl.setErrorAlertAndRedirect(request, response, "Le nouveau mot de passe doit contenir une lettre majuscule ! ", Url_path.CHANGE_PASS);
			return;
		}
		
		if (!PasswordValidations.numberExists(pass)) {
			logger.info("Nouveau mot de pass ne contient pas de nombre  !!!");
			AlertControl.setErrorAlertAndRedirect(request, response, "Le nouveau mot de passe doit contenir un nombre ! ", Url_path.CHANGE_PASS);
			return;
		}
		if (!PasswordValidations.accentExists(pass)) {
			logger.info("Nouveau mot de pass ne contient pas d'accentué  !!!");
			AlertControl.setErrorAlertAndRedirect(request, response, "Le nouveau mot de passe doit contenir une lettre accentué dans 'éèçàùîôêâ' ! ", Url_path.CHANGE_PASS);
			return;
		}
		
		if (!PasswordValidations.passMatchConfirm(pass, confirm)) {
			logger.info("Nouveau mot de pass différent de sa confirmation  !!!");
			AlertControl.setErrorAlertAndRedirect(request, response, "Le nouveau mot de passe et sa confirmation doivent être pareils ", Url_path.CHANGE_PASS);
			return;
		}
		
		logger.info("Checkings ok");	
		if	(PasswordValidations.check(pass, confirm)) {
			logger.info("Changement de mot de passe en cours!");
		
			cli.setPassword(pass);
			cli = ClientManager.updateClient(cli);
			request.getSession().setAttribute("client", cli);
			logger.info("Changement de mot de pass reussis!");
			response.sendRedirect(request.getContextPath()+Url_path.ACCOUNT);
		}
		else {
			logger.error("Impossible de changer le mot de passe!");
			response.sendRedirect(request.getContextPath()+Url_path.CHANGE_PASS);
		}
	}
}

