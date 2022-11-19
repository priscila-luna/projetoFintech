<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Cadastro de Despesa</title>
<%@ include file="header.jsp" %>
</head>
<body>


<%@ include file="menu.jsp"%>
	<div class="container">
		<h1>Despesas</h1>
		<c:if test="${not empty msg }">
			<div class="alert alert-success">${msg}</div>
		</c:if>
		<c:if test="${not empty erro }">
			<div class="alert alert-danger">${erro}</div>
		</c:if>
		<table class="table table-striped">
			<tr>
				<th>Descrição</th>
				<th>Valor</th>
				<th>Data</th>
				<th>Tipo</th>
				<th></th>
			</tr>
			<c:forEach items="${despesas}" var="p">
				<tr>
					<td>${p.dsDespesa}</td>
					<td>${p.vlrDespesa}</td>
					<td>${p.tpDespesa}</td>
					<td>
						<fmt:formatDate value="${p.dtDespesa.time}" pattern="dd/MM/yyyy"/>
					</td>
					<td>
						<c:url value="despesa" var="link">
							<c:param name="acao" value="abrir-form-edicao"/>
							<c:param name="idDespesa" value="${p.idDespesa}"/>
							<c:param name="idUsuario" value="${p.idUsuario}"/>
						</c:url>
						<a class="btn btn-primary" href="${link}">Editar</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
<%@ include file="footer.jsp" %>

</body>
</html>