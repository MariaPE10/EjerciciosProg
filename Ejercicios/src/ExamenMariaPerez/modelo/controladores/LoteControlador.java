package ExamenMariaPerez.modelo.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import ExamenMariaPerez.modelo.Lote;
import ExamenMariaPerez.modelo.Entidad;



public class LoteControlador extends Controlador {

	
	private static LoteControlador controlador = null;
	
	/**
	 * 
	 * @param nombreEntidad
	 */
	public LoteControlador() {
		super("Lote");
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @return
	 */
	public static LoteControlador getControlador() {
		if(controlador == null) {
			controlador = new LoteControlador();
		}
		return controlador;
	}
	

	@Override
	public Lote findFirst() {
		return (Lote) super.findFirst();
	}

	@Override
	public Lote findLast() {
		return (Lote) super.findLast();
	}

	@Override
	public Lote findNext(Entidad e) {
		return (Lote) super.findNext(e);
	}

	@Override
	public Lote findPrevious(Entidad e) {
		return (Lote) super.findPrevious(e);
	}
	
	public List<Lote> findAllLotes() {
		List<Lote> resultado = new ArrayList<Lote>();
		for (Entidad e : super.findAll()) {
			resultado.add((Lote)e);
		}
		return resultado;
	}
	
	/**
	 * 
	 * @return
	 */
	public Lote findById (int id) {
		Lote resultado = null;
		EntityManager em = null;
		try {
			em = getEntityManagerFactory().createEntityManager();
			Query q = em.createNativeQuery("SELECT * from lote where id = ?", Lote.class);
			q.setParameter(1, id);
			resultado = (Lote) q.setMaxResults(1).getSingleResult();
		}
		catch (NoResultException nrEx) {
			return null;
		}
		em.close();
		return resultado;
	}
}
