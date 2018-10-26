package Examenes;
public class ApartadoE {

	/*Crea una clase con un método “main” que cree un array de 20 posiciones 
	 * de valores enteros. Los valores enteros deben generarse al azar entre 
	 * los valores 0 y 40 y no pueden repetirse. Muestra el array.
	 */
	public static void main(String[] args) {
		apartadoE();
	}
	
	public static void apartadoE() {	
		int longitud =20;
		int array[]= new int [longitud];
		int num;
		boolean encontrado = false;
		
		//Generacion del array con las condiciones pedidas
		for (int i = 0; i < array.length; i++) {
			
			//genera un numero
			do {
				encontrado = false;
				num = (int) (Math.random() * 40); //Genera un numero entre 0 y 40
				for (int j = 0; j < i; j++) {
					if(array[j] == num) { //Comprueba que el numero no se encuentra repetido
						encontrado = true;
					}
				}
			} while (encontrado); //Condicion para salir del bucle, "encontrado" debe ser false.
			
			array[i] = num; //Da valor a la posicion del array en i
			System.out.print("["+i+"]" + " "); //Imprime el array
			System.out.print(array[i] + " "); //Imprime el array
		}
	}
}
