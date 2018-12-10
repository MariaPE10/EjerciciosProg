package Ejercicios.Objetos.CarreraCoches;

public class Moto extends Vehiculo {
	
	/**
	 * @param nombre
	 * @param color
	 */
	public Moto(String nombre, String color) {
		super(nombre, color);
	}

	@Override
	public String paint() {
		return "Moto -> Conductor/a:" + nombre + ", posicion:" + posicion;
	}
}
