package examen_MariaPerez;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	private List<Articulo> articulos = new ArrayList<Articulo>();
	
	
	/**
	 * @param articulos
	 */
	public Cliente() {
		super();
		this.articulos = rellenaLista();
	}


	/**
	 * 
	 * @return
	 */
	public List<Articulo> rellenaLista() {
		
		Jardineria jar = new Jardineria("1", "Amapola", 1, 1.5f, "Opiacea");
		articulos.add(jar);
		
		Lacteos lac = new Lacteos("2", "Leche", 1, 0.8f, "1L");
		articulos.add(lac);
		
		Pasteleria past = new Pasteleria("3", "Tarta", 2, 2.4f, "Chocolate");
		articulos.add(past);
		
		Perfumeria perf = new Perfumeria("4", "Agua de Rosas", 1, 13.5f, "Rosas");
		articulos.add(perf);
		
		Pescaderia pes = new Pescaderia("5", "Atun", 1, 9.8f, "Rojo");
		articulos.add(pes);
		
		return articulos;
	}


	/**
	 * @return the articulos
	 */
	public List<Articulo> getArticulos() {
		return articulos;
	}
	
	
}
