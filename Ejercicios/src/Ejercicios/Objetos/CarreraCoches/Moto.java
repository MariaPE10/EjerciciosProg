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
	public void paint() {
		System.out.println( "Moto -> Conductor/a:" + nombre + ", posicion:" + posicion);
	}
}
