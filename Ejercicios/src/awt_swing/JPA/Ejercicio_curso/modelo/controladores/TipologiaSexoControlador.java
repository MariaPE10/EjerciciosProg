package awt_swing.JPA.Ejercicio_curso.modelo.controladores;


import java.util.ArrayList;
import java.util.List;

import awt_swing.JPA.Ejercicio_curso.modelo.TipologiaSexo;
import awt_swing.JPA.Ejercicio_curso.modelo.Entidad;

public class TipologiaSexoControlador extends Controlador {

	
	private static TipologiaSexoControlador controlador = null;
	
	/**
	 * 
	 * @param nombreEntidad
	 */
	public TipologiaSexoControlador() {
		super("TipologiaSexo");
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @return
	 */
	public static TipologiaSexoControlador getControlador() {
		if(controlador == null) {
			controlador = new TipologiaSexoControlador();
		}
		return controlador;
	}
	

	@Override
	public TipologiaSexo findFirst() {
		return (TipologiaSexo) super.findFirst();
	}

	@Override
	public TipologiaSexo findLast() {
		return (TipologiaSexo) super.findLast();
	}

	@Override
	public TipologiaSexo findNext(Entidad e) {
		return (TipologiaSexo) super.findNext(e);
	}

	@Override
	public TipologiaSexo findPrevious(Entidad e) {
		return (TipologiaSexo) super.findPrevious(e);
	}

	
	public List<TipologiaSexo> findAllTipologiaSexos() {
		List<TipologiaSexo> resultado = new ArrayList<TipologiaSexo>();
		for (Entidad e : super.findAll()) {
			resultado.add((TipologiaSexo)e);
		}
		return resultado;
	}

}
