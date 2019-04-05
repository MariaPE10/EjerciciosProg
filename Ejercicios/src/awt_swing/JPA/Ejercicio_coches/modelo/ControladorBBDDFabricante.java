package awt_swing.JPA.Ejercicio_coches.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
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
	
//	/**
//	 * 
//	 * @return
//	 */
//	public static List<Fabricante> getTodosFabricantes () {
//		List<Fabricante> resultado = new ArrayList<Fabricante>();
//		try {
//			Connection conn = ConnectionManagerV2.getConexion();
//			
//			PreparedStatement ps = conn.prepareStatement("SELECT * FROM tutorialjavacoches.fabricante order by nombre");
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				resultado.add(getFabricanteFromResultSet(rs));
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
//	
//	/**
//	 * 
//	 * @param rs
//	 * @return
//	 */
//	private static Fabricante getFabricanteFromResultSet (ResultSet rs) {
//		Fabricante fabricante = new Fabricante();
//		
//		try {
//			fabricante.setId(rs.getInt("id"));
//			fabricante.setCif(rs.getString("cif"));
//			fabricante.setNombre(rs.getString("nombre"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return fabricante;
//	}
//	
//	/**
//	 * 
//	 * @return
//	 */
//	public static Fabricante getPrimerFabricante () {
//		Fabricante fabricante = null;
//		try {
//			Connection conn = ConnectionManagerV2.getConexion();
//			
//			PreparedStatement ps = conn.prepareStatement("SELECT * FROM tutorialjavacoches.fabricante order by id limit 1");
//			ResultSet rs = ps.executeQuery();
//			if (rs.next()) {
//				fabricante = getFabricanteFromResultSet(rs);		
//			}
//			rs.close();
//			ps.close();
//			conn.close();
//		} catch (SQLException | ImposibleConectarException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return fabricante;
//	}
//	
//	/**
//	 * 
//	 * @return
//	 */
//	public static Fabricante getUltimoFabricante () {
//		Fabricante fabricante = null;
//		try {
//			Connection conn = ConnectionManagerV2.getConexion();
//			
//			PreparedStatement ps = conn.prepareStatement("SELECT * FROM tutorialjavacoches.fabricante order by id desc limit 1");
//			ResultSet rs = ps.executeQuery();
//			if (rs.next()) {
//				fabricante = getFabricanteFromResultSet(rs);		
//			}
//			rs.close();
//			ps.close();
//			conn.close();
//		} catch (SQLException | ImposibleConectarException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return fabricante;
//	}
//	
//	/**
//	 * 
//	 * @return
//	 */
//	public static Fabricante getSiguienteFabricante (Fabricante fabricanteActual) {
//		Fabricante fabricanteResultado = null;
//		try {
//			Connection conn = ConnectionManagerV2.getConexion();
//			
//			PreparedStatement ps = conn.prepareStatement("SELECT * FROM tutorialjavacoches.fabricante where id > ? order by id limit 1");
//			ps.setInt(1, fabricanteActual.getId());
//			ResultSet rs = ps.executeQuery();
//			if (rs.next()) {
//				fabricanteResultado = getFabricanteFromResultSet(rs);		
//			}
//			rs.close();
//			ps.close();
//			conn.close();
//		} catch (SQLException | ImposibleConectarException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return fabricanteResultado;
//	}
//	
//	/**
//	 * 
//	 * @return
//	 */
//	public static Fabricante getAnteriorFabricante (Fabricante fabricanteActual) {
//		Fabricante fabricanteResultado = null;
//		try {
//			Connection conn = ConnectionManagerV2.getConexion();
//			
//			PreparedStatement ps = conn.prepareStatement("SELECT * FROM tutorialjavacoches.fabricante where id < ? order by id desc limit 1");
//			ps.setInt(1, fabricanteActual.getId());
//			ResultSet rs = ps.executeQuery();
//			if (rs.next()) {
//				fabricanteResultado = getFabricanteFromResultSet(rs);		
//			}
//			rs.close();
//			ps.close();
//			conn.close();
//		} catch (SQLException | ImposibleConectarException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return fabricanteResultado;
//	}
//	
//	/**
//	 * 
//	 * @return
//	 */
//	public static boolean eliminarFabricante (Fabricante fabricante) {
//		boolean resultado = true;
//		try {
//			Connection conn = ConnectionManagerV2.getConexion();
//			
//			PreparedStatement ps = conn.prepareStatement(""
//					+ "DELETE FROM tutorialjavacoches.fabricante where id = ?");
//			ps.setInt(1, fabricante.getId());
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
//	/**
//	 * 
//	 * @return
//	 */
//	public static boolean guardarNuevoFabricante (Fabricante fabricante) {
//		boolean resultado = true;
//		try {
//			Connection conn = ConnectionManagerV2.getConexion();
//			
//			PreparedStatement ps = conn.prepareStatement(""
//					+ "INSERT INTO tutorialjavacoches.fabricante values (?, ?, ?)");
//			ps.setInt(1, getUltimoFabricante().getId() + 1);
//			ps.setString(2, fabricante.getCif());
//			ps.setString(3, fabricante.getNombre());
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
//	/**
//	 * 
//	 * @return
//	 */
//	public static boolean modificarFabricante (Fabricante fabricante) {
//		boolean resultado = true;
//		try {
//			Connection conn = ConnectionManagerV2.getConexion();
//			
//			PreparedStatement ps = conn.prepareStatement(""
//					+ "UPDATE tutorialjavacoches.fabricante SET cif = ?, nombre = ? where id = ?");
//			ps.setString(1, fabricante.getCif());
//			ps.setString(2, fabricante.getNombre());
//			ps.setInt(3, fabricante.getId());
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
}
