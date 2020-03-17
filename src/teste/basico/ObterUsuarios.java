package teste.basico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.basico.Usuario;

public class ObterUsuarios {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		//String jpql = "select u from Usuario u";
		//TypedQuery<Usuario> query = em.createQuery(jpql,Usuario.class);
		//query.setMaxResults(5);
		String jpql = "select u from Usuario u";
		List<Usuario> usuarios = em.createQuery(jpql,Usuario.class)
				.setMaxResults(5)
				.getResultList();
		
		for (Usuario usuario : usuarios) {
			System.out.println("Id do usuario " + usuario.getId() + " Nome do Usuario " + 
					usuario.getNome()
					);
		}
		
		emf.close();
		em.close();

		
	}
}
