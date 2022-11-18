package br.com.fiap.poupemais.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
		
		try{
			String descricao = request.getParameter("descricao");
			double valor = Double.parseDouble(request.getParameter("valor"));
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataDespesa = Calendar.getInstance();
			dataDespesa.setTime(format.parse(request.getParameter("dataDespesa")));
			String tipo = request.getParameter("tipo");
			int idUsuarioFixo = 10;
			
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

}