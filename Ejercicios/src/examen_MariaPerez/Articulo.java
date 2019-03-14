package examen_MariaPerez;

public abstract class Articulo {

	private String identificador;
	private String nombre;
	private int cantidad;
	private float precio;
	private String fecha;
	

	/**
	 * @param identificador
	 * @param nombre
	 * @param cantidad
	 * @param precio
	 */
	public Articulo(String identificador, String nombre, int cantidad, float precio) {
		super();
		this.identificador = identificador;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	
	/**
	 * @return the identificador
	 */
	public String getIdentificador() {
		return identificador;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}
	/**
	 * @return the precio
	 */
	public float getPrecio() {
		return precio;
	}
	
	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public abstract String getDescripcion();
}
