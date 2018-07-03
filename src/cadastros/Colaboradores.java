/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastros;

import java.util.ArrayList;

public class Colaboradores {
    
        /**
	 * create By Amanda Priscila da Silva
	 * 
	 */
    
	private int idColab;
	private String nome;
	private int cpf;
        private String dtnasc;
	private String telefone;
	private String celular;
        private String endereco;
	private int tipo;
	
	
	public int getidColab() {
		return idColab;
	}
	public void setidColab(int idColab) {
		this.idColab = idColab;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
        public String getDtnasc() {
		return dtnasc;
	}
	public void setDtnasc(String dtnasc) {
		this.dtnasc = dtnasc;
	}        
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getTipoInt() {
		return tipo;
	}
	public String getTipoStr() {
		switch(tipo) {
		
		case 1: 
			return "Proprietario";
		case 2:
			return"Acionista";
		case 3:
			return "Funcionarios";
		case 4:
			return "Terceirizados";		
		default:
			return "N�o foi possivel inserir o tipo de banco";
		}
	}
	
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

    int getTipoConta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
