package ejercicios.objetos.bloque4.matriculas;

public class ESO extends Matricula {

	private boolean pmar;

	/**
	 * 
	 */
	public ESO() {
		super();
	}

	/**
	 * 
	 * @param pmar
	 */
	public ESO(boolean pmar) {
		super();
		this.pmar = pmar;
	}
	
	/**
	 * @param fechaMatricula
	 * @param codigo
	 * @param pmar
	 */
	public ESO(String fechaMatricula, String codigo, boolean pmar) {
		super(fechaMatricula, codigo);
		this.pmar = pmar;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isPmar() {
		return pmar;
	}
	public void setPmar(boolean pmar) {
		this.pmar = pmar;
	}

	@Override
	public String toString() {
		String respuestaPmar = " ";
		if (pmar == true) {
			respuestaPmar = "Si";
		} else {
			respuestaPmar = "No";
		}
		return "\n\nMATRICULA DE ESO \nPmar: " + respuestaPmar + "\nFecha de Matricula: " + getFechaMatricula() 
				+ "\nCodigo: " + getCodigo();
	}

	
}
