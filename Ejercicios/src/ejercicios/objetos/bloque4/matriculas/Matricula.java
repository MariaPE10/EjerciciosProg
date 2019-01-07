package ejercicios.objetos.bloque4.matriculas;

public class Matricula {

	private String fechaMatricula;
	private String codigo;
	
	/**
	 * 
	 */
	public Matricula() {
		super();
	}

	/**
	 * 
	 * @param fechaMatricula
	 * @param codigo
	 */
	public Matricula(String fechaMatricula, String codigo) {
		super();
		this.fechaMatricula = fechaMatricula;
		this.codigo = codigo;
	}

	/**
	 * 
	 * @return
	 */
	public String getFechaMatricula() {
		return fechaMatricula;
	}
	public void setFechaMatricula(String fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}

	/**
	 * 
	 * @return
	 */
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	
}
