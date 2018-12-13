package Ejercicios.Objetos.Bloque3.bloque01.ejercicio01;

import java.io.IOException;
import java.util.List;

import Ejercicios.Objetos.Bloque3.bloque01.Utils;

public class Main {

	public static void main(String[] args) {
		Editor editor = new Editor();
		
		
		do {
			List<String> palabras = editor.obtenerComandoUsuario();
			editor.procesaComandoUsuario(palabras);
			
		} while (true);
		
	}

	
	
	
}
