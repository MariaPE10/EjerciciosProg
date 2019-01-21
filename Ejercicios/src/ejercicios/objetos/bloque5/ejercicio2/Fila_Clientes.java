package ejercicios.objetos.bloque5.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Fila_Clientes {
	private List<Cliente> fila = new ArrayList<Cliente>();
	
	
	/**
	 * Imprimir la fila
	 * @param fila
	 */
	public void imprimeFila () {
		for (Cliente cliente : this.fila) {
			System.out.println("Nombre: " + cliente.getNombre() + ", Id: " + cliente.getId() + ", Posición: " + this.fila.indexOf(cliente));
		}
	}
	
	/**
	 * Agrega un cliente a la fila
	 * @param cliente
	 */
	public void agregarCliente (Cliente cliente) {
		this.fila.add(cliente);
	}
	
	/**
	 * 
	 * @return
	 */
	public Cliente sacarCliente () {
		Cliente cliente;
		cliente = this.fila.remove(0);
		return cliente;
	}
	
	/**
	 * 
	 * @param indice
	 * @return
	 */
	public Cliente moverCliente(int indice) {
		Cliente cliente = this.fila.remove(indice);
		return cliente;
	}
	
	/**
	 * 
	 * @return
	 */
	public Fila_Clientes dividirFila () {
		Fila_Clientes segundaFila = new Fila_Clientes();
		for (int i = 1; i < this.fila.size(); i++) {
			segundaFila.agregarCliente(moverCliente(i));
		}
		return segundaFila;
	}
}
