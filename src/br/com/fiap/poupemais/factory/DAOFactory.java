package br.com.fiap.poupemais.factory;

import br.com.fiap.poupemais.dao.DespesaDAO;
import br.com.fiap.poupemais.dao.UsuarioDAO;
import br.com.fiap.poupemais.dao.impl.OracleDespesaDAO;
public class DAOFactory {
	
	public static DespesaDAO getDespesaDAO() {
		return new OracleDespesaDAO();
	}

	public static UsuarioDAO getUsuarioDAO() {
		return null;
	}
}
