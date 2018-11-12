package Ejercicios.Objetos.Oca;

public class Principal {


	
	
	public static void main(String[] args) {
		
		//Inicializacion e impresion del tablero
		Tablero tablero = new Tablero ();
		tablero.imprimeTablero();
		
		//Prueba de uso del primero jugador
		Jugador jugador = new Jugador("Jugador 1", tablero);
		do {
			jugador.tirarDado();
			jugador.imprimirJugador();
		}while (jugador.getPosicion() < 62);
		
	}

	
}
