package br.com.tap.faculdadenovaroma.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.tap.faculdadenovaroma.entidade.Caixa;
import br.com.tap.faculdadenovaroma.entidade.Cliente;
import br.com.tap.faculdadenovaroma.entidade.Fornecedor;
import br.com.tap.faculdadenovaroma.entidade.Funcionario;
import br.com.tap.faculdadenovaroma.entidade.Produto;

public class ControllerDAO<T> implements IRControllerDAO<T> {
	private String className;
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public ControllerDAO(T obj) {
		this.className = obj.getClass().getSimpleName();
		this.emf = Persistence.createEntityManagerFactory("farmarcia_Dev");
		this.em = emf.createEntityManager();
	}
	
	public boolean salvar(T obj) {
		boolean salvou = true;
		
		try {
			this.em.getTransaction().begin();
			this.em.merge(obj);
			this.em.flush();
			this.em.getTransaction().commit();
		} catch (Exception e) {
			salvou = false;
		} finally {
			this.emf.close();
		}
		
		return salvou;
	}
	
	public boolean alterar(T obj) {
		boolean alterou = true;
		
		try {
			this.em.getTransaction().begin();
			this.em.merge(obj);
			this.em.flush();
			this.em.getTransaction().commit();
		} catch (Exception e) {
			alterou = false;
		} finally {
			this.emf.close();
		}
		
		return alterou;
	}
	
	@SuppressWarnings("unchecked")
	public T buscar(String value) {
		T obj = null;
		String query = "";

		if (this.className.equalsIgnoreCase(Cliente.class.getSimpleName()))
			query = "SELECT * FROM CLIENTE WHERE CPF = '"+ value+"'";
		else if (this.className.equalsIgnoreCase(Fornecedor.class.getSimpleName()))
			query = "SELECT * FROM FORNECEDOR WHERE CNPJ = "+ value;
		else if (this.className.equalsIgnoreCase(Funcionario.class.getSimpleName()))
			query = "SELECT * FROM FUNCIONARIO WHERE CPF = "+ value;
		else if (this.className.equalsIgnoreCase(Produto.class.getSimpleName()))
			query = "SELECT * FROM PRODUTO WHERE NOME = "+ value;
		
		try {
			this.em.getTransaction().begin();
			Query q = em.createNativeQuery(query);
			obj = (T) q.getSingleResult();
			this.em.getTransaction().commit();
		} catch (Exception e) {
			obj = null;
		} finally {
			this.emf.close();
		}
		
		return obj;
	}
	
	@SuppressWarnings("unchecked")
	public T buscar(long id) {
		T obj = null;
		String query = "SELECT * FROM ENDERECO WHERE ID = "+id;
		
		try {
			this.em.getTransaction().begin();
			Query q = em.createNativeQuery(query);
			obj = (T) q.getSingleResult();
			this.em.getTransaction().commit();
		} catch (Exception e) {
			obj = null;
		} finally {
			this.emf.close();
		}
		
		return obj;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> listar() {
		List<T> lista = null;
		String query = "";

		if (this.className.equalsIgnoreCase(Cliente.class.getSimpleName()))
			query = "SELECT * FROM CLIENTE";
		else if (this.className.equalsIgnoreCase(Fornecedor.class.getSimpleName()))
			query = "SELECT * FROM FORNECEDOR";
		else if (this.className.equalsIgnoreCase(Funcionario.class.getSimpleName()))
			query = "SELECT * FROM FUNCIONARIO";
		else if (this.className.equalsIgnoreCase(Produto.class.getSimpleName()))
			query = "SELECT * FROM PRODUTO";
		else if (this.className.equalsIgnoreCase(Caixa.class.getSimpleName()))
			query = "SELECT * FROM CAIXA";
		
		try {
			this.em.getTransaction().begin();
			Query q = em.createNativeQuery(query);
			lista = q.getResultList();
			this.em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			lista = null;
		} finally {
			this.emf.close();
		}
		
		return lista;
	}
	
	public boolean excluir(T obj) {
		boolean excluiu = true;
		
		try {
			this.em.getTransaction().begin();
			this.em.remove(em.getReference(obj.getClass(), ((Cliente)obj).getId()));
			this.em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			excluiu = false;
		} finally {
			this.emf.close();
		}
		
		return excluiu;
	}
}
