package fr.ynov.arnold.banque.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

@WebServlet("/logout")
public class LogOut extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4218149167927730862L;
	private static final Logger logger = (Logger) LogManager.getLogger(LogOut.class);
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		logger.info("controller LogOut, method doGet!");
		HttpSession session = request.getSession(false);
		if(session != null)
		    session.invalidate();
		Login.loginPath(request, response);
	}

}
