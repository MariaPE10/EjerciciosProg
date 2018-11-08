package Ejercicios.Objetos.Bloque4.Matriculas;

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
		return "\nMATRICULA DE ESO \nPmar: " + respuestaPmar + "\nFecha de Matricula: " + getFechaMatricula() 
				+ "\nCodigo: " + getCodigo();
	}

	
}
