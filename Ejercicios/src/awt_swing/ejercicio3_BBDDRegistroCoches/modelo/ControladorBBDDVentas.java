package awt_swing.ejercicio3_BBDDRegistroCoches.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import awt_swing.ejercicio3_BBDDRegistroCoches.modelo.entidades.Venta;

public class ControladorBBDDVentas {

	private static Date fecha = new Date();
	/**
	 * 
	 * @return
	 */
	public static Venta getPrimeraVenta () {
		Venta venta = null;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM tutorialjavacoches.venta order by id limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				venta = getVentaFromResultSet(rs);		
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return venta;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public static Venta getUltimaVenta () {
		Venta venta = null;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM tutorialjavacoches.venta order by id desc limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				venta = getVentaFromResultSet(rs);		
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return venta;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public static Venta getSiguienteVenta (Venta ventaActual) {
		Venta ventaResultado = null;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM tutorialjavacoches.venta where id > ? order by id limit 1");
			ps.setInt(1, ventaActual.getId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ventaResultado = getVentaFromResultSet(rs);		
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ventaResultado;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public static Venta getAnteriorVenta (Venta ventaActual) {
		Venta ventaResultado = null;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM tutorialjavacoches.venta where id < ? order by id desc limit 1");
			ps.setInt(1, ventaActual.getId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ventaResultado = getVentaFromResultSet(rs);		
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ventaResultado;
	}
	
	
	
	
	/**
	 * 
	 * @return
	 */
	public static boolean guardarNuevaVenta (Venta venta) {
		boolean resultado = true;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement(""
					+ "INSERT INTO tutorialjavacoches.venta values (?, ?, ?, ?, ?, ?)");
			ps.setInt(1, getUltimaVenta().getId() + 1);
			ps.setInt(2, venta.getIdCliente());
			ps.setInt(3, venta.getIdConcesionario());
			ps.setInt(4, venta.getIdCoche());
			if (venta.getFecha() != null) {
				ps.setDate(5, new java.sql.Date(venta.getFecha().getTime()));
			} else {
				ps.setDate(5, new java.sql.Date(fecha.getTime()));
			}
			ps.setFloat(6, venta.getPrecioVenta());
			int registrosAfectados = ps.executeUpdate();
			if (registrosAfectados != 1) {
				resultado = false;		
			}
			ps.close();
			conn.close();
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultado = false;
		}
		
		return resultado;
	}
	
	
	
	
	
	/**
	 * 
	 * @return
	 */
	public static boolean modificarVenta (Venta venta) {
		boolean resultado = true;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement(""
					+ "UPDATE tutorialjavacoches.venta SET idCliente = ?, idConcesionario = ?, idCoche = ?, fecha = ?, precioVenta = ? where id = ?");
			ps.setInt(1, venta.getIdCliente());
			ps.setInt(2, venta.getIdConcesionario());
			ps.setInt(3, venta.getIdCoche());
			if (venta.getFecha() != null) {
				ps.setDate(4, new java.sql.Date(venta.getFecha().getTime()));
			} else {
				ps.setDate(4, new java.sql.Date(fecha.getTime()));
			}
			ps.setFloat(5, venta.getPrecioVenta());
			ps.setInt(6, venta.getId());
			int registrosAfectados = ps.executeUpdate();
			if (registrosAfectados != 1) {
				resultado = false;		
			}
			ps.close();
			conn.close();
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultado = false;
		}
		
		return resultado;
	}
	
	
	
	
	/**
	 * 
	 * @return
	 */
	public static boolean eliminarVenta (Venta venta) {
		boolean resultado = true;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement(""
					+ "DELETE FROM tutorialjavacoches.venta where id = ?");
			ps.setInt(1, venta.getId());
			int registrosAfectados = ps.executeUpdate();
			if (registrosAfectados != 1) {
				resultado = false;		
			}
			ps.close();
			conn.close();
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultado = false;
		}
		
		return resultado;
	}
	
	
	
	
	
	private static Venta getVentaFromResultSet (ResultSet rs) {
		Venta venta = new Venta();
		
		try {
			venta.setId(rs.getInt("id"));
			venta.setIdCliente(rs.getInt("idCliente"));
			venta.setIdConcesionario(rs.getInt("idConcesionario"));
			venta.setIdCoche(rs.getInt("idCoche"));
			venta.setFecha(rs.getDate("fecha"));
			venta.setPrecioVenta(rs.getFloat("precioVenta"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return venta;
	}
}
