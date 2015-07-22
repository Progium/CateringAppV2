package com.progium.catering.config;

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@WebFilter(filterName="wsFilter",urlPatterns="/rest/protected/*")
public class WSFilter implements Filter {

	final Logger logger = LoggerFactory.getLogger(WSFilter.class);

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest servletRequest = (HttpServletRequest)request;
	    HttpServletResponse servletResponse = (HttpServletResponse) response;
		
	    String needAccess = servletRequest.getParameter("needAccess");
	    
	    HttpSession currentSession = servletRequest.getSession();
	    
	    System.out.println("Session Object ------> " + currentSession.getAttribute("idUsuario"));
	    
		if (currentSession.getAttribute("idUsuario") != null || needAccess==null || needAccess.equals("false")) {
			chain.doFilter(servletRequest, servletResponse);
		} else {
			logger.debug("Rejected: " + servletRequest.toString());
			servletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext (this);
	}

}
