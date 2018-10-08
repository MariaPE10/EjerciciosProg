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
		double suma=0d;
		
		for (int i = 1; i < 5; i++) {
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
		int n1, cantidadNumeros;
		double suma=0d;
		
		cantidadNumeros =Integer.parseInt(JOptionPane.showInputDialog("Introduzca la cantidad de numeros"));
		
		for (int i = 0; i < cantidadNumeros; i++) {
			n1 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca un numero " + (i+1)));
			if (n1 > 10) {
				suma = suma + n1;
			}
		}
		JOptionPane.showMessageDialog(null, "La suma de los numeros mayores de 10 es: " + suma);
	}
	
	/* Ejercicio 3: Realiza un ejercicio que pida n�meros al usuario, tantos como indique el usuario. al final
	 * debe aparecer cuantos n�meros positivos y negativos se han introducido.
	 */
	
	public static void BuclesB1Ej3 () {
		int n1, cantidadNumeros;
		double contPos=0d;
		double contNeg=0d;
		
		cantidadNumeros =Integer.parseInt(JOptionPane.showInputDialog("Introduzca la cantidad de numeros"));
		
		for (int i = 0; i < cantidadNumeros; i++) {
			n1 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca un numero " + (i+1)));
			if (n1 >= 0) {
				contPos++; //operador incremento
			} else {
				contNeg++;
			}
		}
		JOptionPane.showMessageDialog(null, "Cantidad de numeros positivos introducidos: " + contPos 
				+ "\nCantidad de numeros negativos introducidos: " + contNeg);
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
	public static void BuclesB2Ej1B () {
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
		int n1 =0, cantidadNumeros, menor, mayor;
		
		cantidadNumeros =Integer.parseInt(JOptionPane.showInputDialog("Introduzca la cantidad de numeros"));
		n1 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca un numero 1"));
		mayor = n1;
		menor = n1;
		
		for (int i = 0; i < (cantidadNumeros-1); i++) { //cantidad de numeros -1 xq ya ha pedido un numero antes del bucle.
			n1 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca un numero " + (i+2)));
			mayor = (n1 > mayor)? n1 : mayor;
			menor = (n1 < menor)? n1 : menor;
		}
		JOptionPane.showMessageDialog(null,"El numero MAYOR es: " + mayor + "\n El numero MENOR es: " + menor);
	}
	
	public static void BuclesB2Ej2B () {
		int numero = 1, mayor = 0, menor =0;
		String mensaje = "Introduzca n�mero (0 -> Terminar)";
		
		for (int i = 0; numero != 0; i++) {
			if (i == 0) { // Primera iteraci�n
				mayor = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
				menor = mayor;
				numero = mayor;
			}
			else { // Resto de iteraciones
				numero = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
				if (numero > mayor && numero != 0) {
					mayor = numero;
				} 
				if (numero < menor && numero != 0) {
					menor = numero; 
				}
			}	
		}
		
		JOptionPane.showMessageDialog(null, "Mayor: " + mayor + " - Menor: " + menor);
	}
	
	/*Ejercicio 3: Ejercicio que obtenga todos los m�ltiplos de un n�mero introducido por el usuario.
	 * Se imprimir�n todos los m�ltiplos menores de 100, este ser� el l�mite.
	 */
	public static void BuclesB2Ej3 () {
		int num;
			
		num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un numero"));
		
		for (int contador = 1; (num * contador) < 100; contador++) {
			System.out.println(num + " x " + contador + " = " + (num * contador));
		}
	}

	/*BLOQUE 3 HECHO CON WHILE
	* Ejercicio 1: Realiza un ejercicio que pida números al usuario. El programa debe detenerse cuando el usuario introduzca
	* el número 0 (cero), que no debe tenerse en cuenta para ninguna operación aritmética, simplemente para salir
	* de la aplicación. Cuando el programa haya terminado, se debe sacar en pantalla el valor de la suma de todos
	* los números. */
	
	public static void WhileB3Ej1 () {
		int num=1, suma=0;
		String mensaje = "Introduzca n�mero (0 -> Terminar)";
		
		while (num != 0) {
			num =Integer.parseInt(JOptionPane.showInputDialog(mensaje));
			suma= suma +num;
		}
		JOptionPane.showMessageDialog(null,"La suma de los numeros es: " + suma);
	}
	
	/* Ejercicio 2: Realiza un ejercicio igual al anterior, con la particularidad de imprimir la 
	 * media al final del ejercicio, no la suma.
	 */
	
	public static void WhileB3Ej2 () {
		int num=1, suma=0, contador=0;
		double media=0d;
		String mensaje = "Introduzca n�mero (0 -> Terminar)";
		
		while (num != 0) {
			num =Integer.parseInt(JOptionPane.showInputDialog(mensaje));
			suma= suma +num;
			contador++;
		}
		media = (double)suma/(contador-1);
		JOptionPane.showMessageDialog(null,"La media de los numeros es: " + media);
	}
	
	/* Ejercicio 3:  Realiza un ejercicio que pida números al usuario hasta que este introduzca el 0 (cero).
	 * Al finalizar el ejercicio se debe imprimir en pantalla el valor mayor introducido. El valor 0 (cero) no
	 * debe tenerse en cuenta.
	 */

	public static void WhileB3Ej3 () {
		int num=1, mayor=0;
		String mensaje = "Introduzca n�mero (0 -> Terminar)";
		
		num =Integer.parseInt(JOptionPane.showInputDialog(mensaje));
		mayor = num;
		
		while (num != 0) {
			if (num > mayor) {
				mayor = num;
			}
		num =Integer.parseInt(JOptionPane.showInputDialog(mensaje));
		}
		JOptionPane.showMessageDialog(null,"El numero mayor es: " + mayor);
	}
	
	/* BLOQUE EJERCICIOS 3 HEHCO CON DO WHILE
	 * Ejercicio 1: Realiza un ejercicio que pida números al usuario. El programa debe detenerse cuando el usuario introduzca
	 * el número 0 (cero), que no debe tenerse en cuenta para ninguna operación aritmética, simplemente para salir
	 * de la aplicación. Cuando el programa haya terminado, se debe sacar en pantalla el valor de la suma de todos
	 * los números. */
	
	public static void DoWhileB3Ej1 () {
		int num, suma=0;
		String mensaje = "Introduzca n�mero (0 -> Terminar)";
		
		do { 
			num =Integer.parseInt(JOptionPane.showInputDialog(mensaje));
			suma= suma +num;
		} while (num != 0);
		JOptionPane.showMessageDialog(null,"La suma de los numeros es: " + suma);
	}
	
	/* Ejercicio 2: Realiza un ejercicio igual al anterior, con la particularidad de imprimir la 
	 * media al final del ejercicio, no la suma.
	 */
	
	public static void DoWhileB3Ej2 () {
		int num=1, suma=0, contador=0;
		double media=0d;
		String mensaje = "Introduzca n�mero (0 -> Terminar)";
		
		do {
			num =Integer.parseInt(JOptionPane.showInputDialog(mensaje));
			suma= suma +num;
			contador++;
		} while (num != 0);
		media = (double)suma/(contador-1);
		JOptionPane.showMessageDialog(null,"La media de los numeros es: " + media);
	}
	
	/* Ejercicio 3:  Realiza un ejercicio que pida números al usuario hasta que este introduzca el 0 (cero).
	 * Al finalizar el ejercicio se debe imprimir en pantalla el valor mayor introducido. El valor 0 (cero) no
	 * debe tenerse en cuenta.
	 */

	public static void DoWhileB3Ej3 () {
		int num=1, mayor=0;
		String mensaje = "Introduzca n�mero (0 -> Terminar)";
		
		num =Integer.parseInt(JOptionPane.showInputDialog(mensaje));
		mayor = num;
		
		do {
			if (num > mayor) {
				mayor = num;
			}
		num =Integer.parseInt(JOptionPane.showInputDialog(mensaje));
		} while (num != 0);
		JOptionPane.showMessageDialog(null,"El numero mayor es: " + mayor);
	}
	
	
	
	
	
	
	
}

