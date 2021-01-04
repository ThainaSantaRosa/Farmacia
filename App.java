package br.com.tap.faculdadenovaroma.app;

import java.util.List;

import br.com.tap.faculdadenovaroma.dao.ControllerDAO;
import br.com.tap.faculdadenovaroma.entidade.Cliente;
import br.com.tap.faculdadenovaroma.entidade.Endereco;
import br.com.tap.faculdadenovaroma.negocio.Factory;

public class App {

	public static void main(String[] args) {
		Endereco end = new Endereco();
		end.setRua("Rua1");
		end.setNumero("numero1");
		end.setBairro("bairro1");
		end.setCep("Cep1");
		Cliente cli = new Cliente();
		cli.setCpf("CPF1");
		cli.setEndereco(end);
		cli.setNome("nome1");
		cli.setTelefone("telefone1");
		
		//Controller<Endereco> enderecoController = new Controller<Endereco>(end);
		//enderecoController.salvar(end);
		
//		ControllerDAO<Cliente> clienteController = new ControllerDAO<Cliente>(cli);
//		clienteController.salvarA(cli);
		
		Factory fabrica = Factory.getInstance();
		//fabrica.salvarCliente(cli);
		List<Cliente> listaCli = fabrica.listarCliente();
		Cliente cliente = new Cliente();
		cliente = fabrica.buscarCliente("CPF1");
		fabrica.excluirCliente(cliente);
	}

}
