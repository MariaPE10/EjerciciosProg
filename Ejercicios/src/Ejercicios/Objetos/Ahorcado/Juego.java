package Ejercicios.Objetos.Ahorcado;

import javax.swing.JOptionPane;

public class Juego {
	
	public static void Empezar (String coincidencias[], String palabraAleatoria) {
		//Creacion de un array auxiliar para mostrar los fallos del usuario
		int fallosMaximos = 10;
		String auxFallos[]= new String [fallosMaximos];
		
		//Inicializacion del array de nuestra palabra oculta
		InicializaEImprimePalabra(coincidencias);
		//Inicializacion e impresion del array auxiliar de fallos
		InicializaAux(auxFallos);
		
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
				ImprimeArray(coincidencias);
				
				System.out.print("\nFallos: ");
				ImprimeArray(auxFallos);
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
	 * @param array
	 */
	private static void ImprimeArray (String array[]) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
	/**
	 * 
	 * @param coincidencias
	 */
	private static void InicializaEImprimePalabra(String coincidencias[]) {
		 for (int i = 0; i < coincidencias.length; i++) {
				coincidencias[i] = "_";
				System.out.print(coincidencias[i] + " ");
			}
	}
	
	/**
	 * 
	 * @param auxFallos
	 */
	private static void InicializaAux (String auxFallos[]) {
		System.out.println();
		for (int i = 0; i < auxFallos.length; i++) {
			auxFallos[i] = "-";
		}
	}
	
	/**
	 * 
	 * @param coincidencias
	 * @return
	 */
	private static boolean isTerminado( String coincidencias[]) {
		for (int i = 0; i < coincidencias.length; i++) {
			if (coincidencias[i] == "_") {
				return false;
			}
		}
		return true;
	}
}
