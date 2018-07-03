package cadastros;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class ClientesDAO extends DBQuery {

	/**
	 * DAO dos Clientes
	 * 
	 * @author Evellyn dos Santos Silva
	 * 
	 */
	
	private Clientes cliente = null;
	
	String   table    = null;
	String[] fields   = null;
	String   keyField = null;
	
	public ClientesDAO(Clientes cliente) {
		this.setTable	("cadClientes");
		this.setFields	(new String[]{"idCliente","Nome","RG","CPF","Telefone","Email", "Endereço", "Tipo"});
		this.setKeyField("idCliente");
		this.setClientes(cliente);
	}
	
	public ClientesDAO() {
		this.setTable	("cadClientes");
		this.setFields	(new String[]{"idCliente","Nome","RG","CPF","Telefone","Email", "Endereço", "Tipo"});
		this.setKeyField("idCliente");
	}

	public void setClientes(Clientes cliente) {
		this.cliente = cliente;
	}
	
	public void inserirBanco(Clientes cliente) {

		int rs;
		
		String sql = "INSERT INTO cadCliente (nome, rg, cpf, telefone, email, endereco, tipo) VALUES ";
				 sql += "('"+ cliente.getNome() +"',";
				 sql += " '"+ cliente.getRg() +"',";
				 sql += " '"+ cliente.getCpf() +"',";
				 sql += " '"+ cliente.getTel() +"',";
				 sql += " '"+ cliente.getEmail() +"',";
				 sql += " '"+ cliente.getEnd() +"',";
				 sql += " '"+ cliente.getTipoCli() +"');";
					 
		try {
			   
			DBQuery query = new DBQuery();
			
			System.out.printf(sql);
			
			rs = (int) query.executeUpdate(sql);
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erro! Cliente não inserido!");
		}
	}
	
	public void selecionarBanco(Clientes cli) {
		
		ResultSet rs;
		String sql = "SELECT * FROM cadCliente where cpf = " + cli.getCpf();
		
		DBQuery query = new DBQuery(table, fields, keyField);

		System.out.printf(sql);
		rs = query.executeQuery(sql);
		
		
		try {
			while(rs.next()) {
				cli.setIdCliente(Integer.parseInt(rs.getString("idCliente")));
				cli.setNome(rs.getString("nome"));
				cli.setRg(Integer.parseInt(rs.getString("rg")));
				cli.setCpf(Integer.parseInt(rs.getString("cpf")));
				cli.setTel(Integer.parseInt(rs.getString("telefone")));
				cli.setEmail(rs.getString("email"));
				cli.setEnd(rs.getString("endereco"));
				cli.setTipoCli(Integer.parseInt(rs.getString("tipo")));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi possivel fazer a consulta no banco");
		}
	}
	
	public void alterarBanco(Clientes cli) {
			
		int rs;
		
		String sql = "UPDATE cadCliente SET ";
			   sql += "nome = '" + cli.getNome();
			   sql += "', rg = '" + cli.getRg();
			   sql += "', cpf = '" + cli.getCpf();
			   sql += "', telefone = '" + cli.getTel();
			   sql += "', email = '" + cli.getEmail();
			   sql += "', endereco = '" + cli.getEnd();
			   sql += "', tipo = '" + cli.getTipoCli();
			   sql += "' WHERE idCliente = '" + cli.getIdCliente() + "'";
	
		try {
			   
		DBQuery query = new DBQuery();
		
		System.out.printf(sql);
		
		rs = (int) query.executeUpdate(sql);
		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erro! Cliente não alterado!");
		}
	}
	
	public void deletarBanco(Clientes cli) {
		
		int rs;
		
		String sql = "DELETE FROM cadCliente WHERE idCliente = " + cli.getIdCliente();
	
		try {
			   
		DBQuery query = new DBQuery();
		
		System.out.printf(sql);
		
		rs = (int) query.executeUpdate(sql);
		
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erro! Cliente não deletado!");
		}
	}
}
