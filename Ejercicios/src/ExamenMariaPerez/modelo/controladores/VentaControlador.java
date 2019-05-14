package ExamenMariaPerez.modelo.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import ExamenMariaPerez.modelo.Venta;
import awt_swing.JPA.Ejercicio_curso.modelo.ValoracionMateria;
import ExamenMariaPerez.modelo.Entidad;
import ExamenMariaPerez.modelo.Lote;



public class VentaControlador extends Controlador {

	
	private static VentaControlador controlador = null;
	
	/**
	 * 
	 * @param nombreEntidad
	 */
	public VentaControlador() {
		super("Venta");
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @return
	 */
	public static VentaControlador getControlador() {
		if(controlador == null) {
			controlador = new VentaControlador();
		}
		return controlador;
	}
	

	@Override
	public Venta findFirst() {
		return (Venta) super.findFirst();
	}

	@Override
	public Venta findLast() {
		return (Venta) super.findLast();
	}

	@Override
	public Venta findNext(Entidad e) {
		return (Venta) super.findNext(e);
	}

	@Override
	public Venta findPrevious(Entidad e) {
		return (Venta) super.findPrevious(e);
	}
	
	public List<Venta> findAllVentas() {
		List<Venta> resultado = new ArrayList<Venta>();
		for (Entidad e : super.findAll()) {
			resultado.add((Venta)e);
		}
		return resultado;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Venta> findByVentaAnulada (boolean anulada) {
		List<Venta> resultado = new ArrayList<Venta>();
		EntityManager em = null;
		try {
			em = getEntityManagerFactory().createEntityManager();
			Query q = em.createNativeQuery("SELECT * from venta where ventaAnulada = ?", Venta.class);
			q.setParameter(1, anulada);
			resultado.addAll((List<Venta>) q.getResultList());
		}
		catch (NoResultException nrEx) {
			return null;
		}
		em.close();
		return resultado;
	}
}
