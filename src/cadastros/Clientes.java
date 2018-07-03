package cadastros;

public class Clientes {
	
	/**
	 * Model dos Clientes
	 * 
	 * @author Evellyn dos Santos Silva
	 * 
	 */
	
	private int idCliente;
	private String nome;
	private int rg;
	private int cpf;
	private int tel;
	private String email;
	private String end;
	private int tipoCli;
	
	public int getTipoCli() {
		return tipoCli;
	}
	public void setTipoCli(int tipoCli) {
		this.tipoCli = tipoCli;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getRg() {
		return rg;
	}
	public void setRg(int rg) {
		this.rg = rg;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
}
