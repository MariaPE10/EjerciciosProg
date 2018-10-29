package Ejercicios.Objetos.Bloque1;
/* Ejercicio 7: Realiza un método que muestre en pantalla los números del 1 al 100.
 * El único requisito para esto es que debe hacerse utilizando la recursividad.
 */
public class Numeros1a100Recursividad {

	public static void main(String[] args) {
		recursividadNumeros1a100(1);

	}
	/**
	 * Muestra los numeros del 1 al 100 haciendo uso de la recursividad de un metodo.
	 * Dentro del metodo, vuelve a llamarse a si mismo hasta que se cumple la condicion de salida.
	 * Es muy importante poner la condicion de salida ya que sino se generaria un bucle infinito que 
	 * terminaria en un "StackOverFlow", se supera la capacidad de memoria asignada para dicho metodo.
	 * @param primerNumero Primer numero de la serie, en este caso 1 por defecto.
	 */
	public static void recursividadNumeros1a100 (int primerNumero) {
		System.out.print(primerNumero + " ");
		if (primerNumero < 100) {
			recursividadNumeros1a100(primerNumero+1);
		}
	}
}
