package ExamenMariaPerez.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the lote database table.
 * 
 */
@Entity
@Table(name="lote")
@NamedQuery(name="Lote.findAll", query="SELECT l FROM Lote l")
public class Lote extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String color;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRecepcion;

	private int unidadesStock;

	//bi-directional many-to-one association to Distribuidor
	@ManyToOne
	@JoinColumn(name="idDistribuidor")
	private Distribuidor distribuidor;

	//bi-directional many-to-one association to Tipoarticulo
	@ManyToOne
	@JoinColumn(name="idTipoArticulo")
	private Tipoarticulo tipoarticulo;

	//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="lote")
	private List<Venta> ventas;

	public Lote() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Date getFechaRecepcion() {
		return this.fechaRecepcion;
	}

	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public int getUnidadesStock() {
		return this.unidadesStock;
	}

	public void setUnidadesStock(int unidadesStock) {
		this.unidadesStock = unidadesStock;
	}

	public Distribuidor getDistribuidor() {
		return this.distribuidor;
	}

	public void setDistribuidor(Distribuidor distribuidor) {
		this.distribuidor = distribuidor;
	}

	public Tipoarticulo getTipoarticulo() {
		return this.tipoarticulo;
	}

	public void setTipoarticulo(Tipoarticulo tipoarticulo) {
		this.tipoarticulo = tipoarticulo;
	}

	public List<Venta> getVentas() {
		return this.ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public Venta addVenta(Venta venta) {
		getVentas().add(venta);
		venta.setLote(this);

		return venta;
	}

	public Venta removeVenta(Venta venta) {
		getVentas().remove(venta);
		venta.setLote(null);

		return venta;
	}

}