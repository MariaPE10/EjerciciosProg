package examenMvS;

import javax.swing.JOptionPane;

public class Main {
	
	private static Main instancia = null;
	private static Personaje personajes[] = new Personaje[2];
	private static int indicePersonajeActivo = 0;
	Personaje personajeActivo = null;
	public boolean finDeJuego = false;
	
	/**
	 * Getter Singleton
	 * @return
	 */
	public static Main getInstancia () {
		if (instancia == null) {
			instancia = new Main();
		}
		return instancia;
	}
	
	/**
	 * 
	 */
	public void iniciaJuego() {
		personajes[0] = new Ahri(1, "Ahri", 500, 20);
		personajes[1] = new Akali(2, "Akali", 600, 15);
		JOptionPane.showMessageDialog(null, "Pelea: " + personajes[0].getNombre() + " vs " + personajes[1].getNombre(), "Ahri vs Akali", 1);
		System.out.println("Pelea: " + personajes[0].getNombre() + " vs " + personajes[1].getNombre());
		int random = ((int) Math.round(Math.random()));
		if (random == 1) {
			//System.out.println("Comienza : " + personajes[0].getNombre());
			personajeActivo = personajes[0];
		} else {
			//System.out.println("Comienza : " + personajes[1].getNombre());
			personajeActivo = personajes[1];
		}
	}
	
	/**
	 * 
	 */
	public void juego() {
		iniciaJuego();
		while (!finDeJuego) {
			getPersonajeTurnoActivo().actua();
		}
	}
	
	/**
	 * 
	 */
	public void tieneVida(Personaje personaje) {
		if (personaje.getVida() < 1) {
			finDeJuego = true;
		}
	}
	
	/**
	 * @return the personajes
	 */
	public static Personaje[] getPersonajes() {
		return personajes;
	}
	/**
	 * @param personajes the personajes to set
	 */
	public static void setPersonajes(Personaje[] personajes) {
		Main.personajes = personajes;
	}
	/**
	 * 
	 * @return
	 */
	public static Personaje getPersonajeTurnoActivo () {
		return personajes[indicePersonajeActivo];
	}
	
	/**
	 * 
	 */
	public static void avanzaTurno () {
		if (indicePersonajeActivo == 0) {
			indicePersonajeActivo = 1;
		}
		else {
			indicePersonajeActivo = 0;
		}
	}
	
	public static void main(String[] args) {
		Main.getInstancia().juego();
	}
}
