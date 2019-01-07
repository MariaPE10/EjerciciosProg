package examenes.examenCartas;


public class Carta {

	private int valornumerico;
	private String palo = "";
	private int id; 
	
	public Carta (int valornumerico, String palo,int id) {
		super();
		this.valornumerico = valornumerico;
		this.palo = palo;
		this.id = id;
	}
	

	/**
	 * @return the valornumerico
	 */
	public int getValornumerico() {
		return valornumerico;
	}

	/**
	 * @param valornumerico the valornumerico to set
	 */
	public void setValornumerico(int valornumerico) {
		this.valornumerico = valornumerico;
	}

	/**
	 * @return the palo
	 */
	public String getPalo() {
		return palo;
	}

	/**
	 * @param palo the palo to set
	 */
	public void setPalo(String palo) {
		this.palo = palo;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "" + valornumerico + " de " + palo + " id: " + id;
	}

	
	
	
}
