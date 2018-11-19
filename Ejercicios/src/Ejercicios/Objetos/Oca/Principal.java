package Ejercicios.Objetos.Oca;

import javax.swing.JOptionPane;


public class Principal {

	
	public static void main(String[] args) {
		
		int numeroJugadores = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el numero de jugadores"));
		Jugador jugador[] = new Jugador[numeroJugadores];
		
//		for (int i = 0; i < numeroJugadores; i++) {
//			jugador[i] = new Jugador(JOptionPane.showInputDialog("Nombre del jugador"));
//		}
		
		for (int i = 0; i < numeroJugadores; i++) {
			jugador[i] = new Jugador("0" + (i+1));
		}
		
		do {
			for (int i = 0; i < numeroJugadores; i++) {
				if (!jugador[i].isTerminado()) {
					if (jugador[i].getTurno() < 0) {
						jugador[i].setTurno(jugador[i].getTurno() + 1);
					} else {
//						do {
							System.out.println("Jugador - " + jugador[i].getNombre());
							jugador[i].tirarDado();
							if (jugador[i].isTerminado()) {
								System.out.println("\n\n\tHAS TERMINADO EL JUEGO DE LA OCA");
								jugador[i].setPodium(getMayorPodio(jugador) + 1);
							}
//						} while (jugador[i].getTurno() > 0);
					}
				}
			}
		} while(!estaJuegoTerminado(jugador) );
		
		// Impresion del array de jugadores ordenados previamente
		ordenaJugadoresPorPodio(jugador);
		for (int i = 0; i < jugador.length; i++) {
			System.out.print(jugador[i].toString());
		}
	}
	
	/**
	 * Comprueba si hay algun jugador que todavia no ha terminado
	 * @return
	 */
	private static boolean estaJuegoTerminado (Jugador jugadores[]) {
		for (int i = 0; i < jugadores.length; i++) {
			if (!jugadores[i].isTerminado()) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @param jugadores
	 * @return
	 */
	private static int getMayorPodio (Jugador jugadores[]) {
		int mayor = 0;
		if (jugadores.length > 0) {
			mayor = jugadores[0].getPodium();
			for (int i = 1; i < jugadores.length; i++) {
				if (jugadores[i].getPodium() > mayor) { //Buscamos el podio mayor del array
					mayor = jugadores[i].getPodium();
				}
			}
		}
		return mayor;
	}
	
	/**
	 * Ordena el array de jugadores por el metodo de la burbuja
	 * @param jugador
	 */
	private static void ordenaJugadoresPorPodio (Jugador jugador[]) {
		for (int i = jugador.length-1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (jugador[j].getPodium() > jugador[j+1].getPodium()) {
					Jugador aux = jugador[j];
					jugador[j] = jugador[j+1];
					jugador [j+1] = aux;
				}
			}
		}
	}
	
}
