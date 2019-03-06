package ejercicios.capitulo6.exception.ejercicio2;

import java.util.Scanner;

import javax.swing.JOptionPane;


/*Realiza un programa Java parecido al anterior en el que pidas al usuario una frase que contenga la palabra "bombilla". 
 * Las excepciones, creadas por ti, deben realizarse en los siguientes casos:
    - La frase introducida no tiene caracteres distintos al espacio en blanco.
    - La cantidad de palabras de la frase introducida es inferior a 3.
    - En la frase no aparece la palabra "bombilla".
    - En la frase aparece una palabra ofensiva de la siguiente relación: "tonto", "tonta", "idiota".
   Cada uno de los supuestos anteriores provocará un tipo diferente de excepción. Tú debes controlar todos los tipos y responder al usuario con un	mensaje adecuado.*/
public class peticionFrase {

	public static String pedirFraseBombilla() throws EspacioBlancoException, MenosDeTresPalabrasException, NoApareceBombillaException, PalabraOfensivaException {
		String fraseUsuario = JOptionPane.showInputDialog("Introduzca una frase");
		String[] palabras = fraseUsuario.split(" ");
		
		//La frase no tiene espacios en blanco
		if ((fraseUsuario.toLowerCase().trim()).isEmpty()) {
			throw new EspacioBlancoException();
		}
		//La frase tiene menos de 3 palabras
		if (palabras.length<3) {
			throw new MenosDeTresPalabrasException();
		}
		//La frase no contiene bombilla
		if (!fraseUsuario.toLowerCase().contains("bombilla")) {
			throw new NoApareceBombillaException();
		}
		
		//La frase contiene una frase ofensiva
		if (fraseUsuario.toLowerCase().contains("tonto") || fraseUsuario.toLowerCase().contains("tonta") ||fraseUsuario.toLowerCase().contains("idiota")) {
			throw new PalabraOfensivaException();
		}

		return fraseUsuario;
	}
	
	public static void main(String[] args) {
			String frase;
			try {
				frase = pedirFraseBombilla();
				System.out.println("Frase del usuario: " + frase);
			}catch (EspacioBlancoException e) {
				System.out.println("No has introducido una frase");
			}catch (MenosDeTresPalabrasException e) {
				System.out.println("Has introducido una frase muy corta");
			} catch (NoApareceBombillaException e) {
				System.out.println("La palabra bombilla no aparece");
			} catch (PalabraOfensivaException e) {
				System.out.println("Has introducido una palabra ofensiva, por favor cuida tu lenguaje!!");
			}
			
	}
}
