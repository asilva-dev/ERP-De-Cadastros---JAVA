package cadastros;

import java.util.ArrayList;

public class Instituicao {
	
	private int idCadProduto;
	private int idCadProdutoFabricante;
	private int idCadProdutoMarca;
	private int idCadProdutoModelo;
	private int tipoMaterial;
    private int idCadProdutosRisco;
    private int idCadProdutoCategoria;
    private int idCadProdutoUnidadeMedida;
	private String descr;
	private String tags;
	private String ativo;
	
	private int getIdCadProduto() {
		return idCadProduto;
	}
	private void setIdCadProduto(int idCadProduto) {
		this.idCadProduto = idCadProduto;
	}
	private int getIdCadProdutoFabricante() {
		return idCadProdutoFabricante;
	}
	private void setIdCadProdutoFabricante(int idCadProdutoFabricante) {
		this.idCadProdutoFabricante = idCadProdutoFabricante;
	}
	private int getIdCadProdutoMarca() {
		return idCadProdutoMarca;
	}
	private void setIdCadProdutoMarca(int idCadProdutoMarca) {
		this.idCadProdutoMarca = idCadProdutoMarca;
	}
	private int getIdCadProdutoModelo() {
		return idCadProdutoModelo;
	}
	private void setIdCadProdutoModelo(int idCadProdutoModelo) {
		this.idCadProdutoModelo = idCadProdutoModelo;
	}
	private int getTipoMaterial() {
		return tipoMaterial;
	}
	private void setTipoMaterial(int tipoMaterial) {
		this.tipoMaterial = tipoMaterial;
	}
	private int getIdCadProdutosRisco() {
		return idCadProdutosRisco;
	}
	private void setIdCadProdutosRisco(int idCadProdutosRisco) {
		this.idCadProdutosRisco = idCadProdutosRisco;
	}
	private int getIdCadProdutoCategoria() {
		return idCadProdutoCategoria;
	}
	private void setIdCadProdutoCategoria(int idCadProdutoCategoria) {
		this.idCadProdutoCategoria = idCadProdutoCategoria;
	}
	private int getIdCadProdutoUnidadeMedida() {
		return idCadProdutoUnidadeMedida;
	}
	private void setIdCadProdutoUnidadeMedida(int idCadProdutoUnidadeMedida) {
		this.idCadProdutoUnidadeMedida = idCadProdutoUnidadeMedida;
	}	
	
	private String getDescr() {
		return descr;
	}
	private void setDescr(String descr) {
		this.descr = descr;
	}	
	private String getTags() {
		return tags;
	}
	private void setTags(String tags) {
		this.tags = tags;
	}	
	private String getAtivo() {
		return ativo;
	}
	private void setAtivo(String ativo) {
		this.ativo = ativo;
	}	
    
    }