package ejercicios.capitulo6.exception.ejercicio1;

import java.util.Scanner;

public class PeticionNumero {

	public static int pedirNumeroPar() throws NumeroImparException {
		Scanner sc = new Scanner(System.in);
		
		int numUsuario = sc.nextInt();
		
		if (numUsuario%2 == 1) { //Es impar
			throw new NumeroImparException();
		}
		
		return numUsuario;
	}
	
	public static void main(String[] args) {
		System.out.println("Introduzc numero: ");
		try {
			int num = pedirNumeroPar();
			System.out.println("Numero par del usuario: " + num);
			
		} catch (NumeroImparException e) {
			System.out.println("Numero impar introducido");
		}
		
	}
}
