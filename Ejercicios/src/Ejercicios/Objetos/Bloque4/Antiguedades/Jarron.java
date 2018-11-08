package Ejercicios.Objetos.Bloque4.Antiguedades;

public class Jarron extends Antiguedad {

	private String material;
	private String estilo;
	
	/**
	 * Crear el constructor por defecto e inicializa el atributo especifico de la clase.
	 */
	public Jarron() {
		super();
		material ="Sin especificar";
		estilo ="Sin especificar";
	}

	/**
	 * Constructor que inicialza los atributos de la clase padre y tambien los especificos de la clase hija.
	 * @param anioFabricacion
	 * @param origen
	 * @param precio
	 * @param material
	 * @param estilo
	 */
	public Jarron(int anioFabricacion, String origen, float precio, String material, String estilo) {
		super(anioFabricacion, origen, precio);
		this.material = material;
		this.estilo = estilo;
	}


	/**
	 * 
	 * @param material
	 * @param estilo
	 */
	public Jarron(String material, String estilo) {
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

	@Override
	public String toString() {
		String toStringSuper = super.toString();
		return "JARRON \nMaterial: " + material + "\nEstilo: " + estilo + "\n" + toStringSuper;
	}
	
	
	
}
