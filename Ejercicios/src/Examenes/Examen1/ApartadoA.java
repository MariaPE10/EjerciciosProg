package Examenes.Examen1;


public class ApartadoA {
 /* Crea una clase con un método “main” que cree un array con 100 elementos de 
  * longitud, los elementos deben ser números enteros al azar comprendidos entre 0 y 1000.
  * Muestra el array en pantalla. Calcula la suma de todos los elementos, la media, el máximo y el
  * mínimo.
  */
	public static void main(String[] args) {
		apartadoA();
	}

	public static void apartadoA() {
		int array[] = new int [100];
		int suma = 0, mayor, menor; 
		float media;
		
		//Generacion del array de 100 elementos, con numeros enteros entre 0 y 1000 y lo muestra en pantalla.
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random()*1000);
			System.out.println("Numero[" + i + "]: " + array[i]);
		}
		
		//Damos valores a las variables mayor, menor y suma al valor del array[0].
		mayor = array[0];
		menor = array[0];
		suma = array[0];
		
	   /* Comenzamos a buscar mayor y menor, y a sumar los valores dentro del array.
		* Inicializamos la "i" en 1 porque ya hemos tenido en cuenta el valor del array[0] a la hora de
		* dar valor a nuestras variables. 
		*/
		for (int i = 1; i<array.length; i++) {
			suma+=array[i];
			if (array[i] > mayor) { //Buscamos el numero mayor del array
				mayor = array[i];
			}
			if (array[i] < menor) { //Buscamos el numero menor del array
				menor = array[i];
			}
		}
		
		// Calculo de la media, que sera un numero flota.
		media=((float) suma / array.length);
		
		//Impresion de los resultados en pantalla.
		System.out.println("Suma: " + suma);
		System.out.println("Media: " + media);
		System.out.println("Mayor: " + mayor);
		System.out.println("Menor: " + menor);
	}
}
