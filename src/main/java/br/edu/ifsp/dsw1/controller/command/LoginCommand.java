package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.dao.UsuarioDaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		var login = request.getParameter("login");
		var senha = request.getParameter("senha");
		
		var dao = new UsuarioDaoFactory().factory();
		var usuario = dao.findByLogin(login);;
		
		String view;
		
		if(usuario != null && usuario.getSenha().equals(senha)) {
			var session = request.getSession(true);
			session.setAttribute("usuario", usuario);
			session.setMaxInactiveInterval(60 * 60 * 24);
			view = "logged.jsp";
		} else {
			request.setAttribute("mensagem", "Usuário não encontrado.");
			view = "controller.do?action=index";
		}
		
		return view;
	}

}
