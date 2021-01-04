package br.com.tap.faculdadenovaroma.negocio;

import java.util.List;

import br.com.tap.faculdadenovaroma.dao.ControllerDAO;
import br.com.tap.faculdadenovaroma.dao.IRControllerDAO;
import br.com.tap.faculdadenovaroma.entidade.Caixa;

public class CadastroCaixa {
	private IRControllerDAO<Caixa> repositorio;
	
	public CadastroCaixa(Caixa caixa) {
		this.repositorio = new ControllerDAO<Caixa>(caixa);
	}
	
	public boolean salvar(Caixa caixa) {
		return this.repositorio.salvar(caixa);
	}
	
	public boolean alterar(Caixa caixa) {
		return this.repositorio.alterar(caixa);
	}

	public List<Caixa> listar() {
		return this.repositorio.listar();
	}
	
	public boolean excluir(Caixa caixa) {
		return this.repositorio.excluir(caixa);
	}
}
