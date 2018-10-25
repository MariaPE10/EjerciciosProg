
public class ApartadoD {
	/* Crea una clase con un método “main” que cree un array de 5 posiciones con
	 * números generados al azar entre 0 y 100. Muestra el array. Crea un nuevo array de 5 
	 * posiciones en el que copies los números del primer array en posiciones aleatorias del 
	 * segundo array. No puedes repetir números del primer array en el segundo array.
	 */
	
	public static void main(String[] args) {
		apartadoD();
	}

	public static void apartadoD() {	
		int longitud =5;
		int array1[]= new int [longitud];
		int array2[]= new int [longitud];
		boolean vacio = true;
		int posicion;
		
		//Genera el array1 y lo imprime
		System.out.println("ARRAY NUMERO 1\n");
		for (int i = 0; i < array1.length; i++) {
			array1[i] = (int) Math.round(Math.random()*100);
			System.out.print("["+i+"]" + " ");
			System.out.print(array1[i] + " ");
		}
		//Genera el array2
		System.out.println("\nARRAY NUMERO 2\n");
		for (int i = 0; i < array2.length; i++) {
			do {
				vacio = true;
				posicion = (int) (Math.random() * 4); //Genera un numero entre 0 y 4
				for (int j = 0; j < i; j++) {
					if(array2[j] == posicion ) { //Comprueba que la posicion esta vacia
						vacio = false;
					}
				}
			} while (!vacio); //Condicion para salir del bucle, "vacio" debe ser true.
				
			array2[i] = array1[posicion];
			System.out.print("["+i+"]" + " ");
			System.out.print(array2[i] + " ");
		}

	}
}
