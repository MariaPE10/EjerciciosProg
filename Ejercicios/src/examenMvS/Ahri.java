package examenMvS;

import arkanoid.Arkanoid;
import arkanoid.Pildora;
import arkanoid.PildoraRev;

public class Ahri extends Personaje {

	public Ahri(int id, String nombre, int vida, int fuerza) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.vida = vida;
		this.fuerza = fuerza;
	}

	/**
	 * 
	 */
	public void actua() {
		
		int numAtaques = ((int) Math.round(Math.random() * (3-1)))+1;
		for (int i = 1; i <= numAtaques; i++) {
			int random = ((int) Math.round(Math.random() * (3-1)))+1;
			if (random == 1) {
				Punetazo punetazo = new Punetazo(5);
				getAtaques().add(punetazo);
			} else if (random == 2) {
				Patada patada = new Patada(10);
				getAtaques().add(patada);
			} else {
				AtaqueEspecial AtacEsp = new AtaqueEspecial(25);
				getAtaques().add(AtacEsp);
			}
		}
		System.out.println("TURNO DE: " + this.nombre);
		for (Ataque ataque : getAtaques()) {
			if(Math.random() < 0.75) { //Probabilidad de 75% acierto
				System.out.println("Vida de " +  Main.getInstancia().getPersonajes()[1].getNombre() + ": " + Main.getInstancia().getPersonajes()[1].getVida());
				System.out.println(this.nombre+ " utiliza: " + ataque.getNombre() + " (" + (ataque.damage+this.fuerza) + ")");
				Main.getInstancia().getPersonajes()[1].setVida(Main.getInstancia().getPersonajes()[1].getVida()-(ataque.damage+this.fuerza));
				//System.out.println("Vida de " +  Main.getInstancia().getPersonajes()[1].getNombre() + ": " + Main.getInstancia().getPersonajes()[1].getVida());
				Main.getInstancia().tieneVida(Main.getInstancia().getPersonajes()[1]);
				if (Main.getInstancia().finDeJuego) {
					System.out.println("GANADORA: " + this.nombre);
					break;
				}
			} else {
				System.out.println(this.nombre + " ha fallado el ataque: " + ataque.getNombre());
			}
			
		}
		getAtaques().clear();
		Main.getInstancia().avanzaTurno();
	}
}
