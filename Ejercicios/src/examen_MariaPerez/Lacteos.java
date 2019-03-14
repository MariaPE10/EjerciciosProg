package examen_MariaPerez;

public class Lacteos extends Articulo {

	private String tamanio;

	/**
	 * @param identificador
	 * @param nombre
	 * @param cantidad
	 * @param precio
	 */
	public Lacteos(String identificador, String nombre, int cantidad, float precio, String tamanio) {
		super(identificador, nombre, cantidad, precio);
		this.tamanio = tamanio;
	}

	@Override
	public String getDescripcion() {
		//System.out.println("Id: "+ this.getIdentificador() + "\nNombre: " + this.getNombre() + "\nCantidad: " + this.getCantidad() + "\nPrecio: " + this.getPrecio() + "\nTamanio: " + this.tamanio);
		return "Id: "+ this.getIdentificador() + "\nNombre: " + this.getNombre() + "\nCantidad: " + this.getCantidad() + "\nPrecio: " + this.getPrecio() + "\nTamanio: " + this.tamanio;
	}
	
	
}
