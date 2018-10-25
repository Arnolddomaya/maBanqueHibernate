package fr.ynov.arnold.banque.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import fr.ynov.arnold.banque.model.Client;

@WebFilter("/*")
public class ConnectionFilter implements Filter {
	
	private static final Logger logger = (Logger) LogManager.getLogger(ConnectionFilter.class);
	
	@Override
	public void destroy() {	
	}
	@Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {    
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        String loginURI = request.getContextPath() + "/userLogin";

        Client cli ;
        try {
        	cli = (Client)session.getAttribute("client");
        	if (cli != null)
        		logger.info("Filter ConnectionFilert, CLient exists__try_Catch");
        	else 
        		logger.info("Filter ConnectionFilert, CLient not exists__try_Catch");
        }
        catch(java.lang.NullPointerException e ) {
        	cli = null;
        	logger.error("Filter ConnectionFilert, CLient not exists");
        }
//        if (cli != null)
//        	logger.info("Filter ConnectionFilert, CLient exists___ testIf");
//        else 
//        	logger.error("Filter ConnectionFilert, CLient not exists");
        boolean loggedIn = session != null && cli != null;
        boolean loginRequest = request.getRequestURI().equals(loginURI);
        if (loggedIn || loginRequest) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect(loginURI);
        }
    }

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
