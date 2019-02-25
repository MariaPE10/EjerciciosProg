package ejercicios.capitulo6.listeners;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Main {

	static List<PalabraSecretaListener> palabrasSecretasIntroducidas = new ArrayList<PalabraSecretaListener>();
	
	/**
	 * 
	 * @param listener
	 */
	public static void addPalabraSecretaListener(PalabraSecretaListener listener) {
		palabrasSecretasIntroducidas.add(listener);
	}
	
	/**
	 * 
	 * @param listener
	 */
	public static void removePalabraSecretaListener(PalabraSecretaListener listener) {
		palabrasSecretasIntroducidas.remove(listener);
	}
	
	/**
	 * 
	 * @param e
	 */
	public static void firePalabraSecretaListener (PalabraSecretaEvent e) {
		for (PalabraSecretaListener listener : palabrasSecretasIntroducidas) {
			listener.palabraSecretaIntroducida(e);
		}
	}
	
	public static void main(String[] args) {
		addPalabraSecretaListener(new Maria());
		while (true) {
			String fraseIntroducida = JOptionPane.showInputDialog("Introduzca una palabra o frase: ");
			System.out.println(fraseIntroducida);
			if (fraseIntroducida.equalsIgnoreCase("avioneta") || fraseIntroducida.contains("avioneta")) {
				PalabraSecretaEvent event = new PalabraSecretaEvent(fraseIntroducida);
				firePalabraSecretaListener(event);
			}
		}

	}

}
