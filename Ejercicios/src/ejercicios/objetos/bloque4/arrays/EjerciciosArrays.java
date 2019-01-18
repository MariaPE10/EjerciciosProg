package ejercicios.objetos.bloque4.arrays;

import javax.swing.JOptionPane;

public class EjerciciosArrays {

	public static void main(String[] args) {
		//Ejercicio 1
		int array[]= creaArray();
		imprimeArray(array);
		System.out.println();
		System.out.println( "Valor central: " + getValorCentral(array));
	
		//Ejercicio2
//		int array2[]= creaArray21();
//		imprimeArray(array2);
//		calculaPorcentajeAprobados(array2);
		
		//Ejercicio3
//		float array3[]= creaArray20();
		
	}
	
	
	/**
	 * Crea un Metodo que reciba un array de números enteros creados al azar entre 0 y 100.
	 * @return
	 */
	private static int[] creaArray() {
		int array[] = new int[Integer.parseInt(JOptionPane.showInputDialog("Introduzca el tamaño del array"))];
		
		for (int i = 0; i < array.length; i++) {
			array[i]= (int)Math.round(Math.random()*100);
		}
		
		return array;
	}
	
	/**
	 * Metodo que recibe un array y lo imprime.
	 * @param array
	 */
	private static void imprimeArray(int array[]) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "  ");
		}
	}
	
	/**
	 * El metodo debe examinar la longitud del array, comprobar que la longitud es un valor
	 * impar y devolver el valor que se encuentre en la posición media. En caso de que la longitud del
	 * array sea un número par se debe devolver un valor -1.
	 * @param array
	 * @return
	 */
	private static int getValorCentral (int array[]) {
		int valorCentral;
		if(array.length%2==0){ //Es par
			return -1;
		} else { //Es impar
			int indice = Math.round(array.length/2);
			valorCentral = array[indice];
		}
		return valorCentral;
	}
	
	/**
	 * Crea un array de 21 numeros enteros generados al azar entre 0 y 10.
	 * @return
	 */
	private static int[] creaArray21() {
		int array[] = new int[21];
		
		for (int i = 0; i < array.length; i++) {
			array[i]= (int)Math.round(Math.random()*10);
		}
		
		return array;
	}
	
	/**
	 * Analiza el array y calcula el porcentaje (con decimales) de notas aprobadas ( >= 5 )
	 * y de notas suspensas
	 * @return
	 */
	private static void calculaPorcentajeAprobados(int array[]) {
		float mediaAprobados = 0f;
		float mediaSuspensos = 0f;
		int contAprobados = 0, contSuspensos = 0;
		
		for (int i = 0; i < array.length; i++) {
			if(array[i] >= 5) { //aprobados
				contAprobados++;
			} else { //suspensos
				contSuspensos++;
				
			}
		}
	
		mediaAprobados = (float) contAprobados * 100 / ((float) array.length);
		mediaSuspensos = (float) contSuspensos/array.length;
		System.out.println();
		System.out.println("El porcentaje de aprobados es: " + mediaAprobados + "%");
		System.out.println("El porcentaje de aprobados es: " + mediaSuspensos*100 + "%");
	}
	
	/**
	 * Crea un array de 20 numeros enteros generados al azar entre 0 y 100. Para crear el número
	 * decimal debes generar al azar la parte entera y la parte decimal por separado para después
	 * unir las dos partes. A continuación debes examinar la cantidad de números cuya parte decimal
	 * está comprendida entre .00 y .49
	 * @return
	 */
	private static float[] creaArray20() {
		float array[] = new float[20];
		int contador = 0;
		
		for (int i = 0; i < array.length; i++) {
			int entero = (int)Math.round(Math.random()*100);
			float decimal = (float) Math.random();
			array[i] = entero + decimal;
			System.out.print(array[i] + "  ");
			if(decimal < 0.5) {
				contador++;
			}
		}
		
		System.out.println();
		System.out.println("Hay " + contador + " numeros cuya parte decimal esta entre .00 y .49");
		return array;
	}

}
