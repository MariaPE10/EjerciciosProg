package Ejercicios.Objetos.Bloque4.Antiguedades;

import javax.swing.JOptionPane;

/*Crear un programa que use la herencia para gestionar una colecci�n de antig�edades.
 * Todas las antig�edades tienen datos en com�n, como a�o de fabricaci�n, el origen y el
 * precio de venta, pero cada tipo particular de antig�edad tiene datos espec�ficos. Por ejemplo,
 * las joyas tienen un material de fabricaci�n. Los libros tienen un autor y t�tulo, etc... El
 * programa podr� crear y gestionar antig�edades  de 4 tipos diferentes. Deber�s crear las clases
 * necesarias, con sus variables de instancia, m�todos para actualizar y consultar las variables,
 * constructores, y m�todos para imprimir en pantalla el objeto. Para probar las clases, deber�s crear
 * una clase llamada "ColeccionAntiguedades", que pida los datos sobre una antig�edad (el tipo, datos comunes,
 * datos espec�ficos), cree el objeto de la clase correspondiente, y posteriormente lo imprima en pantalla. 
 */
public class ColeccionAntiguedades {

	public static void main(String[] args) {
		
		String anioFabricacion;
		String origen;
		float precio;
		
		anioFabricacion = String.valueOf(JOptionPane.showInputDialog("Introduzca el a�o de fabricaci�n de la antig�edad"));
		origen = String.valueOf(JOptionPane.showInputDialog("Introduzca el origen de la antig�edad"));
		precio = Float.parseFloat(JOptionPane.showInputDialog("Introduzca el precio de la antig�edad"));
		
		int opcion;
		String menu = "�Qu� tipo de Antig�edad es?\n"
				+ "1.- Es solo una Antig�edad\n"
				+ "2.- Crea una Joya\n"
				+ "3.- Crea una Libro\n"
				+ "4.- Crea una Jarron\n"
				+ "5.- Crea una Cuadros\n"
				+ "0.- Salir de la aplicacion.";
		
		opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
		switch (opcion) {
		case 0:
			System.exit(0); // Acaba radicalmente con la ejecuci�n
			break;
		case 1: //Antiguedad
			Antiguedad antiguedad01 = new Antiguedad(anioFabricacion, origen, precio);
			JOptionPane.showMessageDialog(null, antiguedad01.toString());
			break;
		case 2: // Joyas
			String materialFabricacion = String.valueOf(JOptionPane.showInputDialog("Introduzca el material de fabricaci�n de la joya"));
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
