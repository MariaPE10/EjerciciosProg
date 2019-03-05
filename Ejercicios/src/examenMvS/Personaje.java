package examenMvS;

import java.util.List;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;


public abstract class Personaje {

	protected int id;
	protected String nombre;
	protected int vida;
	protected int fuerza;
	private List<Ataque> ataques = new ArrayList<Ataque>();
	private boolean enter;
	
	public Personaje() {
		super();
	}
	
//	 /**
//	   * 
//	   * @param e
//	   */
//	 public void keyPressed(KeyEvent e) {
//	  	switch (e.getKeyCode()) {
//	  	case KeyEvent.VK_ENTER : enter = true; break;
//	  	}
//	 }
	
	/**
	 * @return the ataques
	 */
	public List<Ataque> getAtaques() {
		return ataques;
	}


	/**
	 * @param ataques the ataques to set
	 */
	public void setAtaques(List<Ataque> ataques) {
		this.ataques = ataques;
	}


	/**
	 * 
	 */
	public abstract void actua();
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the vida
	 */
	public int getVida() {
		return vida;
	}
	/**
	 * @param vida the vida to set
	 */
	public void setVida(int vida) {
		this.vida = vida;
	}
	/**
	 * @return the fuerza
	 */
	public int getFuerza() {
		return fuerza;
	}
	/**
	 * @param fuerza the fuerza to set
	 */
	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}
	
	
}
