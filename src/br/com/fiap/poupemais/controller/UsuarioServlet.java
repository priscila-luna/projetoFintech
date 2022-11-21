package br.com.fiap.poupemais.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.poupemais.bean.Usuario;
import br.com.fiap.poupemais.dao.UsuarioDAO;
import br.com.fiap.poupemais.exception.DBException;
import br.com.fiap.poupemais.factory.DAOFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private UsuarioDAO dao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getUsuarioDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		switch (acao) {
		case "cadastrar":
			cadastrar(request, response);
			break;
		case "editar":
			editar(request, response);
			break;
		case "excluir":
			excluir(request, response);
			break;
		}
	}
	
	private void excluir(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		  int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
		  try {
		    dao.remover(idUsuario);
		    request.setAttribute("msg", "Usu�rio removido!");
		  } catch (DBException e) {
		    e.printStackTrace();
		    request.setAttribute("erro", "Erro ao atualizar");
		  }
		  listar(request,response);
		}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			String nome = request.getParameter("nmUsuario");
			String email = request.getParameter("dsEmail");
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(format.parse(request.getParameter("dtNascimento")));
			String senha = request.getParameter("senha");
			String celular = request.getParameter("nmrCelular");
			
			System.out.println(nome);
			
			Usuario usuario = new Usuario(nome, email, dataNascimento, senha, celular); 
			dao.cadastrar(usuario);
			
			request.setAttribute("msg", "Usu�rio cadastrado!");
		}catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar Usu�rio");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.getRequestDispatcher("cadastro-usuario.jsp").forward(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int codUsuario = Integer.parseInt(request.getParameter("idUsuario"));
			String nome = request.getParameter("nmUsuario");
			String email = request.getParameter("dsEmail");
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(format.parse(request.getParameter("dtNascimento")));
			String senha = request.getParameter("senha");
			String celular = request.getParameter("nmrCelular");

			Usuario usuario = new Usuario(codUsuario, nome, email, dataNascimento, senha, celular);
			dao.atualizar(usuario);

			request.setAttribute("msg", "Usu�rio atualizado!");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar usu�rio");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		listar(request,response);
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		switch (acao) {
		case "listar":
			listar(request, response);
			break;
		case "abrir-form-edicao":
			abrirFormEdicao(request, response);
			break;
		}
	}
	
	private void abrirFormEdicao(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		    int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
		    Usuario usuario = dao.buscar(idUsuario);
		    request.setAttribute("usuario", usuario);
		    request.getRequestDispatcher("edicao-usuario.jsp").forward(request, response);
		  }

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuario> lista = dao.listar();
		request.setAttribute("usuarios", lista);
		request.getRequestDispatcher("lista-usuario.jsp").forward(request, response);
	}
			
}
	
