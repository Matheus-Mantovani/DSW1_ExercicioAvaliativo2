package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.dao.PedidosDaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GerenciarPedidosCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		var dao = new PedidosDaoFactory().factory();
		
		var pedidos = dao.getAll();
		
		request.setAttribute("pedidos", pedidos);

		return "/logged/gerenciarPedidos.jsp";
	}

}
