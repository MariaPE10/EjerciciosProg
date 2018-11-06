package Ejercicios.Objetos.Bloque4.Antiguedades;

public class Libros extends Antiguedad {

	private String autor;
	private String titulo;
	
	/**
	 * 
	 */
	public Libros() {
		super();
	}

	/**
	 * 
	 * @param autor
	 * @param titulo
	 */
	public Libros(String autor, String titulo) {
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
	
	
	
}
