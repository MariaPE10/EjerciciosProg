package ejercicios.objetos.carreraCoches;

import java.awt.Graphics;

public abstract class Vehiculo {

	protected String nombre;
	protected int posicion;
	protected String color;
	private Pista pista;
	private int podium;
	protected String mensaje;
	
	
	/**
	 * @return the podium
	 */
	public int getPodium() {
		return podium;
	}

	/**
	 * @param podium the podium to set
	 */
	public void setPodium(int podium) {
		this.podium = podium;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

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
		this.mensaje = this.nombre + " posicion inicial: " + this.posicion;
	}

	/**
	 * 
	 * @return
	 */
	public int avanza() {
		int posicionFinal;
		int posicionesAvanzadas = (int)Math.round(Math.random()*(50-3)+3);
		this.mensaje = mensaje.concat("\n" + "Avanza: " + posicionesAvanzadas);
//		System.out.println("posicion inicial " + this.posicion + " avanza: " + posicionesAvanzadas);
		posicionFinal = this.posicion + posicionesAvanzadas;
		posicionFinal = avancePorObstaculo (posicionFinal);
		if (posicionFinal > 500) {
			posicionFinal = 500;
		}
		if (this instanceof Coche) {
			this.mensaje = this.mensaje.concat("\n"  + nombre + " (Coche), posicion final: " + posicionFinal);
			System.out.println( nombre + " (Coche), posicion final: " + posicionFinal);
		} else {
			this.mensaje = this.mensaje.concat("\n"  + nombre + " (Moto), posicion final: " + posicionFinal);
			System.out.println( nombre + " (Moto), posicion final: " + posicionFinal);
		}
		return this.posicion = posicionFinal;
	}
	
	/**
	 * 
	 */
	public int avancePorObstaculo (int posicionFinal) {
		for (int i = 0; i < this.pista.getObstaculos().length; i++) {
			if (posicionFinal >= this.pista.getObstaculos()[i].getPosicionObs() && this.posicion <= this.pista.getObstaculos()[i].getPosicionObs()) {
				if (this.pista.getObstaculos()[i] instanceof Rampa) {
					int posicionesRampa = this.pista.getObstaculos()[i].inicializa();
					posicionFinal += posicionesRampa;
					Carrera.sonidoFondo.playSound("rampa.wav");
					System.out.println( this.nombre + " ha pasado por una Rampa (posicion: " + this.pista.getObstaculos()[i].getPosicionObs() + ") y avanza: " + posicionesRampa);
					this.mensaje = mensaje.concat("\n" + this.nombre + " ha pasado por una Rampa (posicion: " + this.pista.getObstaculos()[i].getPosicionObs() + ") y avanza: " + posicionesRampa);
				}
				if (this.pista.getObstaculos()[i] instanceof Mancha) {
					int posicionesMancha = this.pista.getObstaculos()[i].inicializa();
					posicionFinal += posicionesMancha;
					Carrera.sonidoFondo.playSound("mancha.wav");
					if (posicionFinal < 0) {
						posicionFinal = 0;
					}
					System.out.println( this.nombre + " ha pasado por una Mancha (posicion: " + this.pista.getObstaculos()[i].getPosicionObs() + ") y retrocede: " + posicionesMancha);
					this.mensaje = mensaje.concat("\n" + this.nombre + " ha pasado por una Mancha (posicion: " + this.pista.getObstaculos()[i].getPosicionObs() + ") y retrocede: " + posicionesMancha);
				}
			}
		}
		return posicionFinal;
	}
	
	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}
	
	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	/**
	 * 
	 */
	public abstract void paint(Graphics g, int posicionY);
	public abstract void paint(Graphics g,int posicionX, int posicionY);

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
	 * @return the pista
	 */
	public Pista getPista() {
		return pista;
	}

	/**
	 * @param pista the pista to set
	 */
	public void setPista(Pista pista) {
		this.pista = pista;
	}


	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
}
