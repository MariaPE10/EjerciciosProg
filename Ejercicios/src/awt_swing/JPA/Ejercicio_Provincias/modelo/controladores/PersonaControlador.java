package awt_swing.JPA.Ejercicio_Provincias.modelo.controladores;


import java.util.ArrayList;
import java.util.List;

import awt_swing.JPA.Ejercicio_Provincias.modelo.Persona;
import awt_swing.JPA.Ejercicio_Provincias.modelo.Entidad;

public class PersonaControlador extends Controlador {

	
	private static PersonaControlador controlador = null;
	
	/**
	 * 
	 * @param nombreEntidad
	 */
	public PersonaControlador() {
		super("Persona");
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @return
	 */
	public static PersonaControlador getControlador() {
		if(controlador == null) {
			controlador = new PersonaControlador();
		}
		return controlador;
	}
	

	@Override
	public Persona findFirst() {
		return (Persona) super.findFirst();
	}

	@Override
	public Persona findLast() {
		return (Persona) super.findLast();
	}

	@Override
	public Persona findNext(Entidad e) {
		return (Persona) super.findNext(e);
	}

	@Override
	public Persona findPrevious(Entidad e) {
		return (Persona) super.findPrevious(e);
	}

	
	public List<Persona> findAllPersonas() {
		List<Persona> resultado = new ArrayList<Persona>();
		for (Entidad e : super.findAll()) {
			resultado.add((Persona)e);
		}
		return resultado;
	}

}
