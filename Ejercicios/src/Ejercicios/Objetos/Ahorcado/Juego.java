package Ejercicios.Objetos.Ahorcado;

import javax.swing.JOptionPane;
//CHEAT 09: "PISTA"; 10: "INMORTAL"; 11: "NIER || HALLOWEEN || NAVIDAD"
public class Juego {
	//Array de palabras posibles
	private String palabras[] = new String[] {"aburrido", "alegre", "alto", "amargo", "ancho", "atrevido", "azul", "bajo", "blanco", "blando", "bonito", "buen", "caliente", "capaz", "central", "chungo", "conocido", "contento", "corto", "delgado", "derecho", "diferente","dulce", "duro", "enfermo", "estrecho", "exterior", "falso", "famoso", "feo", "final", "fresco", "fuerte", "gordo", "grande", "guay", "guapo", "igual", "imposible", "interesante", "interior", "izquierdo", "joven", "largo", "lento", "listo", "malo", "masivo", "mayor", "mejor", "menor", "mucho", "muerto", "musical", "nacional", "natural", "negro", "nuevo", "peor", "perfecto", "pobre", "poco", "popular", "posible", "primero", "principal", "raro", "real", "recto", "rico", "rojo", "salado", "sano", "seco", "segundo", "simple", "social", "solo", "soso", "tonto", "triste", "verdadero", "verde", "viejo", "vivo", "crema", "navaja", "universidad", "llaves", "catre", "escuela", "codo", "mapa", "lima", "edificio", "hojas", "granizo", "mano", "abuelo", "templo", "plato", "botella", "casa", "planeta", "metal", "mono", "debate", "herramienta", "anteojos", "zapato", "ojo", "ciente", "diente", "buzo", "puerta", "ensalada", "candidato", "diario", "hierro", "barco", "tecla", "departamento", "discurso", "lentejas", "reloj", "desodorante", "partido", "fiesta", "guitarra", "martillo", "lapicera", "letra", "rueda", "camisa", "teclado", "pantalla", "tenedor", "pantalla", "tenedor", "agua", "cohete", "parlante", "monitor", "hombre", "velero", "palo", "lentes", "nube", "castillo", "libro", "televisor", "percha", "anillo", "pared", "cartas", "impresora", "luces", "bomba", "gobierno", "enano", "persona", "guantes", "proyector", "muela", "remate", "cuaderno", "taladro", "chocolate", "caramelos", "angustia", "lluvia", "corbata", "planta", "chupete", "oficina", "persiana", "silla", "pradera", "deporte", "recipiente", "ave", "refugio", "carne", "nieve", "humedad", "pistola", "tristeza", "cama", "campera", "coche", "famoso", "madera", "piso", "diputado", "cuchillo", "candado", "luz", "ordenador", "radio", "cuadro", "calor", "teatro", "bala", "auriculares", "libro", "aluminio", "agujeta", "sonido", "perro", "pelo", "felicidad", "servilleta", "sol", "mensaje", "rey", "presidencia", "colegio", "flor", "tornillo", "abuela", "cosplay", "jaula", "olas", "articulacion", "negativo", "inflacion", "barro", "ahri", "akali", "zinogre"};
	//Genera un numero aleatorio que sera mi palabra aleatoria
	private int indicePalabraAleatoria = (int) Math.round(Math.random()*(palabras.length-1));
	//Creacion de un array con la longitud de nuestra palabra aleatoria
	private String palabraAleatoria = palabras[indicePalabraAleatoria];
	private String coincidencias[]= new String [palabraAleatoria.length()];
	private int fallosUsuario = 0;
	private int fallosMaximos = 10;
	//Inicializo juego a null para hacer un singleton
	private static Juego juego = null;
	//Creacion de un array auxiliar para mostrar los fallos del usuario
	private String auxFallos[]= new String [fallosMaximos];
	private String pista = "pista";
	private boolean pistaUsada = false;
	private String inmortal = "inmortal";
	private boolean modoInmortal = false;
	private String navidad = "Navidad";
	private String halloween = "Halloween";
	private String nier = "Nier";
	
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
	 * @return the modoInmortal
	 */
	public boolean isModoInmortal() {
		return modoInmortal;
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
			//Uso del cheat "PISTA"
			if (palabraUsuario.equals(pista) && !pistaUsada) {
				usarPista();
				JOptionPane.showMessageDialog(null, "Has usado una pista!");
			}
			if (palabraUsuario.equals(inmortal)) {
				modoInmortal = true;
				JOptionPane.showMessageDialog(null, "Has entrado en modo inmortal!");
			}
			if (palabraUsuario.equals(navidad)) { //|| palabraUsuario.equals(nier) || palabraUsuario.equals(halloween)) {
				//AQUI ES DONDE TENGO QUE SEGUIR CURRANDO
			}
			if (palabraUsuario.equals(palabraAleatoria)) { //La palabra del usuario es la misma que la oculta
				for (int i = 0; i < coincidencias.length; i++) {
					coincidencias[i] = String.valueOf(palabraUsuario.charAt(i));
				}
			} else {
				boolean encontrado = false;
				if (palabraUsuario.length() == 1) {
					encontrado = palabraUsuarioEsUnaLetra (encontrado, palabraUsuario);
				}if (!encontrado && !(palabraUsuario.equals(palabraAleatoria)) && !modoInmortal ) {
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
		} else if (isTerminado(coincidencias) || palabraUsuario.equals(palabraAleatoria)){
			JOptionPane.showMessageDialog(null,"\n\t\t\tFELICIDADES!! La palabra ocultas era: " + palabraAleatoria);
		}
		
	}
	
	/**
	 * 
	 */
	private void usarPista() {
		pistaUsada = true;
		boolean cambio = false;
		do {
			int charAleatorio = (int) Math.round(Math.random()*(palabraAleatoria.length()-1));
			char charAleatorioPalabra = palabraAleatoria.charAt(charAleatorio);
			if (coincidencias[charAleatorio] == "_") {
				coincidencias[charAleatorio] = String.valueOf(charAleatorioPalabra);
				cambio = true;
			}
			
		} while (!cambio);
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
