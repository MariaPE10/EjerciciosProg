package Codigo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class codigo03 {

	/*BLOQUE 01: Ejercicio 0: Realiza un ejercicio que inicialice un array de 150 elementos enteros al
	 * azar entre 0 y 100. Debes mostrar el array en pantalla y obtener la suma, la media, el menor y el
	 * mayor de todos los números que aparecen en el array.
	 */

	public static void ArrayB1Ej0() {
		int array[] = new int [150];
		int suma = 0, mayor, menor; 
		float media;
		
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random()*100);
			System.out.println("Numero[" + i + "]: " + array[i]);
		}
		
		mayor = array[0];
		menor = array[0];
		suma = array[0];
		
		for (int i = 1; i<array.length; i++) {
			suma+=array[i];
			if (array[i] > mayor) {
				mayor = array[i];
			}
			if (array[i] < menor) {
				menor = array[i];
			}
		}
		
		media=((float) suma / array.length);
		
		System.out.println("Suma: " + suma);
		System.out.println("Media: " + media);
		System.out.println("Mayor: " + mayor);
		System.out.println("Menor: " + menor);
	}
	
	/* Ejercicio 1: Realiza un ejercicio que inicialice un array de 150 elementos enteros al azar
	 * entre un límite inferior y uno superior que debe especificar el usuario. Debes mostrar el
	 * array en pantalla para comprobar el funcionamiento.
	 */
	
	public static void ArrayB1Ej1() {	
		int array[] = new int [150];
		int max, min;
		
		min=Integer.parseInt(JOptionPane.showInputDialog("Introduzca el limite inferior:"));
		max=Integer.parseInt(JOptionPane.showInputDialog("Introduzca el limite superior:"));
		
		for (int i = 0; i < array.length; i++) {
			array[i] = ((int) Math.round(Math.random() * (max-min)))+min;
			System.out.println("Numero[" + i + "]: " + array[i]);
		}
		
		System.out.println("Límite superior: " + max);
		System.out.println("Límite inferior: " + min);
		
	}
	
	/* Ejercicio 2: Realiza un ejercicio que inicialice un array de 150 elementos enteros al azar entre 0 y 100.
	 * Después de su inicialización debéis imprimir el array en orden inverso.
	 */
	
	public static void ArrayB1Ej2() {	
		int array[] = new int [150];
		
		for (int i = 0; i<array.length; i++) {
			array[i] = (int) Math.round(Math.random()*100);
		}
		
		for (int i = 149; i > -1; i--) {
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
		boolean numEncontrado = false;
		
		num=Integer.parseInt(JOptionPane.showInputDialog("Introduzca el valor buscado (0 a 100)"));
		
		for (int i = 0; i<array.length; i++) {
			array[i]= (int) Math.round(Math.random()*100);
			if (num==array[i]) {
				System.out.println("El numero " + num + " Se encuentra en la posicion " + i);
				numEncontrado = true;
			}
		}
		if (!numEncontrado){
			System.out.println("El numero que ha introducido no ha sido encontrado" + num);
		}
	}
	
	/* Ejercicio 4: Realiza un ejercicio que inicialice un array de 150 elementos enteros al azar entre 0 y 100.
	 * Debes obtener la suma de los números pares y los impares en variables separadas. 
	 */
	
	public static void ArrayB1Ej4() {	
		int array[] = new int [150];
		int sumaPar = 0, sumaImpar = 0;
		
		for (int i = 0; i< array.length; i++) {
			array[i] = (int) Math.round(Math.random()*100);
			if (array[i] % 2 == 0) { //es par
				sumaPar += array[i];
			}
			else { //es impar
				sumaImpar += array[i];
			}
		}
		
		System.out.println("La suma de los numeros pares es: " + sumaPar);
		System.out.println("La suma de los numeros impares es: " + sumaImpar);
	}
	
	/* Ejercicio 5: Realiza un ejercicio que inicialice un array de 150 elementos enteros al azar entre 0 y 100,
	 * dentro de una función. Debes mostrar al usuario la suma de los elementos cuyo índice sea par.
	 */
	
	public static void ArrayB1Ej5() {	
		int array[]= new int [150];
		int suma=0;
		
		for (int i = 0; i<array.length; i++) {
			array[i] = (int) Math.round(Math.random()*100);
			if (i % 2 == 0) { // es par
				suma += array[i];
			}
		}
		System.out.println("La suma de los numeros con indice par es: " + suma);
	}
	
	/* BLOQUE 02: Ejercicio 1: Realiza un ejercicio que inicialice un array de 150 elementos enteros al azar 
	 * entre -100 y 100. Debes conseguir que todos los números pares del array cambien de signo, los positivos
	 * deben pasar a negativos y viceversa. 
	 */
	
	public static void ArrayB2Ej1() {
		int array[]= new int [150];
		
		for (int i = 0; i<array.length; i++) {
			array[i]= (int) Math.round(Math.random()*200)-100;
			System.out.print( array[i] + " ");
			if (array[i] % 2 == 0) {
				array[i]=array[i]*-1;
			}
		}
		System.out.println("Array con signos cambiados\n");
		for (int i = 0; i<array.length; i++) {
		System.out.print(array[i] + " ");
		}
	}
	
	/* Ejercicio 2: Realiza un ejercicio que inicialice dos arrays de 150 elementos enteros al azar 
	 * entre 0 y 100. Debes crear un tercer array, compuesto de la siguiente forma: en los elementos de
	 * índice impar del tercer array debes copiar los elementos de índice impar del primer array; en los
	 * elementos de índice par del tercer array debes copiar los elementos de índice par del segundo array.
	 */
	
	public static void ArrayB2Ej2() {
		int longitud =150;
		int array1[]= new int [longitud];
		int array2[]= new int [longitud];
		int array3[]= new int [longitud];
		
		System.out.println("ARRAY NUMERO 1\n");
		for (int i = 0; i < array1.length; i++) {
			array1[i] = (int) Math.round(Math.random()*100);
			System.out.print("["+i+"]" + " ");
			System.out.print(array1[i] + " ");
		}
		System.out.println("\nARRAY NUMERO 2\n");
		for (int i = 0; i<array2.length; i++) {
			array2[i]= (int) Math.round(Math.random()*100);
			System.out.print("["+i+"]" + " ");
			System.out.print(array2[i] + " ");
		}
		System.out.println("\nARRAY NUMERO 3\n");
		for (int i = 0; i < array3.length; i++) {	
			if (i % 2 == 0) { //es par
				array3[i] = array2[i];
			}
			else {
				array3[i] = array1[i];
			}
			System.out.print("[" + i + "]" + " ");
			System.out.print(array3[i] + " ");
		}
	}
	
	/* Ejercicio 3: Realiza un ejercicio que inicialice un array de 150 elementos enteros al azar entre 0
	 * y 100. Debes conseguir multiplicar cada uno de los elementos del array por un número determinado,
	 * pedido al usuario.
	 */
	
	public static void ArrayB2Ej3() {
		int array[]= new int [150];
		int num;
		
		num=Integer.parseInt(JOptionPane.showInputDialog("Introduzca el multiplicador"));
		
		System.out.println("ARRAY\n");
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random()*100);
			System.out.print("[" + i + "]" + " ");
			System.out.print(array[i] + " ");
		}
		System.out.println("\nARRAY MULTIPLICADO POR: " + num);
		for (int i = 0; i < array.length; i++) {
			array[i] = array[i] * num;
			System.out.print("[" + i + "]" + " ");
			System.out.print(array[i] + " ");
		}
	}
	
	/* Ejercicio 4: Realiza un ejercicio en que inicialice un array de 5 elementos enteros al azar entre 0 y 100.
	 * Debes conseguir que se desplacen los n�meros un lugar a su derecha, de manera que el desplazamiento sea circular,
	 * si un n�mero sale por la derecha volver� a entrar por la izquierda. Ejemplo: 1 2 3 4 5 pasa a ser 5 1 2 3 4 que
	 * pasa a ser 4 5 1 2 3.
	 */
	
	public static void ArrayB2Ej4() {
		int array[]= new int [5];
		
		// 12 > 1 > 4 > 21 > 56
		
		System.out.println("ARRAY");
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random()*100);
			System.out.println(array[i]);
		}
		System.out.println("\nARRAY CIRCULAR\n");
		
		// aux = el valor que hay en la posicion 4 del array
		// int aux = array[array.length-1];
		
		/*// i = 4
		for (int i = (array.length-1); i > 0; i--) {
			array[i] = array[i-1];
		}
		array[0]= aux;
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		*/
		
		int arrayAux[] = new int[5];
		// 12 > 1 > 4 > 21 > 56
		// 56 > 12 > 1 > 4 > 21
		for(int i = 0; i < array.length; i++) {			
			if(i == array.length - 1) {
				arrayAux[0] = array[array.length -1];
			} else {
				arrayAux[i + 1] = array[i];
			}	
		}
		
		for (int i = 0; i<arrayAux.length; i++) {
			System.out.println(arrayAux[i]);
		}
	}
	
	/* Ejercicio 5:  Realiza un ejercicio igual al anterior, pero en el que el usuario pueda indicar la cantidad de
	 * posiciones que deseamos desplazar.
	 */
	
	public static void ArrayB2Ej5() {
		int array[]= new int [5];
		int num;
		
		num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la cantidad de posiciones desplazadas"));
		
		
		System.out.println("ARRAY");
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random()*100);
			System.out.println(array[i]);
		}
		
		// num = 3
		for (int j = 0;j < num;j++) {
			System.out.println("\nARRAY CIRCULAR "+ (j+1));
			
			// aux = array[4]
			int aux = array[array.length-1];
			
			for (int i = (array.length-1); i > 0; i--) {
				array[i] = array[i-1];
			}
			array[0] = aux;
			for (int i = 0; i < array.length; i++) {
				System.out.println(array[i]);
			}
		}		
	}
	
	/* Ejercicio 6: Realiza un ejercicio igual al anterior, en el que el usuario tambi�n pueda deteminar la direcci�n 
	 * del movimiento.
	 */
	
	public static void ArrayB2Ej6() {
		int array[]= new int [5];
		int num, sentido;
		
		num=Integer.parseInt(JOptionPane.showInputDialog("Introduzca la cantidad de posiciones desplazadas"));
		sentido =Integer.parseInt(JOptionPane.showInputDialog("Introduzca el sentido:\n 0 Abajo\n 1 Arriba"));
		
		System.out.println("ARRAY");
		for (int i = 0; i<array.length; i++) {
			array[i]= (int) Math.round(Math.random()*100);
			System.out.println(array[i]);
		}
		if (sentido ==0) {
			for (int j=0;j<num;j++) {
				System.out.println("\nARRAY CIRCULAR "+ (j+1));
				int aux=array[array.length-1];
				
				for (int i = (array.length-1); i>0; i--) {
					array[i]=array[i-1];
				}
				array[0]=aux;
				for (int i = 0; i<array.length; i++) {
					System.out.println(array[i]);
				}
			}
		}
		else {
			for (int j=0;j<num;j++) {
				System.out.println("\nARRAY CIRCULAR "+ (j+1));
				int aux=array[0];
				
				for (int i = 0; i<array.length-1; i++) {
					array[i]=array[i+1];
				}
				array[array.length-1]=aux;
				for (int i = 0; i<array.length; i++) {
					System.out.println(array[i]);
				}
			}
		}
	}
	
	/* BLOQUE 3. Ejercicio 1: Realiza un ejercicio que inicialice un array de 150 elementos enteros al azar entre 
	 * 0 y 1.000. Una vez que lo hayas conseguido debes realizar implementar el algoritmo de ordenaci�n llamado 
	 * "Burbuja", con el objetivo de ordenar el array completamente.
	 */
	
	public static void ArrayB3Ej1() {
		int array[] = new int [10];
		int aux;
		
		System.out.println("ARRAY");
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 1000);
			System.out.print(array[i]+ " ");
		}
		
		for (int j = array.length -1; j > 0 ; j--) {
			for (int i = 0; i < j ; i++) {
				if (array[i] > array[i+1]) {
					aux = array[i];
					array[i]=array [i+1];
					array[i+1]=aux;
				}
			}
		}
		System.out.print("\nARRAY ORDENADO\n");

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+ " ");
		}
	}
	
	/* Ejercicio 2: Realiza un ejercicio que inicialice un array de 150 elementos enteros al azar entre 0 y 1.000.
	 * Una vez que lo hayas conseguido debes realizar implementar el algoritmo de ordenaci�n llamado "Inserci�n directa",
	 * con el objetivo de ordenar el array completamente.
	 */
	
	public static void ArrayB3Ej2() {
		int array[] = new int [10];
		int aux;
		
		System.out.println("ARRAY");
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 1000);
			System.out.print(array[i]+ " ");
		}
		
		for (int i = 0; i < array.length; i++) {			
			for (int j = i; j > 0; j--) {
				if(array[j] < array[j-1]) {
					aux = array[j];
					array[j] = array[j-1];
					array[j-1] = aux;
				}
			}			
		}
		System.out.print("\nARRAY ORDENADO\n");

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+ " ");
		}
	}
		
}
