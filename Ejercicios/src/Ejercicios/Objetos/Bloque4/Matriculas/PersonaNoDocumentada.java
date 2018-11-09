package Ejercicios.Objetos.Bloque4.Matriculas;

public class PersonaNoDocumentada extends Persona {

	private String descripcion;

	/**
	 * 
	 */
	public PersonaNoDocumentada() {
		super();
	}

	/**
	 * @param descripcion
	 */
	public PersonaNoDocumentada(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	/**
	 * @param nombre
	 * @param apellidos
	 * @param fechaNacimiento
	 * @param descripcion
	 */
	public PersonaNoDocumentada(String nombre, String apellidos, String fechaNacimiento, String descripcion) {
		super(nombre, apellidos, fechaNacimiento);
		this.descripcion = descripcion;
	}

	/**
	 * 
	 * @return
	 */
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "ALUMNO \nDescripcion: " + descripcion + "\nNombre: " + getNombre() + "\nApellidos: " + getApellidos()
		+ "\nFecha de Nacimiento: " + getFechaNacimiento();
	}

	
}
