package examen_MariaPerez;

public class Pasteleria extends Articulo {

	private String sabor;

	/**
	 * @param identificador
	 * @param nombre
	 * @param cantidad
	 * @param precio
	 */
	public Pasteleria(String identificador, String nombre, int cantidad, float precio, String sabor) {
		super(identificador, nombre, cantidad, precio);
		this.sabor = sabor;
	}

	@Override
	public String getDescripcion() {
		//System.out.println("Id: "+ this.getIdentificador() + "\nNombre: " + this.getNombre() + "\nCantidad: " + this.getCantidad() + "\nPrecio: " + this.getPrecio() + "\nSabor: " + this.sabor);
		return "Id: "+ this.getIdentificador() + "\nNombre: " + this.getNombre() + "\nCantidad: " + this.getCantidad() + "\nPrecio: " + this.getPrecio() + "\nSabor: " + this.sabor;
	}
	
	
}
