package awt_swing.JPA.Ejercicio_coches.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import awt_swing.JPA.Ejercicio_coches.modelo.entidades.Concesionario;


public class ControladorBBDDConcesionario extends Controlador {

	/**
	 * 
	 * @return
	 */
	public static List<Concesionario> findAll () {
		
		EntityManager em = getEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM concesionario;", Concesionario.class);
		
		List<Concesionario> entidades = new ArrayList<Concesionario>();
		
		try {
			entidades = (List<Concesionario>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		em.close();
		
		return entidades;
	}
}
