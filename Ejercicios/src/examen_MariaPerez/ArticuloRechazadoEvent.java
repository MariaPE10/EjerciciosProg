package examen_MariaPerez;

public class ArticuloRechazadoEvent {

	private Articulo art;

	/**
	 * @param art
	 */
	public ArticuloRechazadoEvent(Articulo art) {
		super();
		this.art = art;
	}

	/**
	 * @return the art
	 */
	public Articulo getArt() {
		return art;
	}
	
	
}
