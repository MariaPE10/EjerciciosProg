package examenes;

import javax.swing.JOptionPane;

public class RepasoArrays {

	public static void main(String[] args) {
		Ejercicio04();
	}
	
	/* Ejercicio 1: Realiza un programa que sume los valores de un array. El array se rellenara con valores aleatorios entre el 1 y el 25.
	 * La longitud vendra dada por el usuario.
	 */
	public static void Ejercicio01 () {
		int longitudArray, suma= 0;
		int max=25, min=1;
		longitudArray = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la longitud del array"));
		int array[] = new int [longitudArray];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random()*(max-min))+min;
			System.out.println("Numero[" + i + "]: " + array[i]);
			suma += array[i];
		}
		System.out.println("La suma es: " + suma);
	}
	
	// Ejercicio 2: Realiza un ejercicio igual al anterior pero que en lugar de sumarlos todos, sume solo los valores pares.
	
	public static void Ejercicio02 () {
		int longitudArray, suma= 0;
		int max=25, min=1;
		longitudArray = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la longitud del array"));
		int array[] = new int [longitudArray];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random()*(max-min))+min;
			System.out.println("Numero[" + i + "]: " + array[i]);
			if (array[i] % 2 == 0) { // Es par
				suma += array[i];
			}
		}
		System.out.println("La suma es: " + suma);
	}
	
	// Ejercicio 3: Realiza la media de todos los valores del array.
	
	public static void Ejercicio03 () {
		int longitudArray, suma = 0;
		int max = 25, min = 1;
		float media = 0;
		longitudArray = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la longitud del array"));
		int array[] = new int [longitudArray];
		
		for (int i = 0; i < array.length; i++) { //En este caso array.length tiene el mismo valor que longitudArray por lo que la media se puede calcular con ambos
			array[i] = (int) Math.round(Math.random()*(max-min))+min;
			System.out.println("Numero[" + i + "]: " + array[i]);
			suma += array[i];
		}
		media = (float) suma/array.length;
		// media = (float) suma/longitudArray;
		System.out.println("La suma es: " + suma);
		System.out.println("La media es: " + media);
	}
	
	// Ejercicio 4: Encuentra los valores duplicados en el array.
	
	public static void Ejercicio04 () {
		int longitudArray;
		int max=25, min=1;
		longitudArray = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la longitud del array"));
		int array[] = new int [longitudArray];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random()*(max-min))+min;
			if(i==0) {
				System.out.print(array[i]);
			} else {
				System.out.print(", " + array[i]);
			}
			
		}
		
		//meter un salto de l�nea
		System.out.println();
		
		// ejemplo declarar valores al inicializar el array int auxiliar[] = {1,2,3,4}; 
		int auxiliar[] = new int[longitudArray];
		int posicionEnArrayAuxiliar = 0;
		
		for (int i = 0; i < array.length; i++) {
			for(int j = 0; j < array.length; j++) {
				if(j!=i && array[i] == array[j]) {					
					boolean encontradoEnAuxiliar = encontrarValor(array[i],auxiliar);										
					if(!encontradoEnAuxiliar) {
						auxiliar[posicionEnArrayAuxiliar] = array[i];
						posicionEnArrayAuxiliar++;
					}											
				}
			}
		}
		
		for (int w = 0; w < posicionEnArrayAuxiliar; w++) {
			System.out.println(auxiliar[w] + " se repite" );
		}
	}
	
	private static boolean encontrarValor(int valor, int[] array) {
		boolean encontrado = false;
		
		for (int j2 = 0; j2 < array.length; j2++) {
			if(array[j2] == valor) {
				encontrado = true;
			}
		}	
		return encontrado;
	}
	
	// Ejercicio 5: Encuentra el minimo y el m�ximo valor en un array aleatorio como el primero.
	
	public static void Ejercicio05 () {
		int longitudArray, menor, mayor;
		int max=25, min=1;
		longitudArray = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la longitud del array"));
		int array[] = new int [longitudArray];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random()*(max-min))+min;
			System.out.println("Numero[" + i + "]: " + array[i]);
		}
		
		mayor = array[0];
		menor = array[0];
		
		for (int i = 1; i < array.length; i++) {
			if (array[i] > mayor) {
				mayor = array[i];
			}
			if (array[i] < menor) {
				menor = array[i];
			}
		}
		
		System.out.println("El mayor es: " + mayor);
		System.out.println("El menor es: " + menor);
	}
	
	// Ejercicio 6: Encuentra el segundo menor valor y el segundo mayor valor en un array aleatorio. 
	//############################################ .....................NO FUNCIONA............................################################################
	
	public static void Ejercicio06 () {
		int longitudArray, menor, mayor, segundoMenor, segundoMayor;
		int max=25, min=1;
		longitudArray = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la longitud del array"));
		int array[] = new int [longitudArray];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random()*(max-min))+min;
			System.out.println("Numero[" + i + "]: " + array[i]);
		}
		
		mayor = array[0];
		menor = array[0];
		segundoMayor = array[0];
		segundoMenor = array[0];
		
		for (int i = 1; i < array.length; i++) {
			
		}
		
		System.out.println("El segundo mayor es: " + segundoMayor);
		System.out.println("El segundo menor es: " + segundoMenor);
	}
	
	// Ejercicio 7: Realiza un programa que inicialmente cree un array con valores aleatorios comprendidos entre el 1 y el 3 incluidos, de tama�o 10.
	//Tras mostrarlo por pantalla, adelanta el array tantas veces como indique el elemento en la posici�n 8 (0 a 9).
	
	
	// Ejercicio 8: Realiza un programa que compruebe si dos arrays contienen los mismos valores aunque est�n desordenados 
	// [1,4,3,6,8] > [2,3,8,4,1]
	// [2,5,4,1] > [5,4,2,1]
}
