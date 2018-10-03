package Codigo;

import javax.swing.JOptionPane;

public class codigo02 {
	
/* BLOQUE 02: Ejercicio1 1: Media de una cantidad de numeros introducidos por el usuario.
 * El usuario especificara una cantidad de numeros, tras lo cual se le deben pedir 
 * tantos como este haya indicado. Al final se debe imprimir la media. 
 */
	public static void BuclesEj1 () {
		int n1, acumulado; 
		int suma =0;
		double resultado =0d;
		
		// Peticion de numero de veces que se repetirá el bucle
		n1 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca la cantidad de numeros"));
		
		for (int i = 0; i < n1; i++ ) { 
			 acumulado = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un numero"));
			 suma = suma + acumulado;
		 }
		 resultado = suma/n1;
		JOptionPane.showMessageDialog(null, "La media de los numeros es: " + resultado);
	}
	
	/* Hacer lo mismo que en el anterior pero con un while. Se debe repetir hasta que el numero
	 * introducido sea 0.
	 */
	public static void BuclesEj1B () {
		int num = 0;
		int suma =0;
		int contador =0;
		double resultado =0d;
		
		num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un numero"));
		suma = suma + num;
		contador++;
		
		while (num != 0) { //se repetira mientras que lo que hay dentro del parentesis sea verdadero.
			num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un numero"));
			if (num != 0) {
				suma = suma + num;
				contador++;
			}
		}
		resultado = suma/contador;
		JOptionPane.showMessageDialog(null, "La media de los numeros es: " + resultado);
	}
}

