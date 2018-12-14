package Examenes.ExamenCartas;

public class Principal {

	public static void main(String[] args) {
		
		Baraja.getBaraja().barajar();
		Baraja.getBaraja().ordenarBaraja();
//		Baraja.getBaraja().movimientoCiclicoIzquierda();

		
		Poker.getPoker().reparteCartas();
		
	}

}
