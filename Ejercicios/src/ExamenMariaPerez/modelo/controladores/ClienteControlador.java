package ExamenMariaPerez.modelo.controladores;

import java.util.ArrayList;
import java.util.List;

import ExamenMariaPerez.modelo.Cliente;
import ExamenMariaPerez.modelo.Entidad;



public class ClienteControlador extends Controlador {

	
	private static ClienteControlador controlador = null;
	
	/**
	 * 
	 * @param nombreEntidad
	 */
	public ClienteControlador() {
		super("Cliente");
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @return
	 */
	public static ClienteControlador getControlador() {
		if(controlador == null) {
			controlador = new ClienteControlador();
		}
		return controlador;
	}
	

	@Override
	public Cliente findFirst() {
		return (Cliente) super.findFirst();
	}

	@Override
	public Cliente findLast() {
		return (Cliente) super.findLast();
	}

	@Override
	public Cliente findNext(Entidad e) {
		return (Cliente) super.findNext(e);
	}

	@Override
	public Cliente findPrevious(Entidad e) {
		return (Cliente) super.findPrevious(e);
	}
	
	public List<Cliente> findAllClientes() {
		List<Cliente> resultado = new ArrayList<Cliente>();
		for (Entidad e : super.findAll()) {
			resultado.add((Cliente)e);
		}
		return resultado;
	}
	
}
