<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="#">POUPE MAIS</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
		
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item">
				<a class="nav-link" href="cadastro-usuario.jsp">Cadastro Usuário</a>
			</li>
			
			<li class="nav-item">
				<a class="nav-link" href="cadastro-despesa.jsp">Cadastro Despesa</a>
			</li>
			
			<li class="nav-item">
				<a class="nav-link" href="cadastro-receita.jsp">Cadastro Receita</a>
			</li>
			
			<li class="nav-item">
				<a class="nav-link" href="despesa?acao=listar">Despesas</a>
			</li>
			
			<li class="nav-item">
				<a class="nav-link" href="receita?acao=listar">Receitas</a>
			</li>
			
			<li class="nav-item">
				<a class="nav-link" href="usuario?acao=listar">Usuários</a>
			</li>
		</ul>
		
		<span class="navbar-text text-danger" style="margin-right:10px">
			${erro}
		</span>
		
		<form class="form-inline my-2 my-lg-0" action="login" method="post">
			<input class="form-control mr-sm-2" type="text" name="email" placeholder="E-mail">
			<input class="form-control mr-sm-2" type="password" name="senha" placeholder="Senha">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Entrar</button>
		</form>
	</div>
</nav>