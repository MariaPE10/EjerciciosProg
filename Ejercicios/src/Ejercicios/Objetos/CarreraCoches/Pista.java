package Ejercicios.Objetos.CarreraCoches;

import java.util.Arrays;

public class Pista {

	Obstaculo pista[] = new Obstaculo[4];
	
	
	/**
	 * 
	 */
	public Pista() {
		
		for (int i = 0; i < pista.length; i++) {
			float porcentaje = (float) Math.random();
			if (porcentaje > 0.5) {
				pista[i]= new Rampa();
			} else {
				pista[i] = new Mancha();
			}
		}
		
		compruebaObstaculos();
	}
	
	/**
	 * 
	 */
	public void compruebaObstaculos() {
	int posicion;
		for (int j = pista.length-1; j > 0; j--) {
			for (int i = 0; i < j; i++) {
				if (pista[i].getPosicionObs() == pista[j].getPosicionObs()) {
					do {
						posicion = (int)(Math.round(Math.random()*(500-1)+1));
					}while(pista[i].getPosicionObs() == pista[j].getPosicionObs());
					pista[i].setPosicionObs(posicion);
				}
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pista: " + Arrays.toString(pista);
	}
	
	
}
