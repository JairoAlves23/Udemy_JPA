package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAO <E>{
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	//           <Produto> classe
	private Class<E> classe;
	
	//EntityManager em = emf.createEntityManager();
	
	static {
		try {
			emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public DAO() {
		this(null);
	}
	
	public DAO(Class<E> classe) {
	//ex. de criação do objeto da classe: DAO<Produto> dao = new DAO(<E>=Produto.class = classe);	
		this.classe = classe;
		em = emf.createEntityManager();
	}
	
	public DAO<E> abrirT() {
		//ex:Produto prod1 = new Produto("Caneta", 7.45);
		//dao.abrirT();
		em.getTransaction().begin();
		return this;
	}
	
	public DAO<E> fecharT() {
		//ex:Produto prod1 = new Produto("Caneta", 7.45);
		//dao.fecharT();
		em.getTransaction().commit();
		return this;
	}
	
	public DAO<E> incluirT(E entidade) {
		//ex:Produto prod1 = new Produto("Caneta", 7.45);
		//dao.incluirT(prod1)
		em.persist(entidade);
		return this;
	}
	
	public DAO<E> incluirAtomico(E entidade) {
		return this.abrirT().incluirT(entidade).fecharT();
	}
	
	public List<E> obterTodos(int qtde, int deslocamento) {
		
		if(classe == null) {
			throw new UnsupportedOperationException("Classe nula");
		}
		
		String jpql = "select e from " + classe.getName() + " e";
		
		TypedQuery<E> query = em.createQuery(jpql, classe);
		query.setMaxResults(qtde);
		query.setFirstResult(deslocamento);
		
		return query.getResultList();
	}
	
	public List<E> obterTodos() {
		return this.obterTodos(10,0);
	} 
	
	public void Fechar() {
		em.close();
	}
	
	public E obterPorID(Object id) {
		return em.find(classe, id);
	}
	
}
