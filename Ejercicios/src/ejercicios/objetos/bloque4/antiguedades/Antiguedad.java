package ejercicios.objetos.bloque4.antiguedades;

public class Antiguedad {
	
	private int anioFabricacion;
	private String origen;
	private float precio;
	
	
	/**
	 * Constructor por defecto, inicializa todos los atributos a 0 o sin especificar.
	 */
	public Antiguedad() {
		super();
		anioFabricacion = 0;
		origen = "Sin especificar";
		precio = 0f;
	}

	/**
	 * Constructor que inicialza los atributos de la clase padre.
	 * @param anioFabricacion
	 * @param origen
	 * @param precio
	 */
	public Antiguedad(int anioFabricacion, String origen, float precio) {
		super();
		this.anioFabricacion = anioFabricacion;
		this.origen = origen;
		this.precio = precio;
	}

	public int getAnioFabricacion() {
		return anioFabricacion;
	}
	public void setAnioFabricacion(int anioFabricacion) {
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
		return "Anio Fabricacion: " + anioFabricacion + "\nOrigen: " + origen + "\nPrecio: " + precio + "€";
	}
	
}
