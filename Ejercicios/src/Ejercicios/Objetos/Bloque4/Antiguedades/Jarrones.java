package Ejercicios.Objetos.Bloque4.Antiguedades;

public class Jarrones extends Antiguedad {

	private String material;
	private String estilo;
	
	/**
	 * 
	 */
	public Jarrones() {
		super();
	}

	/**
	 * 
	 * @param material
	 * @param estilo
	 */
	public Jarrones(String material, String estilo) {
		super();
		this.material = material;
		this.estilo = estilo;
	}

	/**
	 * 
	 * @return
	 */
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}

	/**
	 * 
	 * @return
	 */
	public String getEstilo() {
		return estilo;
	}
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	
	
}
