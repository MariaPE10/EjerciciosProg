package Codigo;

import javax.swing.JOptionPane;

public class codigo03 {

	/*BLOQUE 01: Ejercicio 0: Realiza un ejercicio que inicialice un array de 150 elementos
	 * enteros al azar entre 0 y 100. Después de su inicialización debéis imprimir el
	 * array en orden inverso.
	 */

	public static void ArrayB1Ej0() {
		int array[]= new int [150];
		
		for (int i = 0; i<array.length; i++) {
			array[i]= (int) Math.round(Math.random()*100);
		}
		
		for (int i = 149; i>=0; i--) {
			System.out.println("Numero[" + i + "]: " + array[i]);
		}
	}
	
	/* Ejercicio 1: Realiza un ejercicio que inicialice un array de 150 elementos enteros al azar
	 * entre un límite inferior y uno superior que debe especificar el usuario. Debes mostrar el
	 * array en pantalla para comprobar el funcionamiento.
	 */
	
	public static void ArrayB1Ej1() {	
		int array[]= new int [150];
		int max, min;
		
		min=Integer.parseInt(JOptionPane.showInputDialog("Introduzca el limite inferior:"));
		max=Integer.parseInt(JOptionPane.showInputDialog("Introduzca el limite superior:"));
		
		for (int i = 0; i<array.length; i++) {
			array[i]= ((int) Math.round(Math.random() * (max-min)))+min;
		}
		
		System.out.println("Límite superior: "+max);
		System.out.println("Límite inferior: "+min);
		
		for (int i = 0; i<array.length; i++) {
			System.out.println("Numero[" + i + "]: " + array[i]);
		}
	}
	
	/* Ejercicio 2: Realiza un ejercicio que inicialice un array de 150 elementos enteros al azar entre 0 y 100.
	 * Después de su inicialización debéis imprimir el array en orden inverso.
	 */
	
	public static void ArrayB1Ej2() {	
		int array[]= new int [150];
		
		for (int i = 0; i<array.length; i++) {
			array[i]= (int) Math.round(Math.random()*100);
		}
		
		for (int i = 149; i>=0; i--) {
			System.out.println("Numero[" + i + "]: " + array[i]);
		}
	}
	
	/* Ejercicio 3: Realiza un ejercicio que inicialice un array de 150 elementos enteros al azar entre 0 y 100.
	 * A continuación pedirás al usuario un valor y buscarás dicho valor en el array. Si lo encuentras, debes
	 * indicar al usuario la posición del array en que se encuenta. En caso de que no encuentres el valor buscado,
	 * debes indicárselo también al usuario.
	 */
	
	public static void ArrayB1Ej3() {	
		int array[]= new int [150];
		int num;
		
		num=Integer.parseInt(JOptionPane.showInputDialog("Introduzca el valor buscado (0 a 100)"));
		
		for (int i = 0; i<array.length; i++) {
			array[i]= (int) Math.round(Math.random()*100);
			if (num==array[i]) {
				System.out.println("El numero " + num + " Se encuentra en la posicion [" + i + "]: " + array[i]);
			}
		}
	}
	
	/* Ejercicio 4: Realiza un ejercicio que inicialice un array de 150 elementos enteros al azar entre 0 y 100.
	 * Debes obtener la suma de los números pares y los impares en variables separadas. 
	 */
	
	public static void ArrayB1Ej4() {	
		int array[]= new int [150];
		int sumaPar=0, sumaImpar=0;
		
		for (int i = 0; i<array.length; i++) {
			array[i]= (int) Math.round(Math.random()*100);
			if (array[i]%2==0) { //es par
				sumaPar = sumaPar+array[i];
			}
			else { //es impar
				sumaImpar = sumaImpar+ array[i];
			}
		}
		
		System.out.println("La suma de los numeros pares es: "+ sumaPar);
		System.out.println("La suma de los numeros impares es: "+ sumaImpar);
	}
	
	/* Ejercicio 5: Realiza un ejercicio que inicialice un array de 150 elementos enteros al azar entre 0 y 100,
	 * dentro de una función. Debes mostrar al usuario la suma de los elementos cuyo índice sea par.
	 */
	
	public static void ArrayB1Ej5() {	
		int array[]= new int [150];
		int suma=0;
		
		for (int i = 0; i<array.length; i++) {
			array[i]= (int) Math.round(Math.random()*100);
			if (i%2==0) { // es par
				suma=suma+array[i];
			}
		}
		System.out.println("La suma de los numeros con indice par es: " + suma);
	}
	
	/* BLOQUE 02: Ejercicio 1: Realiza un ejercicio que inicialice un array de 150 elementos enteros al azar entre -100 y 100.
	 * Debes conseguir que todos los números pares del array cambien de signo, los positivos deben pasar a
	 * negativos y viceversa. 
	 */
	public static void ArrayB2Ej1() {
		int array[]= new int [150];
		
		for (int i = 0; i<array.length; i++) {
			array[i]= (int) Math.round(Math.random()*100)-100;
			if (array[i]%2==0) { // es par
				System.out.println("Numero[" + i + "]: " + array[i]);
			}
		}
	}
	
	
	
	
	
	
	
	
	
}
