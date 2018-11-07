package Ejercicios.Objetos.Bloque4.Antiguedades;

public class Cuadro extends Antiguedad {

	private String pintor;
	private String nombre;
	
	/**
	 * Crear el constructor por defecto e inicializa el atributo especifico de la clase.
	 */
	public Cuadro() {
		super();
		pintor = "";
		nombre = "";
	}
	
	/**
	 * Constructor que inicialza los atributos de la clase padre y tambien el atributo especifico de la clase hija.
	 * @param anioFabricacion
	 * @param origen
	 * @param precio
	 * @param pintor
	 * @param nombre
	 */
	public Cuadro(String anioFabricacion, String origen, float precio, String pintor, String nombre) {
		super(anioFabricacion, origen, precio);
		this.pintor = pintor;
		this.nombre = nombre;
	}

	/**
	 * 
	 * @param pintor
	 * @param nombre
	 */
	public Cuadro(String pintor, String nombre) {
		super();
		this.pintor = pintor;
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return
	 */
	public String getPintor() {
		return pintor;
	}
	public void setPintor(String pintor) {
		this.pintor = pintor;
	}

	/**
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		String toStringSuper = super.toString();
		return "CUADRO \nPintor: " + pintor + "\nNombre del Cuadro: " + nombre + "\n" + toStringSuper;
	}
	
	
}
