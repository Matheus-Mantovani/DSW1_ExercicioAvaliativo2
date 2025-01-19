<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	var mensagem = request.getAttribute("mensagem");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Novo pedido</title>
</head>
<body>
	
	<jsp:include page="includes/navbar.jsp" /><br>
	
	<%if(mensagem != null) {%>
		<%=mensagem %>
	<%} %>
	
	<form action="controller.do?action=novoPedido" method="post">
		<label for="nomeCliente">Nome do Cliente</label>
		<input type="text" name="nomeCliente" id="nomeCliente" required><br><br>
		
		<label for="enderecoEntrega">Endereco de entrega</label>
		<input type="text" name="enderecoEntrega" id="enderecoEntrega" required><br><br>
		
		<label for="valor">Valor</label>
		<input type="number" name="valor" id="valor" required><br><br>
		
		<label for="descricao">Descrição</label>
		<input type="text" name="descricao" id="descricao"><br><br>
		
		<button type="submit">Enviar</button>
	</form>
	
</body>
</html>