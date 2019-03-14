package examen_MariaPerez;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/* Ejercicio 1: Crea un programa en Java que utilice un fichero de propiedades 
 * para leer un nombre de usuario ficticio y su correspondiente contraseña.
 */
public class Super_Properties {

	private static Properties propiedades = null;

	public Super_Properties () {
		super();
	}
	
	/**
	 * 
	 * @return
	 */
	private static Properties getPropiedades() {
		if (propiedades == null) {
			propiedades = new Properties();
		    
			try {
				propiedades.load(propiedades.getClass().getResourceAsStream("/examen_MariaPerez/properties"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		}
		return propiedades;
	}

	/**
	 * 
	 * @param nombrePropiedad
	 * @return
	 */
	public static String getProperty(String nombrePropiedad) {
		return getPropiedades().getProperty(nombrePropiedad);
	}

	
	/**
	 * 
	 * @param nombrePropiedad
	 * @return
	 */
	public static int getIntProperty (String nombrePropiedad) {
		return Integer.parseInt(getPropiedades().getProperty(nombrePropiedad));
	}
	
	
	/**
	 * 
	 * @param nombrePropiedad
	 * @return
	 */
	public static Float getFloatProperty (String nombrePropiedad) {
		return Float.parseFloat(getPropiedades().getProperty(nombrePropiedad));
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main (String args[]) {
		String usuario = Super_Properties.getProperty("USUARIO");
		String password = Super_Properties.getProperty("PASSWORD");
		int id = Super_Properties.getIntProperty("ID_USUARIO");
		
		System.out.println("Usuario leido del fichero de propiedades: " + usuario);
		System.out.println("Password leido del fichero de propiedades: " + password);
		System.out.println("Id de usuario leido del fichero de propiedades: " + id);
	}
}
