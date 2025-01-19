<%@page import="br.edu.ifsp.dsw1.model.entity.Usuario" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	var usuario = (Usuario)session.getAttribute("usuario");
%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logado</title>
</head>
<body>
	<p>Bem vindo, <%= usuario.getLogin() %></p>
</body>
</html>