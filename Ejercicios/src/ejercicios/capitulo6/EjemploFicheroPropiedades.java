package ejercicios.capitulo6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class EjemploFicheroPropiedades {

	private static Properties propiedades = null;

	public EjemploFicheroPropiedades () {
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
				propiedades.load(propiedades.getClass().getResourceAsStream("/ejercicios/capitulo6/ejemplo.properties"));
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
		String usuario = EjemploFicheroPropiedades.getProperty("USUARIO");
		String password = EjemploFicheroPropiedades.getProperty("PASSWORD");
		int id = EjemploFicheroPropiedades.getIntProperty("ID_USUARIO");
		
		System.out.println("Usuario leido del fichero de propiedades: " + usuario);
		System.out.println("Password leido del fichero de propiedades: " + password);
		System.out.println("Id de usuario leido del fichero de propiedades: " + id);
	}
}
