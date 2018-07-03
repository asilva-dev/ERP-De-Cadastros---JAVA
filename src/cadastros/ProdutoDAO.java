package cadastros;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import cadastros.DBQuery;

public class ProdutoDAO extends DBQuery {
	
	private Produto prod = null;
	
	String   table    = null;
	String[] fields   = null;
	String   keyField = null;
	
	public ProdutoDAO(Produto prod) {
		this.setTable	("cadProdutos");
		this.setFields	(new String[]{"idCadProduto","idCadProdutoFabricante","idCadProdutoMarca","idCadProdutoModelo","tipoMaterial","idCadProdutosRisco", "idCadProdutoCategoria", "idCadProdutoUnidadeMedida", "descr", "tags", "ativo"});
		this.setKeyField("idCadProduto");
		this.setProduto(prod);
	}
	
	public ProdutoDAO() {
		this.setTable	("cadProdutos");
		this.setFields	(new String[]{"idCadProduto","idCadProdutoFabricante","idCadProdutoMarca","idCadProdutoModelo","tipoMaterial","idCadProdutosRisco", "idCadProdutoCategoria", "idCadProdutoUnidadeMedida", "descr", "tags", "ativo"});
		this.setKeyField("idCadProduto");
	}
	

	public void setProduto(Produto prod) {
		this.prod = prod;
	}
	
	public void inserirBanco(Produto prod) {
		
		int rs;
		
		String sql = "INSERT INTO cadProdutos (idCadProduto, idCadProdutoFabricante, idCadProdutoMarca,idCadProdutoModelo,tipoMaterial,idCadProdutosRisco, idCadProdutoCategoria, idCadProdutoUnidadeMedida, descr, tags, ativo) values ";
				 sql += "('"+ Integer.toString(prod.getIdCadProduto()) +"',";
				 sql += " '"+ Integer.toString(prod.getIdCadProdutoFabricante()) +"',";
				 sql += " '"+ Integer.toString(prod.getIdCadProdutoMarca()) +"',";
				 sql += " '"+ Integer.toString(prod.getTipoMaterial()) +"',";
                 sql += " '"+ Integer.toString(prod.getIdCadProdutosRisco()) +"',";
				 sql += " '"+ Integer.toString(prod.getIdCadProdutoCategoria()) +"',";
				 sql += " '"+ Integer.toString(prod.getIdCadProdutoUnidadeMedida()) +"',";
				 sql += " '"+ prod.getDescr() +"',";
				 sql += " '"+ prod.getTags() +"',";
				 sql += " '"+ Integer.toString(prod.getAtivo()) +"');";
					 
		try {
			   
			DBQuery query = new DBQuery();
			
			System.out.printf(sql);
			
			rs = (int) query.executeUpdate(sql);
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erro!");
		}
			
	}
	
	public void selecionarBanco(Produto prod) {
		
		ResultSet rs;
		String sql = "SELECT * FROM cadProdutos where idCadProduto = " + Integer.toString(prod.getIdCadProduto()) + " and descr = " + (prod.getDescr());
		
		DBQuery query = new DBQuery(table, fields, keyField);
		
		rs = query.executeQuery(sql);
		
		try {
			while(rs.next()) {
				prod.setIdCadProduto(Integer.parseInt(rs.getString("idCadProduto")));
				prod.setIdCadProdutoFabricante(Integer.parseInt(rs.getString("idCadProdutoFabricante")));
				prod.setIdCadProdutoMarca(Integer.parseInt(rs.getString("idCadProdutoMarca")));
				prod.setTipoMaterial(Integer.parseInt(rs.getString("tipoMaterial")));
				prod.setIdCadProdutosRisco(Integer.parseInt(rs.getString("idCadProdutosRisco")));
				prod.setIdCadProdutoCategoria(rs.getString("idCadProdutoCategoria"));
				prod.setIdCadProdutoUnidadeMedida(Integer.parseInt(rs.getString("idCadProdutoUnidadeMedida")));
				prod.setDescr(rs.getString("descr"));
				prod.setTags(rs.getString("tags"));
				prod.setAtivo(rs.getString("ativo"));

				
				
				
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "N�o foi possivel fazer a consulta no banco");
		}
		
	}
	
	public int selecionar() {
			
			int rs;
			String sql = "SELECT * FROM cadProdutos";
			
			DBQuery query = new DBQuery(table, fields, keyField);
			
			rs = (int) query.executeUpdate(sql);
			
			return rs;
		}
	
	
	public void deletarBanco(Produto prod) {
			
		int rs;
		
		String sql = "DELETE FROM cadProdutos WHERE idCadProduto = " + Integer.toString(prod.getIdCadProduto());
	
		try {
			   
		DBQuery query = new DBQuery();
		
		System.out.printf(sql);
		
		rs = (int) query.executeUpdate(sql);
		
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erro!");
		}
	}

}
	