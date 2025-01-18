<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="controller.do?action=login" method="post">
		<label for="nome">Nome</label>
		<input type="text" name="nome" id="nome"><br>
		
		<label for="senha">Senha</label>
		<input type="text" name="senha" id="senha"><br><br>
		
		<button type="submit">Enviar</button>
	</form>
</body>
</html>