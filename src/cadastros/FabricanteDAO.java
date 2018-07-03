package cadastros;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import cadastros.DBQuery;

public class FabricanteDAO extends DBQuery {
	
	private Fabricante fab = null;
	
	String   table    = null;
	String[] fields   = null;
	String   keyField = null;
	
	public FabricanteDAO(Fabricante fab) {
		this.setTable	("cadProdutoFabricantes");
		this.setFields	(new String[]{"idCadProdutoFabricante","razaoSocial","cnpj","ie","im","logradouro", "bairro", "cidade", "uf", "pais", "cep", "telefone", "contato", "url"});
		this.setKeyField("idCadProdutoFabricante");
		this.setFabricante(fab);
	}
	
	public FabricanteDAO() {
		this.setTable	("cadProdutoFabricantes");
		this.setFields	(new String[]{"idCadProdutoFabricante","razaoSocial","cnpj","ie","im","logradouro", "bairro", "cidade", "uf", "pais", "cep", "telefone", "contato", "url"});
		this.setKeyField("idCadProdutoFabricante");
	}
	

	public void setFabricante(Fabricante fab) {
		this.fab = fab;
	}
	
	public void inserirBanco(Fabricante fab) {
		
		int rs;
		
		String sql = "INSERT INTO cadProdutoFabricantes (idCadProdutoFabricante, razaoSocial, cnpj, ie, im, logradouro, bairro, cidade, uf, pais, cep, telefone, contato, url) values ";
				 sql += "('"+ Integer.toString(prod.getIdCadProdutoFabricante()) +"',";
				 sql += " '"+ prod.getRazaoSocial() +"',";
				 sql += " '"+ prod.getCNPJ() +"',";
				 sql += " '"+ prod.getIE() +"',";
				 sql += " '"+ prod.getIM() +"',";
				 sql += " '"+ prod.getLogradouro() +"',";
				 sql += " '"+ prod.getBairro() +"',";
                 sql += " '"+ prod.getCidade() +"',";
				 sql += " '"+ prod.getUF() +"',";
				 sql += " '"+ prod.getPais() +"',";
				 sql += " '"+ prod.getCEP() +"',";
				 sql += " '"+ prod.getTelefone() +"',";
				 sql += " '"+ prod.getContato() +"',";
				 sql += " '"+ prod.getURL() +"');";
					 
		try {
			   
			DBQuery query = new DBQuery();
			
			System.out.printf(sql);
			
			rs = (int) query.executeUpdate(sql);
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erro!");
		}
			
	}
	
	public void selecionarBanco(Fabricante fab) {
		
		ResultSet rs;
		String sql = "SELECT * FROM cadProdutoFabricantes where razaoSocial = " + fab.getRazaoSocial()) + " and cnpj = " + fab.getCNPJ());
		
		DBQuery query = new DBQuery(table, fields, keyField);
		
		rs = query.executeQuery(sql);
		
		try {
			while(rs.next()) {
				prod.setIdCadProdutoFabricante(Integer.parseInt(rs.getString("IdCadProdutoFabricante")));
				prod.setRazaoSocial(rs.getString("razaoSocial"));
				prod.setCNPJ(rs.getString("cnpj")));
				prod.setIE(rs.getString("ie")));
				prod.setIM(rs.getString("im"));
				prod.setLogradouro(rs.getString("logradouro"));
				prod.setBairro(rs.getString("bairro")));
				prod.setUF(rs.getString("uf")));
				prod.setPais(rs.getString("pais")));
                prod.setCEP(rs.getString("cep"));
				prod.setTelefone(rs.getString("telefone")));
				prod.setContato(rs.getString("contato")));
				prod.setURL(rs.getString("url")));
				
				
				
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "N�o foi possivel fazer a consulta no banco");
		}
		
	}
	
	public int selecionar() {
			
			int rs;
			String sql = "SELECT * FROM cadProdutoFabricantes";
			
			DBQuery query = new DBQuery(table, fields, keyField);
			
			rs = (int) query.executeUpdate(sql);
			
			return rs;
		}
	

	
	public void deletarBanco(Fabricante fab) {
			
		int rs;
		
		String sql = "DELETE FROM cadProdutoFabricantes WHERE idCadProdutoFabricante = " + Integer.toString(fab.getIdCadProdutoFabricante());
	
		try {
			   
		DBQuery query = new DBQuery();
		
		System.out.printf(sql);
		
		rs = (int) query.executeUpdate(sql);
		
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erro! Conta n�o deletada!");
		}
	}

}