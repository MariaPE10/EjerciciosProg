package awt_swing.JPA.Ejercicio_coches.modelo;


import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import awt_swing.JPA.Ejercicio_coches.modelo.entidades.Venta;

public class ControladorBBDDVentas extends Controlador{

	
	/**
	 * 
	 */
	public static Venta findFirst () {
		EntityManager em = getEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM tutorialjavacoches.venta order by id limit 1", Venta.class);
		Venta venta = null; 
		
		try {
			venta = (Venta) q.getSingleResult();
		}
		catch (NoResultException ex) {
		}
		
		em.close();
		
		return venta;
	}
	
	/**
	 * 
	 */
	public static Venta findLast () {
		EntityManager em = getEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM tutorialjavacoches.venta order by id desc limit 1", Venta.class);
		Venta venta = null; 
		
		try {
			venta = (Venta) q.getSingleResult();
		}
		catch (NoResultException ex) {
		}
		
		em.close();
		
		return venta;
	}
	
	
	/**
	 * 
	 */
	public static Venta findNext (Venta ventaActual) {
		EntityManager em = getEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM tutorialjavacoches.venta where id > ? order by id limit 1", Venta.class);
		q.setParameter(1, ventaActual.getId());
		Venta venta = null; 
		
		try {
			venta = (Venta) q.getSingleResult();
		}
		catch (NoResultException ex) {
		}
		
		em.close();
		
		return venta;
	}
	
	
	/**
	 * 
	 */
	public static Venta findPrevious (Venta ventaActual) {
		EntityManager em = getEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM tutorialjavacoches.venta where id < ? order by id desc limit 1", Venta.class);
		q.setParameter(1, ventaActual.getId());
		Venta venta = null; 
		
		try {
			venta = (Venta) q.getSingleResult();
		}
		catch (NoResultException ex) {
		}
		
		em.close();
		
		return venta;
	}
	
	/**
	 * 
	 * @param coche
	 */
	public static Venta persist (Venta venta) {
		EntityManager em = getEntityManager();
		  
		try {
			em.getTransaction().begin();
			if (exists(venta)) {
				venta = em.merge(venta);
			}
			else {
				em.persist(venta);
			}
			em.getTransaction().commit();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		em.close();
		return venta;
	}
	
	
	/**
	 * 
	 * @param coche
	 */
	public static boolean remove (Venta venta) {
		EntityManager em = getEntityManager();
		
		boolean ok = true;
		try {
			if (exists(venta)) {
				em.getTransaction().begin();
				venta = em.merge(venta);
				em.remove(venta);
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
	public static boolean exists(Venta venta) {
		EntityManager em = getEntityManager();
		
		boolean ok = true;
		try {
			Query q = em.createNativeQuery("SELECT * FROM tutorialjavacoches.venta where id = ?", Venta.class);
			q.setParameter(1, venta.getId());
			venta = (Venta) q.getSingleResult(); 
		}
		catch (NoResultException ex) {
			ok = false;
		}
		em.close();
		return ok;
	}
	
}
