package Ejercicios.Objetos.CarreraCoches;

public class Rampa extends Obstaculo {

	@Override
	public int inicializa() {
		int posicionesAvanzadas = (int)Math.round(Math.random()*(100-50)+50);
		
		return posicionesAvanzadas;
	}

}
