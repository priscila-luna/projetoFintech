package br.com.fiap.poupemais.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.poupemais.bean.Despesa;
import br.com.fiap.poupemais.dao.DespesaDAO;
import br.com.fiap.poupemais.exception.DBException;
import br.com.fiap.poupemais.factory.DAOFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/despesa")
public class DespesaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private DespesaDAO dao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getDespesaDAO();
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
		}
	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			String descricao = request.getParameter("descricao");
			double valor = Double.parseDouble(request.getParameter("valor"));
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataDespesa = Calendar.getInstance();
			dataDespesa.setTime(format.parse(request.getParameter("dataDespesa")));
			String tipo = request.getParameter("tipo");
			int idUsuarioFixo = 1;
			
			Despesa despesa = new Despesa(descricao, valor, dataDespesa, tipo, idUsuarioFixo); 
			dao.cadastrar(despesa);
			
			request.setAttribute("msg", "Despesa cadastrado!");
		}catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar Despesa");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.getRequestDispatcher("cadastro-despesa.jsp").forward(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int codDespesa = Integer.parseInt(request.getParameter("idDespesa"));
			String descricao = request.getParameter("dsDespesa");
			double valor = Double.parseDouble(request.getParameter("vlrDespesa"));
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataDespesa = Calendar.getInstance();
			dataDespesa.setTime(format.parse(request.getParameter("dtDespesa")));
			String tipo = request.getParameter("tpDespesa");
			int idUsuarioFixo = 1;

			Despesa despesa = new Despesa(codDespesa, descricao, valor, dataDespesa, tipo, idUsuarioFixo);
			dao.atualizar(despesa);

			request.setAttribute("msg", "Despesa atualizada!");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar despesa");
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
			int idDespesa = Integer.parseInt(request.getParameter("idDespesa"));
			Despesa despesa = dao.buscar(idDespesa);
			request.setAttribute("despesa", despesa);
			request.getRequestDispatcher("edicao-produto.jsp").forward(request,response);
		}
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Despesa> lista = dao.listar();
		request.setAttribute("despesas", lista);
		request.getRequestDispatcher("lista-despesa.jsp").forward(request, response);
	}
			
}
	
