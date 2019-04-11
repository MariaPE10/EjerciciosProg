package awt_swing.JPA.Ejercicio_curso.modelo.controladores;

import awt_swing.JPA.Ejercicio_curso.modelo.Materia;
import awt_swing.JPA.Ejercicio_curso.modelo.Entidad;

public class MateriaControlador extends Controlador {

	
	private static MateriaControlador controlador = null;
	
	/**
	 * 
	 * @param nombreEntidad
	 */
	public MateriaControlador() {
		super("Materia");
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @return
	 */
	public static MateriaControlador getControlador() {
		if(controlador == null) {
			controlador = new MateriaControlador();
		}
		return controlador;
	}
	

	@Override
	public Materia findFirst() {
		return (Materia) super.findFirst();
	}

	@Override
	public Materia findLast() {
		return (Materia) super.findLast();
	}

	@Override
	public Materia findNext(Entidad e) {
		return (Materia) super.findNext(e);
	}

	@Override
	public Materia findPrevious(Entidad e) {
		return (Materia) super.findPrevious(e);
	}
	
}
