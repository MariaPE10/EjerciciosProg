package Codigo;

import javax.swing.JOptionPane;

public class codigo02 {
	
	/* BLOQUE 1: Ejercicio1: Realiza un programa que pida al usuario cuatro números enteros, y calcule la suma solo
	 * de aquellos números introducidos por el usuario, que sean mayores de 10. Es decir, que si el
	 * usuario introduce el 5, el 15, el 6 y el 25, el programa debe calcular la suma solo de 15 más 25,
	 * ya que 5 y 6 son menores de 10.
	 */
		
	public static void BuclesB1Ej1 () {
		int n1;
		int i;
		double suma=0d;
		
		for (i = 1; i < 5; i++) {
			n1 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca un numero: " + i));
			if (n1 > 10) {
				suma += n1;
			}
		}
		JOptionPane.showMessageDialog(null, "La suma de los numeros mayores de 10 es: " + suma);
	}
	
	/* Ejercicio 2: Modifica el ejercicio anterior de manera que, en lugar de que el programa siempre pida
	 * cuatro números, sea el usuario el que decida cuantos números se van a pedir. 
	 */
	
	public static void BuclesB1Ej2 () {
		int n1, i, cantidadNumeros;
		double suma=0d;
		
		cantidadNumeros =Integer.parseInt(JOptionPane.showInputDialog("Introduzca la cantidad de numeros"));
		
		for (i = 0; i < cantidadNumeros; i++) {
			n1 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca un numero " + (i+1)));
			if (n1 > 10) {
				suma = suma + n1;
			}
		}
		JOptionPane.showMessageDialog(null, "La suma de los numeros mayores de 10 es: " + suma);
	}
	
	
	public static void BuclesB1Ej3 () {
		int n1, i, cantidadNumeros;
		double suma=0d;
		
		cantidadNumeros =Integer.parseInt(JOptionPane.showInputDialog("Introduzca la cantidad de numeros"));
		
		for (i = 0; i < cantidadNumeros; i++) {
			n1 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca un numero " + (i+1)));
			if (n1 > 10) {
				suma = suma + n1;
			}
		}
		JOptionPane.showMessageDialog(null, "La suma de los numeros mayores de 10 es: " + suma);
	}
	
	
	/* BLOQUE 02: Ejercicio1 1: Media de una cantidad de numeros introducidos por el usuario.
	 * El usuario especificara una cantidad de numeros, tras lo cual se le deben pedir 
	 * tantos como este haya indicado. Al final se debe imprimir la media. 
	 */
	public static void BuclesB2Ej1 () {
		int n1, acumulado; 
		int suma =0;
		double resultado =0d;
		
		// Peticion de numero de veces que se repetir� el bucle
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

	/*Ejercicio 2: Mayor y menor de una cantidad de números dada por el usuario. El usuario introducirá una cantidad de números,
	 * tras lo cual se le deben pedir tantos como este haya indicado. Al final se debe imprimir el mayor y el menor
	 * de todos los introducidos. 
	 */
	
	public static void BuclesB2Ej2 () {
		int n1, i, cantidadNumeros, menor, mayor;
		
		cantidadNumeros =Integer.parseInt(JOptionPane.showInputDialog("Introduzca la cantidad de numeros"));
		
		for (i = 0; i < cantidadNumeros; i++) {
			n1 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca un numero " + (i+1)));
			}
		}
		JOptionPane.showMessageDialog(null,"El numero MAYOR es: " + maro + "\n El numero MENOR es: " + menor);

}

