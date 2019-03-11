package ejercicios.capitulo6.bloque3;

import javax.swing.JOptionPane;
/* Ejercicio 1: Realizar un programa que imprima una tabla con los límites máximo y mínimo representables para 
 * los diferentes tipos primitivos en Java (byte, int, short, long, float, double). En la tabla 
 * también deberá aparecer el número de bytes que cada tipo usa para su representación.
 */

/* Ejercicio 2: Crear un programa que pida al usuario una contraseña con los siguientes requisitos:
         - Al menos una mayúscula.
         - Al menos una minúscula.
         - Al menos un dígito
         - Al menos un carácter no alfanumérico.
    El programa no terminará hasta que el usuario no introduzca la contraseña con estos requisitos.*/

public class Contrasenia {

	/**
	 * Ejercicio 1
	 */
	public static void imprimePrimitivos () {
		System.out.println("Valor maximo para un Integer: " + Integer.MAX_VALUE);
		System.out.println("Valor minimo para un Integer: " + Integer.MIN_VALUE);
		System.out.println("Tamanio en bits complemento a 2 para Integer: " + Integer.SIZE);
		// Wrapper para el tipo de datos "long"
		System.out.println("\nValor maximo para un Long: " + Long.MAX_VALUE);
		System.out.println("Valor minimo para un Long: " + Long.MIN_VALUE);
		System.out.println("Tamanio en bits complemento a 2 para Long: " + Long.SIZE);
		// Wrapper para el tipo de datos "short"
		System.out.println("\nValor maximo para un Short: " + Short.MAX_VALUE);
		System.out.println("Valor minimo para un Short: " + Short.MIN_VALUE);
		System.out.println("Tamanio en bits complemento a 2 para Short: " + Short.SIZE);
		// Wrapper para el tipo de datos "float"
		System.out.println("\nValor maximo para un Float: " + Float.MAX_VALUE);
		System.out.println("Valor minimo para un Float: " + Float.MIN_VALUE);
		System.out.println("Tamanio en bits complemento a 2 para Float: " + Float.SIZE);
		// Wrapper para el tipo de datos "double"
		System.out.println("\nValor maximo para un Double: " + Double.MAX_VALUE);
		System.out.println("Valor minimo para un Double: " + Double.MIN_VALUE);
		System.out.println("Tamanio en bits complemento a 2 para Double: " + Double.SIZE);
		// Wrapper para el tipo de datos "byte"
		System.out.println("\nValor maximo para un Byte: " + Byte.MAX_VALUE);
		System.out.println("Valor minimo para un Byte: " + Byte.MIN_VALUE);
		System.out.println("Tamanio en bits complemento a 2 para Byte: " + Byte.SIZE);
	}
	
	/**
	 * Ejercicio 2
	 */
	public static void pedirContrasenia() {
		boolean mayus, minus, digito, noAlpha;
		do {
			mayus=false;
			minus=false;
			digito=false;
			noAlpha=false;
			String passUsuario = JOptionPane.showInputDialog("Introduzca una contraseña que cumpla los siguientes requisitos:"
					+ "\n - Al menos una mayúscula."
					+ "\n - Al menos una minúscula."
					+ "\n - Al menos un dígito."
					+ "\n - Al menos un carácter no alfanumérico.");
			
			char cadenaTexto[] = passUsuario.toCharArray();
			for (int i = 0; i < cadenaTexto.length; i++) {
				if (Character.isDigit(cadenaTexto[i])) {
					digito = true;
				}
				if (Character.isLowerCase(cadenaTexto[i])) {
					minus=true;
				}
				if (Character.isUpperCase(cadenaTexto[i])){
					mayus = true;
				}
				if (!Character.isLetterOrDigit(cadenaTexto[i])) {
					noAlpha=true;
				}
			}
		}while (!(mayus && minus && digito && noAlpha));
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		imprimePrimitivos();
		pedirContrasenia();
	}
}
