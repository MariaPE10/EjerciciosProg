package MySQL.ciclistas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import com.mysql.jdbc.Statement;

public class Creacion_InsertAzar {

	private static String tablas[] = new String[] {"etapa", "ciclista"};
	private static String nombres[] = new String[] {"Eva", "Juan", "Carmen", "Pablo", "Rafa", "Pilar", "Pedro", 
			"Lola", "Casimiro", "Gertrudis", "Eustaquio", "Gerarda", "Nepomunosio", "Argimira", "Ascensio", "Baltasara", "Baudilio", "Bernabea"};
	private static String apellidos[] = new String[] {"Gonzalez", "Lopez", "Gutierrez", "Ruiz", "Jurado", "Carrasco", "Flores", 
			"Sanchez", "Bose", "Martin", "Martinez", "Santos", "Pozo", "Quijano", "Romero", "Pisano", "Cuevas", "Sanz"};
	private static String equipos[] = new String[] {"UniCaja", "Fanatic", "Origen", "Movistar", "x6tence", "SSG", "Cloud9", "SKT1"};
	private static String localidades[] = new String[] {"Lucena", "Cabra", "Priego de Cordoba", "Puente Genil", "Benameji", "Palenciana","Baena","Albendin"};
	private static String abecedario = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
	private static SimpleDateFormat sdfFechaNacimiento = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static int CONT_NOTIFICACION_INSERCION = 20;
	private static int REGISTROS_A_INSERTAR_EN_ETAPA = 20;
	private static int REGISTROS_A_INSERTAR_EN_CICLISTA = 100;
	private static boolean LOG = true;
	
	/**
	 * 
	 * @param conn
	 * @throws SQLException
	 */
	private static void vaciarTablas (Connection conn) throws SQLException {
		Statement s = (Statement) conn.createStatement();
		
		if (LOG)
			System.out.println("Eliminando los registros de todas las tablas");
		
		for (String tabla : tablas) {
			int registrosAfectados = s.executeUpdate("delete from ciclistas." + tabla);
			if (LOG)
				System.out.println("\t" + registrosAfectados + " registros eliminados en la tabla " + tabla);
		}
		s.close();
	}
	
	/**
	 * @throws ImposibleConectarException 
	 * @throws SQLException 
	 * 
	 */
	private static void creacionDatosEtapa (Connection conn) throws SQLException, ImposibleConectarException {
		PreparedStatement ps = conn.prepareStatement("INSERT INTO ciclistas.etapa (netapa, km, salida, llegada, dorsal) VALUES (?,?,?,?,?)");
		int registrosInsertados = 0;
		int contRegistrosInsertados = 0;		
		
		if (LOG)
			System.out.println("\nInsertando registros de en la tabla etapa");

		for (int i = 0; i < REGISTROS_A_INSERTAR_EN_ETAPA; i++) {
			
			ps.setInt(1, nextIdEnTabla(conn, "etapa"));
			ps.setInt(2, Utils.obtenerNumeroAzar(1000, 10000));
			ps.setString(3, getStringAlAzar(localidades));
			ps.setString(4, getStringAlAzar(localidades));
			ps.setInt(5, getIdAzarEnTabla(conn, "ciclista"));
			try {
				registrosInsertados = ps.executeUpdate();
			} catch (Exception ex) {
				ex.printStackTrace();;
			}
			
			if (registrosInsertados != 1) {
				throw new SQLException ("No ha sido posible la insercion en la tabla etapa");
			}
			contRegistrosInsertados++;
			if (contRegistrosInsertados % CONT_NOTIFICACION_INSERCION == 0 && LOG) {
				System.out.println("\t" + contRegistrosInsertados + " registros insertados en tabla etapa");
			}
		}
		ps.close();
	}
	
	/**
	 * @throws ImposibleConectarException 
	 * @throws SQLException 
	 * 
	 */
	private static void creacionDatosCiclista (Connection conn) throws SQLException, ImposibleConectarException {
		PreparedStatement ps = conn.prepareStatement("INSERT INTO ciclistas.ciclista (dorsal, nombre, edad, nomeq) VALUES  (?,?,?,?)");
		int registrosInsertados;
		int contRegistrosInsertados = 0;		
		
		if (LOG)
			System.out.println("\nInsertando registros de en la tabla ciclista");

		for (int i = 0; i < REGISTROS_A_INSERTAR_EN_CICLISTA; i++) {
			ps.setInt(1, nextIdEnTabla(conn, "ciclista"));
			ps.setString(2, getStringAlAzar(nombres)+ " " + getStringAlAzar(apellidos));
			ps.setInt(3, Utils.obtenerNumeroAzar(18, 45));
			ps.setString(4, getStringAlAzar(equipos));
			
			registrosInsertados = ps.executeUpdate();
			if (registrosInsertados != 1) {
				throw new SQLException ("No ha sido posible la insercion en la tabla ciclista");
			}
			contRegistrosInsertados++;
			if (contRegistrosInsertados % CONT_NOTIFICACION_INSERCION == 0 && LOG) {
				System.out.println("\t" + contRegistrosInsertados + " registros insertados en tabla ciclista");
			}
		}
		ps.close();
	}

	/**
	 * 
	 * @param conn
	 * @param tabla
	 * @return
	 * @throws SQLException
	 */
	private static int getIdAzarEnTabla (Connection conn, String tabla) throws SQLException {
		int maxId = maxIdEnTabla(conn, tabla);
		int idAzar;
		
		Statement s = (Statement) conn.createStatement();
		ResultSet rs;
		do {
			idAzar = Utils.obtenerNumeroAzar(1, maxId);
			rs = s.executeQuery("select * from ciclistas." + tabla + " where dorsal = " + idAzar);
		} while (!rs.next());
		
		rs.close();
		s.close();
		return idAzar;
	}

	/**
	 * 
	 * @param strings
	 * @return
	 */
	private static String getStringAlAzar (String strings[]) {
		return strings[Utils.obtenerNumeroAzar(0, strings.length - 1)];
	}
	
	/**
	 * 
	 * @param conn
	 * @param tabla
	 * @return
	 * @throws SQLException
	 */
	private static int nextIdEnTabla (Connection conn, String tabla) throws SQLException {
		return maxIdEnTabla(conn, tabla) + 1;
	}
	
	/**
	 * 
	 * @param conn
	 * @param tabla
	 * @return
	 * @throws SQLException
	 */
	private static int maxIdEnTabla (Connection conn, String tabla) throws SQLException {
		Statement s = (Statement) conn.createStatement();

		String sql = "select max(dorsal) from ciclistas." + tabla;
		ResultSet rs = s.executeQuery(sql);
		int max = 1; 
		if (rs.next() ) {
			max = rs.getInt(1);
		}
		rs.close();
		s.close();
		return max;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			long startTime = new Date().getTime();
			
			Connection conn;
			conn = ConnectionManagerV2.getConexion();
			
			// Limpieza en las tablas
			vaciarTablas(conn);
			// Datos de ciclistas
			creacionDatosCiclista(conn);
			// Datos de etapa
			creacionDatosEtapa(conn);
			
			long usedMillis = new Date().getTime() - startTime;
			int secs = (int) (usedMillis/1000);
			System.out.println("\nProceso terminado en " + secs + " segundos y " + (usedMillis - secs * 1000) + " milisegundos");
			
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
