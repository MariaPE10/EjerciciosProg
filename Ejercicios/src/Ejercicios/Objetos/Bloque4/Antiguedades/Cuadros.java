package Ejercicios.Objetos.Bloque4.Antiguedades;

public class Cuadros extends Antiguedad {

	private String pintor;
	private String nombre;
	
	/**
	 * 
	 */
	public Cuadros() {
		super();
	}

	/**
	 * 
	 * @param pintor
	 * @param nombre
	 */
	public Cuadros(String pintor, String nombre) {
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
	
	
}
