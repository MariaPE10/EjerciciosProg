package awt_swing.JPA.Ejercicio_coches.modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Controlador {
	
	private static EntityManagerFactory entityManagerFactory = null;

	protected static EntityManager getEntityManager () {
		
		if (entityManagerFactory == null) {
			entityManagerFactory  = Persistence.createEntityManagerFactory("Ejercicio_coches");
		}
		
		return entityManagerFactory.createEntityManager();
	}

}
