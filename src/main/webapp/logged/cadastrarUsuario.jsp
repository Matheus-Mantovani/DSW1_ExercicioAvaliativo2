<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	var mensagem = request.getAttribute("mensagem");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar usuário</title>
</head>
<body>

	<jsp:include page="includes/navbar.jsp" />
	
	<%if(mensagem != null) {%>
		<%=mensagem %>
	<%} %>

	<form action="logged.do?action=cadastrarUsuario" method="post">
		<label for="nome">Nome</label>
		<input type="text" name="novoLogin" id="nome"><br>
		
		<label for="senha">Senha</label>
		<input type="password" name="novaSenha" id="senha"><br><br>
		
		<button type="submit">Cadastrar usuário</button>
	</form>
</body>
</html>