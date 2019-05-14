package ExamenMariaPerez.modelo.controladores;

import java.util.ArrayList;
import java.util.List;

import ExamenMariaPerez.modelo.Metodopago;
import ExamenMariaPerez.modelo.Entidad;



public class MetodoPagoControlador extends Controlador {

	
	private static MetodoPagoControlador controlador = null;
	
	/**
	 * 
	 * @param nombreEntidad
	 */
	public MetodoPagoControlador() {
		super("Metodopago");
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @return
	 */
	public static MetodoPagoControlador getControlador() {
		if(controlador == null) {
			controlador = new MetodoPagoControlador();
		}
		return controlador;
	}
	

	@Override
	public Metodopago findFirst() {
		return (Metodopago) super.findFirst();
	}

	@Override
	public Metodopago findLast() {
		return (Metodopago) super.findLast();
	}

	@Override
	public Metodopago findNext(Entidad e) {
		return (Metodopago) super.findNext(e);
	}

	@Override
	public Metodopago findPrevious(Entidad e) {
		return (Metodopago) super.findPrevious(e);
	}
	
	public List<Metodopago> findAllMetodopagos() {
		List<Metodopago> resultado = new ArrayList<Metodopago>();
		for (Entidad e : super.findAll()) {
			resultado.add((Metodopago)e);
		}
		return resultado;
	}
	
}
