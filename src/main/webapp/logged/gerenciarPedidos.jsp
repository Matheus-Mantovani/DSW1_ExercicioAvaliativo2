<%@page import="br.edu.ifsp.dsw1.model.entity.Pedido"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	var mensagem = request.getAttribute("mensagem");
	var pedidos = (List<Pedido>) request.getAttribute("pedidos");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gerenciar pedidos</title>
</head>
<body>

	<jsp:include page="includes/navbar.jsp" />
	
	<%if(mensagem != null) {%>
		<%=mensagem %>
	<%} %>
	
	<%if(pedidos != null && pedidos.size() > 0) {%>
		<form action="logged.do?action=filtrarPorNome" method="post">
			<label for="nomeCliente">Nome do Cliente</label>
			<input type="text" name="nomeCliente" id="nomeCliente"><br><br>
			
			<button type="submit">Filtrar</button>
		</form>
	
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome Cliente</th>
					<th>Endereco Entrega</th>
					<th>Valor</th>
					<th>Descricao</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
			<%
			for (var pedido : pedidos) {
			%>
				<tr>
					<th><%= pedido.getIdPedido() %></th>
					<td><%= pedido.getNomeCliente() %></td>
					<td><%= pedido.getEnderecoEntrega() %></td>
					<td><%= pedido.getValor() %></td>
					<td><%= pedido.getDescricao() %></td>
					<td>
						<a href="logged.do?action=atualizarPedidoForm&id=<%=pedido.getIdPedido()%>" >Atualizar</a>
						<a href="logged.do?action=removerPedido&id=<%=pedido.getIdPedido()%>" >Remover</a>
					</td>
				</tr>
			<%} %>
			</tbody>
		</table>
	<%} else {%>
		<p>Sem pedidos.</p>
	<%} %>
</body>
</html>