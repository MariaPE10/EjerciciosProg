package arkanoid;


/**
 * Clase que implementa la primera fase del juego
 * @author R
 *
 */
public class Fase02 extends Fase {
	// Propiedades est�ticas de la fase
	public static final int ESPACIO_SUPERIOR_SOBRE_LADRILLOS = 30;

	
	/**
	 * Inicializaci�n de la fase, es la implementaci�n de un m�todo abstracto en el supertipo
	 */
	@Override
	public void inicializaFase() {
		this.fondo = "quilavaFondo.png";
		Arkanoid.getInstancia().soundCache.stop("pokemon.wav");
		Arkanoid.getInstancia().soundCache.stop("AdvanceBattle.wav");
		Arkanoid.getInstancia().soundCache.loopSound("HazteConTodos.wav");
		Arkanoid.getInstancia().musicaUsado = false;
	    // Inicializamos los ladrillos
		int matriz [][] = new int [][] {
			{0,0,0,0,0,0,0,0,0,0,0,0}, //del 1 al 8 son colores de ladrillos
			{0,0,0,0,0,0,0,0,0,0,0,0}, //el 9 son ladrillos de plata y el 10 ladrillos de oro
			{0,0,0,0,0,0,0,0,0,0,0,0},
			{5,6,7,6,10,0,0,10,1,2,3,4},
			{6,7,6,5,10,0,0,10,2,3,4,5},
			{7,6,5,4,10,0,0,10,3,4,5,6},
			{6,5,4,3,10,0,0,10,4,5,6,7},
			{5,4,3,2,10,0,0,10,5,6,7,6},
			{4,3,2,1,10,0,0,10,6,7,6,5},
			{3,2,1,2,10,0,0,10,7,6,5,4},
			{2,1,2,3,10,0,0,10,6,5,4,3},
			{1,2,3,4,10,0,0,10,5,4,3,2},
			{9,9,9,9,10,0,0,10,9,9,9,9}
		};

		int numLadrillosPosibles = Arkanoid.ANCHO / (Ladrillo.ANCHO + Ladrillo.ESPACIO_ENTRE_LADRILLOS);
	    int margenIzquierdo = (Arkanoid.ANCHO % (Ladrillo.ANCHO + Ladrillo.ESPACIO_ENTRE_LADRILLOS)) / 2;
	    
	    // Creamos las filas
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if (matriz[i][j] >= 1 && matriz[i][j] <= 8) { // ladrillo normal
					this.actores.add(new Ladrillo(margenIzquierdo + j * (Ladrillo.ANCHO + Ladrillo.ESPACIO_ENTRE_LADRILLOS), 
			    			ESPACIO_SUPERIOR_SOBRE_LADRILLOS + i * (Ladrillo.ALTO + Ladrillo.ESPACIO_ENTRE_LADRILLOS), matriz[i][j], 0));
				}
				if (matriz[i][j] == 9) { // ladrillo de 2 toques
					this.actores.add(new Ladrillo(margenIzquierdo + j * (Ladrillo.ANCHO + Ladrillo.ESPACIO_ENTRE_LADRILLOS), 
			    			ESPACIO_SUPERIOR_SOBRE_LADRILLOS + i * (Ladrillo.ALTO + Ladrillo.ESPACIO_ENTRE_LADRILLOS)));
				}
				if (matriz[i][j] == 10) { // ladrillo irrompible
					this.actores.add(new Ladrillo(margenIzquierdo + j * (Ladrillo.ANCHO + Ladrillo.ESPACIO_ENTRE_LADRILLOS), 
			    			ESPACIO_SUPERIOR_SOBRE_LADRILLOS + i * (Ladrillo.ALTO + Ladrillo.ESPACIO_ENTRE_LADRILLOS), i));
				}
			}
			
		}
   
	}
	

}
