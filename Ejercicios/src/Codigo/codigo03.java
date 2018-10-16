package Codigo;

import javax.swing.JOptionPane;

public class codigo03 {

	/*BLOQUE 01: Ejercicio 0: Realiza un ejercicio que inicialice un array de 150 elementos enteros al
	 * azar entre 0 y 100. Debes mostrar el array en pantalla y obtener la suma, la media, el menor y el
	 * mayor de todos los números que aparecen en el array.
	 */

	public static void ArrayB1Ej0() {
		int array[]= new int [10];
		int suma=0; 
		float media;
		
		for (int i = 0; i<array.length; i++) {
			array[i]= (int) Math.round(Math.random()*10);
		}
		
		int  mayor=array[0], menor=array[0];
		
		for (int i = 0; i<array.length; i++) {
			System.out.println("Numero[" + i + "]: " + array[i]);
		}
		
		for (int i = 0; i<array.length; i++) {
			suma=suma+array[i];
			if (array[i]>mayor) {
				mayor=array[i];
			}
			if (array[i]<menor) {
				menor=array[i];
			}
		}
		
		media=((float) suma / array.length);
		
		System.out.println("Suma: "+suma);
		System.out.println("Media: "+media);
		System.out.println("Mayor: "+mayor);
		System.out.println("Menor: "+menor);
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
			System.out.println("Numero[" + i + "]: " + array[i]);
		}
		
		System.out.println("Límite superior: "+max);
		System.out.println("Límite inferior: "+min);
		
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
			else {
				System.out.println("El numero que ha introducido no ha sido encontrado");
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
	
	/* BLOQUE 02: Ejercicio 1: Realiza un ejercicio que inicialice un array de 150 elementos enteros al azar 
	 * entre -100 y 100. Debes conseguir que todos los números pares del array cambien de signo, los positivos
	 * deben pasar a negativos y viceversa. 
	 */
	
	public static void ArrayB2Ej1() {
		int array[]= new int [150];
		
		for (int i = 0; i<array.length; i++) {
			array[i]= (int) Math.round(Math.random()*200)-100;
			System.out.println("Numero[" + i + "]: " + array[i]);
			array[i]=array[i]*-1;
			System.out.println("Numero[" + i + "]: " + array[i]);
		}
	}
	
	/* Ejercicio 2: Realiza un ejercicio que inicialice dos arrays de 150 elementos enteros al azar 
	 * entre 0 y 100. Debes crear un tercer array, compuesto de la siguiente forma: en los elementos de
	 * índice impar del tercer array debes copiar los elementos de índice impar del primer array; en los
	 * elementos de índice par del tercer array debes copiar los elementos de índice par del segundo array.
	 */
	
	public static void ArrayB2Ej2() {
		int array1[]= new int [150];
		int array2[]= new int [150];
		int array3[]= new int [150];
		
		System.out.println("ARRAY NUMERO 1\n");
		for (int i = 0; i<array1.length; i++) {
			array1[i]= (int) Math.round(Math.random()*100);
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
		for (int i = 0; i<array3.length; i++) {
			array3[i]= (int) Math.round(Math.random()*100);	
			if (i%2==0) { //es par
				array3[i]=array1[i];
			}
			else {
				array3[i]=array2[i];
			}
			System.out.print("["+i+"]" + " ");
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
		
		System.out.println("ARRAY NUMERO 1\n");
		for (int i = 0; i<array.length; i++) {
			array[i]= (int) Math.round(Math.random()*100);
			System.out.print("["+i+"]" + " ");
			System.out.print(array[i] + " ");
		}
		
		for (int i = 0; i<array.length; i++) {
			array[i]= (int) Math.round(Math.random()*100);

		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
