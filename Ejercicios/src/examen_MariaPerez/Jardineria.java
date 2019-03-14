package examen_MariaPerez;

public class Jardineria extends Articulo {

	private String especie;

	/**
	 * @param identificador
	 * @param nombre
	 * @param cantidad
	 * @param precio
	 */
	public Jardineria(String identificador, String nombre, int cantidad, float precio, String especie) {
		super(identificador, nombre, cantidad, precio);
		this.especie = especie;
	}

	@Override
	public String getDescripcion() {
		//System.out.println("Id: "+ this.getIdentificador() + "\nNombre: " + this.getNombre() + "\nCantidad: " + this.getCantidad() + "\nPrecio: " + this.getPrecio() + "\nEspecie: " + this.especie);
		return "Id: "+ this.getIdentificador() + "\nNombre: " + this.getNombre() + "\nCantidad: " + this.getCantidad() + "\nPrecio: " + this.getPrecio() + "\nEspecie: " + this.especie;
	}
	
	
}
