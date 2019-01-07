package ejercicios.objetos.carreraCoches;

import java.awt.Color;
import java.awt.Graphics;

public class Moto extends Vehiculo {
	
	/**
	 * @param nombre
	 * @param color
	 */
	public Moto(String nombre, String color) {
		super(nombre, color);
	}

	@Override
	public void paint(Graphics g,int posicionY) {
//		super.mensaje = super.mensaje.concat("\n" + nombre + " (Moto), posicion final:" + posicion);
//		System.out.println( nombre + " (Moto), posicion final:" + posicion);
		g.setColor(Color.decode(color));
		g.fillOval(posicion, posicionY, 20, 20);
	}
	
	@Override
	public void paint(Graphics g,int posicionX, int posicionY) {
//		super.mensaje = super.mensaje.concat("\n" + nombre + " (Moto), posicion final:" + posicion);
//		System.out.println( nombre + " (Moto), posicion final:" + posicion);
		g.setColor(Color.decode(color));
		g.fillOval(posicionX, posicionY, 20, 20);
	}
}
