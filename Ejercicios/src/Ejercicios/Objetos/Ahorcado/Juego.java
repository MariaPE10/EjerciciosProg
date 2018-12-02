package Ejercicios.Objetos.Ahorcado;

import javax.swing.JOptionPane;

public class Juego {
	//Array de palabras posibles
	private String palabras[] = new String[] {"cosplay", "jaula", "olas", "articulacion", "negativo", "inflacion", "barro", "ahri", "akali", "zinogre"};
	//Genera un numero aleatorio que sera mi palabra aleatoria
	private int indicePalabraAleatoria = (int) Math.round(Math.random()*(palabras.length-1));
	//Creacion de un array con la longitud de nuestra palabra aleatoria
	private String palabraAleatoria = palabras[indicePalabraAleatoria];
	private String coincidencias[]= new String [palabraAleatoria.length()];
	private int fallosUsuario = 0;
	private int fallosMaximos = 10;
	private static Juego juego = null;
	//Creacion de un array auxiliar para mostrar los fallos del usuario
	private String auxFallos[]= new String [fallosMaximos];
	
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
	public int getFallosUsuario() {
		return fallosUsuario;
	}

	/**
	 * @return the auxFallos
	 */
	public String[] getAuxFallos() {
		return auxFallos;
	}

	/**
	 * @return the coincidencias
	 */
	public String[] getCoincidencias() {
		return coincidencias;
	}

	/**
	 * 
	 */
	public void empezar () {

		//Inicializacion del array de nuestra palabra oculta
		inicializaEImprimePalabra(coincidencias);
		//Inicializacion e impresion del array auxiliar de fallos
		inicializaAux(auxFallos);
		
		String palabraUsuario = "";
		
		do {
			//Pide al usuario la palabra o letra
			palabraUsuario = JOptionPane.showInputDialog(null, "Introduzca la letra o palabra buscada");
			if (palabraUsuario.equals(palabraAleatoria)) {
				for (int i = 0; i < coincidencias.length; i++) {
					coincidencias[i] = String.valueOf(palabraUsuario.charAt(i));
				}
				JOptionPane.showMessageDialog(null,"\n\t\t\tFELICIDADES!! La palabra ocultas era: " + palabraAleatoria);
			} else {
				boolean encontrado = false;
				if (palabraUsuario.length() == 1) {
					encontrado = palabraUsuarioEsUnaLetra (encontrado, palabraUsuario);
				}if (!encontrado && !(palabraUsuario.equals(palabraAleatoria))) {
					jugadaConFallo(palabraUsuario);
				}
				
				Ventana.getVentana().repaint();
				// Impresion de los arrays despues de cada jugada
				System.out.println();
				imprimeArray(coincidencias);
				
				System.out.print("\nFallos: ");
				imprimeArray(auxFallos);
			}
			
		} while (!(fallosUsuario>=fallosMaximos || isTerminado(coincidencias) || palabraUsuario.equals(palabraAleatoria)));
		
		if (fallosUsuario>=fallosMaximos) {
			JOptionPane.showMessageDialog(null,"\n\t\t\tLASTIMA TE HAS MUERTO!! La palabra ocultas era: " + palabraAleatoria);
		} else if (isTerminado(coincidencias)){
			JOptionPane.showMessageDialog(null,"\n\t\t\tFELICIDADES!! La palabra ocultas era: " + palabraAleatoria);
		}
		
	}
	
	/**
	 * 
	 * @param encontrado
	 * @param palabraUsuario
	 * @return
	 */
	private boolean palabraUsuarioEsUnaLetra (boolean encontrado, String palabraUsuario) {
		char charUsuario = palabraUsuario.charAt(0);
		for (int i = 0; i < coincidencias.length; i++) {
			if (palabraAleatoria.charAt(i) == charUsuario) {
				coincidencias[i] = palabraUsuario;
				encontrado = true;
			}
		}
		return encontrado;
	}
	/**
	 * 
	 * @param palabraUsuario
	 */
	private void jugadaConFallo (String palabraUsuario) {
		fallosUsuario++;
		System.out.println();
		System.out.println(palabraUsuario + " no esta en la palabra buscada");
		for (int i = 0; i < auxFallos.length; i++) {
			if (auxFallos[i] == "_") {
				auxFallos[i] = palabraUsuario;
				break;
			}
		}
	}
	/**
	 * 
	 * @param array
	 */
	private void imprimeArray (String array[]) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
	/**
	 * 
	 * @param coincidencias
	 */
	private void inicializaEImprimePalabra(String coincidencias[]) {
		 for (int i = 0; i < coincidencias.length; i++) {
				coincidencias[i] = "_";
				System.out.print(coincidencias[i] + " ");
			}
	}
	
	/**
	 * 
	 * @param auxFallos
	 */
	private void inicializaAux (String auxFallos[]) {
		System.out.println();
		for (int i = 0; i < auxFallos.length; i++) {
			auxFallos[i] = "_";
		}
	}
	
	/**
	 * 
	 * @param coincidencias
	 * @return
	 */
	private boolean isTerminado( String coincidencias[]) {
		for (int i = 0; i < coincidencias.length; i++) {
			if (coincidencias[i] == "_") {
				return false;
			}
		}
		return true;
	}

}
