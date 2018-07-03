package cadastros;

import java.util.ArrayList;

public class Fabricante {
	
	private int idCadProdutoFabricante;
	private String razaoSocial;
    private String CNPJ;
    private String IE;
    private String IM;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String UF;
    private String pais;
    private String CEP;
    private String telefone;
    private String contato;
    private String URL;
    
    
    
	private int getIdCadProdutoFabricante() {
		return idCadProdutoFabricante;
	}
	private void setIdCadProdutoFabricante(int idCadProdutoFabricante) {
		this.idCadProdutoFabricante = idCadProdutoFabricante;
	}
	
	private String getRazaoSocial() {
		return razaoSocial;
	}
	private void setRazaoSocial(int razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	private String getCNPJ() {
		return CNPJ;
	}
	private void setCNPJ(String CNPJ) {
		this.CNPJ = CNPJ;
	}
	private String getIE() {
		return IE;
	}
	private void setIE(String IE) {
		this.IE = IE;
	}
	private String getIM() {
		return IM;
	}
	private void setIM(String IM) {
		this.IM = IM;
	}
	private String getLogradouro() {
		return logradouro;
	}
	private void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	private String getBairro() {
		return bairro;
	}
	private void setBairro(String bairro) {
		this.bairro = bairro;
	}
	private String getCidade() {
		return cidade;
	}
	private void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	private String getUF() {
		return UF;
	}
	private void setUF(String UF) {
		this.UF = UF;
	}
	
	private String getPais() {
		return pais;
	}
	private void setPais(String pais) {
		this.pais = pais;
	}
	
	private String getCEP() {
		return CEP;
	}
	private void setCEP(String CEP) {
		this.CEP = CEP;
	}
	private String getTelefone() {
		return telefone;
	}
	private void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	private String getContato() {
		return contato;
	}
	private void setContato(String contato) {
		this.contato = contato;
	}
	private String getURL() {
		return URL;
	}
	private void setURL(String URL) {
		this.URL = URL;
	}
}