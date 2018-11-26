package Ejercicios.Objetos.Ahorcado;

import javax.swing.JOptionPane;

public class Principal { 

	public static void main(String[] args) {
		
		//Array de palabras posibles
		String palabras[] = new String[] {"Sepultura", "Jaula", "Olas", "Articulacion", "Negativo", "Inflacion", "Barro"};
		
		//Genera un numero aleatorio que será mi palabra aleatoria
//		int palabraAleatoria = (int) Math.round(Math.random()*(7));
		int indicePalabraAleatoria = 2;
		
		//Creacion de un array con la longitud de nuestra palabra aleatoria
		String palabraAleatoria = palabras[indicePalabraAleatoria];
		String coincidencias[]= new String [palabraAleatoria.length()];
		
		
		//Imprime la palabra aleatoria oculta 
		Palabra.ImprimePalabraOculta(coincidencias);
		 
		//Pide al usuario la palabra
		String palabraUsuario = String.valueOf(JOptionPane.showInputDialog(null, "Introduzca el caracter o la palabra buscada"));
//		Palabra.ComparaCaracteres(palabraUsuario, palabraAleatoria, coincidencias);
//		
	}

}
