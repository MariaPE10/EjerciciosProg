package awt_swing.ejercicio3_BBDDRegistroCoches.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import awt_swing.ejercicio3_BBDDRegistroCoches.modelo.entidades.Cliente;

public class ControladorBBDDCliente {

	/**
	 * 
	 * @return
	 */
	public static Cliente getPrimerCliente () {
		Cliente cliente = null;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM tutorialjavacoches.cliente order by id limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cliente = getClienteFromResultSet(rs);		
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cliente;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public static Cliente getUltimoCliente () {
		Cliente cliente = null;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM tutorialjavacoches.cliente order by id desc limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cliente = getClienteFromResultSet(rs);		
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cliente;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public static Cliente getSiguienteCliente (Cliente clienteActual) {
		Cliente clienteResultado = null;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM tutorialjavacoches.cliente where id > ? order by id limit 1");
			ps.setInt(1, clienteActual.getId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				clienteResultado = getClienteFromResultSet(rs);		
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return clienteResultado;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public static Cliente getAnteriorCliente (Cliente clienteActual) {
		Cliente clienteResultado = null;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM tutorialjavacoches.cliente where id < ? order by id desc limit 1");
			ps.setInt(1, clienteActual.getId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				clienteResultado = getClienteFromResultSet(rs);		
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return clienteResultado;
	}
	
	
	
	
	/**
	 * 
	 * @return
	 */
	public static boolean guardarNuevoCliente (Cliente cliente) {
		boolean resultado = true;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement(""
					+ "INSERT INTO tutorialjavacoches.cliente values (?, ?, ?, ?, ?, ?)");
			ps.setInt(1, getUltimoCliente().getId() + 1);
			ps.setString(2, cliente.getNombre());
			ps.setString(3, cliente.getApellidos());
			ps.setString(4, cliente.getLocalidad());
			ps.setString(5, cliente.getDni());
			ps.setDate(6, new java.sql.Date(cliente.getFechaNacimiento().getTime()));
			
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
	public static boolean modificarCliente (Cliente cliente) {
		boolean resultado = true;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement(""
					+ "UPDATE tutorialjavacoches.cliente SET nombre = ?, apellidos = ?, localidad = ?, dni = ?, fechanac = ? where id = ?");
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellidos());
			ps.setString(3, cliente.getLocalidad());
			ps.setString(4, cliente.getDni());
			ps.setDate(5, new java.sql.Date( cliente.getFechaNacimiento().getTime()));
			ps.setInt(6, cliente.getId());
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
	public static boolean eliminarCliente (Cliente cliente) {
		boolean resultado = true;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement(""
					+ "DELETE FROM tutorialjavacoches.cliente where id = ?");
			ps.setInt(1, cliente.getId());
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
	
	
	
	
	
	private static Cliente getClienteFromResultSet (ResultSet rs) {
		Cliente cliente = new Cliente();
		
		try {
			cliente.setId(rs.getInt("id"));
			cliente.setNombre(rs.getString("nombre"));
			cliente.setApellidos(rs.getString("apellidos"));
			cliente.setLocalidad(rs.getString("localidad"));
			cliente.setDni(rs.getString("dni"));
			cliente.setFechaNacimiento(rs.getDate("fechaNac"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cliente;
	}
}
