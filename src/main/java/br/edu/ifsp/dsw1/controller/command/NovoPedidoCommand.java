package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.dao.PedidosDaoFactory;
import br.edu.ifsp.dsw1.model.entity.Pedido;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NovoPedidoCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		var nomeCliente = request.getParameter("nomeCliente");
		var enderecoEntrega = request.getParameter("enderecoEntrega");
		var strValor = request.getParameter("valor");
		var descricao = request.getParameter("descricao");
		
		var valor = Double.parseDouble(strValor);
		//caso a descricao seja null ou vazia, atribui um valor padrao
		descricao = (descricao != null && !descricao.isBlank()) ? descricao : "Sem descrição";
		
		var dao = new PedidosDaoFactory().factory();
		
		Pedido pedido = new Pedido(nomeCliente, enderecoEntrega, valor, descricao);
		var inserido = dao.insert(pedido);
		
		if(inserido) {
			request.setAttribute("mensagem", "Pedido inserido com sucesso!");
		} else {
			request.setAttribute("mensagem", "<ERRO> Erro ao inserir pedido.");
		}
		
		return "controller.do?action=novoPedidoForm";
	}

}
