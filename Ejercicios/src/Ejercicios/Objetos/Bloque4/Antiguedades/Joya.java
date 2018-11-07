package Ejercicios.Objetos.Bloque4.Antiguedades;

public class Joya extends Antiguedad {

	private String materialFabricacion;
	
	/**
	 * Crear el constructor por defecto e inicializa el atributo especifico de la clase.
	 */
	public Joya() {
		super();
		materialFabricacion = "";
	}

	/**
	 * 
	 * @param materialFabricacion
	 */
	public Joya(String materialFabricacion) {
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
	public Joya(String anioFabricacion, String origen, float precio, String materialFacricacion) {
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
		return "JOYA \nMaterial Fabricacion: " + materialFabricacion + "\n" + toStringSuper;
	}
	
	
}
