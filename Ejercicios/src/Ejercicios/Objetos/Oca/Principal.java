package Ejercicios.Objetos.Oca;

import javax.swing.JOptionPane;

public class Principal {

	
	public static void main(String[] args) {
		
		int numeroJugadores = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el número de jugadores"));
		Jugador jugador[] = new Jugador[numeroJugadores];
		
		for (int i = 0; i < numeroJugadores; i++) {
			jugador[i] = new Jugador(JOptionPane.showInputDialog("Nombre del jugador"));
		}
		
		int numJugadoresTerminados = 0;
		
		do {
			for (int i = 0; i < numeroJugadores; i++) {
				if (!jugador[i].isTerminado()) {
					do {
						jugador[i].tirarDado();
					} while (jugador[i].getCasilla().getTurnos() == 1);	
				}
			}
		} while(numJugadoresTerminados < numeroJugadores );
		
		
		System.out.println("\n\n\tHAS GANADO EL JUEGO DE LA OCA");
	}


	
}
