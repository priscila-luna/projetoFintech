package br.com.fiap.poupemais.factory;

import br.com.fiap.poupemais.dao.DespesaDAO;
import br.com.fiap.poupemais.dao.ReceitaDAO;
import br.com.fiap.poupemais.dao.UsuarioDAO;
import br.com.fiap.poupemais.dao.impl.OracleDespesaDAO;
import br.com.fiap.poupemais.dao.impl.OracleReceitaDAO;
import br.com.fiap.poupemais.dao.impl.OracleUsuarioDAO;

public class DAOFactory {
	
	public static DespesaDAO getDespesaDAO() {
		return new OracleDespesaDAO();
	}

	public static ReceitaDAO getReceitaDAO() {
		return new OracleReceitaDAO();
	}

	
	public static UsuarioDAO getUsuarioDAO() {
		return new OracleUsuarioDAO();
	}
}
