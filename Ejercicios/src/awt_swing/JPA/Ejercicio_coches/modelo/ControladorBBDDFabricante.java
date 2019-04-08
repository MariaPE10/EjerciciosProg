package awt_swing.JPA.Ejercicio_coches.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import awt_swing.JPA.Ejercicio_coches.modelo.entidades.Fabricante;

public class ControladorBBDDFabricante extends Controlador{
	
	/**
	 * 
	 * @return
	 */
	public static List<Fabricante> findAll () {
		
		EntityManager em = getEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM fabricante;", Fabricante.class);
		
		List<Fabricante> entidades = new ArrayList<Fabricante>();
		
		try {
			entidades = (List<Fabricante>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		em.close();
		
		return entidades;
	}
	
	/**
	 * 
	 * @return
	 */
	public static Fabricante findFirst () {
		
		EntityManager em = getEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM tutorialjavacoches.fabricante order by id limit 1", Fabricante.class);
		Fabricante fabricante = null; 
		
		try {
			fabricante = (Fabricante) q.getSingleResult();
		}
		catch (NoResultException ex) {
		}
		
		em.close();
		
		return fabricante;
	}
	
	/**
	 * 
	 */
	public static Fabricante findLast () {
		EntityManager em = getEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM tutorialjavacoches.fabricante order by id desc limit 1", Fabricante.class);
		Fabricante fabricante = null; 
		
		try {
			fabricante = (Fabricante) q.getSingleResult();
		}
		catch (NoResultException ex) {
		}
		
		em.close();
		
		return fabricante;
	}
	
	/**
	 * 
	 */
	public static Fabricante findNext (Fabricante fabricanteActual) {
		EntityManager em = getEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM tutorialjavacoches.fabricante where id > ? order by id limit 1", Fabricante.class);
		q.setParameter(1, fabricanteActual.getId());
		Fabricante fabricante = null; 
		
		try {
			fabricante = (Fabricante) q.getSingleResult();
		}
		catch (NoResultException ex) {
		}
		
		em.close();
		
		return fabricante;
	}
	
	/**
	 * 
	 */
	public static Fabricante findPrevious (Fabricante fabricanteActual) {
		EntityManager em = getEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM tutorialjavacoches.fabricante where id < ? order by id desc limit 1", Fabricante.class);
		q.setParameter(1, fabricanteActual.getId());
		Fabricante fabricante = null; 
		
		try {
			fabricante = (Fabricante) q.getSingleResult();
		}
		catch (NoResultException ex) {
		}
		
		em.close();
		
		return fabricante;
	}
	
	/**
	 * 
	 * @param coche
	 */
	public static Fabricante persist (Fabricante fabricante) {
		EntityManager em = getEntityManager();
		  
		try {
			em.getTransaction().begin();
			if (exists(fabricante)) {
				fabricante = em.merge(fabricante);
			}
			else {
				em.persist(fabricante);
			}
			em.getTransaction().commit();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		em.close();
		return fabricante;
	}
	
	/**
	 * 
	 * @param coche
	 */
	public static boolean remove (Fabricante fabricante) {
		EntityManager em = getEntityManager();
		
		boolean ok = true;
		try {
			if (exists(fabricante)) {
				em.getTransaction().begin();
				fabricante = em.merge(fabricante);
				em.remove(fabricante);
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
	
	/**
	 * 
	 * @param coche
	 * @return
	 */
	public static boolean exists(Fabricante fabricante) {
		EntityManager em = getEntityManager();
		
		boolean ok = true;
		try {
			Query q = em.createNativeQuery("SELECT * FROM tutorialjavacoches.fabricante where id = ?", Fabricante.class);
			q.setParameter(1, fabricante.getId());
			fabricante = (Fabricante) q.getSingleResult(); 
		}
		catch (NoResultException ex) {
			ok = false;
		}
		em.close();
		return ok;
	}

}
