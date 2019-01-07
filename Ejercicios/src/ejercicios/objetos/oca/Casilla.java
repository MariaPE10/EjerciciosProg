package ejercicios.objetos.oca;

public class Casilla {

	private int orden;
	private String nombre;
	private Casilla destino;
	private int turnos;
	private String mensajeEspecial;
	
	/**
	 * 
	 */
	public Casilla() {
		super();
	}

	/**
	 * Constructor de las casillas especiales
	 * @param orden
	 * @param nombre
	 * @param destino
	 * @param turnos
	 * @param mensajeEspecial
	 */
	public Casilla(int orden, String nombre, Casilla destino, int turnos, String mensajeEspecial) {
		super();
		this.orden = orden;
		this.nombre = nombre;
		this.destino = destino;
		this.turnos = turnos;
		this.mensajeEspecial = mensajeEspecial;
	}
	
	/**
	 * Constructor de las casillas normales
	 * @param orden
	 * @param nombre
	 */
	public Casilla(int orden, String nombre) {
		super();
		this.orden = orden;
		this.nombre = nombre;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Casilla [" + orden + " - " + nombre + "]";
	}
	
	
	
	/**
	 * @return the orden
	 */
	public int getOrden() {
		return orden;
	}

	/**
	 * @param orden the orden to set
	 */
	public void setOrden(int orden) {
		this.orden = orden;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the destino
	 */
	public Casilla getDestino() {
		return destino;
	}
	/**
	 * @param destino the destino to set
	 */
	public void setDestino(Casilla destino) {
		this.destino = destino;
	}

	/**
	 * @return the turnos
	 */
	public int getTurnos() {
		return turnos;
	}
	/**
	 * @param turnos the turnos to set
	 */
	public void setTurnos(int turnos) {
		this.turnos = turnos;
	}

	/**
	 * @return the mensajeEspecial
	 */
	public String getMensajeEspecial() {
		return mensajeEspecial;
	}
	/**
	 * @param mensajeEspecial the mensajeEspecial to set
	 */
	public void setMensajeEspecial(String mensajeEspecial) {
		this.mensajeEspecial = mensajeEspecial;
	}
	
}
