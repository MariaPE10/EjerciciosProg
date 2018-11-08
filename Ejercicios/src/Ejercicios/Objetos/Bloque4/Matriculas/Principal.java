package Ejercicios.Objetos.Bloque4.Matriculas;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		int opcion, opcion2;
		String menu = "Que tipo de persona eres?\n"
				+ "1.- Documentada\n"
				+ "2.- No documentada\n"
				+ "0.- Salir de la aplicacion.";
		String menu2 = "Que tipo de matricula deseas?\n"
				+ "1.- ESO\n"
				+ "2.- Bachillerato\n"
				+ "3.- Formacion Profesional\n"
				+ "0.- Salir de la aplicacion.";
		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
			Persona persona = null;
			
			switch (opcion) {
			case 0:
				System.exit(0); // Acaba radicalmente con la ejecucion
				break;
			case 1: //Documentada
				persona = new PersonaDocumentada();
				((PersonaDocumentada)persona).setDni(JOptionPane.showInputDialog("Introduzca su DNI"));
				break;
			case 2: //No documentada
				persona = new PersonaNoDocumentada();
				((PersonaNoDocumentada)persona).setDescripcion(JOptionPane.showInputDialog("Introduzca su DNI"));
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opcion Incorrecta");
			}
		} while (opcion > 3 || opcion < 0);
		
		do {
			opcion2 = Integer.parseInt(JOptionPane.showInputDialog(menu2));
			
			
			switch (opcion) {
			case 0:
				System.exit(0); // Acaba radicalmente con la ejecucion
				break;
			case 1: //ESO
				
				break;
			case 2: //Bachillerato
				
				break;
			case 3: //FP
				
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opcion Incorrecta");
			}
		} while (opcion > 4 || opcion < 0);
	}
}
