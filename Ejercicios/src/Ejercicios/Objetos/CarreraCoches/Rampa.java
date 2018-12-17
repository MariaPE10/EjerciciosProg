package Ejercicios.Objetos.CarreraCoches;

public class Rampa extends Obstaculo {

	/**
	 * 
	 */
	public Rampa() {
		super();
	}
	
	/**
	 * 
	 */
	@Override
	public int inicializa() {
		int posicionesAvanzadas = (int)Math.round(Math.random()*(100-50)+50);
		
		return posicionesAvanzadas;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Rampa [" + super.toString() + "]";
	}
	
	

}
