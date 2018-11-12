package Ejercicios.Objetos.Oca;

public class Jugador {

	private int posicion = 0;
	private String nombre;
	private Tablero tablero;
	
	/**
	 * 
	 */
	public Jugador() {
		super();
	}
	
	/**
	 * @param nombre
	 */
	public Jugador(String nombre, Tablero tablero) {
		super();
		this.nombre = nombre;
		this.tablero = tablero;
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
	 * @return the posicion
	 */
	public int getPosicion() {
		return posicion;
	}
	/**
	 * @param posicion the posicion to set
	 */
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	
	public void tirarDado () {
		int dado;
		
		dado = (int)Math.round(Math.random()*(6-1)+1);
		System.out.println("Dado: " + dado);
		this.posicion += dado;
		if (this.posicion > tablero.getTablero().length) {
			this.posicion = tablero.getTablero().length - (this.posicion - tablero.getTablero().length);
		}
	}
	
	public void imprimirJugador () {
		System.out.println(this.nombre + " - pos: " + this.posicion);
	}
}
