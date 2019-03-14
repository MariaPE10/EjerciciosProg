package examen_MariaPerez;

public class Perfumeria extends Articulo {

	private String aroma;

	/**
	 * @param identificador
	 * @param nombre
	 * @param cantidad
	 * @param precio
	 */
	public Perfumeria(String identificador, String nombre, int cantidad, float precio, String aroma) {
		super(identificador, nombre, cantidad, precio);
		this.aroma = aroma;
	}

	@Override
	public String getDescripcion() {
		//System.out.println("Id: "+ this.getIdentificador() + "\nNombre: " + this.getNombre() + "\nCantidad: " + this.getCantidad() + "\nPrecio: " + this.getPrecio() + "\nAroma: " + this.aroma);
		return "Id: "+ this.getIdentificador() + "\nNombre: " + this.getNombre() + "\nCantidad: " + this.getCantidad() + "\nPrecio: " + this.getPrecio() + "\nAroma: " + this.aroma;
	}
	
	
}
