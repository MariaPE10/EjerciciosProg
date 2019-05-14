package ExamenMariaPerez.modelo.controladores;

import java.util.ArrayList;
import java.util.List;

import ExamenMariaPerez.modelo.Provincia;
import ExamenMariaPerez.modelo.Entidad;



public class ProvinciaControlador extends Controlador {

	
	private static ProvinciaControlador controlador = null;
	
	/**
	 * 
	 * @param nombreEntidad
	 */
	public ProvinciaControlador() {
		super("Provincia");
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @return
	 */
	public static ProvinciaControlador getControlador() {
		if(controlador == null) {
			controlador = new ProvinciaControlador();
		}
		return controlador;
	}
	

	@Override
	public Provincia findFirst() {
		return (Provincia) super.findFirst();
	}

	@Override
	public Provincia findLast() {
		return (Provincia) super.findLast();
	}

	@Override
	public Provincia findNext(Entidad e) {
		return (Provincia) super.findNext(e);
	}

	@Override
	public Provincia findPrevious(Entidad e) {
		return (Provincia) super.findPrevious(e);
	}
	
	public List<Provincia> findAllProvincias() {
		List<Provincia> resultado = new ArrayList<Provincia>();
		for (Entidad e : super.findAll()) {
			resultado.add((Provincia)e);
		}
		return resultado;
	}
	
}
