package examenes.examenCartas;

import java.util.Arrays;

public class Jugador {

	private String nombre = "";
	private Carta mano[] = new Carta[5];
	
	/**
	 * 
	 */
	public Jugador(String nombre) {
		super();
		this.nombre = nombre;
	}

	
	public void compruebaMano() {
		int contadorCartasIguales = 0;
		for (int j = mano.length -1; j > 0 ; j--) {
			for (int i = 0; i < j ; i++) {
				if (mano[i].getValornumerico() == mano[i+1].getValornumerico()) {
					contadorCartasIguales++;
				}
			}
		}
		if (contadorCartasIguales == 2) {
			System.out.println("Tengo una pareja");
		} else if (contadorCartasIguales == 3) {
			System.out.println("Tengo un trio");
		} else if (contadorCartasIguales == 4) {
			System.out.println("Tengo un Poker!!");
		}
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
	 * @return the mano
	 */
	public Carta[] getMano() {
		return mano;
	}

	/**
	 * @param mano the mano to set
	 */
	public void setMano(Carta[] mano) {
		this.mano = mano;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Jugador [Nombre: " + nombre + " mano: " + Arrays.toString(mano) + "]";
	}
	
	
	
}
