package Examenes.ExamenCartas;

public class Poker {

	Jugador jugadores[] = new Jugador[5];
	public static Poker poker = null; 
	 
	/**
	 * 
	 */
	public static Poker getPoker() {
		if(poker == null) {
			poker = new Poker();
		}
		return poker;
	}
	
	/**
	 * 
	 */
	public void reparteCartas () {
		
		for (int i = 0; i < jugadores.length; i++) {
			jugadores[i] = new Jugador("0" + i);
			Baraja.getBaraja().darCartasJugador(jugadores[i]);
			jugadores[i].compruebaMano();
		}
		
	}
}
