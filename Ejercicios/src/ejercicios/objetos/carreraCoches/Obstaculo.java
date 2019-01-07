package ejercicios.objetos.carreraCoches;


public abstract class Obstaculo {

	private int posicionObs;
	
	
	/**
	 * @param posicionObs
	 */
	public Obstaculo() {
		super();
		this.posicionObs = (int)(Math.round(Math.random()*(500-1)+1));
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "" + posicionObs ;
	}

	/**
	 * 
	 * @return
	 */
	public abstract int inicializa();

	/**
	 * @return the posicionObs
	 */
	public int getPosicionObs() {
		return posicionObs;
	}

	/**
	 * @param posicionObs the posicionObs to set
	 */
	public void setPosicionObs(int posicionObs) {
		this.posicionObs = posicionObs;
	}
	
	
}
