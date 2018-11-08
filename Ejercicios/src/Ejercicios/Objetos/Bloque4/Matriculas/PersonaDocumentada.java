package Ejercicios.Objetos.Bloque4.Matriculas;

public class PersonaDocumentada extends Persona {

	private String dni;

	/**
	 * 
	 */
	public PersonaDocumentada() {
		super();
	}

	/**
	 * 
	 * @param dni
	 */
	public PersonaDocumentada(String dni) {
		super();
		this.dni = dni;
	}

	/**
	 * 
	 * @return
	 */
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
}
