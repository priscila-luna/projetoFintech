<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Login Poupe +</title>
<link rel="stylesheet" type="text/css" href="resources/css/poupemais.css">
<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.csss">


<%@ include file="header.jsp" %>
</head>
<body>


<div class="container-fluid">
    <div class="row justify-content-center mt-5">
      <section class="col-12 col-sm-6 col-md-4">
        <div class="col-12 text-center">
          <img src="resources/img/poupe.png" class="logo">
        </div>
        <form class="form-container" action="AutenticacaoServlet" method="post">
          <div class="form-group mb-3">
            <div class="fs-6">Usuário:</div>
            <input type="text" class="form-control" name="email">
          </div>
          <div class="form-group mb-3">
            <div class="fs-6">Senha:</div>
            <input type="password" class="form-control" name="senha">
          </div>
          <div class="row mb-3">
            <div class="fs-9 text-decoration-underline text-end">Esqueci minha senha</div>
          </div>
          <div class="form-group text-center">
            <input type="submit" value="login"/>
            <br><br>
          </div>
          <div class="row mb-3">
            <div class="fs-6 text-center fw-normal font-monospace">Ainda não possui uma conta?</div>
          </div>
          <div class="row mb-2">
            <div class="fs-7 text-center text-decoration-underline cadastro">Cadastre-se aqui</div>
          </div>
          <br><br><br><br>
        </form>
      </section>
    </div>
  </div>
  
</body>