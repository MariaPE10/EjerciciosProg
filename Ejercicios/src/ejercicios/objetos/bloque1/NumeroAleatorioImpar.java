package ejercicios.objetos.bloque1;

	/* Ejercicio 6: Desarrollar un método que devuelva un número entero aleatorio, impar y 
	 * comprendido entre 11 y 23. "main" debe llamar a esa función y debe imprimir el valor devuelto.
	 */
public class NumeroAleatorioImpar {

	public static void main(String[] args) {
		System.out.println("El numero aleatorio impar es: " + numeroAleatorioImparEntreDosValores());
	}
	/**
	 * Devuelve un numero impar entre dos valores.
	 * @return Un numero entero, impar y entre 11 y 23
	 */
	public static int numeroAleatorioImparEntreDosValores () {
		int numeroAleatorio;
		do {
			
			numeroAleatorio = ((int) Math.round(Math.random() * (23-11))) + 11;
			
		} while (numeroAleatorio%2==0);
		return numeroAleatorio;
	}
}
