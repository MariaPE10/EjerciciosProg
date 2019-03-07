package ejercicios.capitulo6.bloque1;

import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JOptionPane;


public class Almacen {

/* Ejercicio1.- Crear una aplicación que gestione los artículos guardados en un almacén.
 * Cada artículo tiene un código de barras, y un número de estante. La aplicación
 * permitirá que el usuario añada artículos nuevos, los borre, actualice el
 * estante de un artículo, e imprima la lista de artículos. Además el usuario
 * podrá consultar la localización de un determinado artículo por su código de barras.
 * Sólo existirá como mucho una unidad de cada tipo de artículo.
 */
	private static HashMap<String, Articulo> hm = new HashMap<String, Articulo>();
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		menu();
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public static boolean existeArticulo(String key) {
		if(hm.get(key) == null) {
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 */
	public static String obtieneLista() {
		Iterator<Articulo> articulos = hm.values().iterator();
		StringBuffer lista = new StringBuffer();
		while (articulos.hasNext()) {
			 lista.append(articulos.next() + "\n");
		}
		return lista.toString();
	}
	
	/**
	 * 
	 */
	public static void menu () {	
		String menu = "OPCIONES\n"
				+ "1.- Insertar articulo.\n"
				+ "2.- Borrar articulo.\n"
				+ "3.- Actualizar estante de un articulo.\n"
				+ "4.- Imprimir una lista de articulos.\n"
				+ "5.- Localizacion de un articulo por codigo de barras.\n"
				+ "0.- Salir de la aplicacion.";
		int opcion = -1;
		
		do {
			try {
				opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
				switch (opcion) {
				case 0:
					System.exit(0); // Acaba radicalmente con la ejecuci�n
					break;
				case 1: //Insertar Artículo
					String key = JOptionPane.showInputDialog("Introduzca el codigo de barras del articulo");
					if (existeArticulo(key)) {
						JOptionPane.showMessageDialog(null, "El codigo de barras que ha introducido ya existe", "Articulo ya existente", 0);
					} else {
						hm.put(key, new Articulo(key, JOptionPane.showInputDialog("Introduzca el estante del articulo"), JOptionPane.showInputDialog("Introduzca la descripcion del articulo")));
					}
					break;
				case 2: // Borrar articulo
					key = JOptionPane.showInputDialog(null, obtieneLista() + "\n\nIntroduzca el articulo que quiere borrar");
					if(existeArticulo(key)) {
						hm.remove(key);
					} else {
						JOptionPane.showMessageDialog(null, "El codigo de barras que ha introducido no existe", "Error al eliminar el articulo: " + key, 0);
					}
					break;
				case 3: //Actualizar estante de un articulo
					key = JOptionPane.showInputDialog(null, obtieneLista() + "\n\nIntroduzca el articulo que quiere modificar");
					if(existeArticulo(key)) {
						Articulo articulo = hm.get(key);
						articulo.setEstante(JOptionPane.showInputDialog("Introduzca la estanteria del articulo"));
						articulo.setDescripcion(JOptionPane.showInputDialog("Introduzca la descripcion del articulo"));
					}else {
						JOptionPane.showMessageDialog(null, "El codigo de barras que ha introducido no existe", "Error al modificar el articulo: " + key, 0);
					}
					break;
				case 4: //Imprimir una lista de articulos
					JOptionPane.showMessageDialog(null, obtieneLista(), "Lista de Articulos", 1);
					break;
				case 5: //Localizacion de un articulo por codigo de barras
					key = JOptionPane.showInputDialog(null, obtieneLista() + "\n\nIntroduzca el articulo que quiere localizar");
					if(existeArticulo(key)) {
						JOptionPane.showMessageDialog(null, hm.get(key).toString(), "Articulo: " + key, 1);
					} else {
						JOptionPane.showMessageDialog(null, "El codigo de barras que ha introducido no existe", "Error al localizar el articulo: " + key, 0);
					}
					break;
//				default:
//					JOptionPane.showMessageDialog(null, "Opcion Incorrecta", "Opcion Incorrecta", 0);
				}		
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Opcion Incorrecta", "Opcion Incorrecta", 0);
			}
					
		} while (opcion!=0);
	}
}
