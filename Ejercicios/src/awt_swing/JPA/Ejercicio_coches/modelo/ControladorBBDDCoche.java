package awt_swing.JPA.Ejercicio_coches.modelo;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import awt_swing.JPA.Ejercicio_coches.modelo.entidades.Cliente;
import awt_swing.JPA.Ejercicio_coches.modelo.entidades.Coche;


public class ControladorBBDDCoche extends Controlador{
	
	/**
	 * 
	 * @return
	 */
	public static List<Coche> findAll () {
		
		EntityManager em = getEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM coche;", Coche.class);
		
		List<Coche> entidades = new ArrayList<Coche>();
		
		try {
			entidades = (List<Coche>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		em.close();
		
		return entidades;
	}
	
	/**
	 * 
	 */
	public static Coche findFirst () {
		EntityManager em = getEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM tutorialjavacoches.coche order by id limit 1", Coche.class);
		Coche coche = null;
		try {
			coche = (Coche) q.getSingleResult();
		}catch (NoResultException e) {
		}
		
		em.close();
		
		return coche;
	}
	
	/**
	 * 
	 * @return
	 */
	public static Coche findLast () {
		
		EntityManager em = getEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM tutorialjavacoches.coche order by id desc limit 1", Coche.class);
		Coche coche = null;
		try {
			coche = (Coche) q.getSingleResult();
		}catch (NoResultException e) {
		}
		
		em.close();
		
		return coche;
	}
	
	/**
	 * 
	 * @return
	 */
	public static Coche findNext (Coche cocheActual) {
		EntityManager em = getEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM tutorialjavacoches.coche where id > ? order by id limit 1", Coche.class);
		q.setParameter(1, cocheActual.getId());
		Coche coche = null;
		try {
			coche = (Coche) q.getSingleResult();
		}catch (NoResultException e) {
		}
		
		em.close();
		
		return coche;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public static Coche findPrevious (Coche cocheActual) {
		
		EntityManager em = getEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM tutorialjavacoches.coche where id < ? order by id desc limit 1", Coche.class);
		q.setParameter(1, cocheActual.getId());
		Coche coche = null;
		try {
			coche = (Coche) q.getSingleResult();
		}catch (NoResultException e) {
		}
		
		em.close();
		
		return coche;
	}
	
	/**
	 * 
	 */
	public static Coche persist(Coche coche){
		EntityManager em = getEntityManager();
		
		try {
			em.getTransaction().begin();
			if(exists(coche)) {
				coche = em.merge(coche);
			} else {
				em.persist(coche);
			}
			em.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		em.close();
		
		return coche;
	}
	
	/**
	 * 
	 * @param coche
	 * @return
	 */
	public static boolean exists(Coche coche) {
		EntityManager em = getEntityManager();
		
		boolean ok = true;
		try {
			Query q = em.createNativeQuery("SELECT * FROM tutorialjavacoches.coche where id = ?", Coche.class);
			q.setParameter(1, coche.getId());
			coche = (Coche) q.getSingleResult(); 
		}
		catch (NoResultException ex) {
			ok = false;
		}
		em.close();
		
		return ok;
	}
	
	/**
	 * 
	 * @param coche
	 */
	public static boolean remove (Coche coche) {
		EntityManager em = getEntityManager();
		
		boolean ok = true;
		try {
			if (exists(coche)) {
				em.getTransaction().begin();
				coche = em.merge(coche);
				em.remove(coche);
				em.getTransaction().commit();
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
			ok = false;
		}
		
		em.close();
		return ok;
	}

}
