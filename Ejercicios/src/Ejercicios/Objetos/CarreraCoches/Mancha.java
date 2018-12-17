package Ejercicios.Objetos.CarreraCoches;

public class Mancha extends Obstaculo {

	/**
	 * 
	 */
	public Mancha() {
		super();
	}
	
	/**
	 * 
	 */
	@Override
	public int inicializa() {
		int posicionesRetrasadas = (int)(Math.round(Math.random()*(50-10)+10)*(-1));
	
		return posicionesRetrasadas;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Mancha [" + super.toString() + "]";
	}

	
}
