<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Edição de Usuário</title>
<%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>
<div class="container">
	<h1>Edição de Usuário</h1>
	<c:if test="${not empty msg }">
		<div class="alert alert-sucess">${msg}</div>
	</c:if>
	<c:if test="${not empty erro }">
		<div class="alert alert-danger">${erro}</div>
	</c:if>
	<form action="despesa" method="post">
		<input type="hidden" value="editar" name="acao">
		<input type="hidden" value="${usuario.idUsuario}" name="idUsuario">
		<div class="form-group">
			<label for="id-descricao">Nome</label>
			<input type="text" name="nmUsuario" id="id-nome" class="form-control" value="${usuario.nmUsuario}" >
		</div>
		<div class="form-group">
			<label for="id-valor">Login</label>
			<input type="text" name="dsEmail" id="id-valor" class="form-control" value="${usuario.dsEmail}">
		</div>
		<div class="form-group">
			<label for="id-data">Data de Nascimento</label>
			<input type="text" name="dtNascimento" id="id-data" class="form-control" 
				value='<fmt:formatDate value="${usuario.dtNascimento.time }" pattern="dd/MM/yyyy"/>'>
		</div>
		<div class="form-group">
			<label for="id-tipo">Senha</label>
			<input type="text" name="senha" id="id-senha" class="form-control" value="${usuario.senha}">
		</div>
		<div class="form-group">
			<label for="id-tipo">Celular</label>
			<input type="text" name="nmrCelular" id="id-nmrCelular" class="form-control" value="${usuario.nmrCelular}">
		</div>
		<input type="submit" value="Salvar" class="btn btn-primary">
		<a href="produto?acao=listar" class="btn btn-danger">Cancelar</a>
	</form>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>