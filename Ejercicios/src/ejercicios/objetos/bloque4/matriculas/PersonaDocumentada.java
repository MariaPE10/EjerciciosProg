package ejercicios.objetos.bloque4.matriculas;

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
	 * @param nombre
	 * @param apellidos
	 * @param fechaNacimiento
	 * @param dni
	 */
	public PersonaDocumentada(String nombre, String apellidos, String fechaNacimiento, String dni) {
		super(nombre, apellidos, fechaNacimiento);
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
	
	@Override
	public String toString() {
		return "ALUMNO \nDNI: " + dni + "\nNombre: " + getNombre() + "\nApellidos: " + getApellidos()
				+ "\nFecha de Nacimiento: " + getFechaNacimiento();
	}
}
