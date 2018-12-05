package Ejercicios.Objetos.Ahorcado;

import javax.swing.JOptionPane;
//CHEAT 09: "PISTA"; 10: "INMORTAL"; 11: "HALLOWEEN || NAVIDAD"
public class Juego {
	//Array de palabras posibles
	private String palabras[] = new String[] {"aburrido", "alegre", "alto", "amargo", "ancho", "atrevido", "azul", "bajo", "blanco", "blando", "bonito", "buen", "caliente", "capaz", "central", "chungo", "conocido", "contento", "corto", "delgado", "derecho", "diferente","dulce", "duro", "enfermo", "estrecho", "exterior", "falso", "famoso", "feo", "final", "fresco", "fuerte", "gordo", "grande", "guay", "guapo", "igual", "imposible", "interesante", "interior", "izquierdo", "joven", "largo", "lento", "listo", "malo", "masivo", "mayor", "mejor", "menor", "mucho", "muerto", "musical", "nacional", "natural", "negro", "nuevo", "peor", "perfecto", "pobre", "poco", "popular", "posible", "primero", "principal", "raro", "real", "recto", "rico", "rojo", "salado", "sano", "seco", "segundo", "simple", "social", "solo", "soso", "tonto", "triste", "verdadero", "verde", "viejo", "vivo", "crema", "navaja", "universidad", "llaves", "catre", "escuela", "codo", "mapa", "lima", "edificio", "hojas", "granizo", "mano", "abuelo", "templo", "plato", "botella", "casa", "planeta", "metal", "mono", "debate", "herramienta", "anteojos", "zapato", "ojo", "ciente", "diente", "buzo", "puerta", "ensalada", "candidato", "diario", "hierro", "barco", "tecla", "departamento", "discurso", "lentejas", "reloj", "desodorante", "partido", "fiesta", "guitarra", "martillo", "lapicera", "letra", "rueda", "camisa", "teclado", "pantalla", "tenedor", "pantalla", "tenedor", "agua", "cohete", "parlante", "monitor", "hombre", "velero", "palo", "lentes", "nube", "castillo", "libro", "televisor", "percha", "anillo", "pared", "cartas", "impresora", "luces", "bomba", "gobierno", "enano", "persona", "guantes", "proyector", "muela", "remate", "cuaderno", "taladro", "chocolate", "caramelos", "angustia", "lluvia", "corbata", "planta", "chupete", "oficina", "persiana", "silla", "pradera", "deporte", "recipiente", "ave", "refugio", "carne", "nieve", "humedad", "pistola", "tristeza", "cama", "campera", "coche", "famoso", "madera", "piso", "diputado", "cuchillo", "candado", "luz", "ordenador", "radio", "cuadro", "calor", "teatro", "bala", "auriculares", "libro", "aluminio", "agujeta", "sonido", "perro", "pelo", "felicidad", "servilleta", "sol", "mensaje", "rey", "presidencia", "colegio", "flor", "tornillo", "abuela", "cosplay", "jaula", "olas", "articulacion", "negativo", "inflacion", "barro", "ahri", "akali", "zinogre"};
	//Genera un numero aleatorio que sera mi palabra aleatoria
	int indicePalabraAleatoria = (int) Math.round(Math.random()*(palabras.length-1));
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
	private String navidad = "navidad";
	private String halloween = "halloween";
	private String nier = "nier";
	
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
			if (palabraUsuario.equals(pista) && !pistaUsada) { //Uso del cheat "PISTA"
				usarPista();
				JOptionPane.showMessageDialog(null, "Has usado una pista!");
			}
			if (palabraUsuario.equals(inmortal)) { //Modo Inmortal
				modoInmortal = true;
				JOptionPane.showMessageDialog(null, "Has entrado en modo inmortal!");
			}
			if (palabraUsuario.equals(navidad) || palabraUsuario.equals(halloween)) {  //Modo Navidad		
				if (palabraUsuario.equals(navidad)) {
					JOptionPane.showMessageDialog(null, "Modo Navidad!!");
					palabraAleatoria = modoNavidad();
				} else if (palabraUsuario.equals(halloween)) {//Modo  Halloween
					JOptionPane.showMessageDialog(null, "Modo Halloween!!");
					palabraAleatoria = modoHalloween();
				}
			} else
			if (palabraUsuario.equals(palabraAleatoria)) { //La palabra del usuario es la misma que la oculta
				for (int i = 0; i < coincidencias.length; i++) {
					coincidencias[i] = String.valueOf(palabraUsuario.charAt(i));
				}
			} else {
				boolean encontrado = false;
				if (palabraUsuario.length() == 1) { //La palabra del usuario es una letra
					encontrado = palabraUsuarioEsUnaLetra (encontrado, palabraUsuario);
				}if (!encontrado && !(palabraUsuario.equals(palabraAleatoria)) && !modoInmortal ) {
					jugadaConFallo(palabraUsuario);
				}
				//Pinta la ventana despues de cada jugada
				Ventana.getVentana().repaint();
				// Impresion de los arrays despues de cada jugada
				System.out.println();
				imprimeArray(coincidencias);
				
				System.out.print("\nFallos: ");
				imprimeArray(auxFallos);
			}
			
		} while (!(fallosUsuario>=fallosMaximos || isTerminado(coincidencias) || palabraUsuario.equals(palabraAleatoria)));
		//Carteles de fin de juego
		if (fallosUsuario>=fallosMaximos) {
			JOptionPane.showMessageDialog(null,"\n\t\t\tLASTIMA TE HAS MUERTO!! La palabra ocultas era: " + palabraAleatoria);
		} else if (isTerminado(coincidencias) || palabraUsuario.equals(palabraAleatoria)){
			JOptionPane.showMessageDialog(null,"\n\t\t\tFELICIDADES!! La palabra ocultas era: " + palabraAleatoria);
		}
		
		int opcion = JOptionPane.showConfirmDialog(null, "Volver a jugar?", "El Ahorcado", JOptionPane.YES_NO_OPTION);
		if (opcion == JOptionPane.YES_OPTION) { 
			fallosUsuario = 0;
			indicePalabraAleatoria = (int) Math.round(Math.random()*(palabras.length-1));
			palabraAleatoria = palabras[indicePalabraAleatoria];
			Ventana.getVentana().repaint();
			empezar();
			
		}
	}
	
	/**
	 * Metodo muy chulo que cambia la interfaz y todo el juego del oeste por un ambiente navidenio
	 * @return
	 */
	private String modoNavidad() {
		String palabras[] = new String[] {"caramelo", "galletas", "jengibre", "mantecados", "mazapan", "turron", "polvorones", "reyes", "santa", "roscon", "nieve", "regalos", "arbol", "elfos", "belen", "luces", "estrella", "duendes", "angeles", "velas", "adornos", "guirnaldas", "campanas", "carbon", "rudolf", "pino", "reno", "trineo", "chimenea", "hielo", "calcetines", "bufanda", "guantes", "gorro", "invierno", "nochebuena", "nochevieja", "cabalgatas","baltasar","gaspar","melchor","canela"};
		int indicePalabraAleatoria = (int) Math.round(Math.random()*(palabras.length-1));
		palabraAleatoria = palabras[indicePalabraAleatoria];
		coincidencias = new String [palabraAleatoria.length()];
		//Cambio de los colores de la ventana
		String rojo = "#A9001C";
		String verde = "#007731";
		String blanco = "#FFFFFF";
		Ventana.getVentana().setColorPantalon(rojo);
		Ventana.getVentana().setColorCamiseta(rojo);
		Ventana.getVentana().setColorBotones(blanco);
		Ventana.getVentana().setColorHorca(verde);
		Ventana.getVentana().setColorPalabra(blanco);
		Ventana.getVentana().setColorLetras(verde);
		Ventana.getVentana().setColorMangas(blanco);
		Ventana.getVentana().setColorZapatos("#000000");
		Ventana.getVentana().setImagenFondo(CacheImagenes.getCache().getImagenFondoNavidad());
		fallosUsuario = 0;
		//Inicializacion del array de nuestra palabra oculta
		inicializaEImprimePalabra(coincidencias);
		//Inicializacion e impresion del array auxiliar de fallos
		inicializaAux(auxFallos);
		Ventana.getVentana().repaint();
		return palabraAleatoria;
	}
	
	/**
	 * Metodo muy chulo que cambia la interfaz y todo el juego del oeste por un ambiente terrorifico
	 * @return
	 */
	private String modoHalloween() {
		String palabras[] = new String[] {"calabaza", "caramelos", "esqueleto", "mascara", "sangre", "ojos", "gusanos", "chuches", "truco", "octubre", "galletas", "vampiro", "murcielago", "bruja", "gato", "tumba", "cementerio", "araña", "telaraña", "calavera", "zombie", "susto", "miedo", "fantasma", "momia", "demonio", "diablo", "encantada", "escoba", "velas", "magia", "monstruo", "luna", "hechizo", "escalofriante", "espeluznante", "sobrenatural", "almas", "errante", "siniestro", "grito", "monstruo", "lobo", "macabro", "maldicion", "caldero", "linterna", "candelabro", "uvas", "zambomba"};
		int indicePalabraAleatoria = (int) Math.round(Math.random()*(palabras.length-1));
		palabraAleatoria = palabras[indicePalabraAleatoria];
		coincidencias = new String [palabraAleatoria.length()];
		String naranja = "#FFBE2A";
		String morado = "#460071";  //7E0092
		String moradoOsc = "#581845";
		Ventana.getVentana().setColorPantalon(morado);
		Ventana.getVentana().setColorCamiseta(naranja);
		Ventana.getVentana().setColorBotones(morado);
		Ventana.getVentana().setColorHorca(moradoOsc);
		Ventana.getVentana().setColorMangas(morado);
		Ventana.getVentana().setColorZapatos("#000000");
		Ventana.getVentana().setColorPalabra("#FF8B00");
		Ventana.getVentana().setColorLetras(naranja);
		Ventana.getVentana().setImagenFondo(CacheImagenes.getCache().getImagenFondoHalloween());
		fallosUsuario = 0;
		//Inicializacion del array de nuestra palabra oculta
		inicializaEImprimePalabra(coincidencias);
		//Inicializacion e impresion del array auxiliar de fallos
		inicializaAux(auxFallos);
		Ventana.getVentana().repaint();
		return palabraAleatoria;
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
