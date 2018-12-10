package Ejercicios.Objetos.CarreraCoches;

public abstract class Vehiculo {

	protected String nombre;
	protected int posicion;
	protected String color;
	
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
	public abstract String paint();
}
