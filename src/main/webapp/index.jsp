<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	var mensagem = request.getAttribute("mensagem");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>
	
	<%if(mensagem != null) {%>
		<%=mensagem %>
	<%} %>
	
	<form action="controller.do?action=login" method="post">
		<label for="nome">Nome</label>
		<input type="text" name="login" id="nome"><br>
		
		<label for="senha">Senha</label>
		<input type="password" name="senha" id="senha"><br><br>
		
		<button type="submit">Enviar</button>
	</form>
	
	
</body>
</html>