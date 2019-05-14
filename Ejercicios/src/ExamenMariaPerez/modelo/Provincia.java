package ExamenMariaPerez.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the provincia database table.
 * 
 */
@Entity
@Table(name="provincia")
@NamedQuery(name="Provincia.findAll", query="SELECT p FROM Provincia p")
public class Provincia extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="provincia")
	private List<Cliente> clientes;

	//bi-directional many-to-one association to Distribuidor
	@OneToMany(mappedBy="provincia")
	private List<Distribuidor> distribuidors;

	public Provincia() {
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

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente addCliente(Cliente cliente) {
		getClientes().add(cliente);
		cliente.setProvincia(this);

		return cliente;
	}

	public Cliente removeCliente(Cliente cliente) {
		getClientes().remove(cliente);
		cliente.setProvincia(null);

		return cliente;
	}

	public List<Distribuidor> getDistribuidors() {
		return this.distribuidors;
	}

	public void setDistribuidors(List<Distribuidor> distribuidors) {
		this.distribuidors = distribuidors;
	}

	public Distribuidor addDistribuidor(Distribuidor distribuidor) {
		getDistribuidors().add(distribuidor);
		distribuidor.setProvincia(this);

		return distribuidor;
	}

	public Distribuidor removeDistribuidor(Distribuidor distribuidor) {
		getDistribuidors().remove(distribuidor);
		distribuidor.setProvincia(null);

		return distribuidor;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return descripcion;
	}
	
	

}