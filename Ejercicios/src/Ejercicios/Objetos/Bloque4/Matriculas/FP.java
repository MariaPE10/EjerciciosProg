package Ejercicios.Objetos.Bloque4.Matriculas;

public class FP extends Matricula {

	private boolean dual;

	/**
	 * 
	 */
	public FP() {
		super();
	}

	/**
	 * 
	 * @param dual
	 */
	public FP(boolean dual) {
		super();
		this.dual = dual;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isDual() {
		return dual;
	}
	public void setDual(boolean dual) {
		this.dual = dual;
	}

	@Override
	public String toString() {
		String respuestaDual = " ";
		if (dual == true) {
			respuestaDual = "Si";
		} else {
			respuestaDual = "No";
		}
		return "\nMATRICULA DE FORMACION PROFESIONAL \nDual: " + respuestaDual + "\nFecha de Matricula: " + getFechaMatricula() 
				+ "\nCodigo: " + getCodigo();
	}

	
}
