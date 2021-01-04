package br.com.tap.faculdadenovaroma.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.tap.faculdadenovaroma.dao.ControllerDAO;
import br.com.tap.faculdadenovaroma.dao.IRControllerDAO;
import br.com.tap.faculdadenovaroma.entidade.Endereco;
import br.com.tap.faculdadenovaroma.entidade.Funcionario;
import br.com.tap.faculdadenovaroma.entidade.Usuario;

public class CadastroFuncionario {
	private IRControllerDAO<Usuario> repositorio;
	
	public CadastroFuncionario(Usuario usuario) {
		this.repositorio = new ControllerDAO<Usuario>(usuario);
	}
	
	public boolean salvar(Usuario usuario) {
		return this.repositorio.salvar(usuario);
	}
	
	public boolean alterar(Usuario usuario) {
		return this.repositorio.alterar(usuario);
	}

	public Funcionario buscar(String _cpf) {
		Object obj = this.repositorio.buscar(_cpf);
		Object[] o = (Object[]) obj;
		
		Funcionario funcionario = new Funcionario();
		funcionario.setId(Long.parseLong(o[0].toString()));
		funcionario.setCpf((String) o[1]);
		funcionario.setNome((String) o[2]);
		funcionario.setTelefone((String) o[3]);
		Endereco endereco = this.buscarEndereco(Long.parseLong(o[0].toString()));
		funcionario.setEndereco(endereco);
		
		return funcionario;
	}
	
	public List<Funcionario> listar() {
		List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
		
		for (Object obj : this.repositorio.listar()) {
			Object[] o = (Object[]) obj;
			
			Funcionario funcionario = new Funcionario();
			funcionario.setId(Long.parseLong(o[0].toString()));
			funcionario.setCpf((String) o[1]);
			funcionario.setNome((String) o[2]);
			funcionario.setTelefone((String) o[3]);
			Endereco endereco = this.buscarEndereco(Long.parseLong(o[0].toString()));
			funcionario.setEndereco(endereco);
			listaFuncionario.add(funcionario);
			
		}
		
		return listaFuncionario;
	}
	
	public boolean excluir(Usuario usuario) {
		return this.repositorio.excluir(usuario);
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
