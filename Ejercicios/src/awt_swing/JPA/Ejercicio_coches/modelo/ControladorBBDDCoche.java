package awt_swing.JPA.Ejercicio_coches.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import awt_swing.JPA.Ejercicio_coches.modelo.entidades.Coche;


public class ControladorBBDDCoche extends Controlador{

	
//	/**
//	 * 
//	 * @return
//	 */
//	public static List<Coche> getTodosCoches () {
//		List<Coche> resultado = new ArrayList<Coche>();
//		try {
//			Connection conn = ConnectionManagerV2.getConexion();
//			
//			PreparedStatement ps = conn.prepareStatement("SELECT * FROM tutorialjavacoches.coche order by modelo");
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				resultado.add(getCocheFromResultSet(rs));
//			}
//			rs.close();
//			ps.close();
//			conn.close();
//		} catch (SQLException | ImposibleConectarException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return resultado;
//	}
	
	
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
	
//	/**
//	 * 
//	 * @return
//	 */
//	public static boolean guardarNuevoCoche (Coche coche) {
//		boolean resultado = true;
//		try {
//			Connection conn = ConnectionManagerV2.getConexion();
//			
//			PreparedStatement ps = conn.prepareStatement(""
//					+ "INSERT INTO tutorialjavacoches.coche values (?, ?, ?, ?, ?)");
//			ps.setInt(1, getUltimoCoche().getId() + 1);
//			ps.setInt(2, coche.getIdFabricante());
//			ps.setString(3, coche.getBastidor());
//			ps.setString(4, coche.getModelo());
//			ps.setString(5, coche.getColor());
//			int registrosAfectados = ps.executeUpdate();
//			if (registrosAfectados != 1) {
//				resultado = false;		
//			}
//			ps.close();
//			conn.close();
//		} catch (SQLException | ImposibleConectarException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			resultado = false;
//		}
//		
//		return resultado;
//	}
	
	
	
	
	
	/**
	 * 
	 * @return
	 */
//	public static boolean modificarCoche (Coche coche) {
//		boolean resultado = true;
//		try {
//			Connection conn = ConnectionManagerV2.getConexion();
//			
//			PreparedStatement ps = conn.prepareStatement(""
//					+ "UPDATE tutorialjavacoches.coche SET idFabricante = ?, bastidor = ?, modelo = ?, color = ? where id = ?");
//			ps.setInt(1, coche.getIdFabricante());
//			ps.setString(2, coche.getBastidor());
//			ps.setString(3, coche.getModelo());
//			ps.setString(4, coche.getColor());
//			ps.setInt(5, coche.getId());
//			int registrosAfectados = ps.executeUpdate();
//			if (registrosAfectados != 1) {
//				resultado = false;		
//			}
//			ps.close();
//			conn.close();
//		} catch (SQLException | ImposibleConectarException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			resultado = false;
//		}
//		
//		return resultado;
//	}
//	
//	
//	
//	
//	/**
//	 * 
//	 * @return
//	 */
//	public static boolean eliminarCoche (Coche coche) {
//		boolean resultado = true;
//		try {
//			Connection conn = ConnectionManagerV2.getConexion();
//			
//			PreparedStatement ps = conn.prepareStatement(""
//					+ "DELETE FROM tutorialjavacoches.coche where id = ?");
//			ps.setInt(1, coche.getId());
//			int registrosAfectados = ps.executeUpdate();
//			if (registrosAfectados != 1) {
//				resultado = false;		
//			}
//			ps.close();
//			conn.close();
//		} catch (SQLException | ImposibleConectarException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			resultado = false;
//		}
//		
//		return resultado;
//	}
//	
//	
//	
//	
//	
//	private static Coche getCocheFromResultSet (ResultSet rs) {
//		Coche coche = new Coche();
//		
//		try {
//			coche.setId(rs.getInt("id"));
//			coche.setIdFabricante(rs.getInt("idFabricante"));
//			coche.setBastidor(rs.getString("bastidor"));
//			coche.setModelo(rs.getString("modelo"));
//			coche.setColor(rs.getString("color"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return coche;
//	}
}
