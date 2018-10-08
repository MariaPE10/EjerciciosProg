package Codigo;

import javax.swing.JOptionPane;

public class codigo02 {
	
	/* BLOQUE 1: Ejercicio1: Realiza un programa que pida al usuario cuatro nÃºmeros enteros, y calcule la suma solo
	 * de aquellos nÃºmeros introducidos por el usuario, que sean mayores de 10. Es decir, que si el
	 * usuario introduce el 5, el 15, el 6 y el 25, el programa debe calcular la suma solo de 15 mÃ¡s 25,
	 * ya que 5 y 6 son menores de 10.
	 */
		
	public static void BuclesB1Ej1 () {
		int n1;
		float suma=0f;
		
		for (int i = 1; i < 5; i++) {
			n1 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca un numero: " + i));
			if (n1 > 10) {
				suma += n1;
			}
		}
		JOptionPane.showMessageDialog(null, "La suma de los numeros mayores de 10 es: " + suma);
	}
	
	/* Ejercicio 2: Modifica el ejercicio anterior de manera que, en lugar de que el programa siempre pida
	 * cuatro nÃºmeros, sea el usuario el que decida cuantos nÃºmeros se van a pedir. 
	 */
	
	public static void BuclesB1Ej2 () {
		int n1, cantidadNumeros;
		float suma=0f;
		
		cantidadNumeros =Integer.parseInt(JOptionPane.showInputDialog("Introduzca la cantidad de numeros"));
		
		for (int i = 0; i < cantidadNumeros; i++) {
			n1 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca un numero " + (i+1)));
			if (n1 > 10) {
				suma = suma + n1;
			}
		}
		JOptionPane.showMessageDialog(null, "La suma de los numeros mayores de 10 es: " + suma);
	}
	
	/* Ejercicio 3: Realiza un ejercicio que pida nï¿½meros al usuario, tantos como indique el usuario. al final
	 * debe aparecer cuantos nï¿½meros positivos y negativos se han introducido.
	 */
	
	public static void BuclesB1Ej3 () {
		int n1, cantidadNumeros;
		int contPos=0, contNeg=0;
		
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
		int cantidadNum, num; 
		int suma =0;
		float media =0f;
		
		// Peticion de numero de veces que se repetirï¿½ el bucle
		cantidadNum =Integer.parseInt(JOptionPane.showInputDialog("Introduzca la cantidad de numeros"));
		
		for (int i = 0; i < cantidadNum; i++ ) { 
			 num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un numero" + (i+1)));
			 suma = suma + num;
		 }
		 
		media = (float) suma/cantidadNum;
		JOptionPane.showMessageDialog(null, "La media de los numeros es: " + media);
	}
	
	/* Hacer lo mismo que en el anterior pero con un while. Se debe repetir hasta que el numero
	 * introducido sea 0.
	 */
	public static void BuclesB2Ej1B () {
		int num = 1;
		int suma =0;
		int contador =0;
		float media =0f;
		
		while (num != 0) { //se repetira mientras que lo que hay dentro del parentesis sea verdadero.
			num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un numero"));
			if (num != 0) {
				suma = suma + num;
				contador++;
			}
		}
		media = (float)suma/contador;
		JOptionPane.showMessageDialog(null, "La media de los numeros es: " + media);
	}

	/*Ejercicio 2: Mayor y menor de una cantidad de nÃºmeros dada por el usuario. El usuario introducirÃ¡ una cantidad de nÃºmeros,
	 * tras lo cual se le deben pedir tantos como este haya indicado. Al final se debe imprimir el mayor y el menor
	 * de todos los introducidos. 
	 */
	
	public static void BuclesB2Ej2 () {
		int n1 =0, cantidadNumeros, menor=0, mayor=0;
		
		cantidadNumeros =Integer.parseInt(JOptionPane.showInputDialog("Introduzca la cantidad de numeros"));
		
		if (cantidadNumeros >0) {
			n1 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca un numero 1"));
			mayor = n1;
			menor = n1;
			
			for (int i = 0; i < (cantidadNumeros-1); i++) { //cantidad de numeros -1 xq ya ha pedido un numero antes del bucle.
				n1 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca un numero " + (i+2)));
				mayor = (n1 > mayor)? n1 : mayor;
				menor = (n1 < menor)? n1 : menor;
			}
		} 
		JOptionPane.showMessageDialog(null,"El numero MAYOR es: " + mayor + "\n El numero MENOR es: " + menor);
	}
	
	public static void BuclesB2Ej2B () {
		int numero = 1, mayor = 0, menor =0;
		String mensaje = "Introduzca nï¿½mero (0 -> Terminar)";
		
		for (int i = 0; numero != 0; i++) {
			if (i == 0) { // Primera iteraciï¿½n
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
	
	/*Ejercicio 3: Ejercicio que obtenga todos los mï¿½ltiplos de un nï¿½mero introducido por el usuario.
	 * Se imprimirï¿½n todos los mï¿½ltiplos menores de 100, este serï¿½ el lï¿½mite.
	 */
	public static void BuclesB2Ej3 () {
		int num;
			
		num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un numero"));
		
		for (int contador = 1; (num * contador) < 100; contador++) {
			System.out.println(num + " x " + contador + " = " + (num * contador));
		}
	}
	
	// Ejercicio 4: Reforma el ejercicio anterior, para que el límite sea también introducido por el usuario.
	
	public static void BuclesB2Ej4 () {
		int num, cantidadNumeros;
		
		cantidadNumeros =Integer.parseInt(JOptionPane.showInputDialog("Introduzca la cantidad de numeros"));	
		num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un numero"));
		
	
		for (int contador = 1; contador <= cantidadNumeros ; contador++) {
			System.out.println(num + " x " + contador + " = " + (num * contador));
		}
	}
	
	/* BLOQUE 3 Ejercicio1: Realiza un ejercicio que pida números al usuario. El programa debe detenerse cuando 
	 * el usuario introduzca el número 0 (cero), que no debe tenerse en cuenta para ninguna operación aritmética,
	 * simplemente para salir de la aplicación. Cuando el programa haya terminado, se debe sacar en pantalla el valor 
	 * de la suma de todos los números.
	 */
	
	public static void BuclesB3Ej1 () {
		int numero =1, suma=0;
		String mensaje = "Introduzca numero (0 -> Terminar)";
		
		for (int i = 0; numero != 0; i++) {
			if (i == 0) { // Primera iteracion
				suma = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
				numero = suma;
			}
			else { // Resto de iteraciones
				numero = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
				suma += numero;
			}	
		}
		JOptionPane.showMessageDialog(null, "La suma de los numeros introducidos es: " + suma);
	}
	
	/* Ejercicio 2:  Realiza un ejercicio igual al anterior, con la particularidad de imprimir la media al
	 * final del ejercicio, no la suma.
	 */
	
	public static void BuclesB3Ej2 () {
		int numero =1, suma=0, i=0;
		String mensaje = "Introduzca numero (0 -> Terminar)";
		
		for ( i = 0; numero != 0; i++) {
			if (i == 0) { // Primera iteracion
				suma = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
				numero = suma;
			}
			else { // Resto de iteraciones
				numero = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
				suma += numero;
			}	
		}
		JOptionPane.showMessageDialog(null, "La media de los numeros introducidos es: " + suma/(i-1));
	}	
	
	/* Ejercicio 3: Realiza un ejercicio que pida números al usuario hasta que este introduzca el 0 (cero).
	 * Al finalizar el ejercicio se debe imprimir en pantalla el valor mayor introducido. El valor 0 (cero)
	 * no debe tenerse en cuenta.
	 */
	
	public static void BuclesB3Ej3 () {
		int numero = 1, mayor = 0;
		String mensaje = "Introduzca numero (0 -> Terminar)";
		
		for (int i = 0; numero != 0; i++) {
			if (i == 0) { // Primera iteracion
				mayor = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
				numero = mayor;
			}
			else { // Resto de iteraciones
				numero = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
				if (numero > mayor && numero != 0) {
					mayor = numero;
				} 
			}	
		}
		JOptionPane.showMessageDialog(null, "El numero Mayor es: " + mayor);
	}
	
	/* Ejercicio 4: Realiza un ejercicio igual al anterior, con la particularidad de que debe imprimir
	 * en pantalla el menor, no el mayor.
	 */
	
	public static void BuclesB3Ej4 () {
		int numero = 1, menor = 0;
		String mensaje = "Introduzca numero (0 -> Terminar)";
		
		for (int i = 0; numero != 0; i++) {
			if (i == 0) { // Primera iteracion
				menor = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
				numero = menor;
			}
			else { // Resto de iteraciones
				numero = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
				if (numero < menor && numero != 0) {
					menor = numero;
				} 
			}	
		}
		JOptionPane.showMessageDialog(null, "El numero Menor es: " + menor);
	}
	
	/* Ejercicio 5: Realiza un ejercicio parecido a los dos anteriores, dónde se imprima el mayor
	 * valor y el menor de todos los introducidos.
	 */
	
	public static void BuclesB3Ej5 () {
		int numero = 1, mayor = 0, menor =0;
		String mensaje = "Introduzca numero (0 -> Terminar)";
		
		for (int i = 0; numero != 0; i++) {
			if (i == 0) { // Primera iteracion
				mayor = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
				menor = mayor;
				numero = mayor;
			}
			else { // Resto de iteraciones
				numero = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
				if (numero > mayor && numero != 0) {
					mayor = numero;
				} else {
					if (numero < menor && numero != 0) {
						menor = numero; 
					}
				}
			}	
		}
		JOptionPane.showMessageDialog(null, "Mayor: " + mayor + "\nMenor: " + menor);
	}	
	
	/* Ejercicio 6: Realiza un ejercicio que pida números al usuario, hasta que uno de ellos sea 0 (cero).
	 * Para cada número introducido se debe mostrar en pantalla su tabla de multiplicar, desde el 0 
	 * (cero) hasta el 10. 
	 */

	public static void BuclesB3Ej6 () {
		int num;
		String mensaje = "Introduzca numero (0 -> Terminar)";
		
		num = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
		
		for (int i = 0; num != 0; i++) {
			if (i == 0) { // Primera iteraciï¿½n
				for (int contador = 0; contador <= 10; contador++) {
				System.out.println(num + " x " + contador + " = " + (num*contador));	
				}
			} else {
				num = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
				if (num!=0) {
					for (int contador2 = 0; contador2 <= 10; contador2++) {
						System.out.println(num + " x " + contador2 + " = " + (num*contador2));	
					}
				}
			}
		}
	}
	
	/*Ejercicio 7: Realiza un ejercicio que pida números al usuario, hasta que uno de ellos sea 0 (cero).
	 * Al finalizar se debe imprimir en pantalla cuantos son positivos y cuantos negativos.
	 * No debes tener en cuenta el 0 (cero).
	 */
	
	public static void BuclesB3Ej7 () {
		int n1 =1;
		int contPos=0;
		int contNeg=0;
		
		for (int i = 0; n1 !=0; i++) {
			n1 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca un numero " + (i+1)));
			if (n1 >= 0 && n1!=0) {
				contPos++;
			} else {
				if (n1!=0) {
				contNeg++;
				}
			}
		}
		JOptionPane.showMessageDialog(null, "Cantidad de numeros positivos introducidos: " + contPos 
				+ "\nCantidad de numeros negativos introducidos: " + contNeg);
	}
	
	/*BLOQUE 3 HECHO CON WHILE
	* Ejercicio 1: Realiza un ejercicio que pida nÃºmeros al usuario. El programa debe detenerse cuando el usuario introduzca
	* el nÃºmero 0 (cero), que no debe tenerse en cuenta para ninguna operaciÃ³n aritmÃ©tica, simplemente para salir
	* de la aplicaciÃ³n. Cuando el programa haya terminado, se debe sacar en pantalla el valor de la suma de todos
	* los nÃºmeros. */
	
	public static void WhileB3Ej1 () {
		int num=1, suma=0;
		String mensaje = "Introduzca nï¿½mero (0 -> Terminar)";
		
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
		float media=0f;
		String mensaje = "Introduzca nï¿½mero (0 -> Terminar)";
		
		while (num != 0) {
			num =Integer.parseInt(JOptionPane.showInputDialog(mensaje));
			suma= suma +num;
			contador++;
		}
		
		media = (float)suma/(contador-1);
		JOptionPane.showMessageDialog(null,"La media de los numeros es: " + media);
	}
	
	/* Ejercicio 3:  Realiza un ejercicio que pida nÃºmeros al usuario hasta que este introduzca el 0 (cero).
	 * Al finalizar el ejercicio se debe imprimir en pantalla el valor mayor introducido. El valor 0 (cero) no
	 * debe tenerse en cuenta.
	 */

	public static void WhileB3Ej3 () {
		int num=1, mayor=0;
		String mensaje = "Introduzca nï¿½mero (0 -> Terminar)";
		
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
	
	/* BLOQUE EJERCICIOS 3 HECHO CON DO WHILE
	 * Ejercicio 1: Realiza un ejercicio que pida nÃºmeros al usuario. El programa debe detenerse cuando el usuario introduzca
	 * el nÃºmero 0 (cero), que no debe tenerse en cuenta para ninguna operaciÃ³n aritmÃ©tica, simplemente para salir
	 * de la aplicaciÃ³n. Cuando el programa haya terminado, se debe sacar en pantalla el valor de la suma de todos
	 * los nÃºmeros. */
	
	public static void DoWhileB3Ej1 () {
		int num, suma=0;
		String mensaje = "Introduzca nï¿½mero (0 -> Terminar)";
		
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
		float media=0f;
		String mensaje = "Introduzca nï¿½mero (0 -> Terminar)";
		
		do {
			num =Integer.parseInt(JOptionPane.showInputDialog(mensaje));
			suma= suma +num;
			contador++;
		} while (num != 0);
		
		media = (float)suma/(contador-1);
		JOptionPane.showMessageDialog(null,"La media de los numeros es: " + media);
	}
	
	/* Ejercicio 3:  Realiza un ejercicio que pida nÃºmeros al usuario hasta que este introduzca el 0 (cero).
	 * Al finalizar el ejercicio se debe imprimir en pantalla el valor mayor introducido. El valor 0 (cero) no
	 * debe tenerse en cuenta.
	 */

	public static void DoWhileB3Ej3 () {
		int num=1, mayor=0;
		String mensaje = "Introduzca nï¿½mero (0 -> Terminar)";
		
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

