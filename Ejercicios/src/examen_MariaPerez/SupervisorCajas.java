package examen_MariaPerez;

public class SupervisorCajas extends ArticuloRechazadoAdapter {

	private String nombre;

	/**
	 * @param nombre
	 */
	public SupervisorCajas(String nombre) {
		super();
		this.nombre = nombre;
		Caja.addArticuloRechazadoListener(this);
	}
	
	public void articuloRechazadoListener(ArticuloRechazadoEvent event) {
		super.articuloRechazadoListener(event);
		System.out.println("Soy el supervisor de cajas " + this.nombre + " y se ha eliminado un articulo: "+ event.getArt().getNombre() +", en la fecha: " 
				+ event.getArt().getFecha());
	}
	
}
