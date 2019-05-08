package awt_swing.JPA.Ejercicio_curso.modelo.controladores;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import awt_swing.JPA.Ejercicio_curso.modelo.Curso;
import awt_swing.JPA.Ejercicio_curso.modelo.Entidad;
import awt_swing.JPA.Ejercicio_curso.modelo.ValoracionMateria;

public class ValoracionMateriaControlador extends Controlador {

	
	private static ValoracionMateriaControlador controlador = null;
	
	/**
	 * 
	 * @param nombreEntidad
	 */
	public ValoracionMateriaControlador() {
		super("valoracionmateria");
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @return
	 */
	public static ValoracionMateriaControlador getControlador() {
		if(controlador == null) {
			controlador = new ValoracionMateriaControlador();
		}
		return controlador;
	}
	

	@Override
	public ValoracionMateria findFirst() {
		return (ValoracionMateria) super.findFirst();
	}

	@Override
	public ValoracionMateria findLast() {
		return (ValoracionMateria) super.findLast();
	}

	@Override
	public ValoracionMateria findNext(Entidad e) {
		return (ValoracionMateria) super.findNext(e);
	}

	@Override
	public ValoracionMateria findPrevious(Entidad e) {
		return (ValoracionMateria) super.findPrevious(e);
	}

	
	public List<ValoracionMateria> findAllValoracionMaterias() {
		List<ValoracionMateria> resultado = new ArrayList<ValoracionMateria>();
		for (Entidad e : super.findAll()) {
			resultado.add((ValoracionMateria)e);
		}
		return resultado;
	}

	
	/**
	 * 
	 * @return
	 */
	public ValoracionMateria findByProfesorAndMateriaAndEstudiante (ValoracionMateria vm) {
		ValoracionMateria resultado = null;
		EntityManager em = null;
		try {
			em = getEntityManagerFactory().createEntityManager();
			Query q = em.createNativeQuery("SELECT * from valoracionMateria where idProfesor = ? and idEstudiante = ? and idMateria = ?", ValoracionMateria.class);
			q.setParameter(1, vm.getProfesor().getId());
			q.setParameter(2, vm.getEstudiante().getId());
			q.setParameter(3, vm.getMateria().getId());
			resultado = (ValoracionMateria) q.setMaxResults(1).getSingleResult();
		}
		catch (NoResultException nrEx) {
			return null;
		}
		em.close();
		return resultado;
	}
	

}
