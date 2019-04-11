package awt_swing.JPA.Ejercicio_curso.modelo.controladores;


import java.util.ArrayList;
import java.util.List;

import awt_swing.JPA.Ejercicio_curso.modelo.Curso;
import awt_swing.JPA.Ejercicio_curso.modelo.Entidad;

public class CursoControlador extends Controlador {

	
	private static CursoControlador controlador = null;
	
	/**
	 * 
	 * @param nombreEntidad
	 */
	public CursoControlador() {
		super("Curso");
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @return
	 */
	public static CursoControlador getControlador() {
		if(controlador == null) {
			controlador = new CursoControlador();
		}
		return controlador;
	}
	

	@Override
	public Curso findFirst() {
		return (Curso) super.findFirst();
	}

	@Override
	public Curso findLast() {
		return (Curso) super.findLast();
	}

	@Override
	public Curso findNext(Entidad e) {
		return (Curso) super.findNext(e);
	}

	@Override
	public Curso findPrevious(Entidad e) {
		return (Curso) super.findPrevious(e);
	}

	
	public List<Curso> findAllCursos() {
		List<Curso> resultado = new ArrayList<Curso>();
		for (Entidad e : super.findAll()) {
			resultado.add((Curso)e);
		}
		return resultado;
	}

}
