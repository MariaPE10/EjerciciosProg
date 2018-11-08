package Ejercicios.Objetos.Bloque4.Matriculas;

public class Persona {
	
	private String nombre;
	private String apellidos;
	private String fechaNacimiento;
	
	/**
	 * 
	 */
	public Persona() {
		super();
	}

	/**
	 * 
	 * @param nombre
	 * @param apellidos
	 * @param fechaNacimiento
	 */
	public Persona(String nombre, String apellidos, String fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return
	 */
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * 
	 * @return
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
}
