package examenMvS;

import javax.swing.JOptionPane;

public class Akali extends Personaje {

	public Akali(int id, String nombre, int vida, int fuerza) {
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
		JOptionPane.showMessageDialog(null, "TURNO DE: " + this.nombre, "Ahri vs Akali", 1);
		System.out.println("TURNO DE: " + this.nombre);
		for (Ataque ataque : getAtaques()) {
			if(Math.random() < 0.75) { //Probabilidad de 75% acierto
				JOptionPane.showMessageDialog(null, "Vida de " +  Main.getInstancia().getPersonajes()[0].getNombre() + ": " + Main.getInstancia().getPersonajes()[0].getVida() + "\n" + this.nombre+ " utiliza: " + ataque.getNombre() + " (" + (ataque.damage+this.fuerza) + ")", "Ahri vs Akali", 1);
				System.out.println("Vida de " +  Main.getInstancia().getPersonajes()[0].getNombre() + ": " + Main.getInstancia().getPersonajes()[0].getVida());
				System.out.println(this.nombre+ " utiliza: " + ataque.getNombre() + " (" + (ataque.damage+this.fuerza) + ")");
				Main.getInstancia().getPersonajes()[0].setVida(Main.getInstancia().getPersonajes()[0].getVida()-(ataque.damage+this.fuerza));
				//System.out.println("Vida de " +  Main.getInstancia().getPersonajes()[0].getNombre() + ": " + Main.getInstancia().getPersonajes()[0].getVida());
				Main.getInstancia().tieneVida(Main.getInstancia().getPersonajes()[0]);
				if (Main.getInstancia().finDeJuego) {
					JOptionPane.showMessageDialog(null, "GANADORA: " + this.nombre, "Ahri vs Akali", 1);
					System.out.println("GANADORA: " + this.nombre);
					return;
				}
			} else {
				JOptionPane.showMessageDialog(null, this.nombre + " ha fallado el ataque: " + ataque.getNombre(), "Ahri vs Akali", 1);
				System.out.println(this.nombre + " ha fallado el ataque: " + ataque.getNombre());
			}
		}
		getAtaques().clear();
		Main.getInstancia().avanzaTurno();

	}
}
