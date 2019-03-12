package ejercicios.capitulo6.bloque7;

import javax.swing.JOptionPane;

import java.util.ArrayList;
/* Ejercicio 1: Crea un programa en Java que pida palabras, continuamente, al usuario.
 * Para cada palabra debes examinar sus caracteres buscando la cantidad de digitos numéricos
 * que existen. Crea una clase llamada "BuscaDigitos". Debes crear la estructura de listeners
 * y eventos necesarios para que, cuando la palabra introducida por el usuario contenga 3 dígitos,
 * la clase BuscaDigitos sea notificada de ese evento producido.
 */
import java.util.List;

public class Main {

	private static List<DigitoEncontradoListener> listeners = new ArrayList<DigitoEncontradoListener>();
	
	/**
	 * 
	 */
	public static void pidePalabra () {
		String palabra;
		
		do {
			int contador = 0;
			palabra = JOptionPane.showInputDialog("Introduzca una palabra");

			for (int i = 0; i < palabra.length(); i++){
			    char letra = palabra.charAt(i);
			    if(Character.isDigit(letra)) {
			    	contador++;
			    }
			}
			
			if (contador >= 3) {
				DigitoEncontradoEvent event = new DigitoEncontradoEvent(palabra);
				fireDigitoEncontradoListener(event);
			}
			
		}while(!palabra.trim().equals(""));
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BuscaDigitos b01 = new BuscaDigitos("01");
		pidePalabra();
	}

	/**
	 * 
	 * @param listener
	 */
	public static void addDigitoEncontradoListener(DigitoEncontradoListener listener) {
		listeners.add(listener);
	}
	
	/**
	 * 
	 * @param listener
	 */
	public static void removeDigitoEncontradoListener(DigitoEncontradoListener listener) {
		listeners.remove(listener);
	}
	
	/**
	 * 
	 * @param event
	 */
	public static void fireDigitoEncontradoListener(DigitoEncontradoEvent event) {
		for(DigitoEncontradoListener listener : listeners) {
			listener.digitoEncontradoListener(event);
		}
	}
}
