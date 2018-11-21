package Ejercicios.Objetos.Oca;

public class Tablero {
	
	public static String msgOca = "De oca a oca y tiro porque me toca";
	public static String msgPuente = "De puente a puente y tiro porque me lleva la corriente";
	public static String msgPDado ="De dado a dado y tiro porque me ha tocado";
	
	
	Casilla casillas[] = new Casilla[63];
	
	private static Tablero tablero = null;
	
	/**
	 * Constructor por defecto
	 */
	public Tablero () {
		super();
		inicializaTablero();
	}
	
	/**
	 * Utilizamos el patron de diseño "Singleton" que soluciona el problema de poder
	 * acceder a una variable desde muchos puntos, sin crear mas de una variable.
	 * @return
	 */
	public static Tablero getTablero () {
		if (tablero == null) {
			tablero = new Tablero ();
		}
		return tablero;
	}
	
	/**
	 * Metodo que imprime el tablero
	 * @param tablero
	 */
	public void imprimeTablero () {
		for (int i=0; i < casillas.length; i++) {
			System.out.println(casillas[i].getOrden() + " - " + casillas[i].getNombre());
		}
	}
	
	/**
	 * Metodo que inicializa el tablero
	 * @param tablero
	 */
	public void inicializaTablero () {
		//Estructura basica del tablero
				casillas[0] = new Casilla(1, "Inicio");
				casillas[1] = new Casilla(2, "Caballo");
				casillas[2] = new Casilla(3, "Pez");
				casillas[3] = new Casilla(4, "Payaso");
				casillas[4] = new Casilla(5, "Oca", null, 1, msgOca);
				casillas[5] = new Casilla(6, "Puente", null, 1, msgPuente);
				casillas[6] = new Casilla(7, "Tortuga");
				casillas[7] = new Casilla(8, "Banco");
				casillas[8] = new Casilla(9, "Oca", null, 1, msgOca);
				casillas[9] = new Casilla(10, "Raton");
				casillas[10] = new Casilla(11, "Rana");
				casillas[11] = new Casilla(12, "Puente", null, 1, msgPuente);
				casillas[12] = new Casilla(13, "Pollito");
				casillas[13] = new Casilla(14, "Oca", null, 1, msgOca);
				casillas[14] = new Casilla(15, "Helado");
				casillas[15] = new Casilla(16, "Osito");
				casillas[16] = new Casilla(17, "Bebe");
				casillas[17] = new Casilla(18, "Oca", null, 1, msgOca);
				casillas[18] = new Casilla(19, "Posada", null, -1, "POSADA: un turno sin tirar");
				casillas[19] = new Casilla(20, "Cohete");
				casillas[20] = new Casilla(21, "Tarta");
				casillas[21] = new Casilla(22, "Casa");
				casillas[22] = new Casilla(23, "Oca", null, 1, msgOca);
				casillas[23] = new Casilla(24, "Flores");
				casillas[24] = new Casilla(25, "Leon");
				casillas[25] = new Casilla(26, "Dados", null, 1, msgPDado);
				casillas[26] = new Casilla(27, "Oca", null, 1, msgOca);
				casillas[27] = new Casilla(28, "Bicicleta");
				casillas[28] = new Casilla(29, "Delfin");
				casillas[29] = new Casilla(30, "Dragon");
				casillas[30] = new Casilla(31, "Pozo", null, -3, "POZO: tres turnos sin tirar");
				casillas[31] = new Casilla(32, "Oca", null, 1, msgOca);
				casillas[32] = new Casilla(33, "Mariposa");
				casillas[33] = new Casilla(34, "Moto");
				casillas[34] = new Casilla(35, "Osito de Peluche");
				casillas[35] = new Casilla(36, "Oca", null, 1, msgOca);
				casillas[36] = new Casilla(37, "Elefante");
				casillas[37] = new Casilla(38, "Bambi");
				casillas[38] = new Casilla(39, "Conejito");
				casillas[39] = new Casilla(40, "Cesta de Fresas");
				casillas[40] = new Casilla(41, "Oca", null, 1, msgOca);
				casillas[41] = new Casilla(42, "Laberinto", null, 0, "LABERINTO: Te has perdido, vuelves a la casilla 30");
				casillas[42] = new Casilla(43, "Caballo disfrazado");
				casillas[43] = new Casilla(44, "Paraguas");
				casillas[44] = new Casilla(45, "Oca", null, 1, msgOca);
				casillas[45] = new Casilla(46, "Conejito");
				casillas[46] = new Casilla(47, "Muñeco de nieve");
				casillas[47] = new Casilla(48, "Mariposa");
				casillas[48] = new Casilla(49, "Tren");
				casillas[49] = new Casilla(50, "Oca", null, 1, msgOca);
				casillas[50] = new Casilla(51, "Mono");
				casillas[51] = new Casilla(52, "Carcel", null, -2, "CARCEL: 2 turnos sin tirar");
				casillas[52] = new Casilla(53, "Dados", null, 1, msgPDado);
				casillas[53] = new Casilla(54, "Oca", null, 1, msgOca);
				casillas[54] = new Casilla(55, "Buho");
				casillas[55] = new Casilla(56, "Tiburon");
				casillas[56] = new Casilla(57, "Perro");
				casillas[57] = new Casilla(58, "Muerte", null, 0, "Has muerto!! Vuelves a la casilla de inicio");
				casillas[58] = new Casilla(59, "Oca", null, 1, msgOca);
				casillas[59] = new Casilla(60, "Mariposa");
				casillas[60] = new Casilla(61, "Gato");
				casillas[61] = new Casilla(62, "Regadera");
				casillas[62] = new Casilla(63, "Meta", null, 0, "HAS GANADO!!");
				
				//Destino de las casillas especiales
				casillas[4].setDestino(casillas[8]); //Oca
				casillas[5].setDestino(casillas[11]); //Puente
				casillas[8].setDestino(casillas[13]); //Oca
				casillas[11].setDestino(casillas[5]); //Puente
				casillas[13].setDestino(casillas[17]); //Oca
				casillas[17].setDestino(casillas[22]); //Oca
				casillas[22].setDestino(casillas[26]); //Oca
				casillas[25].setDestino(casillas[52]); //Dados
				casillas[26].setDestino(casillas[31]); //Oca
				casillas[31].setDestino(casillas[35]); //Oca
				casillas[35].setDestino(casillas[40]); //Oca
				casillas[40].setDestino(casillas[44]); //Oca
				casillas[41].setDestino(casillas[29]); //Laberinto
				casillas[44].setDestino(casillas[49]); //Oca
				casillas[49].setDestino(casillas[53]); //Oca
				casillas[52].setDestino(casillas[25]); //Dados
				casillas[53].setDestino(casillas[58]); //Oca
				casillas[57].setDestino(casillas[0]); //Muerte
				casillas[58].setDestino(casillas[62]); //Oca
	}

	/**
	 * 
	 * @param posicion
	 * @param dado
	 * @return
	 */
	public static Casilla getCasillaDestino (Casilla casilla, int dado) {
		// Sumo el dado a la posici�n actual
		int posicion = Tablero.getPosicion(casilla); 
		
		posicion += dado; 

		// C�lculo del posible rebote
		posicion = getNuevaPosicionPorRebote(posicion);
		
		// Comprobamos si estamos en una casilla especial
		posicion = getNuevaPosicionPorCasillaEspecial(posicion);
		
		return Tablero.getTablero().getCasillas()[posicion];
	}
	
	/**
	 * 
	 * @param posicion
	 * @return
	 */
	public static int getNuevaPosicionPorRebote (int posicion) {
		int indiceCasillaMeta = Tablero.getTablero().getCasillas().length-1;
		if (posicion > indiceCasillaMeta) {
			posicion = 2 * indiceCasillaMeta - posicion;
		}
		return posicion;
	}
	
	/**
	 * 
	 * @param posicion
	 * @return
	 */
	public static int getNuevaPosicionPorCasillaEspecial (int posicion) {
		// Puntero a la casilla correspondiente del array
		Casilla casillaActual = Tablero.getTablero().getCasillas()[posicion];		
		// Busco un destino de la casilla actual
		if (casillaActual.getDestino() != null) { // Hay un destino
			// Puntero a la casilla de destino, despu�s de la tirada
			Casilla casillaDestino = casillaActual.getDestino();
			// Imprimo el mensaje especial de la casilla de destino
			System.out.println("\t" + casillaActual.getMensajeEspecial());
			// Actualizar la posici�n del jugador, teniendo en cuenta que ha
			// ca�do en una casilla con destino, una casilla especial
			posicion = casillaDestino.getOrden() - 1;
		}
		return posicion;
	}
	
	/**
	 * 
	 * @param casilla
	 * @return
	 */
	public static int getPosicion (Casilla casilla) {
		for (int i = 0; i < Tablero.getTablero().getCasillas().length; i++) {
			if (Tablero.getTablero().getCasillas()[i].equals(casilla)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 
	 * @return
	 */
	public static Casilla getUltimaCasillaEnTablero () {
		return Tablero.getTablero().getCasillas()[Tablero.getTablero().getCasillas().length-1];
	}
	
	/**
	 * 
	 * @return
	 */
	public static Casilla getPrimeraCasillaEnTablero () {
		return Tablero.getTablero().getCasillas()[0];
	}
	
	/**
	 * @return the casillas
	 */
	public Casilla[] getCasillas() {
		return casillas;
	}
	/**
	 * @param casillas the casillas to set
	 */
	public void setCasillas(Casilla[] casillas) {
		this.casillas = casillas;
	}
	
	
}
