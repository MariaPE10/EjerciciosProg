package Ejercicios.Objetos.Bloque3;

public class Primitiva {

	private int arrayNumeros[] = new int[7];
	
	public static void main(String[] args) {

		Primitiva prim = new Primitiva();
		prim.generaCombinacion();
	}
	
	public void generaCombinacion() {
		
		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < arrayNumeros.length; i++) {
				if (i < arrayNumeros.length-1) {
					arrayNumeros[i] = (int) Math.round(Math.random() * (49-1)) + 1;
				} else {
					arrayNumeros[i] = (int) Math.round(Math.random() * (9-1)) + 1;
				}
				System.out.print( arrayNumeros[i] + " ");
			}
			System.out.println();
		}
	}

}
