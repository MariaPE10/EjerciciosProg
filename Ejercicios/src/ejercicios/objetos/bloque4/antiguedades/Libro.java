package ejercicios.objetos.bloque4.antiguedades;

public class Libro extends Antiguedad {

	private String autor;
	private String titulo;
	
	/**
	 * Crear el constructor por defecto e inicializa el atributo especifico de la clase.
	 */
	public Libro() {
		super();
		autor ="Sin especificar";
		titulo = "Sin especificar";
	}

	/**
	 * Constructor que inicialza los atributos de la clase padre y tambien el atributo especifico de la clase hija.
	 * @param anioFabricacion
	 * @param origen
	 * @param precio
	 * @param autor
	 * @param titulo
	 */
	public Libro(int anioFabricacion, String origen, float precio, String autor, String titulo) {
		super(anioFabricacion, origen, precio);
		this.autor = autor;
		this.titulo = titulo;
	}

	/**
	 * 
	 * @param autor
	 * @param titulo
	 */
	public Libro(String autor, String titulo) {
		super();
		this.autor = autor;
		this.titulo = titulo;
	}

	/**
	 * 
	 * @return
	 */
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}

	/**
	 * 
	 * @return
	 */
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		String toStringSuper = super.toString();
		return "LIBRO \nAutor: " + autor + "\nTitulo: " + titulo + "\n" + toStringSuper;
	}
	
	
	
}
