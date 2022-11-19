package br.com.fiap.poupemais.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.poupemais.bean.Usuario;
import br.com.fiap.poupemais.dao.UsuarioDAO;
import br.com.fiap.poupemais.exception.DBException;
import br.com.fiap.poupemais.singleton.ConnectionManager;

public class OracleUsuarioDAO implements UsuarioDAO{
	
	private Connection conexao;
	
	@Override
	public void cadastrar (Usuario usuario) throws DBException {
		PreparedStatement stmt = null;
	
	try {
		conexao = ConnectionManager.getInstance().getConnection();
		String sql = "INSERT INTO T_USUARIO (nm_usuario, ds_email, dt_nascimento, senha, nmr_celular) VALUES (?, ?, ?, ?, ?);";
		stmt = conexao.prepareStatement(sql);
		stmt.setString(1, usuario.getNmUsuario());
		stmt.setString(2, usuario.getDsEmail());
		java.sql.Date dtNascimento = new java.sql.Date(usuario.getDtNascimento().getTimeInMillis());
        stmt.setDate(3, dtNascimento);
        stmt.setString(4, usuario.getSenha());
        stmt.setString(5, usuario.getNmrCelular() );
        
        stmt.executeUpdate();
	} catch (SQLException e){
		e.printStackTrace();
		throw new DBException("Erro ao cadastrar Usuário.");
	} finally {
		try {
			stmt.close();
			conexao.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
}

	@Override
	public void atualizar(Usuario usuario) throws DBException {
		PreparedStatement stmt = null;
		
	try {
		conexao = ConnectionManager.getInstance().getConnection();
		String sql = "UPDATE T_USUARIO SET NM_USUARIO = ? , DS_EMAIL = ? , DT_NASCIMENTO = ? , SENHA= ? , NMR_CELULAR = ?  WHERE ID_USUARIO = ? ";
		stmt = conexao.prepareStatement(sql);
		stmt.setString(1, usuario.getNmUsuario());
		stmt.setString(2, usuario.getDsEmail());
		java.sql.Date dtNascimento = new java.sql.Date(usuario.getDtNascimento().getTimeInMillis());
	    stmt.setDate(3, dtNascimento);
	    stmt.setString(4, usuario.getSenha());
	    stmt.setString(5, usuario.getNmrCelular() );
	    stmt.setInt(6, usuario.getidUsuario());
	    
	    stmt.executeUpdate();
	}catch (SQLException e) {
		e.printStackTrace();
		throw new DBException("Erro ao atualizar despesa.");
	}finally {
		try {
			stmt.close();
			conexao.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
	
	@Override
	public void remover (int idUsuario) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_USUARIO WHERE ID_USUARIO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, idUsuario);
			stmt.executeUpdate();
		}catch (SQLException e) {
			throw new DBException("Erro ao remover usuário.");
		}finally {
			try {
				stmt.close();
				conexao.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	@Override
	public boolean validarUsuario(Usuario usuario) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_USUARIO WHERE DS_EMAIL = ? AND SENHA = ?");
			stmt.setString(1, usuario.getDsEmail());
			stmt.setString(2, usuario.getSenha());
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				return true;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}


	@Override
	public List<Usuario> listar() {
		List<Usuario> lista = new ArrayList<Usuario>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT NM_USUARIO, DS_EMAIL, DT_NASCIMENTO FROM T_USUARIO");
			rs = stmt.executeQuery();
		
			while (rs.next()) {
				int codUsuario = rs.getInt("ID_USUARIO");
				String nome = rs.getString("NM_USUARIO");
				String email = rs.getString("DS_EMAIL");
				java.sql.Date data = rs.getDate("DT_NASCIMENTO");
				Calendar dataNascimento = Calendar.getInstance();
				dataNascimento.setTimeInMillis(data.getTime());
			
				Usuario usuario = new Usuario (codUsuario, nome, email, dataNascimento);
				lista.add(usuario);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conexao.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public Usuario buscar(int idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}
}

	

