package Ejercicios.Objetos.Bloque3;

public class Carta {

	private int indice;
	private String valorPalo[] = new String[] {"oros", "bastos", "copas", "espadas"};
	private int indicePalo;
	private String palo = valorPalo[indicePalo];
	private boolean repartida = false;
	
	
	public Carta(int indice, int indicePalo) {
		super();
		this.indice = indice;
		this.indicePalo = indicePalo;
		this.palo = valorPalo[indicePalo];
		
	}

//	/**
//	 * 
//	 * @return
//	 */
//	public Carta reparteCartas() {
//		
//		Carta carta = new Carta();
//		if (carta.isRepartida() == false) {
//			carta.setIndice((int) Math.round(Math.random() * (12-1)) + 1);
//			carta.setPalo((int) Math.round(Math.random() * 3));
//			carta.setRepartida(true);
//		}
//		
//		return carta;
//		
//	}

	/**
	 * @param indice the indice to set
	 */
	public void setIndice(int indice) {
		this.indice = indice;
	}
	/**
	 * @param palo the indicePalo to set
	 */
	public void setPalo(int indicePalo) {
		this.indicePalo = indicePalo;
	}
	/**
	 * @return the palo
	 */
	public String getPalo() {
		return palo;
	}
	/**
	 * @return the repartida
	 */
	public boolean isRepartida() {
		return repartida;
	}
	/**
	 * @param repartida the repartida to set
	 */
	public void setRepartida(boolean repartida) {
		this.repartida = repartida;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Carta [" + indice + " de " + palo + "]";
	}

	
	
	
	
}
