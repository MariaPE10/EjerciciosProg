package Ejercicios.Objetos.Bloque4.Antiguedades;

import javax.swing.JOptionPane;

/* Crear un programa que use la herencia para gestionar una colecci�n de antig�edades.
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
		//las variables son punteros que apuntan a una direccion de la memoria
		int anioFabricacion;
		String origen;
		float precio;
		
		anioFabricacion = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el anio de fabricacion de la antiguedad"));
		origen = JOptionPane.showInputDialog("Introduzca el origen de la antiguedad");
		precio = Float.parseFloat(JOptionPane.showInputDialog("Introduzca el precio de la antiguedad"));
		
		int opcion;
		String menu = "Que tipo de Antiguedad es?\n"
				+ "1.- Es solo una Antiguedad\n"
				+ "2.- Crea una Joya\n"
				+ "3.- Crea un Libro\n"
				+ "4.- Crea un Jarron\n"
				+ "5.- Crea un Cuadro\n"
				+ "0.- Salir de la aplicacion.";
		
		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
			//Crear los toString de cada clase hija.
			//Crear el constructor por defecto e inicializa el atributo especifico de la clase en el constructor por defecto.
			//Crear un constructor que inicialice los atributos de la clase padre y tambien el atributo especifico de la clase hija.
			switch (opcion) {
			case 0:
				System.exit(0); // Acaba radicalmente con la ejecucion
				break;
			case 1: //Antiguedad
				Antiguedad antiguedad01 = new Antiguedad(anioFabricacion, origen, precio);
				JOptionPane.showMessageDialog(null, antiguedad01.toString());
				break;
			case 2: // Joya
				String materialFabricacion = JOptionPane.showInputDialog("Introduzca el material de fabricacion de la joya");
				Joya joya01 = new Joya(anioFabricacion, origen, precio, materialFabricacion);
				JOptionPane.showMessageDialog(null, joya01); //Se puede omitir el .toString()
				break;
			case 3: //Libro
				String autor = JOptionPane.showInputDialog("Introduzca el autor del libro");
				String titulo = JOptionPane.showInputDialog("Introduzca el titulo del libro");
				Libro libro01 = new Libro (anioFabricacion, origen, precio, autor, titulo);
				JOptionPane.showMessageDialog(null, libro01.toString());
				break;
			case 4: //Jarron
				String material = JOptionPane.showInputDialog("Introduzca el material del jarron");
				String estilo = JOptionPane.showInputDialog("Introduzca el estilo del jarron");
				Jarron jarron01 = new Jarron (anioFabricacion, origen, precio, material, estilo);
				JOptionPane.showMessageDialog(null, jarron01.toString());
				break;
			case 5: // Cuadro
				String pintor = JOptionPane.showInputDialog("Introduzca el Nombre del pintor del cuadro");
				String nombre = JOptionPane.showInputDialog("Introduzca el Nombre del cuadro");
				Cuadro cuadro01 = new Cuadro (anioFabricacion, origen, precio, pintor, nombre);
				JOptionPane.showMessageDialog(null, cuadro01.toString());
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opcion Incorrecta");
			}
		} while (opcion > 6 || opcion < 0);
	}
}
