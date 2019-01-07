package ejercicios.objetos.bloque4.matriculas;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		int respuesta3;
		int opcion, opcion2;
		
		String menuMatricula = "Que tipo de matricula deseas?\n"
				+ "1.- ESO\n"
				+ "2.- Bachillerato\n"
				+ "3.- Formacion Profesional\n"
				+ "0.- Salir de la aplicacion.";
		String menuModalidad = "Introduzca la modalidad\n"
				+ "1.- Ciencias\n"
				+ "2.- Artes\n"
				+ "3.- Tecnologia\n"
				+ "4.- Sociales";
		
		//Se "crea" un objeto de tipo Persona y se declara null (vacio), para guardar el hueco en la memoria (sin crear un objeto
		// que ocupe un espacio en la memoria y posteriormente no usaremos para nada, ya que la variable persona es un 
		// puntero que apunta a una direccion de memora en la que se encuentra dicho objeto).
		Persona persona = null;
		
		opcion = JOptionPane.showConfirmDialog(null,"-DNI Requerido","Tiene documentacion?", JOptionPane.YES_NO_OPTION);
		
		if (opcion == JOptionPane.YES_OPTION) { //Persona documentada
			persona = new PersonaDocumentada();
			((PersonaDocumentada)persona).setDni(JOptionPane.showInputDialog("Introduzca su DNI"));
		} else { //Persona sin documentacion
			persona = new PersonaNoDocumentada();
			((PersonaNoDocumentada)persona).setDescripcion(JOptionPane.showInputDialog("Introduzca una descripcion"));
		}
		
		/* ################################FORMA DE HACERLO CON UN SWITCH########################################
		 
	   	String menuPersona = "Que tipo de persona eres?\n"
			+ "1.- Documentada\n"
			+ "2.- No documentada\n"
			+ "0.- Salir de la aplicacion.";
		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(menuPersona));
			
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
				((PersonaNoDocumentada)persona).setDescripcion(JOptionPane.showInputDialog("Introduzca una descripcion"));
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opcion Incorrecta");
			}
		} while (opcion > 3 || opcion < 0);
		*/
		
		persona.setNombre(JOptionPane.showInputDialog("Introduzca su nombre"));
		persona.setApellidos(JOptionPane.showInputDialog("Introduzca sus apellidos"));
		persona.setFechaNacimiento(JOptionPane.showInputDialog("Introduzca su fecha de nacimiento"));
		
		//Se crea un objeto de tipo Matricula y se declara null, para guardar el hueco en la memoria (evita error)
		Matricula matricula = null;
		do {
			opcion2 = Integer.parseInt(JOptionPane.showInputDialog(menuMatricula));
			
			switch (opcion2) {
			case 0:
				System.exit(0); // Acaba radicalmente con la ejecucion
				break;
			case 1: //ESO
				matricula = new ESO();
				int respuesta = JOptionPane.showConfirmDialog(null,"Pmar\nPrograma de mejora de aprendizaje y rendimiento","Desea opcion PMAR?", JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_OPTION) {
					((ESO)matricula).setPmar(true);
				} else {
					((ESO)matricula).setPmar(false);
				}
				break;
			case 2: //Bachillerato
				matricula = new Bachillerato();
				
				do {
					respuesta3 =Integer.parseInt(JOptionPane.showInputDialog(menuModalidad));
					if (respuesta3 == 1) {
						((Bachillerato)matricula).setModalidad("Ciencias");
					} else if (respuesta3 == 2){
						((Bachillerato)matricula).setModalidad("Artes");
					} else if (respuesta3 == 3 ) {
						((Bachillerato)matricula).setModalidad("Tecnologia");
					} else if (respuesta3 == 4) {
						((Bachillerato)matricula).setModalidad("Sociales");
					} else {
						JOptionPane.showMessageDialog(null, "Opcion Incorrecta");
					}
				}while (respuesta3 < 0 || respuesta3 > 5);
				break;
			case 3: //FP
				matricula = new FP();
				int respuesta2 = JOptionPane.showConfirmDialog(null,"Dual\nAlternancia entre el centro educativo y la empresa","Opcio DUAL?", JOptionPane.YES_NO_OPTION);
				if (respuesta2 == JOptionPane.YES_OPTION) {
					((FP)matricula).setDual(true);
				} else {
					((FP)matricula).setDual(false);
				}
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opcion Incorrecta");
			}
		} while (opcion2 > 4 || opcion2 < 0);
		
		matricula.setCodigo(JOptionPane.showInputDialog("Introduzca el codigo de la matricula"));
		matricula.setFechaMatricula(JOptionPane.showInputDialog("Introduzca la fecha de la matricula"));
		
		//##############################IMPRESION DE DATOS##############################
		
		JOptionPane.showMessageDialog(null, persona.toString() + matricula.toString());
	}
}
