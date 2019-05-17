package awt_swing.JPA.Ejercicio_curso.modelo.controladores;

import awt_swing.JPA.Ejercicio_curso.modelo.Profesor;

import java.util.ArrayList;
import java.util.List;

import awt_swing.JPA.Ejercicio_curso.modelo.Entidad;

public class ProfesorControlador extends Controlador {

	
	private static ProfesorControlador controlador = null;
	
	/**
	 * 
	 * @param nombreEntidad
	 */
	public ProfesorControlador() {
		super("Profesor");
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @return
	 */
	public static ProfesorControlador getControlador() {
		if(controlador == null) {
			controlador = new ProfesorControlador();
		}
		return controlador;
	}
	

	@Override
	public Profesor findFirst() {
		return (Profesor) super.findFirst();
	}

	@Override
	public Profesor findLast() {
		return (Profesor) super.findLast();
	}

	@Override
	public Profesor findNext(Entidad e) {
		return (Profesor) super.findNext(e);
	}

	@Override
	public Profesor findPrevious(Entidad e) {
		return (Profesor) super.findPrevious(e);
	}
	
	public List<Profesor> findAllProfesores() {
		List<Profesor> resultado = new ArrayList<Profesor>();
		for (Entidad e : super.findAll()) {
			resultado.add((Profesor)e);
		}
		return resultado;
	}
}
