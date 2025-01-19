<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<nav>
	<ul>
		<li><a href="<%=request.getContextPath()%>/controller.do?action=logged">Home</a></li>
		<li><a href="<%=request.getContextPath()%>/controller.do?action=cadastrarUsuario">Cadastrar usuario</a></li>
		<li><a href="<%=request.getContextPath()%>/controller.do?action=novoPedido">Novo pedido</a></li>
		<li><a href="<%=request.getContextPath()%>/controller.do?action=gerenciarPedidos">Gerenciar pedidos</a></li>
		<li><a href="<%=request.getContextPath()%>/controller.do?action=logout">Logout</a></li>
	</ul>
</nav>