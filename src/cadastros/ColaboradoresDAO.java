package cadastros;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class ColaboradoresDAO extends DBQuery{
    
        /**
	 * create By Amanda Priscila da Silva
	 * 
	 */
	
	
private Colaboradores colaboradores = null;
	
	String   table    = null;
	String[] fields   = null;
	String   keyField = null;
	
	public ColaboradoresDAO(Colaboradores colaboradores) {
		this.setTable	("cadColab");
		this.setFields	(new String[]{"idColab","nome","cpf","dtnasc", "telefone", "celular", "endereco","tipo" });
		this.setKeyField("idColab");
		this.setColaboradores(colaboradores);
	}
	
	public ColaboradoresDAO() {
		this.setTable	("cadColab");
		this.setFields	(new String[]{"idColab","nome","cpf","dtnasc", "telefone", "celular", "endereco","tipo"});
		this.setKeyField("colaboradores");
	}
	

	public void setColaboradores(Colaboradores colaboradores) {
		this.colaboradores = colaboradores;
	}
        
        public void inserirColaboradores(Colaboradores colaboradores) {
		
		int rs;
		
		String sql = "INSERT INTO cadColab (idColab, nome, cpf, dtnasc, telefone, celular, endereco, tipo) values ";
				 sql += "('"+ Integer.toString(colaboradores.getidColab()) +"',";
				 sql += " '"+ Integer.toString(colaboradores.getCpf()) +"',";
				 sql += " '"+ Integer.toString(colaboradores.getTipoInt()) +"',";
				 sql += " '"+ colaboradores.getDtnasc() +"',";
                                 sql += " '"+ colaboradores.getTelefone() +"',";
                                 sql += " '"+ colaboradores.getCelular() +"',";
				 sql += " '"+ colaboradores.getEndereco() +"',";
				 sql += " '"+ colaboradores.getNome() +"',";
				 sql += " '"+ Integer.toString(colaboradores.getCpf()) +"',";
				 
					 
		try {
			   
			DBQuery query = new DBQuery();
			
			System.out.printf(sql);
			
			rs = (int) query.executeUpdate(sql);
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erro! Colaborador não inserido!");
		}
			
	}
	
	public void selecionarColaboradores(Colaboradores colaboradores) {
		
		ResultSet rs;
		String sql = "SELECT * FROM cadColab where colab = " + Integer.toString(colaboradores.getCpf()) + " and agencia = " + colaboradores.getNome();
		
		DBQuery query = new DBQuery(table, fields, keyField);
		
		rs = query.executeQuery(sql);
		
		try {
		
			
		colaboradores.setCpf(Integer.parseInt(rs.getString("CPF")));
		colaboradores.setNome(rs.getString("Nome"));
		colaboradores.setDtnasc(rs.getString("Data de nascimento"));
		colaboradores.setTelefone(rs.getString("Telefone"));
		colaboradores.setCelular(rs.getString("Celular"));
		colaboradores.setEndereco(rs.getString("Endere�o"));
		colaboradores.setTipo(Integer.parseInt(rs.getString("Tipo")));
		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "N�o foi possivel fazer a consulta no banco");
		}
		
	}
	
public ResultSet selecionar() {
		
		ResultSet rs;
		String sql = "SELECT * FROM cadColab";
	
	DBQuery query = new DBQuery(table, fields, keyField);
	
	rs = query.executeQuery(sql);
	
	return (rs);
}
	
	public void alterarColab(Colaboradores colaboradores) {
		
		int rs;
                
		String sql = "UPDATE cadColab SET ";
			   sql += "idColab = 		" + Integer.toString(colaboradores.getidColab());
			   sql += "nome = 		" + colaboradores.getNome();
			   sql += "cpf = 		" + Integer.toString(colaboradores.getCpf());
			   sql += "dtnasc = 		" + colaboradores.getDtnasc();
			   sql += "telefone = 		" + colaboradores.getTelefone();
			   sql += "celular = 		" + colaboradores.getCelular();
			   sql += "endereco =		" + colaboradores.getEndereco();
			   sql += "tipo = 		" + Integer.toString(colaboradores.getTipoInt());
			   sql += " WHERE idColab = " + Integer.toString(colaboradores.getidColab());
			  	
		try {
			   
		DBQuery query = new DBQuery();
		
		System.out.printf(sql);
		
		rs = (int) query.executeUpdate(sql);
		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erro! Conta n�o alterada!");
		}
			
	}
        
        
       public void deletarColab(Colaboradores colaboradores) {
			
		int rs;
		
		String sql = "DELETE FROM cadColab WHERE idColab = " + Integer.toString(colaboradores.getidColab());
	
		try {
			   
		DBQuery query = new DBQuery();
		
		System.out.printf(sql);
		
		rs = (int) query.executeUpdate(sql);
		
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erro! Colaborador não deletado!");
		}
	}
       
       

}
