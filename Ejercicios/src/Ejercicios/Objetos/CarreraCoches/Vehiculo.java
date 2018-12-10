package Ejercicios.Objetos.CarreraCoches;

public abstract class Vehiculo {

	protected String nombre;
	protected int posicion;
	protected String color;
	private Pista pista;
	private static final int META = 500;
	
	/**
	 * @param nombre
	 * @param posicion
	 * @param color
	 */
	public Vehiculo (String nombre, String color) {
		super();
		this.nombre = nombre;
		this.color = color;
		this.posicion = 0;
	}

	public int avanza(int posicion) {
		int posicionesAvanzadas = (int)Math.round(Math.random()*(50-3)+3);
		
		return this.posicion += posicionesAvanzadas;
	}
	
	public abstract void paint();

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

	/**
	 * @return the meta
	 */
	public static int getMeta() {
		return META;
	}
	
}
