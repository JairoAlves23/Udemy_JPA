package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario02 {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		// Quando vc faz uma consulta o objeto fica em um estado gerenciado
		Usuario usuario = em.find(Usuario.class, 1L);
		
		usuario.setEmail("jairo@resibras.com.br");
		usuario.setNome("Jairo Alterado");
		System.out.println(usuario.getEmail());
		//faz a alteração no BD
		
		
		//em.merge(usuario); atualizou sem merge pq esta no estado gerenciado
		em.getTransaction().commit();
			
		em.close();
		emf.close();
	}

}
