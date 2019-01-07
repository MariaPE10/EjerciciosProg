package ejercicios.objetos.bloque1;
/* Ejercicio 8: Realiza un método que reciba un valor entero, del 1 al 10, como 
 * argumento de entrada e imprima en pantalla dicho número con palabras.
 */

import javax.swing.JOptionPane;

public class NumeroEnPalabras {

	public static void main(String[] args) {
		int numeroElegido = pideNumeroEntero("Introduzca un numero entre 1 y 10");
		numerosEnPalabra(numeroElegido);
	}
	
	/**
	 * Devuelve el numero introducido de forma escrita (entre 1 y 10).
	 * @param numeroElegido Numero que saldra por consola en palabra
	 */
	public static void numerosEnPalabra (int numeroElegido) {
		
		switch (numeroElegido) {
		case 1: 
			System.out.println("Uno");
			break;
		case 2:
			System.out.println("Dos");
			break;
		case 3:
			System.out.println("Tres");
			break;
		case 4:
			System.out.println("Cuatro");
			break;
		case 5:
			System.out.println("Cinco");
			break;
		case 6:
			System.out.println("Seis");
			break;
		case 7:
			System.out.println("Siete");
			break;
		case 8:
			System.out.println("Ocho");
			break;
		case 9:
			System.out.println("Nueve");
			break;
		case 10:
			System.out.println("Diez");
			break;
		default:
			JOptionPane.showMessageDialog(null, "Opcion Incorrecta");
		}
	}
	
	/**
	 * Pide un numero entero al usuario, con un mensaje.
	 * @param mensaje
	 * @return devuelve un numero entero pedido al usuario.
	 */
	public static int pideNumeroEntero(String mensaje) {
		int num;
		
		num = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
		
		return num;
	}
}
