package br.com.tap.faculdadenovaroma.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.tap.faculdadenovaroma.dao.ControllerDAO;
import br.com.tap.faculdadenovaroma.dao.IRControllerDAO;
import br.com.tap.faculdadenovaroma.entidade.Endereco;
import br.com.tap.faculdadenovaroma.entidade.Fornecedor;

public class CadastroFornecedor {
	private IRControllerDAO<Fornecedor> repositorio;
	
	public CadastroFornecedor(Fornecedor fornecedor) {
		this.repositorio = new ControllerDAO<Fornecedor>(fornecedor);
	}
	
	public boolean salvar(Fornecedor fornecedor) {
		return this.repositorio.salvar(fornecedor);
	}
	
	public boolean alterar(Fornecedor fornecedor) {
		return this.repositorio.alterar(fornecedor);
	}

	public Fornecedor buscar(String _cnpj) {
		Object obj = this.repositorio.buscar(_cnpj);
		Object[] o = (Object[]) obj;
		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setId(Long.parseLong(o[0].toString()));
		fornecedor.setCnpj((String) o[1]);
		fornecedor.setNome((String) o[2]);
		fornecedor.setTelefone((String) o[3]);
		Endereco endereco = this.buscarEndereco(Long.parseLong(o[0].toString()));
		fornecedor.setEndereco(endereco);
		
		return fornecedor;
	}
	
	public List<Fornecedor> listar() {
		List<Fornecedor> listaFornecedor = new ArrayList<Fornecedor>();
		
		for (Object obj : this.repositorio.listar()) {
			Object[] o = (Object[]) obj;
			
			Fornecedor fornecedor = new Fornecedor();
			fornecedor.setId(Long.parseLong(o[0].toString()));
			fornecedor.setCnpj((String) o[1]);
			fornecedor.setNome((String) o[2]);
			fornecedor.setTelefone((String) o[3]);
			Endereco endereco = this.buscarEndereco(Long.parseLong(o[0].toString()));
			fornecedor.setEndereco(endereco);
			listaFornecedor.add(fornecedor);
			
		}
		
		return listaFornecedor;
	}
	
	public boolean excluir(Fornecedor fornecedor) {
		return this.repositorio.excluir(fornecedor);
	}

	private Endereco buscarEndereco(long id) {
		Endereco endereco = new Endereco();
		IRControllerDAO<Endereco> repEndereco = new ControllerDAO<Endereco>(endereco);
		
		Object obj = repEndereco.buscar(id);
		Object[] o = (Object[]) obj;
		
		endereco.setId(id);
		endereco.setBairro((String)o[1]);
		endereco.setCep((String)o[2]);
		endereco.setNumero((String)o[3]);
		endereco.setRua((String)o[4]);
		
		return endereco;
	}
}
