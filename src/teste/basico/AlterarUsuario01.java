package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario01 {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Usuario usuario = em.find(Usuario.class, 1L);
		usuario.setEmail("jairo@resibras.com.br");
		usuario.setNome("Jairo Alves");
		System.out.println(usuario.getEmail());
		//faz a alteração no BD
		em.merge(usuario);
		em.getTransaction().commit();
		
		System.out.println(usuario.getEmail());
		
		em.close();
		emf.close();
	}
}
