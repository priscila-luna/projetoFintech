package br.com.fiap.poupemais.teste;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import br.com.fiap.poupemais.bean.Despesa;
import br.com.fiap.poupemais.dao.DespesaDAO;
import br.com.fiap.poupemais.exception.DBException;
import br.com.fiap.poupemais.factory.DAOFactory;

public class TesteDespesaDAO {

	public static void main(String[] args) {
		DespesaDAO dao = DAOFactory.getDespesaDAO();
		
		//cadastrar despesa
		Despesa despesa = new Despesa( "CINEMA", 60, Calendar.getInstance() , "Lazer", 1 );
		try {
			dao.cadastrar(despesa);
			System.out.println("Despesa cadastrada com sucesso !");
		}catch (DBException e) {
			e.printStackTrace();
		}
		
		//Buscar despesa e atualizar
		
		despesa = dao.buscar(10, 1);
		despesa.setDsDespesa("Cinema Especial");
		despesa.setVlrDespesa(60);
		try {
			dao.editar(despesa);
			System.out.println("Despesa Editada com sucesso!");
		}catch (DBException e) {
			e.printStackTrace();
		}
		
		//listar as despesas
		List<Despesa> lista = dao.listar();
		for (Despesa item : lista) {
			System.out.println(item.getDsDespesa() + " " + item.getTpDespesa() + " " + item.getVlrDespesa() + " " + item.getDtDespesa());
		}
		
		//remover despesa
		try {
			dao.remover(10);
			System.out.println("Produto removido com sucesso!");
		}catch (DBException e) {
			e.printStackTrace();
		}
		
	}

}
