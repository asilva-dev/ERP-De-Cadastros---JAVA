package cadastros;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import cadastros.DBQuery;

public class LocaisDAO extends DBQuery {
	
	/**
	 * DAO dos Locais
	 * 
	 * @author Beatriz Felipe 
	 * 
	 */
	
	private Locais locais = null;
	
	String   table    = null;
	String[] fields   = null;
	String   keyField = null;
	
	public LocaisDAO(Locais Locais) {
		this.setTable	("cadLocais");
		this.setFields	(new String[]{"nome","num","end","tipo"});
		this.setKeyField("idLocais");
		this.setLocais(locais);
	}
	
	public LocaisDAO() {
		this.setTable	("cadLocais");
		this.setFields	(new String[]{"nome","num","end","tipo"});
		this.setKeyField("idLocais");
		this.setLocais(locais);
	}

	public void setLocais(Locais locais) {
		this.locais = locais;
	}
	
	public void inserirBanco(Locais locais) {
		
		int rs;
		
		String sql = "INSERT INTO cadLocais (nome, num, end, tipo) values ";
				 sql += " '"+ locais.getEndereco() +"',";
				 sql += " '"+ locais.getNumero() +"',";
				 sql += " '"+ locais.getTipoStr() +"',";
				 sql += " '"+ locais.getNome() +"',";

					 
		try {
			   
			DBQuery query = new DBQuery();
			
			System.out.printf(sql);
			
			rs = (int) query.executeUpdate(sql);
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erro! Local não inserido!");
		}
			
	}
	
	public void selecionarBanco(Locais locais) {
		
		ResultSet rs;
		String sql = "SELECT * FROM cadLocais where num = " + locais.getNumero();
		
		DBQuery query = new DBQuery(table, fields, keyField);
		
		rs = query.executeQuery(sql);
		
		try {
			while(rs.next()) {
				locais.setNumero(rs.getString("num"));
				locais.setTipo (rs.getInt("tipo"));
				locais.setEndereco(rs.getString("end"));
				locais.setNome(rs.getString("nome"));
	
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi possivel fazer a consulta no banco");
		}
		
	}
	
	public int selecionar() {
			
			int rs;
			String sql = "SELECT * FROM cadLocais";
			
			DBQuery query = new DBQuery(table, fields, keyField);
			
			rs = (int) query.executeUpdate(sql);
			
			return rs;
		}
	
	public void alterarBanco(Locais locais) {
		
		int rs;
		
		String sql = "UPDATE cadLocais SET ";
			   sql += "', tipo = '" + locais.getTipoStr();
			   sql += "', end = '" + locais.getEndereco();
			   sql += "', nome = '" + locais.getNome();
			   sql += "', num = '" + locais.getNumero();
		
	
		try {
			   
		DBQuery query = new DBQuery();
		
		System.out.printf(sql);
		
		rs = (int) query.executeUpdate(sql);
		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erro! Local não alterado!");
		}
	}
	
	public void deletarBanco(Locais locais) {
			
		int rs;
		
		String sql = "DELETE FROM cadLocais WHERE idLocais = " + Integer.toString(locais.getIdLocais());
	
		try {
			   
		DBQuery query = new DBQuery();
		
		System.out.printf(sql);
		
		rs = (int) query.executeUpdate(sql);
		
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erro! Local não deletado!");
		}
	}

}
	
