<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Edição de Despesa</title>
<%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>
<div class="container">
	<h1>Edição de Despesa</h1>
	<c:if test="${not empty msg }">
		<div class="alert alert-sucess">${msg}</div>
	</c:if>
	<c:if test="${not empty erro }">
		<div class="alert alert-danger">${erro}</div>
	</c:if>
	<form action="despesa" method="post">
		<input type="hidden" value="editar" name="acao">
		<input type="hidden" value="${despesa.idDespesa}" name="codDespesa">
		<div class="form-group">
			<label for="id-descricao">Descrição</label>
			<input type="text" name="nome" id="id-descricao" class="form-control" value="${despesa.dsDespesa}" >
		</div>
		<div class="form-group">
			<label for="id-valor">Valor</label>
			<input type="text" name="valor" id="id-valor" class="form-control" value="${despesa.vlrDespesa}">
		</div>
		<div class="form-group">
			<label for="id-data">Data da Despesa</label>
			<input type="text" name="data" id="id-data" class="form-control" 
				value='<fmt:formatDate value="${despesa.dtDespesa.time }" pattern="dd/MM/yyyy"/>'>
		</div>
		<div class="form-group">
			<label for="id-tipo">Tipo</label>
			<input type="text" name="tipo" id="id-tipo" class="form-control" value="${despesa.tpDespesa}">
		</div>
		<input type="submit" value="Salvar" class="btn btn-primary">
		<a href="produto?acao=listar" class="btn btn-danger">Cancelar</a>
	</form>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>