package Ejercicios.Objetos.Bloque1;

import javax.swing.JOptionPane;

/* Ejercicio 4: La serie de Fibonacci es una serie num�rica que comienza en los n�meros 1, 1 y continua de forma infinita,
  * calculando cada mienbro de la serie como la suma de los dos anteriores. De esta manera, la serie de Fibonacci
  * comienza 1, 1, 2, 3, 5, 8, 13, 21, 34, 55.......... Debes crear un m�todo llamado "fibonacci". El m�todo
  * recibir� dos argumentos de entrada, de tipo entero. Los dos argumentos deben ser miembros de la serie de Fibonacci.
  * El m�todo debe imprimir en pantalla los siguientes 5 t�rminos de la serie de Fibonacci.
  */
public class Fibonacci {
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
	 * Este metodo recibe dos parametros: El primero determina el valor de la primera posicion en el array, el segundo la segunda posicion.
	 */
	public static void fibonacci(int primeraPosicion, int segundaPosicion) {
		int array[] = new int [7];
		
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
		
		System.out.println("Los numeros introducidos son: " + numeroPedido1 + " y "+ numeroPedido2);
		fibonacci(numeroPedido1, numeroPedido2);
	}
	
}
