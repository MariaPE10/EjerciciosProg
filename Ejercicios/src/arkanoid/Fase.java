package arkanoid;

import java.util.ArrayList;
import java.util.List;

/**
 * Todas las fases deber�n extender esta clase abstracta y personalizar la apariencia y el comportamiento
 * @author R
 *
 */
public abstract class Fase {
	
	// Lista de actores a colocar en cualquier fase
	protected List<Actor> actores = new ArrayList<Actor>();
	protected String fondo = "pikachuFondo.jpg";
	
	/**
	 * @return the fondo
	 */
	public String getFondo() {
		return fondo;
	}

	/**
	 * Metodo que debe implementar cada Fase
	 */
	public abstract void inicializaFase ();

	/**
	 * Getter de la lista de actores
	 * @return
	 */
	public List<Actor> getActores() { return actores; }
}
