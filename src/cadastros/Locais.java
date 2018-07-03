
package cadastros;

import java.util.ArrayList;
import java.util.*;

public class Locais {
   	
	private int salas;
	private int armarios;
	private int departamentos;
    private int tipo;
    private String nome;
	private String endereco;
	private String numero;
	
	
	public int getSalas() {
		return salas;
	}
	public void setSalas(String nome) {
		this.salas = salas;
	}
	public int getArmarios() {
		return armarios;
	}
	public void setArmarios(int armarios) {
		this.armarios = armarios;
	}
	public int getDepartamentos() {
		return departamentos;
	}
	public void setDepartamentos(int departamentos) {
		this.departamentos = departamentos;
	}
	public int getTipoInt() {
		return tipo;
	}
	public String getTipoStr() {
		switch(tipo) {
		
		case 1: 
			return "Departamento";
		case 2:
			return"Armarios";
		case 3:
			return "Salas";
		default:
			return "Nao foi possivel inserir o tipo de banco";
		}
	}
	
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
}

