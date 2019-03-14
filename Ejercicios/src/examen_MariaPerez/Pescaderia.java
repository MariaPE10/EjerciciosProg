package examen_MariaPerez;

public class Pescaderia extends Articulo {

	private String color;

	/**
	 * @param identificador
	 * @param nombre
	 * @param cantidad
	 * @param precio
	 */
	public Pescaderia(String identificador, String nombre, int cantidad, float precio, String color) {
		super(identificador, nombre, cantidad, precio);
		this.color = color;
	}

	@Override
	public String getDescripcion() {
		//System.out.println("Id: "+ this.getIdentificador() + "\nNombre: " + this.getNombre() + "\nCantidad: " + this.getCantidad() + "\nPrecio: " + this.getPrecio() + "\nColor: " + this.color);
		return "Id: "+ this.getIdentificador() + "\nNombre: " + this.getNombre() + "\nCantidad: " + this.getCantidad() + "\nPrecio: " + this.getPrecio() + "\nColor: " + this.color;
	}
	
	
}
