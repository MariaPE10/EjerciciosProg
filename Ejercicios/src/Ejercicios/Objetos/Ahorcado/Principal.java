package Ejercicios.Objetos.Ahorcado;

import javax.swing.JOptionPane;

public class Principal { 

	public static void main(String[] args) {
		
		//Array de palabras posibles
		String palabras[] = new String[] {"cosplay", "jaula", "olas", "articulacion", "negativo", "inflacion", "barro"};
		
		//Genera un numero aleatorio que sera mi palabra aleatoria
		int indicePalabraAleatoria = (int) Math.round(Math.random()*(palabras.length-1));
		
		System.out.println("Palabra oculta: " + palabras[indicePalabraAleatoria]);
		//Creacion de un array con la longitud de nuestra palabra aleatoria
		String palabraAleatoria = palabras[indicePalabraAleatoria];
		String coincidencias[]= new String [palabraAleatoria.length()];
		//Creacion de un array auxiliar para mostrar los fallos del usuario
		int fallosMaximos = 10;
		String auxFallos[]= new String [fallosMaximos];
		
		//Inicializacion del array de nuestra palabra oculta
		for (int i = 0; i < coincidencias.length; i++) {
			coincidencias[i] = "_";
			System.out.print(coincidencias[i] + " ");
		}
		
		//Inicializacion e impresion del array auxiliar de fallos
		System.out.println();
		for (int i = 0; i < auxFallos.length; i++) {
			auxFallos[i] = "-";
		}
		String palabraUsuario = "";
		int fallosUsuario = 0;
		do {
			//Pide al usuario la palabra o letra
			palabraUsuario = String.valueOf(JOptionPane.showInputDialog(null, "Introduzca la letra o palabra buscada"));
			if (palabraUsuario.equals(palabraAleatoria)) {
				System.out.println("\nFELICIDADES!! La palabra ocultas era: " + palabraAleatoria);
			} else {
				boolean encontrado = false;
				if (palabraUsuario.length() == 1) {
					char charUsuario = palabraUsuario.charAt(0);
					for (int i = 0; i < coincidencias.length; i++) {
						if (palabraAleatoria.charAt(i) == charUsuario) {
							coincidencias[i] = palabraUsuario;
							encontrado = true;
						}
					}
				}if (!encontrado && !(palabraUsuario.equals(palabraAleatoria))) {
					fallosUsuario++;
					System.out.println();
					System.out.println(palabraUsuario + " no esta en la palabra buscada");
					for (int i = 0; i < auxFallos.length; i++) {
						if (auxFallos[i] == "-") {
							auxFallos[i] = palabraUsuario;
							break;
						}
					}
				}
				// Impresion de los arrays despues de cada jugada
				System.out.println();
				for (int i = 0; i < coincidencias.length; i++) {
					System.out.print(coincidencias[i] + " ");
				}
				System.out.print("\nFallos: ");
				for (int i = 0; i < auxFallos.length; i++) {
					System.out.print(auxFallos[i] + " ");
				}
			}
			
		} while (!(fallosUsuario>=fallosMaximos || isTerminado(coincidencias) || palabraUsuario.equals(palabraAleatoria)));
		
		if (fallosUsuario>=fallosMaximos) {
			System.out.println("\nLASTIMA TE HAS MUERTO!! La palabra ocultas era: " + palabraAleatoria);
		} else if (isTerminado(coincidencias)){
			System.out.println("\nFELICIDADES!! La palabra ocultas era: " + palabraAleatoria);
		}
	
	}

	/**
	 * 
	 * @param coincidencias
	 * @return
	 */
	public static boolean isTerminado( String coincidencias[]) {
		for (int i = 0; i < coincidencias.length; i++) {
			if (coincidencias[i] == "_") {
				return false;
			}
		}
		return true;
	}
	
}
