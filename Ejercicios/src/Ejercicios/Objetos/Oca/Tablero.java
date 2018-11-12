package Ejercicios.Objetos.Oca;

public class Tablero {
	
	public static String msgOca = "De oca a oca y tiro porque me toca";
	public static String msgPuente = "De puente a puente y tiro porque me lleva la corriente";
	public static String msgPDado ="De dado a dado y tiro porque me ha tocado";
	
	Casilla tablero[] = new Casilla[63];
	
	/**
	 * Constructor por defecto
	 */
	public Tablero () {
		super();
		inicializaTablero();
	}
	/**
	 * Metodo que imprime el tablero
	 * @param tablero
	 */
	public void imprimeTablero () {
		for (int i=0; i < tablero.length; i++) {
			System.out.println(tablero[i].getOrden() + " - " + tablero[i].getNombre());
		}
	}
	
	/**
	 * Metodo que inicializa el tablero
	 * @param tablero
	 */
	public void inicializaTablero () {
		//Estructura basica del tablero
				tablero[0] = new Casilla(1, "Inicio");
				tablero[1] = new Casilla(2, "Caballo");
				tablero[2] = new Casilla(3, "Pez");
				tablero[3] = new Casilla(4, "Payaso");
				tablero[4] = new Casilla(5, "Oca", null, 1, msgOca);
				tablero[5] = new Casilla(6, "Puente", null, 1, msgPuente);
				tablero[6] = new Casilla(7, "Tortuga");
				tablero[7] = new Casilla(8, "Banco");
				tablero[8] = new Casilla(9, "Oca", null, 1, msgOca);
				tablero[9] = new Casilla(10, "Raton");
				tablero[10] = new Casilla(11, "Rana");
				tablero[11] = new Casilla(12, "Puente", null, 1, msgPuente);
				tablero[12] = new Casilla(13, "Pollito");
				tablero[13] = new Casilla(14, "Oca", null, 1, msgOca);
				tablero[14] = new Casilla(15, "Helado");
				tablero[15] = new Casilla(16, "Osito");
				tablero[16] = new Casilla(17, "Bebe");
				tablero[17] = new Casilla(18, "Oca", null, 1, msgOca);
				tablero[18] = new Casilla(19, "Posada", null, -1, "POSADA: un turno sin tirar");
				tablero[19] = new Casilla(20, "Cohete");
				tablero[20] = new Casilla(21, "Tarta");
				tablero[21] = new Casilla(22, "Casa");
				tablero[22] = new Casilla(23, "Oca", null, 1, msgOca);
				tablero[23] = new Casilla(24, "Flores");
				tablero[24] = new Casilla(25, "Leon");
				tablero[25] = new Casilla(26, "Dados", null, 1, msgPDado);
				tablero[26] = new Casilla(27, "Oca", null, 1, msgOca);
				tablero[27] = new Casilla(28, "Bicicleta");
				tablero[28] = new Casilla(29, "Delfin");
				tablero[29] = new Casilla(30, "Dragon");
				tablero[30] = new Casilla(31, "Pozo", null, -3, "POZO: tres turnos sin tirar");
				tablero[31] = new Casilla(32, "Oca", null, 1, msgOca);
				tablero[32] = new Casilla(33, "Mariposa");
				tablero[33] = new Casilla(34, "Moto");
				tablero[34] = new Casilla(35, "Osito de Peluche");
				tablero[35] = new Casilla(36, "Oca", null, 1, msgOca);
				tablero[36] = new Casilla(37, "Elefante");
				tablero[37] = new Casilla(38, "Bambi");
				tablero[38] = new Casilla(39, "Conejito");
				tablero[39] = new Casilla(40, "Cesta de Fresas");
				tablero[40] = new Casilla(41, "Oca", null, 1, msgOca);
				tablero[41] = new Casilla(42, "Laberinto", null, 0, "LABERINTO: Te has perdido, vuelves a la casilla 30");
				tablero[42] = new Casilla(43, "Caballo disfrazado");
				tablero[43] = new Casilla(44, "Paraguas");
				tablero[44] = new Casilla(45, "Oca", null, 1, msgOca);
				tablero[45] = new Casilla(46, "Conejito");
				tablero[46] = new Casilla(47, "Muñeco de nieve");
				tablero[47] = new Casilla(48, "Mariposa");
				tablero[48] = new Casilla(49, "Tren");
				tablero[49] = new Casilla(50, "Oca", null, 1, msgOca);
				tablero[50] = new Casilla(51, "Mono");
				tablero[51] = new Casilla(52, "Carcel", null, -2, "CARCEL: 2 turnos sin tirar");
				tablero[52] = new Casilla(53, "Dados", null, 1, msgPDado);
				tablero[53] = new Casilla(54, "Oca", null, 1, msgOca);
				tablero[54] = new Casilla(55, "Buho");
				tablero[55] = new Casilla(56, "Tiburon");
				tablero[56] = new Casilla(57, "Perro");
				tablero[57] = new Casilla(58, "Muerte", null, 0, "Has muerto!! Vuelves a la casilla de inicio");
				tablero[58] = new Casilla(59, "Oca", null, 1, msgOca);
				tablero[59] = new Casilla(60, "Mariposa");
				tablero[60] = new Casilla(61, "Gato");
				tablero[61] = new Casilla(62, "Regadera");
				tablero[62] = new Casilla(63, "Meta", null, 0, "HAS GANADO!!");
				
				//Destino de las casillas especiales
				tablero[4].setDestino(tablero[8]); //Oca
				tablero[5].setDestino(tablero[11]); //Puente
				tablero[8].setDestino(tablero[13]); //Oca
				tablero[11].setDestino(tablero[5]); //Puente
				tablero[13].setDestino(tablero[17]); //Oca
				tablero[17].setDestino(tablero[22]); //Oca
				tablero[22].setDestino(tablero[26]); //Oca
				tablero[25].setDestino(tablero[52]); //Dados
				tablero[26].setDestino(tablero[31]); //Oca
				tablero[31].setDestino(tablero[35]); //Oca
				tablero[35].setDestino(tablero[40]); //Oca
				tablero[40].setDestino(tablero[44]); //Oca
				tablero[41].setDestino(tablero[29]); //Laberinto
				tablero[44].setDestino(tablero[49]); //Oca
				tablero[49].setDestino(tablero[53]); //Oca
				tablero[52].setDestino(tablero[25]); //Dados
				tablero[53].setDestino(tablero[58]); //Oca
				tablero[57].setDestino(tablero[0]); //Muerte
				tablero[58].setDestino(tablero[62]); //Oca
	}
	/**
	 * @return the tablero
	 */
	public Casilla[] getTablero() {
		return tablero;
	}
	/**
	 * @param tablero the tablero to set
	 */
	public void setTablero(Casilla[] tablero) {
		this.tablero = tablero;
	}
}
