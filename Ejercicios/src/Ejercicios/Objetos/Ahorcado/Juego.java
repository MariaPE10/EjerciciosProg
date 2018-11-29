package Ejercicios.Objetos.Ahorcado;

import javax.swing.JOptionPane;

public class Juego {
	//Array de palabras posibles
	private static String palabras[] = new String[] {"cosplay", "jaula", "olas", "articulacion", "negativo", "inflacion", "barro", "ahri", "akali", "zinogre"};
	//Genera un numero aleatorio que sera mi palabra aleatoria
	private static int indicePalabraAleatoria = (int) Math.round(Math.random()*(palabras.length-1));
	//Creacion de un array con la longitud de nuestra palabra aleatoria
	private static String palabraAleatoria = palabras[indicePalabraAleatoria];
	private static String coincidencias[]= new String [palabraAleatoria.length()];
	private static int fallosUsuario = 0;
	private static int fallosMaximos = 10;
	private static Juego juego = null;
	
	/**
	 * 
	 */
	public Juego () {
		super();
	}
	
	/**
	 * 
	 * @return
	 */
	public static Juego getJuego() {
		if(juego == null) {
			juego = new Juego();
		}
		return juego;
	}
	
	/**
	 * @return the fallosUsuario
	 */
	public static int getFallosUsuario() {
		return fallosUsuario;
	}
	/**
	 * @param fallosUsuario the fallosUsuario to set
	 */
	public static void setFallosUsuario(int fallosUsuario) {
		Juego.fallosUsuario = fallosUsuario;
	}

	/**
	 * 
	 */
	public static void empezar () {
		//Creacion de un array auxiliar para mostrar los fallos del usuario
		String auxFallos[]= new String [fallosMaximos];
		
		//Inicializacion del array de nuestra palabra oculta
		inicializaEImprimePalabra(coincidencias);
		//Inicializacion e impresion del array auxiliar de fallos
		inicializaAux(auxFallos);
		
		String palabraUsuario = "";
		
		do {
			//Pide al usuario la palabra o letra
			palabraUsuario = JOptionPane.showInputDialog(null, "Introduzca la letra o palabra buscada");
			if (palabraUsuario.equals(palabraAleatoria)) {
				System.out.println("\n\t\t\tFELICIDADES!! La palabra ocultas era: " + palabraAleatoria);
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
				imprimeArray(coincidencias);
				
				System.out.print("\nFallos: ");
				imprimeArray(auxFallos);
			}
			
		} while (!(fallosUsuario>=fallosMaximos || isTerminado(coincidencias) || palabraUsuario.equals(palabraAleatoria)));
		
		if (fallosUsuario>=fallosMaximos) {
			System.out.println("\n\t\t\tLASTIMA TE HAS MUERTO!! La palabra ocultas era: " + palabraAleatoria);
		} else if (isTerminado(coincidencias)){
			System.out.println("\n\t\t\tFELICIDADES!! La palabra ocultas era: " + palabraAleatoria);
		}
		
	}
	
	/**
	 * 
	 * @param array
	 */
	private static void imprimeArray (String array[]) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
	/**
	 * 
	 * @param coincidencias
	 */
	private static void inicializaEImprimePalabra(String coincidencias[]) {
		 for (int i = 0; i < coincidencias.length; i++) {
				coincidencias[i] = "_";
				System.out.print(coincidencias[i] + " ");
			}
	}
	
	/**
	 * 
	 * @param auxFallos
	 */
	private static void inicializaAux (String auxFallos[]) {
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
