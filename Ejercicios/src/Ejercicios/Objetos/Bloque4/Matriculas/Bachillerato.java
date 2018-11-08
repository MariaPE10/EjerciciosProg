package Ejercicios.Objetos.Bloque4.Matriculas;

public class Bachillerato extends Matricula {

	private String modalidad;

	/**
	 * 
	 */
	public Bachillerato() {
		super();
	}

	/**
	 * 
	 * @param modalidad
	 */
	public Bachillerato(String modalidad) {
		super();
		this.modalidad = modalidad;
	}

	/**
	 * 
	 * @return
	 */
	public String getModalidad() {
		return modalidad;
	}
	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	
}
