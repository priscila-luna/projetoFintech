<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Lista de Despesa</title>
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
						<button type="button" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#excluirModal" onclick="idDespesaExcluir.value = ${p.idDespesa}">Excluir</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
<%@ include file="footer.jsp" %>

<!-- Modal -->
<div class="modal fade" id="excluirModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Confirmação</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
            Deseja realmente excluir o registro?
      </div>
      <div class="modal-footer">
        <form action="despesa" method="post">
          <input type="hidden" name="acao" value="excluir">
          <input type="hidden" name="idDespesa" id="idDespesaExcluir">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
          <button type="submit" class="btn btn-danger">Excluir</button>
        </form>
      </div>
    </div>
  </div>
</div>

</body>
</html>