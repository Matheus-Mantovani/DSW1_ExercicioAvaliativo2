package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.dao.UsuarioDaoFactory;
import br.edu.ifsp.dsw1.model.entity.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CadastrarUsuarioCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		var novoLogin = request.getParameter("novoLogin");
		var novaSenha = request.getParameter("novaSenha");
		
		var dao = new UsuarioDaoFactory().factory();
		
		//verifica se o login ja esta em uso
		if(dao.findByLogin(novoLogin) != null) {
			request.setAttribute("mensagem", "<ERRO> Nome já está em uso.");
		} else {
			dao.insert(new Usuario(novoLogin, novaSenha));
			request.setAttribute("mensagem", "Usuario cadastrado com sucesso!");
		}
		
		return "/logged/cadastrarUsuario.jsp";
	}

}
