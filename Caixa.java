package br.com.tap.faculdadenovaroma.entidade;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="caixa")
public class Caixa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "usuario_id")
	private Usuario user;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "produto_id")
	private List<Produto> produtos;
	/*@Column
	private List<Integer> qtd;*/
	@Column
	private double total;
	@Column
	private Date dataCompra;
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
/*	public List<Integer> getQtd() {
		return qtd;
	}
	public void setQtd(List<Integer> qtd) {
		this.qtd = qtd;
	}*/
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Date getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	
	
}
