package Ejercicios.Objetos.Oca;


public class Jugador {

	private Casilla casilla;
	private String nombre;
	int podium;
	int turno;

	
	/**
	 * 
	 */
	public Jugador() {
		super();
	}
	
	/**
	 * @param nombre
	 */
	public Jugador(String nombre) {
		super();
		this.nombre = nombre;
		this.casilla = Tablero.getPrimeraCasillaEnTablero();
		this.podium = 0;
		this.turno = 0;
	}
	
	/**
	 * 
	 */
	public void tirarDado () {
		// Imprimo en la consola la casilla, antes del movimiento		
		System.out.println("\t" + this.casilla);

		// Utilizamos el azar para conseguir un dado virtual
		int dado = (int) Math.round(Math.random()*(6-1)+1);
		System.out.println("\tDado: " + dado); 
		
		//Actualizacion de la posicion del jugador
		this.casilla = Tablero.getCasillaDestino(this.casilla, dado);
		
		//Actualiza los turnos del jugador
		if (this.casilla.getTurnos() != 0) {
			this.turno = this.casilla.getTurnos();
		}
	}

	/**
	 * 
	 * @return
	 */
	public boolean isTerminado () {
		if (this.casilla.equals(Tablero.getUltimaCasillaEnTablero())) {
			return true;
		}
		return false;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\nJugador: " + nombre + ", podium: " + podium;
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
	 * @return the casilla
	 */
	public Casilla getCasilla() {
		return casilla;
	}
	/**
	 * @param casilla the casilla to set
	 */
	public void setCasilla(Casilla casilla) {
		this.casilla = casilla;
	}

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
	 * @return the turno
	 */
	public int getTurno() {
		return turno;
	}

	/**
	 * @param turno the turno to set
	 */
	public void setTurno(int turno) {
		this.turno = turno;
	}
	
	
	
}
