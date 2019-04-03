package awt_swing.ejercicio3_BBDDRegistroCoches_JDBC.modelo.entidades;

import java.util.Date;

public class Venta {

	private int id;
	private int idCliente;
	private int idConcesionario;
	private int idCoche;
	private Date fecha;
	private float precioVenta;
	/**
	 * 
	 */
	public Venta() {
		super();
	}
	/**
	 * @param id
	 * @param idCliente
	 * @param idConcesionario
	 * @param idCoche
	 * @param fecha
	 * @param precioVenta
	 */
	public Venta(int id, int idCliente, int idConcesionario, int idCoche, Date fecha, float precioVenta) {
		super();
		this.id = id;
		this.idCliente = idCliente;
		this.idConcesionario = idConcesionario;
		this.idCoche = idCoche;
		this.fecha = fecha;
		this.precioVenta = precioVenta;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the idCliente
	 */
	public int getIdCliente() {
		return idCliente;
	}
	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	/**
	 * @return the idConcesionario
	 */
	public int getIdConcesionario() {
		return idConcesionario;
	}
	/**
	 * @param idConcesionario the idConcesionario to set
	 */
	public void setIdConcesionario(int idConcesionario) {
		this.idConcesionario = idConcesionario;
	}
	/**
	 * @return the idCoche
	 */
	public int getIdCoche() {
		return idCoche;
	}
	/**
	 * @param idCoche the idCoche to set
	 */
	public void setIdCoche(int idCoche) {
		this.idCoche = idCoche;
	}
	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	/**
	 * @return the precioVenta
	 */
	public float getPrecioVenta() {
		return precioVenta;
	}
	/**
	 * @param precioVenta the precioVenta to set
	 */
	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}
	
	
}
