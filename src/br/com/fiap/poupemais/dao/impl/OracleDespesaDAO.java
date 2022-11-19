package br.com.fiap.poupemais.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import br.com.fiap.poupemais.bean.Despesa;
import br.com.fiap.poupemais.dao.DespesaDAO;
import br.com.fiap.poupemais.exception.DBException;
import br.com.fiap.poupemais.singleton.ConnectionManager;

public class OracleDespesaDAO implements DespesaDAO{
	private Connection conexao;
	
	@Override
	public void cadastrar (Despesa despesa) throws DBException {
		PreparedStatement stmt = null;
	
	try {
		conexao = ConnectionManager.getInstance().getConnection();
		String sql = "INSERT INTO T_DESPESA (DS_DESPESA, VLR_DESPESA, DT_DESPESA, TP_DESPESA, ID_USUARIO) VALUES (?, ?, ?, ?, ?)";
		stmt = conexao.prepareStatement(sql);
		stmt.setString(1, despesa.getDsDespesa());
		stmt.setDouble(2, despesa.getVlrDespesa());
		java.sql.Date dataDespesa = new java.sql.Date(despesa.getDtDespesa().getTimeInMillis());
        stmt.setDate(3, dataDespesa);
        stmt.setString(4, despesa.getTpDespesa());
        stmt.setInt(5, despesa.getIdUsuario() );
        
        stmt.executeUpdate();
	} catch (SQLException e){
		e.printStackTrace();
		throw new DBException("Erro ao cadastrar despesa.");
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
	public void atualizar(Despesa despesa) throws DBException {
		PreparedStatement stmt = null;
		
	try {
		conexao = ConnectionManager.getInstance().getConnection();
		String sql = "UPDATE  T_DESPESA  SET DS_DESPESA= ? , VLR_DESPESA = ? , DT_DESPESA= ? , TP_DESPESA= ? WHERE ID_DESPESA = ? ";
		stmt = conexao.prepareStatement(sql);
		stmt.setString(1, despesa.getDsDespesa());
		stmt.setDouble(2, despesa.getVlrDespesa());
		java.sql.Date dataDespesa = new java.sql.Date(despesa.getDtDespesa().getTimeInMillis());
	    stmt.setDate(3, dataDespesa);
	    stmt.setString(4, despesa.getTpDespesa());
	    stmt.setInt(5, despesa.getIdDespesa() );
	    
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
	public void remover (int idDespesa) throws DBException {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_DESPESA WHERE ID_DESPESA = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, idDespesa);
			stmt.executeUpdate();
		}catch (SQLException e) {
			throw new DBException("Erro ao remover despesa.");
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
	public Despesa buscar(int idDespesa) {
		Despesa despesa = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_DESPESA  WHERE ID_DESPESA = ?");
			stmt.setInt(1, idDespesa);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				int codDespesa = rs.getInt("ID_DESPESA");
				String descricao = rs.getString("DS_DESPESA");
				double valor = rs.getDouble("VLR_DESPESA");
				java.sql.Date data = rs.getDate("DT_DESPESA");
				Calendar dataDespesa = Calendar.getInstance();
				dataDespesa.setTimeInMillis(data.getTime());
				String tipo = rs.getString("TP_DESPESA");
				int codUsuario = rs.getInt("ID_USUARIO");
				
				despesa = new Despesa(codDespesa, descricao, valor, dataDespesa, tipo, codUsuario);
			}
		} catch (SQLException e) {
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
		return despesa;
	}
		

	@Override
	public List<Despesa> listar() {
		List<Despesa> lista = new ArrayList<Despesa>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_DESPESA");
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				int codDespesa = rs.getInt("ID_DESPESA");
				String descricao = rs.getString("DS_DESPESA");
				double valor = rs.getDouble("VLR_DESPESA");
				java.sql.Date data = rs.getDate("DT_DESPESA");
				Calendar dataDespesa = Calendar.getInstance();
				dataDespesa.setTimeInMillis(data.getTime());
				String tipo = rs.getString("TP_DESPESA");
				int codUsuario = rs.getInt("ID_USUARIO");
				
				Despesa despesa = new Despesa (codDespesa, descricao, valor, dataDespesa, tipo, codUsuario);
				lista.add(despesa);
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

}
