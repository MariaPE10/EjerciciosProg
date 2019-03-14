package examen_MariaPerez;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;


public class Caja {

	private static HashMap<String, Articulo> hmCaja = new HashMap<String, Articulo>();
	public static List<Articulo> articulosParaEliminar = new ArrayList<Articulo>();
	private static List<ArticuloRechazadoListener> listenersDeArticulos = new ArrayList<ArticuloRechazadoListener>();
	
	/**
	 * 
	 * @param cl
	 */
	public static void pasarArticulosPorCaja(Cliente cl) {
	
		List<Articulo> articulos = cl.getArticulos();
		for (Articulo art : articulos) {
			hmCaja.put(art.getIdentificador(), art);
		}
		
	}
	
	/**
	 * 
	 * @return
	 */
	public static float factura() {
		Iterator<Articulo> articulos = hmCaja.values().iterator();
		float precio = 0f;
		Articulo art;
		while(articulos.hasNext()) {
			art = articulos.next();
			precio += (art.getPrecio()*art.getCantidad());
		}
		
		return precio;
	}
	
	/**
	 * 
	 * @return
	 */
	public static String obtieneLista() {
		Iterator<Articulo> articulos = hmCaja.values().iterator();
		StringBuffer lista = new StringBuffer();
		while (articulos.hasNext()) {
			 lista.append(articulos.next().getDescripcion() + "\n\n");
		}
		return lista.toString();
	}
	
	/**
	 * 
	 */
	public static void eliminaArticulo() {
		Iterator<Articulo> articulos = hmCaja.values().iterator();
		String respuesta;
		
		while (articulos.hasNext()) {
			Articulo art = articulos.next();
			respuesta = JOptionPane.showInputDialog(null, art.getDescripcion() + "\nDesea eliminar el articulo?");
			if(respuesta.toUpperCase().equals("SI")) {
				articulosParaEliminar.add(art);
			}
		}
		
		for (Articulo articulo : articulosParaEliminar) {
			hmCaja.remove(articulo.getIdentificador());
			SimpleDateFormat sdf = new SimpleDateFormat ("dd-MM-yyyy\n" + 
					"HH:mm:ss");
			articulo.setFecha(sdf.format(new Date()));
			//System.out.println("Fecha y Hora: " + articulo.getFecha());
			ArticuloRechazadoEvent event = new ArticuloRechazadoEvent(articulo);
			fireArticuloRechazadoListener(event);
		}
	}
	
	/**
	 * 
	 * @param precio
	 * @return
	 * @throws CashInsuficienteException
	 */
	public static float pagar(float precio) throws CashInsuficienteException{
		float vuelta, cantidadUsuario;
		cantidadUsuario = Float.parseFloat(JOptionPane.showInputDialog("Cantidad a pagar: " + precio));
		if(cantidadUsuario<precio) {
			throw new CashInsuficienteException();
		} else {
			vuelta = cantidadUsuario - precio;
		}
		
		return vuelta;
	}
		
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Bienvenido/a", Super_Properties.getProperty("NOMBRE"), 1);
		System.out.println(Super_Properties.getProperty("NOMBRE"));
		
		SupervisorCajas supMaria = new SupervisorCajas("Maria");
		Cliente maria = new Cliente();
		pasarArticulosPorCaja(maria);
		
		JOptionPane.showMessageDialog(null, "Total: " + factura(), "Cantidad a pagar", 1);
		System.out.println("Cantidad total a pagar: " + factura());
		
		eliminaArticulo();
		
		JOptionPane.showMessageDialog(null, obtieneLista(), "Lista de articulos", 1);
		JOptionPane.showMessageDialog(null, "Total: " + factura(), "Nueva cantidad a pagar", 1);
		System.out.println("Nueva cantidad total a pagar: " + factura());
		
		try {
			JOptionPane.showMessageDialog(null, "Su cambio es: " + pagar(factura()), "Cambio", 1);
		} catch (CashInsuficienteException e) {
			JOptionPane.showMessageDialog(null, "La cantidad introducida es insuficiente", "Cantidad insuficiente", 0);
		}
	}
	
	/**
	 * 
	 * @param listener
	 */
	public static void addArticuloRechazadoListener (ArticuloRechazadoListener listener) {
		listenersDeArticulos.add(listener);
	}
	
	/**
	 * 
	 * @param listener
	 */
	public static void removeArticuloRechazadoListener (ArticuloRechazadoListener listener) {
		listenersDeArticulos.remove(listener);
	}
	
	/**
	 * 
	 * @param event
	 */
	public static void fireArticuloRechazadoListener (ArticuloRechazadoEvent event) {
		for(ArticuloRechazadoListener listener : listenersDeArticulos) {
			listener.articuloRechazadoListener(event);
		}
	}
}
