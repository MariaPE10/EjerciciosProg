package ejercicios.objetos.bloque1;

import javax.swing.JOptionPane;

/* Ejercicio 3: Realliza un método que pida al usuario dos valores. A continuación 
  * se deben enviar a otra función, creada por ti, que devuelva el mayor valor de los dos introducidos.
  */
public class Mayor2Numeros {

	//Pide un numero entero 
	public static int pideNumeroEntero() {
		int num;
		
		num = Integer.parseInt(JOptionPane.showInputDialog("Introduzca numero entero"));
		
		return num;
	}
	
	//Averigua el mayor de 2 numeros
	public static int obtenerMayor2Numeros (int num1, int num2) {
		int mayor = num1;
		
		if (num1 > num2) {
			mayor = num1;
		} else 
			if (num2 > num1){
			mayor = num2;
		} else {
			System.out.println("Los numeros son iguales");
		}
		
		return mayor; 
	}
	
	public static void main(String[] args) {
		int numeroPedido1 = pideNumeroEntero();
		int numeroPedido2 = pideNumeroEntero();
		int mayor = obtenerMayor2Numeros(numeroPedido1, numeroPedido2);
	
		
		System.out.println("Los numeros introducidos son: " + numeroPedido1 + " y "+ numeroPedido2);
		System.out.println("El numero mayor es: " + mayor);
	}
}
