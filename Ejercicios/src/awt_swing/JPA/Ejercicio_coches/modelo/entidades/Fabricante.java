package awt_swing.JPA.Ejercicio_coches.modelo.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the fabricante database table.
 * 
 */
@Entity
@Table(name="fabricante")
@NamedQuery(name="Fabricante.findAll", query="SELECT f FROM Fabricante f")
public class Fabricante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String cif;

	private String nombre;

	//bi-directional many-to-one association to Coche
	@OneToMany(mappedBy="fabricante")
	private List<Coche> coches;

	public Fabricante() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCif() {
		return this.cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Coche> getCoches() {
		return this.coches;
	}

	public void setCoches(List<Coche> coches) {
		this.coches = coches;
	}

	public Coche addCoch(Coche coch) {
		getCoches().add(coch);
		coch.setFabricante(this);

		return coch;
	}

	public Coche removeCoch(Coche coch) {
		getCoches().remove(coch);
		coch.setFabricante(null);

		return coch;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return cif + " - " + nombre;
	}

}