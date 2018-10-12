package fr.ynov.arnold.banque.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import fr.ynov.guerny.banque.model.Client;

//@webServlet("/")
public class Hello extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = (Logger) LogManager.getLogger(Client.class);

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
//		response.setContentType("text/html");
//		response.setCharacterEncoding( "UTF-8" );
//		PrintWriter out = response.getWriter();
//		out.println("<!DOCTYPE html>");
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<meta charset=\"utf-8\" />");
//		out.println("<title>Test</title>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<p>Ceci est une page générée depuis une servlet.</p>");
//		out.println("</body>");
//		out.println("</html>");
		String str = new String("Tout roule ok!");
		request.setAttribute("test", str);
		logger.info("Test logger !!");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/accueil.jsp");
		dispatcher.forward(request, response);
	}

	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
	}

}
