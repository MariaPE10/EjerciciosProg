package Ejercicios.Objetos.Bloque4.Antiguedades;

import javax.swing.JOptionPane;

/*Crear un programa que use la herencia para gestionar una colección de antigüedades.
 * Todas las antigüedades tienen datos en común, como año de fabricación, el origen y el
 * precio de venta, pero cada tipo particular de antigüedad tiene datos específicos. Por ejemplo,
 * las joyas tienen un material de fabricación. Los libros tienen un autor y título, etc... El
 * programa podrá crear y gestionar antigüedades  de 4 tipos diferentes. Deberás crear las clases
 * necesarias, con sus variables de instancia, métodos para actualizar y consultar las variables,
 * constructores, y métodos para imprimir en pantalla el objeto. Para probar las clases, deberás crear
 * una clase llamada "ColeccionAntiguedades", que pida los datos sobre una antigüedad (el tipo, datos comunes,
 * datos específicos), cree el objeto de la clase correspondiente, y posteriormente lo imprima en pantalla. 
 */
public class ColeccionAntiguedades {

	public static void main(String[] args) {
		
		String anioFabricacion;
		String origen;
		float precio;
		
		anioFabricacion = String.valueOf(JOptionPane.showInputDialog("Introduzca el año de fabricación de la antigüedad"));
		origen = String.valueOf(JOptionPane.showInputDialog("Introduzca el origen de la antigüedad"));
		precio = Float.parseFloat(JOptionPane.showInputDialog("Introduzca el precio de la antigüedad"));
		
		int opcion;
		String menu = "¿Qué tipo de Antigüedad es?\n"
				+ "1.- Es solo una Antigüedad\n"
				+ "2.- Crea una Joya\n"
				+ "3.- Crea una Libro\n"
				+ "4.- Crea una Jarron\n"
				+ "5.- Crea una Cuadros\n"
				+ "0.- Salir de la aplicacion.";
		
		opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
		switch (opcion) {
		case 0:
			System.exit(0); // Acaba radicalmente con la ejecuciï¿½n
			break;
		case 1: //Antiguedad
			Antiguedad antiguedad01 = new Antiguedad(anioFabricacion, origen, precio);
			JOptionPane.showMessageDialog(null, antiguedad01.toString());
			break;
		case 2: // Joyas
			String materialFabricacion = String.valueOf(JOptionPane.showInputDialog("Introduzca el material de fabricación de la joya"));
			Joyas joya01 = new Joyas(anioFabricacion, origen, precio, materialFabricacion);
			JOptionPane.showMessageDialog(null, joya01.toString());
			break;
		case 3: //Libros
			// Crear los toString de cada clase hija.
			//Crear el constructor por defecto e inicializa el atributo especifico de la clase en el constructor por defecto.
			//Crear un constructor que inicialice los atributos de la clase padre y tambien el atributo especifico de la clase hija.
			break;
		case 4: //Jarrones
			
			break;
		case 5: // Cuadros
		
			break;
		default:
			JOptionPane.showMessageDialog(null, "Opcion Incorrecta");
		}

	}

}
