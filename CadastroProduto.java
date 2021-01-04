package br.com.tap.faculdadenovaroma.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.tap.faculdadenovaroma.dao.ControllerDAO;
import br.com.tap.faculdadenovaroma.dao.IRControllerDAO;
import br.com.tap.faculdadenovaroma.entidade.Produto;

public class CadastroProduto {
	private IRControllerDAO<Produto> repositorio;
	
	public CadastroProduto(Produto produto) {
		this.repositorio = new ControllerDAO<Produto>(produto);
	}
	
	public boolean salvar(Produto produto) {
		return this.repositorio.salvar(produto);
	}
	
	public boolean alterar(Produto produto) {
		return this.repositorio.alterar(produto);
	}

	public Produto buscar(String nome) {
		Object obj = this.repositorio.buscar(nome);
		Object[] o = (Object[]) obj;
		
		Produto produto = new Produto();
		produto.setId(Long.parseLong(o[0].toString()));
		produto.setCodigoBarras((String) o[1]);
		produto.setNome((String) o[2]);
		produto.setDescricao((String) o[3]);
		produto.setPrecoCompra(Float.parseFloat(o[4].toString()));
		produto.setQtdEstoque(Integer.parseInt(o[5].toString()));
		produto.setPorcentagemLucro(Float.parseFloat(o[6].toString()));
		produto.setDtCompra((String) o[7]);
		produto.setDtValidade((String) o[8]);
		
		return produto;
	}
	
	public List<Produto> listar() {
		List<Produto> listaProduto = new ArrayList<Produto>();
		
		for (Object obj : this.repositorio.listar()) {
			Object[] o = (Object[]) obj;
			
			Produto produto = new Produto();
			produto.setId(Long.parseLong(o[0].toString()));
			produto.setCodigoBarras((String) o[1]);
			produto.setNome((String) o[2]);
			produto.setDescricao((String) o[3]);
			produto.setPrecoCompra(Float.parseFloat(o[4].toString()));
			produto.setQtdEstoque(Integer.parseInt(o[5].toString()));
			produto.setPorcentagemLucro(Float.parseFloat(o[6].toString()));
			produto.setDtCompra((String) o[7]);
			produto.setDtValidade((String) o[8]);
			
			listaProduto.add(produto);
			
		}
		
		return listaProduto;
	}
	
	public boolean excluir(Produto produto) {
		return this.repositorio.excluir(produto);
	}
}
