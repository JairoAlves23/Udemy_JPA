package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario03 {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
em.getTransaction().begin();
		
		// Quando vc faz uma consulta o objeto fica em um estado gerenciado
		Usuario usuario = em.find(Usuario.class, 1L);
		
		// Retira o estado do gerenciado, por isso obrigado a incluir o merge
		em.detach(usuario);
		
		usuario.setEmail("jairoAlves@resibras.com.br");
		usuario.setNome("Jairo Alterado");
		System.out.println(usuario.getEmail());
		//faz a alteração no BD
		em.merge(usuario); 
		em.getTransaction().commit();
			
		em.close();
		emf.close();
		
	}
}
