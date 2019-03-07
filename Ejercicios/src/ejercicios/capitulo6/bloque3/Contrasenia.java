package ejercicios.capitulo6.bloque3;

import javax.swing.JOptionPane;

/* Crear un programa que pida al usuario una contraseña con los siguientes requisitos:
         - Al menos una mayúscula.
         - Al menos una minúscula.
         - Al menos un dígito
         - Al menos un carácter no alfanumérico.
    El programa no terminará hasta que el usuario no introduzca la contraseña con estos requisitos.*/

public class Contrasenia {

	/**
	 * 
	 */
	public static void pedirContrasenia() {
		boolean mayus, minus, digito, noAlpha;
		do {
			mayus=false;
			minus=false;
			digito=false;
			noAlpha=false;
			String passUsuario = JOptionPane.showInputDialog("Introduzca una contraseña que cumpla los siguientes requisitos:"
					+ "\n - Al menos una mayúscula."
					+ "\n - Al menos una minúscula."
					+ "\n - Al menos un dígito."
					+ "\n - Al menos un carácter no alfanumérico.");
			
			char cadenaTexto[] = passUsuario.toCharArray();
			for (int i = 0; i < cadenaTexto.length; i++) {
				if (Character.isDigit(cadenaTexto[i])) {
					digito = true;
				}
				if (Character.isLowerCase(cadenaTexto[i])) {
					minus=true;
				}
				if (Character.isUpperCase(cadenaTexto[i])){
					mayus = true;
				}
				if (!Character.isLetterOrDigit(cadenaTexto[i])) {
					noAlpha=true;
				}
			}
		}while (!(mayus && minus && digito && noAlpha));
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		pedirContrasenia();
	}
}
