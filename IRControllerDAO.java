package br.com.tap.faculdadenovaroma.dao;

import java.util.List;

public interface IRControllerDAO<T> {
	public boolean salvar(T obj);
	public boolean alterar(T obj);
	public T buscar(String value);
	public T buscar(long id);
	public List<T> listar();
	public boolean excluir(T obj);
}
