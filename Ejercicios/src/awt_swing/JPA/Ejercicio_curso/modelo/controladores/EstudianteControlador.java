package awt_swing.JPA.Ejercicio_curso.modelo.controladores;

import awt_swing.JPA.Ejercicio_curso.modelo.Estudiante;
import awt_swing.JPA.Ejercicio_curso.modelo.Entidad;

public class EstudianteControlador extends Controlador {

	
	private static EstudianteControlador controlador = null;
	
	/**
	 * 
	 * @param nombreEntidad
	 */
	public EstudianteControlador() {
		super("Estudiante");
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @return
	 */
	public static EstudianteControlador getControlador() {
		if(controlador == null) {
			controlador = new EstudianteControlador();
		}
		return controlador;
	}
	

	@Override
	public Estudiante findFirst() {
		return (Estudiante) super.findFirst();
	}

	@Override
	public Estudiante findLast() {
		return (Estudiante) super.findLast();
	}

	@Override
	public Estudiante findNext(Entidad e) {
		return (Estudiante) super.findNext(e);
	}

	@Override
	public Estudiante findPrevious(Entidad e) {
		return (Estudiante) super.findPrevious(e);
	}
	
}
