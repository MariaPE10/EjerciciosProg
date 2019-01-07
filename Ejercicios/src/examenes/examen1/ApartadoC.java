package examenes.examen1;

public class ApartadoC {
	/* Crea una clase con un mÃ©todo â€œmainâ€� que cree un array de 20 posiciones al azar
	 * con nÃºmeros generados al azar, pares, mayores de 25 y menores de 100.
	 */
	
	public static void main(String[] args) {
		apartadoC();
	}

	public static void apartadoC() {	
		int array[] = new int [20];
		int num;
		//Genera un array
		for (int i = 0; i < array.length; i++) {
			// Genera un numero que es par y estÃ¡ entre 25 y 100.
			do {
				num = (int) (Math.random() * 100);
			} while (num%2==1 || num < 25 || num > 100); 
			array[i] = num; //Da valor a la posicion del array en i
			System.out.print("["+i+"]" + " "); //Imprime el array
			System.out.print(array[i] + " "); //Imprime el array
		}
	}
}
