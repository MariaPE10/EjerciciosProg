package ExamenMariaPerez.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipoarticulo database table.
 * 
 */
@Entity
@Table(name="tipoarticulo")
@NamedQuery(name="Tipoarticulo.findAll", query="SELECT t FROM Tipoarticulo t")
public class Tipoarticulo extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to Lote
	@OneToMany(mappedBy="tipoarticulo")
	private List<Lote> lotes;

	public Tipoarticulo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Lote> getLotes() {
		return this.lotes;
	}

	public void setLotes(List<Lote> lotes) {
		this.lotes = lotes;
	}

	public Lote addLote(Lote lote) {
		getLotes().add(lote);
		lote.setTipoarticulo(this);

		return lote;
	}

	public Lote removeLote(Lote lote) {
		getLotes().remove(lote);
		lote.setTipoarticulo(null);

		return lote;
	}

}