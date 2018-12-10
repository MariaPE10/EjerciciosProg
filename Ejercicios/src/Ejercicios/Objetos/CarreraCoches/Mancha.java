package Ejercicios.Objetos.CarreraCoches;

public class Mancha extends Obstaculo {

	@Override
	public int inicializa() {
		int posicionesRetrasadas = (int)(Math.round(Math.random()*(50-10)+10)*(-1));
	
		return posicionesRetrasadas;
	}

}
