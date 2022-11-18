package br.com.fiap.poupemais.dao;

import java.util.List;
import br.com.fiap.poupemais.bean.Despesa;
import br.com.fiap.poupemais.exception.DBException;

public interface DespesaDAO {
	void cadastrar (Despesa despesa) throws DBException;
	void editar (Despesa despesa) throws DBException;
	void remover (int idDespesa) throws DBException;
	Despesa buscar (int idDespesa, int idUsuario);
	List<Despesa> listar();

}
