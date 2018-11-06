package Ejercicios.Objetos.Bloque4.Antiguedades;

public class Antiguedad {
	
	private String anioFabricacion;
	private String origen;
	private float precio;
	
	
	/**
	 * 
	 */
	public Antiguedad() {
		super();
		anioFabricacion = "";
		origen = "";
		precio = 0f;
	}

	/**
	 * 
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
		return "Antiguedad \nAño Fabricacion: " + anioFabricacion + "\nOrigen: " + origen + "\nPrecio: " + precio;
	}
	
}
