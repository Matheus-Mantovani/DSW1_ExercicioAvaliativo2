package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.dao.PedidosDaoFactory;
import br.edu.ifsp.dsw1.model.entity.Pedido;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AtualizarPedidoCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var IDpedido = Integer.parseInt(request.getParameter("id"));
		var nomeCliente = request.getParameter("nomeCliente");
		var enderecoEntrega = request.getParameter("enderecoEntrega");
		var valor = Double.parseDouble(request.getParameter("valor"));
		var descricao = request.getParameter("descricao");
		
		var dao = new PedidosDaoFactory().factory();
		
		var pedidoAtualizado = new Pedido(nomeCliente, enderecoEntrega, valor, descricao);
		
		String mensagem;
		if(dao.update(pedidoAtualizado, IDpedido)) {
			mensagem = "Pedido atualizado com sucesso!";
		} else {
			mensagem = "<ERRO> Falha ao atualizar pedido.";
		}
		
		request.setAttribute("mensagem", mensagem);
		
		return "logged.do?action=gerenciarPedidos";
	}

}
