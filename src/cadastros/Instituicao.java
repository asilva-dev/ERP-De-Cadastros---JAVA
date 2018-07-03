package cadastros;

import java.util.ArrayList;

public class Instituicao {
	
	/**
	 * Model da Instituicao
	 * 
	 * @author Felipe Trindade Antoniolli
	 * 
	 */
	
	private int idConta;
	private int idBanco;
	private int agencia;
	private int conta;
	private int tipoConta;
	private String endereco;
	private String nomeTitular;
	private int cpfCnpj;	
	private int ativo;
	
	public int getIdConta() {
		return idConta;
	}
	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}
	public int getAtivo() {
		return ativo;
	}
	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public int getConta() {
		return conta;
	}
	public void setConta(int conta) {
		this.conta = conta;
	}
	public int getTipoConta() {
		return tipoConta;
	}
	public void setTipoConta(int tipoConta) {
		this.tipoConta = tipoConta;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNomeTitular() {
		return nomeTitular;
	}
	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}
	public int getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(int cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public int getIdBanco() {
		return idBanco;
	}
	public void setIdBanco(int idBanco) {
		this.idBanco = idBanco;
	}
}
