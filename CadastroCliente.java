package br.com.tap.faculdadenovaroma.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.tap.faculdadenovaroma.dao.ControllerDAO;
import br.com.tap.faculdadenovaroma.dao.IRControllerDAO;
import br.com.tap.faculdadenovaroma.entidade.Cliente;
import br.com.tap.faculdadenovaroma.entidade.Endereco;

public class CadastroCliente {
	private IRControllerDAO<Cliente> repositorio;
	
	public CadastroCliente(Cliente cliente) {
		this.repositorio = new ControllerDAO<Cliente>(cliente);
	}
	
	public boolean salvar(Cliente cliente) {
		return this.repositorio.salvar(cliente);
	}
	
	public boolean alterar(Cliente cliente) {
		return this.repositorio.alterar(cliente);
	}

	public Cliente buscar(String _cpf) {
		Object obj = this.repositorio.buscar(_cpf);
		Object[] o = (Object[]) obj;
		
		Cliente cliente = new Cliente();
		cliente.setId(Long.parseLong(o[0].toString()));
		cliente.setCpf((String) o[1]);
		cliente.setNome((String) o[2]);
		cliente.setTelefone((String) o[3]);
		Endereco endereco = this.buscarEndereco(Long.parseLong(o[0].toString()));
		cliente.setEndereco(endereco);
		
		return cliente;
	}
	
	public List<Cliente> listar() {
		List<Cliente> listaCliente = new ArrayList<Cliente>();
		
		for (Object obj : this.repositorio.listar()) {
			Object[] o = (Object[]) obj;
			
			Cliente cliente = new Cliente();
			cliente.setId(Long.parseLong(o[0].toString()));
			cliente.setCpf((String) o[1]);
			cliente.setNome((String) o[2]);
			cliente.setTelefone((String) o[3]);
			Endereco endereco = this.buscarEndereco(Long.parseLong(o[0].toString()));
			cliente.setEndereco(endereco);
			listaCliente.add(cliente);
			
		}
		
		return listaCliente;
	}
	
	public boolean excluir(Cliente cliente) {
		return this.repositorio.excluir(cliente);
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
