package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.dao.PedidosDaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AtualizarPedidoFormCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		var IDpedido = Integer.parseInt(request.getParameter("id"));
		var dao = new PedidosDaoFactory().factory();
		var pedido = dao.findById(IDpedido);
		
		request.setAttribute("pedido", pedido);
		
		return "/logged/atualizarPedido.jsp";
	}

}
