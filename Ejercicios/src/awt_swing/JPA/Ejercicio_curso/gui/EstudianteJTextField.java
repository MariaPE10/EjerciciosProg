package awt_swing.JPA.Ejercicio_curso.gui;

import javax.swing.JTextField;

import awt_swing.JPA.Ejercicio_curso.modelo.Estudiante;

public class EstudianteJTextField extends JTextField {
	
	private Estudiante estudiante;

	/**
	 * @param estud
	 */
	public EstudianteJTextField(Estudiante estudiante) {
		super();
		this.estudiante = estudiante;
		this.setColumns(5);
	}

	/**
	 * @return the estudiante
	 */
	public Estudiante getEstudiante() {
		return estudiante;
	}
	
	

}
