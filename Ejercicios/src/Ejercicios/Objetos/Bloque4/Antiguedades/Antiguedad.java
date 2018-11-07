package Ejercicios.Objetos.Bloque4.Antiguedades;

public class Antiguedad {
	
	private String anioFabricacion;
	private String origen;
	private float precio;
	
	
	/**
	 * Constructor por defecto, inicializa todos los atributos.
	 */
	public Antiguedad() {
		super();
		anioFabricacion = "";
		origen = "";
		precio = 0f;
	}

	/**
	 * Constructor que inicialza los atributos de la clase padre.
	 * @param anioFabricacion
	 * @param origen
	 * @param precio
	 */
	public Antiguedad(String anioFabricacion, String origen, float precio) {
		super();
		this.anioFabricacion = anioFabricacion;
		this.origen = origen;
		this.precio = precio;
	}

	public String getAnioFabricacion() {
		return anioFabricacion;
	}
	public void setAnioFabricacion(String anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}

	
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}

	
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "\nAnio Fabricacion: " + anioFabricacion + "\nOrigen: " + origen + "\nPrecio: " + precio;
	}
	
}
