package awt_swing.JPA.Ejercicio_coches.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import awt_swing.JPA.Ejercicio_coches.modelo.entidades.Cliente;


public class ControladorBBDDCliente extends Controlador {

	/**
	 * 
	 * @return
	 */
	public static List<Cliente> findAll () {
		
		EntityManager em = getEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM cliente;", Cliente.class);
		
		List<Cliente> entidades = new ArrayList<Cliente>();
		
		try {
			entidades = (List<Cliente>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		em.close();
		
		return entidades;
	}
}
