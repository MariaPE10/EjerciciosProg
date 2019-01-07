package ejercicios.objetos.bloque4.matriculas;

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
	 * @param fechaMatricula
	 * @param codigo
	 * @param modalidad
	 */
	public Bachillerato(String fechaMatricula, String codigo, String modalidad) {
		super(fechaMatricula, codigo);
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

	@Override
	public String toString() {
		return "\n\nMATRICULA BACHILLERATO \nModalidad: " + modalidad + "\nFecha de Matricula: " + getFechaMatricula()
				+ "\nCodigo: " + getCodigo();
	}

	
}
