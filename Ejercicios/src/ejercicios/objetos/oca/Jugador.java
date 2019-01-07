package ejercicios.objetos.oca;


public class Jugador {

	private Casilla casilla;
	private String nombre;
	private int podium;
	private int turno;

	
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
		System.out.println("\tEstas en: " + this.casilla);

		// Comprobamos si el jugador tiene que jugar o no
		if (this.turno < 0) {
			System.out.println("\tNo puedes tirar!! " + (this.turno*(-1)) + ": turnos sin tirar");
			this.turno ++;
		} else {
			// Utilizamos el azar para conseguir un dado virtual
			int dado = (int) Math.round(Math.random()*(6-1)+1);
			System.out.println("\t\tDado: " + dado);
			
			// Actualizacion de la posicion del jugador. Conozco la primera
			// casilla de destino, tras haber lanzado y sumado el dado
			int posicionActual = Tablero.getPosicion(this.casilla);
			int nuevaPosicion = posicionActual + dado;
			
			// Calculo de la posicion por rebote
			nuevaPosicion = Tablero.getNuevaPosicionPorRebote(nuevaPosicion);
			// Actualizacion de la casilla despues de caer en casilla rebote
			this.casilla = Tablero.getTablero().getCasillas()[nuevaPosicion];
			
			// Imprimo la casilla despues de mover al jugador
			System.out.println("\t\tMovido a: " + this.casilla);
						
			//Actualiza los turnos del jugador
			if (this.casilla.getTurnos() != 0) {
				this.turno = this.casilla.getTurnos();
			}
			
			// Calculo la nueva posicion por posibilidad de casilla especial
			int nuevaPosicionPorCasillaEspecial= Tablero.getNuevaPosicionPorCasillaEspecial(nuevaPosicion);
			// Actualizacion de la casilla despues de caer en casilla especial
			this.casilla = Tablero.getTablero().getCasillas()[nuevaPosicionPorCasillaEspecial];
			
			if (this.casilla.getDestino() != null) {
				// Imprimo la casilla despues de mover al jugador por una casilla especial
				System.out.println("\t\tEnviado a: " + this.casilla);	
			}
			
			// Si corresponde, el  jugador vuelve a tirar
			if (this.turno > 0 && !this.isTerminado()) { // El jugador debe volver a tirar
				this.turno --;
				this.tirarDado();
			}
		
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
