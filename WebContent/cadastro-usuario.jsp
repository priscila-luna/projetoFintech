<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Cadastro de Usuário</title>
<%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>
<div class="container">
	<h1>Cadastro de Usuário</h1>
	<c:if test="${not empty msg }">
		<div class="alert alert-success">${msg}</div>
	</c:if>
	<c:if test="${not empty erro }">
		<div class="alert alert-danger">${erro}</div>
	</c:if>
	<form action="usuario" method="post">
	<input type="hidden" value="cadastrar" name="acao">
		<div class="form-group">
			<label for="id-descricao">Nome</label>
			<input type="text" name="nmUsuario" id="id-nome" class="form-control">
		</div>
		<div class="form-group">
			<label for="id-valor">Email</label>
			<input type="text" name="dsEmail" id="id-email" class="form-control">
		</div>
		<div class="form-group">
			<label for="id-dataDespesa">Data de Nascimento</label>
			<input type="text" name="dtNascimento" id="id-dataNascimento" class="form-control">
		</div>
		<div class="form-group">
			<label for="id-tipo">Senha</label>
			<input type="password" name="senha" id="id-senha" class="form-control">
		</div>
		<div class="form-group">
			<label for="id-tipo">Celular</label>
			<input type="text" name="nmrCelular" id="id-celular" class="form-control">
		</div>
		<input type="submit" value="Salvar" class="btn btn-primary">
	</form>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>