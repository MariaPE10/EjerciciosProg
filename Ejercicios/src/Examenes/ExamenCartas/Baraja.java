package Examenes.ExamenCartas;

public class Baraja {

	private static Carta barajaCartas[] = new Carta[52];
	public static Baraja baraja = null; 
	
	/**
	 * 
	 */
	public static Baraja getBaraja() {
		if(baraja == null) {
			baraja = new Baraja();
			creaBaraja();
		}
		return baraja;
	}
	
	/**
	 * 
	 */
	public static void creaBaraja() {
			
		for (int j = 1; j<=13; j++) {
			barajaCartas[j-1] = new Carta(j, "picas", (j-1));
		}
		
		for (int j = 1; j<=13; j++) {
			barajaCartas[j+12] = new Carta(j, "diamantes",(j+12));
		}
		
		for (int j = 1; j<=13; j++) {
			barajaCartas[j+25] = new Carta(j, "treboles", (j+25));
		}
		
		for (int j = 1; j<=13; j++) {
			barajaCartas[j+38] = new Carta(j, "corazones", (j+38));
		}
		//Impresion de la baraja de cartas completa
		for (int i = 0; i < barajaCartas.length; i++) {
			System.out.println(barajaCartas[i]);
		}
		
		//movimientoCiclicoIzquierda();
		//movimientoCiclicoDerecha();
	}
	
	/**
	 * 
	 * @param barajaCartas
	 */
	public void movimientoCiclicoDerecha () {
		
		Carta aux = barajaCartas[barajaCartas.length-1];
		
		for (int i = (barajaCartas.length - 1); i > 0; i--) {
			barajaCartas[i] = barajaCartas[i-1];
		}
		barajaCartas[0] = aux;
		
		//Impresion de las cartas despues del movimiento
		System.out.println();
		for (int i = 0; i < barajaCartas.length; i++) {
			System.out.println(barajaCartas[i]);
		}
	}
	
	/**
	 * 
	 * @param barajaCartas
	 */
	public void movimientoCiclicoIzquierda () {
		
		Carta aux = barajaCartas[0];
		
		for (int j = 0; j < barajaCartas.length-1; j++) {
			barajaCartas[j] = barajaCartas[j+1];
		}
		barajaCartas[barajaCartas.length-1] = aux;
		
		//Impresion de las cartas despues del movimiento
		System.out.println();
		for (int i = 0; i < barajaCartas.length; i++) {
			System.out.println(barajaCartas[i]);
		}
	}
	
	/**
	 * 
	 */
	public void barajar() {
		
		for (int i = 0; i < 100; i++) {
			int indiceAzar1 =  (int) Math.round(Math.random() * (barajaCartas.length-1));// 6
			int indiceAzar2 =  (int) Math.round(Math.random() * (barajaCartas.length-1));// 25
			
			Carta aux = barajaCartas[indiceAzar1];
			barajaCartas[indiceAzar1] = barajaCartas[indiceAzar2];
			barajaCartas[indiceAzar2] = aux;
		}
		
		//Impresion de las cartas despues de barajar
		System.out.println();
		for (int i = 0; i < barajaCartas.length; i++) {
			System.out.println(barajaCartas[i]);
		}
	}
	
	/**
	 * 
	 */
	public void ordenarBaraja() {
		Carta aux;
		
		for (int j = barajaCartas.length -1; j > 0 ; j--) {
			for (int i = 0; i < j ; i++) {
				if (barajaCartas[i].getId() > barajaCartas[i+1].getId()) {
					aux = barajaCartas[i];
					barajaCartas[i]=barajaCartas [i+1];
					barajaCartas[i+1]=aux;
				}
			}
		}
		
		//Impresion de las cartas despues de ordenar la baraja
		System.out.println();
		for (int i = 0; i < barajaCartas.length; i++) {
			System.out.println(barajaCartas[i]);
		}
	}
	
	/**
	 * 
	 * @param jugador
	 */
	public void darCartasJugador(Jugador jugador) {
		
		Carta aux[] = new Carta[5];
		
		for (int i = 0; i < aux.length; i++) {
			int cartaAleatoria;
			do {
				cartaAleatoria = (int) Math.round(Math.random()*(barajaCartas.length-1));
				
				if (barajaCartas[cartaAleatoria] != null) {
					aux[i] = barajaCartas[cartaAleatoria];
				}
				
			} while(barajaCartas[cartaAleatoria] == null);
			
			barajaCartas[cartaAleatoria] = null;
				
		}
		
		jugador.setMano(aux);
		//Impresion del jugador para ver su mano
		System.out.println(jugador);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
