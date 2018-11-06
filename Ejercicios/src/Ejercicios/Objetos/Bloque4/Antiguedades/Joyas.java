package Ejercicios.Objetos.Bloque4.Antiguedades;

public class Joyas extends Antiguedad {

	private String materialFabricacion;
	
	/**
	 * 
	 */
	public Joyas() {
		super();
		materialFabricacion = "";
	}

	/**
	 * 
	 * @param materialFabricacion
	 */
	public Joyas(String materialFabricacion) {
		super();
		this.materialFabricacion = materialFabricacion;
	}
	
	/**
	 * Constructor que inicialza los atributos de la clase padre y tambien el atributo especifico de la clase hija.
	 * @param anioFabricacion
	 * @param origen
	 * @param precio
	 * @param materialFacricacion
	 */
	public Joyas(String anioFabricacion, String origen, float precio, String materialFacricacion) {
		super(anioFabricacion, origen, precio);
		this.materialFabricacion = materialFacricacion;
	}

	/**
	 * 
	 * @return
	 */
	public String getMaterialFabricacion() {
		return materialFabricacion;
	}
	public void setMaterialFabricacion(String materialFabricacion) {
		this.materialFabricacion = materialFabricacion;
	}

	@Override
	public String toString() {
		String toStringSuper = super.toString();
		return "Joya \nMaterial Fabricacion: " + materialFabricacion + "\n" + toStringSuper;
	}
	
	
}
