package awt_swing.ejercicio3_BBDDRegistroCoches.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import awt_swing.ejercicio3_BBDDRegistroCoches.modelo.entidades.Coche;
import awt_swing.ejercicio3_BBDDRegistroCoches.modelo.entidades.Fabricante;

public class ControladorBBDDFabricante {

	
	/**
	 * 
	 * @return
	 */
	public static List<Fabricante> getTodosFabricantes () {
		List<Fabricante> resultado = new ArrayList<Fabricante>();
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM tutorialjavacoches.fabricante order by nombre");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				resultado.add(getFabricanteFromResultSet(rs));
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	/**
	 * 
	 * @param rs
	 * @return
	 */
	private static Fabricante getFabricanteFromResultSet (ResultSet rs) {
		Fabricante fabricante = new Fabricante();
		
		try {
			fabricante.setId(rs.getInt("id"));
			fabricante.setCif(rs.getString("cif"));
			fabricante.setNombre(rs.getString("nombre"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fabricante;
	}
	
	/**
	 * 
	 * @return
	 */
	public static Fabricante getPrimerFabricante () {
		Fabricante fabricante = null;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM tutorialjavacoches.fabricante order by id limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				fabricante = getFabricanteFromResultSet(rs);		
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fabricante;
	}
	
	/**
	 * 
	 * @return
	 */
	public static Fabricante getUltimoFabricante () {
		Fabricante fabricante = null;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM tutorialjavacoches.fabricante order by id desc limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				fabricante = getFabricanteFromResultSet(rs);		
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fabricante;
	}
	
	/**
	 * 
	 * @return
	 */
	public static Fabricante getSiguienteFabricante (Fabricante fabricanteActual) {
		Fabricante fabricanteResultado = null;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM tutorialjavacoches.coche where id > ? order by id limit 1");
			ps.setInt(1, fabricanteActual.getId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				fabricanteResultado = getFabricanteFromResultSet(rs);		
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fabricanteResultado;
	}
}
