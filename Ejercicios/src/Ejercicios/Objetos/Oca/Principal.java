package Ejercicios.Objetos.Oca;

public class Principal {


	
	
	public static void main(String[] args) {
		
		//Inicializacion e impresion del tablero
		//Utilizamos el patron de diseño "Singleton" que soluciona el problema de poder
		//acceder a una variable desde muchos puntos, sin crear mas de una variable.
		Tablero.getTablero().imprimeTablero();
		
		//Prueba de uso del primero jugador
		Jugador jugador = new Jugador("Jugador 1");
		do {
			jugador.tirarDado();
			jugador.imprimirJugador();
		}while (jugador.getPosicion() < Tablero.getTablero().getCasillas().length);
		
	}

	
}
