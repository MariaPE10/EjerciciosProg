package Ejercicios.Objetos.Oca;

public class Jugador {

	private int posicion = 0;
	private String nombre;
	
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
	
	public void tirarDado () {
		int dado;
		
		dado = (int)Math.round(Math.random()*(6-1)+1);
		System.out.println("Dado: " + dado);
		this.posicion += dado;
		//Calculo del posible rebote
		if (this.posicion > Tablero.getTablero().getCasillas().length) {
			this.posicion = Tablero.getTablero().getCasillas().length - (this.posicion - Tablero.getTablero().getCasillas().length);
		}
		
		Casilla casillaActual = Tablero.getTablero().getCasillas()[this.posicion];
		
		//Comprobamos si es una casilla especial
		if (casillaActual.getDestino() != null) {
			System.out.println("Casilla especial: " + casillaActual.getMensajeEspecial());
			Casilla casillaDestino = casillaActual.getDestino();
			//Actualizacion de la posicion del jugador
			this.posicion = casillaDestino.getOrden()-1;
			dado = (int)Math.round(Math.random()*(6-1)+1);
			System.out.println("Dado: " + dado);
			this.posicion += dado;
		}
	}
	
	public void imprimirJugador () {
		System.out.println(this.nombre + " - pos: " + this.posicion);
	}
	
}
