package fr.ynov.arnold.banque.others;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import fr.ynov.arnold.banque.controller.ListeComptes;

public class AlertControl {

	private static final Logger logger = (Logger) LogManager.getLogger(AlertControl.class);
	
	public static HttpServletRequest sendAlert(HttpServletRequest request) {
		
		String alert_success = (String)request.getSession().getAttribute("success");
		String alert_error = (String)request.getSession().getAttribute("error");
		
		logger.info("attribut alert gotten : success "+ alert_success + ",  error " + alert_error);
		
		if (alert_success != null) {
			logger.info("attribut alert success gotten !");
			request.setAttribute("success", alert_success);
			//request.getSession().setAttribute("alert_success", null);
			request.getSession().setAttribute("success", null);
		}
		if (alert_error != null ) {
			logger.info("attribut alert error gotten !");
			request.setAttribute("error", alert_error);
			request.getSession().setAttribute("error", null);
		}
		
		return request;
	}
	
	public static void setErrorAlertAndRedirect( HttpServletRequest request, HttpServletResponse response, String msg, String path ) throws IOException {
		
		request.getSession().setAttribute("error", msg);
		response.sendRedirect(request.getContextPath()+path);
	}
}
