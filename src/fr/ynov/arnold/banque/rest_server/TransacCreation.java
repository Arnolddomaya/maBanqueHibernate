package fr.ynov.arnold.banque.rest_server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/createTransac")
public class TransacCreation extends HttpServlet{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		PrintWriter out = ((ServletResponse) request).getWriter();
		out.write("TESTE REST SERVEUR");
	}
	
}
