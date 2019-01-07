package ejercicios.objetos.bloque1;

import javax.swing.JOptionPane;

/* Ejercicio 9:  Realiza un método que reciba tres valores enteros como argumentos de entrada,
 * debe imprimir dichos valores en orden. Debes crear un método para mostrar los números en orden
 * ascendente y otro para mostrarlos en orden descendente.
 */
public class OrdenaTresValores {

	public static void main(String[] args) {
		int primerNumero = pideNumeroEntero("Introduzca el primer numero");
		int segundoNumero = pideNumeroEntero("Introduzca el segundo numero");
		int tercerNumero = pideNumeroEntero("Introduzca el tercer numero");
		
		ordenaTresNumerosAscendente(primerNumero, segundoNumero, tercerNumero);
		ordenaTresNumerosDescendente(primerNumero, segundoNumero, tercerNumero);
	}
	
	/**
	 * Ordena tres numeros de mayor a menor (descendente).
	 * @param primero Primer numero dado por el usuario
	 * @param segundo Segundo numero dado por el usuario
	 * @param tercero Tercer numero dado por el usuario
	 */
	public static void ordenaTresNumerosDescendente (int primero, int segundo, int tercero) {
		int mayor = primero, menor =primero, intermedio = primero;
		
		if (primero > segundo && primero > tercero) {
			mayor = primero;
		} else if (primero < segundo && primero < tercero){
			menor = primero;
		} else {
			intermedio = primero;
		}
		if (segundo > primero && segundo > tercero) {
			mayor = segundo;
		} else if (segundo < primero && segundo < tercero){
			menor = segundo;
		} else {
			intermedio = segundo;
		}
		if (tercero > primero && tercero > segundo) {
			mayor = tercero;
		} else if (tercero < primero && tercero < segundo){
			menor = tercero;
		} else {
			intermedio = tercero;
		}
		
		System.out.println("Numeros ordenados de forma descendente: " + mayor + ", " + intermedio + ", " + menor);
	}
	
	/**
	 * Ordena tres numeros de menor a mayor (ascendente).
	 * @param primero Primer numero dado por el usuario
	 * @param segundo Segundo numero dado por el usuario
	 * @param tercero Tercer numero dado por el usuario
	 */
	public static void ordenaTresNumerosAscendente (int primero, int segundo, int tercero) {
		int mayor = primero, menor =primero, intermedio = primero;
		
		if (primero > segundo && primero > tercero) {
			mayor = primero;
		} else if (primero < segundo && primero < tercero){
			menor = primero;
		} else {
			intermedio = primero;
		}
		if (segundo > primero && segundo > tercero) {
			mayor = segundo;
		} else if (segundo < primero && segundo < tercero){
			menor = segundo;
		} else {
			intermedio = segundo;
		}
		if (tercero > primero && tercero > segundo) {
			mayor = tercero;
		} else if (tercero < primero && tercero < segundo){
			menor = tercero;
		} else {
			intermedio = tercero;
		}
		
		System.out.println("Numeros ordenados de forma ascendente: " + menor + ", " + intermedio + ", " + mayor);
	}
	
	
	/**
	 * Pide un numero entero al usuario, con un mensaje.
	 * @param mensaje
	 * @return devuelve un numero entero pedido al usuario.
	 */
	public static int pideNumeroEntero(String mensaje) {
		int num;
		
		num = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
		
		return num;
	}
}
