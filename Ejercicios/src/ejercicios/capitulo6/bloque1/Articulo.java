package ejercicios.capitulo6.bloque1;

public class Articulo {

	private String codigo;
	private String estante;
	private String descripcion;
	
	/**
	 * @param codigo
	 * @param estante
	 * @param descripcion
	 */
	public Articulo(String codigo, String estante, String descripcion) {
		super();
		this.codigo = codigo;
		this.estante = estante;
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "CodigoBarras: " + this.codigo + " - Estante: " + this.estante + " - Descripcion: " + this.descripcion;
	}

	/**
	 * @return the estante
	 */
	public String getEstante() {
		return estante;
	}

	/**
	 * @param estante the estante to set
	 */
	public void setEstante(String estante) {
		this.estante = estante;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
