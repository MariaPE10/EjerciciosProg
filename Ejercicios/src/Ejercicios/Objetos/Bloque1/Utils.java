package Ejercicios.Objetos.Bloque1;

import javax.swing.JOptionPane;

public class Utils {

/* Ejercicio 1: Realiza un método que reciba como parámetros de entrada tres valores enteros y uno flotante.
  * El método debe devolver la media aritmética de los cuatro valores, un valor flotante.
  * "main" debe usar a esta función creada por ti, e imprimir el valor de la media en la consola de salida.
  */
	
	public int sumaEnteros(int num1, int num2, int num3) {
		
		int acumulado = 0;
		
		acumulado += num1;
		acumulado += num2;
		acumulado += num3;
		
		return acumulado;
	}
	
	public float sumaTotal(float numeroFloat, int numeroEntero1, int numeroEntero2, int numeroEntero3) {		
		
		float sumaTotal = sumaEnteros(numeroEntero1,numeroEntero2,numeroEntero3) + numeroFloat;
		
		return sumaTotal;		
	}

	public float mediaEnteros(int numeroEntero1, int numeroEntero2, int numeroEntero3) {
		
		float mediaEnteros = 0;
		
		mediaEnteros = sumaEnteros(numeroEntero1,numeroEntero2,numeroEntero3)/3;
		
		return mediaEnteros;
	}
	
	public float mediaTotal(float numeroFloat, int numeroEntero1, int numeroEntero2, int numeroEntero3) {
		
		float mediaTotal = 0;
		
		mediaTotal = sumaTotal(numeroFloat, numeroEntero1, numeroEntero2, numeroEntero3)/4;
		
		return mediaTotal;
	}
	
	public static void main(String[] args) {
		int numeroPedido1 = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el primer numero"));
		int numeroPedido2 = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el segundo numero"));
		int numeroPedido3 = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el tercer numero"));
		float numeroPedido4 = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el cuarto numero"));
		
		Utils Media = new Utils();
		Media.sumaEnteros(numeroPedido1,numeroPedido2, numeroPedido3 );
		
		System.out.println("Suma total: " + Media.sumaTotal(numeroPedido4, numeroPedido3, numeroPedido3, numeroPedido3));
		System.out.println("Media total: " + Media.mediaTotal(numeroPedido4, numeroPedido3, numeroPedido3, numeroPedido3));
	}
	
}

