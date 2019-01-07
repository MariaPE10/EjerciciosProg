package ejercicios.objetos.tresEnRaya.v1;

import java.awt.Graphics;

public abstract class Jugador {

	private String nombre;
	private int codigo;

	/**
	 * @param nombre
	 */
	public Jugador(String nombre, int codigo) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
	}

	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	
	/**
	 * 
	 * @param g
	 */
	public abstract void paint(Graphics g, int offsetX, int offsetY);

}
