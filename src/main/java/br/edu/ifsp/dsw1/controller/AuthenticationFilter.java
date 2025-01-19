package br.edu.ifsp.dsw1.controller;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/logged.do"})
public class AuthenticationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);
		var action = httpRequest.getParameter("action");
		
		if(!action.equals("index")) {
			if (session != null && session.getAttribute("usuario") != null) {
				chain.doFilter(request, response);
			} else {
				request.setAttribute("mensagem", "Acesso permitido apenas para usuário logado.");
				
				var dispatcher = request.getRequestDispatcher("front.do?action=index");
				dispatcher.forward(request, response);
			}	
		}
	}
}