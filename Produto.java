package br.com.tap.faculdadenovaroma.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column
	private String codigoBarras;
	@Column
	private String nome;
	@Column
	private String descricao;
	@Column
	private float precoCompra;
	@Column
	private int qtdEstoque;
	@Column
	private float porcentagemLucro;
	@Column
	private String dtCompra;
	@Column
	private String dtValidade;
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getPrecoCompra() {
		return precoCompra;
	}
	public void setPrecoCompra(float precoCompra) {
		this.precoCompra = precoCompra;
	}
	public int getQtdEstoque() {
		return qtdEstoque;
	}
	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}
	public float getPorcentagemLucro() {
		return porcentagemLucro;
	}
	public void setPorcentagemLucro(float porcentagemLucro) {
		this.porcentagemLucro = porcentagemLucro;
	}
	public String getDtCompra() {
		return dtCompra;
	}
	public void setDtCompra(String dtCompra) {
		this.dtCompra = dtCompra;
	}
	public String getDtValidade() {
		return dtValidade;
	}
	public void setDtValidade(String dtValidade) {
		this.dtValidade = dtValidade;
	}
}
