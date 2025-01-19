<%@page import="br.edu.ifsp.dsw1.model.entity.Pedido"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	var pedido = (Pedido) request.getAttribute("pedido");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Atualizar pedido</title>
</head>
<body>

	<jsp:include page="includes/navbar.jsp" /><br>
	
	<form action="controller.do?action=atualizarPedido&id=<%= pedido.getIdPedido() %>" method="post">
		<label for="nomeCliente">Nome do Cliente</label>
		<input type="text" name="nomeCliente" id="nomeCliente" required placeholder="<%=pedido.getNomeCliente()%>"><br><br>
		
		<label for="enderecoEntrega">Endereco de entrega</label>
		<input type="text" name="enderecoEntrega" id="enderecoEntrega" required placeholder="<%=pedido.getEnderecoEntrega()%>"><br><br>
		
		<label for="valor">Valor</label>
		<input type="number" name="valor" id="valor" required placeholder="<%=pedido.getValor()%>"><br><br>
		
		<label for="descricao">Descrição</label>
		<input type="text" name="descricao" id="descricao" placeholder="<%=pedido.getDescricao()%>"><br><br>
		
		<button type="submit">Atualizar</button>
	</form>
	
</body>
</html>