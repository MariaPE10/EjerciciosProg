package ejercicios.objetos.bloque4.arrays;


public class ArrayUtils {

	/**
	 * Crea un array
	 * @param longitud
	 * @param minimo
	 * @param maximo
	 * @return
	 */
	public static int[] creaArray(int longitud, int minimo, int maximo) {
		int array[] = new int[longitud];
		
		for (int i = 0; i < array.length; i++) {
			array[i]= (int)Math.round(Math.random()* (maximo-minimo) +  minimo);
		}
		
		return array;
	}
	
	/**
	 * Metodo que recibe un array y lo imprime.
	 * @param array
	 */
	public static void imprimeArray(int array[]) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "  ");
		}
	}
}
