package Ejercicios.Objetos.Bloque1;

import javax.swing.JOptionPane;

public class Utils {

/* Ejercicio 1: Realiza un mï¿½todo que reciba como parï¿½metros de entrada tres valores enteros y uno flotante.
  * El mï¿½todo debe devolver la media aritmï¿½tica de los cuatro valores, un valor flotante.
  * "main" debe usar a esta funciï¿½n creada por ti, e imprimir el valor de la media en la consola de salida.
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
	//Media de 4 numeros (hace falta crear el objeto par ausarlo)
	public float mediaTotal(float numeroFloat, int numeroEntero1, int numeroEntero2, int numeroEntero3) {
		
		float mediaTotal = 0;
		
		mediaTotal = sumaTotal(numeroFloat, numeroEntero1, numeroEntero2, numeroEntero3)/4;
		
		return mediaTotal;
	}
	//media de 4 numeros
	public static float media4Valores (int num1, int num2, int num3, float num4) {
		float media = (num1 + num2 + num3 + num4) / 4;
		return media;
	}
	
	//Pide un numero entero 
	public static int pideNumeroEntero() {
		
		int num;
		
		num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca numero entero"));
		
		return num;
	}
	//Pide un numero float
	public static float pideNumeroFloat() {
		
		float num;
		
		num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca numero entero"));
		
		return num;
	}
	//Pide un numero Entero entre dos límites
	public static int pideNumeroEntero (int limInf, int limSup) {
		
		int num;
		do {
			num = Integer.parseInt(JOptionPane.showInputDialog(
					"Introduzca número: "));
		} while (num < limInf || num > limSup);
		
		return num;
	}
	//Averigua el mayor de dos numeros introducidos.
	public static int mayor (int num1, int num2) {
		if (num1 > num2) {
			return num1;
		}
		else {
			return num2;
		}
	}
	//Pide dos numeros y averigua el mayor de ellos
	public static int peticion2NumerosYMayor () {
		int pepe = pideNumeroEntero(0, 10);
		int juan = pideNumeroEntero(0, 10);
		
		int mayor = mayor (pepe, juan);
		return mayor;
	}
	
	public static void main(String[] args) {
		int numeroPedido1 = pideNumeroEntero();
		int numeroPedido2 = pideNumeroEntero();
		int numeroPedido3 = pideNumeroEntero();
		float numeroPedido4 = pideNumeroFloat();
		
		Utils Media = new Utils();
		Media.sumaEnteros(numeroPedido1,numeroPedido2, numeroPedido3 );
		
		System.out.println("Suma total: " + Media.sumaTotal(numeroPedido4, numeroPedido3, numeroPedido3, numeroPedido3));
		System.out.println("Media total: " + Media.mediaTotal(numeroPedido4, numeroPedido3, numeroPedido3, numeroPedido3));
	}
	
}

