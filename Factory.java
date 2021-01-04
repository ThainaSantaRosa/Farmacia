package br.com.tap.faculdadenovaroma.negocio;

import java.util.List;

import br.com.tap.faculdadenovaroma.entidade.Caixa;
import br.com.tap.faculdadenovaroma.entidade.Cliente;
import br.com.tap.faculdadenovaroma.entidade.Fornecedor;
import br.com.tap.faculdadenovaroma.entidade.Funcionario;
import br.com.tap.faculdadenovaroma.entidade.Produto;
import br.com.tap.faculdadenovaroma.entidade.Usuario;

public class Factory {
	private static Factory instancia;
	
	private CadastroCaixa cadCaixa;
	private CadastroCliente cadCliente;
	private CadastroFornecedor cadFornecedor;
	private CadastroFuncionario cadFuncionario;
	private CadastroProduto cadProduto;
	
	private Factory() {
		this.initFactory();
	}
	
	public static Factory getInstance() {
		if (instancia == null) {
			instancia = new Factory();
			return instancia;
		} else
			return instancia;
	}
	
	private void initFactory() {
		this.cadCaixa = new CadastroCaixa(new Caixa());
		this.cadCliente = new CadastroCliente(new Cliente());
		this.cadFornecedor = new CadastroFornecedor(new Fornecedor());
		this.cadFuncionario = new CadastroFuncionario(new Usuario());
		this.cadProduto = new CadastroProduto(new Produto());
	}
	
	//Funções de cadastro Cliente
	
	public boolean salvarCliente(Cliente cliente) {
		return this.cadCliente.salvar(cliente);
	}
	
	public boolean alterarCliente(Cliente cliente) {
		return this.cadCliente.alterar(cliente);
	}

	public Cliente buscarCliente(String _cpf) {
		return this.cadCliente.buscar(_cpf);
	}
	
	public List<Cliente> listarCliente() {
		return this.cadCliente.listar();
	}
	
	public boolean excluirCliente(Cliente cliente) {
		return this.cadCliente.excluir(cliente);
	}
	
	//Funções de Cadastro Fornecedor
	
	public boolean salvarFornecedor(Fornecedor fornecedor) {
		return this.cadFornecedor.salvar(fornecedor);
	}
	
	public boolean alterarFornecedor(Fornecedor fornecedor) {
		return this.cadFornecedor.alterar(fornecedor);
	}

	public Fornecedor buscarFornecedor(String _cnpj) {
		return this.cadFornecedor.buscar(_cnpj);
	}
	
	public List<Fornecedor> listarFornecedor() {
		return this.cadFornecedor.listar();
	}
	
	public boolean excluirFornecedor(Fornecedor fornecedor) {
		return this.cadFornecedor.excluir(fornecedor);
	}
	
	//Funções de Cadastro Funcionario
	
	public boolean salvarFuncionario(Usuario usuario) {
		return this.cadFuncionario.salvar(usuario);
	}
	
	public boolean alterarFuncionario(Usuario usuario) {
		return this.cadFuncionario.alterar(usuario);
	}

	public Funcionario buscarFuncionario(String _cpf) {
		return this.cadFuncionario.buscar(_cpf);
	}
	
	public List<Funcionario> listarFuncionario() {
		return this.cadFuncionario.listar();
	}
	
	public boolean excluirFuncionario(Usuario usuario) {
		return this.cadFuncionario.excluir(usuario);
	}
	
	//Funções de Cadastro Produto
	
	public boolean salvarProduto(Produto produto) {
		return this.cadProduto.salvar(produto);
	}
	
	public boolean alterarProduto(Produto produto) {
		return this.cadProduto.alterar(produto);
	}

	public Produto buscarProduto(String nome) {
		return this.cadProduto.buscar(nome);
	}
	
	public List<Produto> listarProduto() {
		return this.cadProduto.listar();
	}
	
	public boolean excluirProduto(Produto produto) {
		return this.cadProduto.excluir(produto);
	}
	
	//Funções de Cadastro Caixa
	
	public boolean salvarCaixa(Caixa caixa) {
		return this.cadCaixa.salvar(caixa);
	}
	
	public boolean alterarCaixa(Caixa caixa) {
		return this.cadCaixa.alterar(caixa);
	}

	public List<Caixa> listarCaixa() {
		return this.cadCaixa.listar();
	}
	
	public boolean excluirCaixa(Caixa caixa) {
		return this.cadCaixa.excluir(caixa);
	}
}
