package Ejercicios.Objetos.Bloque1;
 /*  Ejercicio 5: Modifica el método del ejercicio anterior para que reciba un tercer parámetro de entrada,
  * siendo este el número de términos de la serie de Fibonacci que se deben mostrar en pantalla.
  * Además de mostrar los términos en pantalla, el método debe devolver el último número de Fibonacci creado.
  */
import javax.swing.JOptionPane;

public class Fibonacci2 {
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
	/**
	 *  Realiza la serie de fibonacci.
	 * @param primeraPosicion Posicion 0 del array
	 * @param segundaPosicion Posicion 1 del array
	 * @param longitudArray 
	 */
	public static void fibonacci(int primeraPosicion, int segundaPosicion, int longitudArray) {
		int array[] = new int [longitudArray];
		
		array[0] = primeraPosicion;
		array[1] = segundaPosicion; 
		
		for (int i = 2; i < array.length ;i++) {
			array[i] = array[i-1] + array[i-2];
		}
		
		System.out.println("Serie de fibonnacci: ");
		for (int i = 0; i < array.length ;i++) {
			System.out.print(array[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		int numeroPedido1 = pideNumeroEntero("Introduzca numero entero");
		int numeroPedido2 = pideNumeroEntero("Introduzca numero entero");
		int limiteSerie = pideNumeroEntero("Introduzca el numero de terminos que se deberan mostrar");
		
		System.out.println("Los numeros introducidos son: " + numeroPedido1 + " y "+ numeroPedido2);
		fibonacci(numeroPedido1, numeroPedido2, limiteSerie);
	}
		
}
