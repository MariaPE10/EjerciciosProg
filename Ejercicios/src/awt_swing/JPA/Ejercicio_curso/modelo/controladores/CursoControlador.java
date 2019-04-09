package awt_swing.JPA.Ejercicio_curso.modelo.controladores;

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
}
