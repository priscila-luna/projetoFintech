package br.com.fiap.poupemais.dao;
import java.util.List;

import br.com.fiap.poupemais.bean.Usuario;
import br.com.fiap.poupemais.exception.DBException;

public interface UsuarioDAO {
	boolean validarUsuario(Usuario usuario);
	void cadastrar (Usuario usuario) throws DBException;
	void atualizar (Usuario usuario) throws DBException;
	void remover(int idUsuario) throws DBException;
	Usuario buscar (int idUsuario);
	List<Usuario> listar();
}
