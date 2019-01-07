package ejercicios.objetos.carreraCoches;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

public class Pista {

	Obstaculo obstaculos[] = new Obstaculo[4];
	public static final int META = 500;
	 private int posicionY;
	
	
	/**
	 * @return the posicionY
	 */
	public int getPosicionY() {
		return posicionY;
	}

	/**
	 * @param posicionY the posicionY to set
	 */
	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}

	/**
	 * 
	 */
	public Pista() {
		this.posicionY = 0;
		for (int i = 0; i < obstaculos.length; i++) {
			float porcentaje = (float) Math.random();
			if (porcentaje > 0.5) {
				obstaculos[i]= new Rampa();
			} else {
				obstaculos[i] = new Mancha();
			}
		}
		
		compruebaObstaculos();
		ordenaObstaculos();
	}
	
	/**
	 * 
	 */
	public void compruebaObstaculos() {
	int posicion;
		for (int j = this.obstaculos.length-1; j > 0; j--) {
			for (int i = 0; i < j; i++) {
				if (this.obstaculos[i].getPosicionObs() == this.obstaculos[j].getPosicionObs()) {
					do {
						posicion = (int)(Math.round(Math.random()*(500-1)+1));
						this.obstaculos[i].setPosicionObs(posicion);
					}while(this.obstaculos[i].getPosicionObs() == this.obstaculos[j].getPosicionObs());
					j = this.obstaculos.length-1;
					i--;
				}
			}
		}
	}
	
	
	/**
	 * 
	 */
	public void ordenaObstaculos() {
		Obstaculo aux;
		for (int j = this.obstaculos.length -1; j > 0 ; j--) {
			for (int i = 0; i < j ; i++) {
				if (this.obstaculos[i].getPosicionObs() > this.obstaculos[i+1].getPosicionObs()) {
					aux = this.obstaculos[i];
					this.obstaculos[i]=this.obstaculos [i+1];
					this.obstaculos[i+1]=aux;
				}
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Obstaculos: " + Arrays.toString(obstaculos);
	}

	/**
	 * @return the obstaculos
	 */
	public Obstaculo[] getObstaculos() {
		return obstaculos;
	}
	
	/**
	 *	Método que genera las 5 pistas asignando las posiciones Y a cada una de ellas.
	 * @return
	 */	
	public static Pista[] generatePistas()  {
		
		Pista pistas[] = new Pista[5];
		
		Pista pista1 = new Pista();
		pista1.setPosicionY(25);
		Pista pista2 = new Pista();
		pista2.setPosicionY(75);
		Pista pista3 = new Pista();
		pista3.setPosicionY(125);
		Pista pista4 = new Pista();
		pista4.setPosicionY(175);
		Pista pista5 = new Pista();
		pista5.setPosicionY(225);
		
		pistas[0] = pista1;
		pistas[1] = pista2;
		pistas[2] = pista3;
		pistas[3] = pista4;
		pistas[4] = pista5;
		
		return pistas;
	}
	
	public void paint(Graphics g) {
		for (int i = 0; i < this.obstaculos.length; i++) {
			if ( this.obstaculos[i] instanceof Rampa) {
				g.setColor(Color.orange);
				g.fillOval(this.obstaculos[i].getPosicionObs(), posicionY, 20, 20);
			} else { //es una mancha
				g.setColor(Color.black);
				g.fillOval(this.obstaculos[i].getPosicionObs(), posicionY, 20, 20);
			}
		}
		
	}
}
