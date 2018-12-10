package Ejercicios.Objetos.CarreraCoches;

public class Coche extends Vehiculo {

	/**
	 * @param nombre
	 * @param color
	 */
	public Coche(String nombre, String color) {
		super(nombre, color);
	}

	@Override
	public String paint() {
		return "Coche -> Conductor/a:" + nombre + ", posicion:" + posicion;
	}
	
}
