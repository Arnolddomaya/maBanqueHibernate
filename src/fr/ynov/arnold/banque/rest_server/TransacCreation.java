package fr.ynov.arnold.banque.rest_server;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.ynov.arnold.banque.others.Url_path;

@WebServlet(Url_path.CREATE_TRANSACS)
public class TransacCreation extends HttpServlet{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		response.getWriter().println("123");
	}
	
}
