package ejercicios.capitulo6.bloque7;

import java.util.ArrayList;
import java.util.List;

public class DigitoEncontradoEvent {
	
	private String palabra;
	private List<Integer> digitosEncontrados = new ArrayList<Integer>(); 
	
	/**
	 * @param palabra
	 */
	public DigitoEncontradoEvent(String palabra, List<Integer> digitosEncontrados) {
		super();
		this.palabra = palabra;
		this.digitosEncontrados = digitosEncontrados;
	}

	/**
	 * @return the digitosEncontrados
	 */
	public List<Integer> getDigitosEncontrados() {
		return digitosEncontrados;
	}

	/**
	 * @return the palabra
	 */
	public String getPalabra() {
		return palabra;
	}
	
	

}
