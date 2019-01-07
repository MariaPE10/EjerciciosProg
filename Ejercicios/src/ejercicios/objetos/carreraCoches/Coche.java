package ejercicios.objetos.carreraCoches;

import java.awt.Color;
import java.awt.Graphics;


public class Coche extends Vehiculo {

	/**
	 * @param nombre
	 * @param color
	 */
	public Coche(String nombre, String color) {
		super(nombre, color);
	}

	@Override
	public void paint(Graphics g, int posicionY) {
		super.mensaje = super.mensaje.concat("\n"  + nombre + " (Coche), posicion final:" + posicion);
		System.out.println( nombre + " (Coche), posicion final:" + posicion);
		g.setColor(Color.decode(color));
		g.fillRect(posicion, posicionY, 20, 20);
		
	}
	
}
