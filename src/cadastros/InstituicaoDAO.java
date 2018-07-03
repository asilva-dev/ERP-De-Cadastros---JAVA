package cadastros;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import cadastros.DBQuery;

public class InstituicaoDAO extends DBQuery {
	
	/**
	 * DAO das Instituições
	 * 
	 * @author Felipe Trindade Antoniolli
	 * 
	 */
	
	private Instituicao instituicao = null;
	
	String   table    = null;
	String[] fields   = null;
	String   keyField = null;
	
	public InstituicaoDAO(Instituicao instituicao) {
		this.setTable	("cadContas");
		this.setFields	(new String[]{"idConta","idBanco","agencia","conta","tipoConta","endereco", "nomeTitular", "cpfCnpj", "status"});
		this.setKeyField("idConta");
		this.setInstituicao(instituicao);
	}
	
	public InstituicaoDAO() {
		this.setTable	("cadContas");
		this.setFields	(new String[]{"idConta","idBanco","agencia","conta","tipoConta","endereco", "nomeTitular", "cpfCnpj", "status"});
		this.setKeyField("idConta");
	}
	

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}
	
	public void inserirBanco(Instituicao instituicao) {
		
		int rs;
		
		String sql = "INSERT INTO cadcontas (idbanco, agencia, conta, tipoConta, endereco, nomeTitular, cpfCnpj, status) values ";
				 sql += "('"+ Integer.toString(instituicao.getIdBanco()) +"',";
				 sql += " '"+ Integer.toString(instituicao.getConta()) +"',";
				 sql += " '"+ Integer.toString(instituicao.getAgencia()) +"',";
				 sql += " '"+ Integer.toString(instituicao.getTipoConta()) +"',";
				 sql += " '"+ instituicao.getEndereco() +"',";
				 sql += " '"+ instituicao.getNomeTitular() +"',";
				 sql += " '"+ Integer.toString(instituicao.getCpfCnpj()) +"',";
				 sql += " '"+ Integer.toString(instituicao.getAtivo()) +"');";
					 
		try {
			   
			DBQuery query = new DBQuery();
			
			System.out.printf(sql);
			
			rs = (int) query.executeUpdate(sql);
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erro! Conta não inserida!");
		}
			
	}
	
	public void selecionarBanco(Instituicao instituicao) {
		
		ResultSet rs;
		String sql = "SELECT * FROM cadContas where conta = " + Integer.toString(instituicao.getConta()) + " and agencia = " + Integer.toString(instituicao.getAgencia());
		
		DBQuery query = new DBQuery(table, fields, keyField);
		
		rs = query.executeQuery(sql);
		
		try {
			while(rs.next()) {
				instituicao.setIdConta(Integer.parseInt(rs.getString("idConta")));
				instituicao.setAgencia(Integer.parseInt(rs.getString("agencia")));
				instituicao.setConta(Integer.parseInt(rs.getString("conta")));
				instituicao.setTipoConta(Integer.parseInt(rs.getString("tipoConta")));
				instituicao.setEndereco(rs.getString("endereco"));
				instituicao.setNomeTitular(rs.getString("nomeTitular"));
				instituicao.setCpfCnpj(Integer.parseInt(rs.getString("cpfCnpj")));
				instituicao.setIdBanco(Integer.parseInt(rs.getString("idBanco")));
				instituicao.setAtivo(Integer.parseInt(rs.getString("status")));
				
				
				
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi possivel fazer a consulta no banco");
		}
		
	}
	
	public int selecionar() {
			
			int rs;
			String sql = "SELECT * FROM cadContas";
			
			DBQuery query = new DBQuery(table, fields, keyField);
			
			rs = (int) query.executeUpdate(sql);
			
			return rs;
		}
	
	public void alterarBanco(Instituicao instituicao) {
		
		int rs;
		
		String sql = "UPDATE cadContas SET ";
			   sql += "idBanco = '" + Integer.toString(instituicao.getIdBanco());
			   sql += "', conta = '" + Integer.toString(instituicao.getConta());
			   sql += "', agencia = '" + Integer.toString(instituicao.getAgencia());
			   sql += "', tipoConta = '" + Integer.toString(instituicao.getTipoConta());
			   sql += "', endereco = '" + instituicao.getEndereco();
			   sql += "', nomeTitular = '" + instituicao.getNomeTitular();
			   sql += "', cpfCnpj = '" + Integer.toString(instituicao.getCpfCnpj());
			   sql += "', status = '" + Integer.toString(instituicao.getAtivo());
			   sql += "' WHERE idConta = " + instituicao.getIdConta();
		
	
		try {
			   
		DBQuery query = new DBQuery();
		
		System.out.printf(sql);
		
		rs = (int) query.executeUpdate(sql);
		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erro! Conta não alterada!");
		}
	}
	
	public void deletarBanco(Instituicao instituicao) {
			
		int rs;
		
		String sql = "DELETE FROM cadContas WHERE idConta = " + Integer.toString(instituicao.getIdConta());
	
		try {
			   
		DBQuery query = new DBQuery();
		
		System.out.printf(sql);
		
		rs = (int) query.executeUpdate(sql);
		
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erro! Conta não deletada!");
		}
	}

}
	

