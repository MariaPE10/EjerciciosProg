package arkanoid;


/**
 * Clase que implementa la primera fase del juego
 * @author R
 *
 */
public class Fase02 extends Fase {
	// Propiedades est�ticas de la fase
	public static final int ESPACIO_SUPERIOR_SOBRE_LADRILLOS = 60;

	
	/**
	 * Inicializaci�n de la fase, es la implementaci�n de un m�todo abstracto en el supertipo
	 */
	@Override
	public void inicializaFase() {
		this.fondo = "quilavaFondo.png";
	    // Inicializamos los ladrillos
		int matriz [][] = new int [][] {
			{0,0,0,0,0,1,1,0,0,0,0,0}, //del 1 al 8 son colores de ladrillos
			{0,0,0,0,2,9,9,2,0,0,0,0}, //el 9 son ladrillos de plata y el 10 ladrillos de oro
			{0,0,0,3,3,4,4,3,3,0,0,0},
			{0,0,5,9,9,10,10,9,9,5,0,0},
			{0,0,0,6,6,7,7,6,6,0,0,0},
			{0,0,0,0,8,9,9,8,0,0,0,0},
			{0,0,0,0,0,1,1,0,0,0,0,0}
		};
//		int matriz [][] = new int [][] {
//			{0,0,0,0,0,0}, //del 1 al 8 son colores de ladrillos
//			{0,0,0,9,2,10}, //el 9 son ladrillos de plata y el 10 ladrillos de oro
//			
//		};
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
