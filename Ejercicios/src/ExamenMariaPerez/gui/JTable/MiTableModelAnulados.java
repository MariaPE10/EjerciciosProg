package ExamenMariaPerez.gui.JTable;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import ExamenMariaPerez.modelo.Lote;
import ExamenMariaPerez.modelo.Venta;
import ExamenMariaPerez.modelo.controladores.LoteControlador;
import ExamenMariaPerez.modelo.controladores.VentaControlador;


public class MiTableModelAnulados  extends MiTableModelAbstract {
	public Object datos[][] = null;
	public String titulos[] = null;
	public boolean anulada = true;

	/**
	 * @param anulada the anulada to set
	 */
	public void setAnulada(boolean anulada) {
		this.anulada = anulada;
	}

	/**
	 * 
	 */
	public MiTableModelAnulados(boolean anulada) {
		super();
		actualizaDatosEnTabla();
		this.anulada = anulada;
	}
	
	/**
	 * 
	 * @return
	 */
	public String[] getTitulosColumnas() {
		return new String[] {"Fecha", "Tipo de Articulo", "Color", "Distribuidor","Unidades","Precio", "Cliente"};
	}

	/**
	 * 
	 * @return
	 */
	public Object[][] getDatosDeTabla() {
		// Obtengo todas las personas
		List<Venta> ventas = VentaControlador.getControlador().findByVentaAnulada(this.anulada);
		// Preparo una estructura para pasar al constructor de la JTable
		Object[][] datos = new Object[ventas.size()][7];
		// Cargo los datos de la lista de personas en la matriz de los datos
		for (int i = 0; i < ventas.size(); i++) {
			Venta venta = ventas.get(i);
			datos[i][0] = venta.getFecha();
			datos[i][1] = venta.getLote().getTipoarticulo();
			datos[i][2] = venta.getLote().getColor();
			datos[i][3] = venta.getLote().getDistribuidor().getNombre();
			datos[i][4] = venta.getUnidades();
			datos[i][5] = venta.getPrecioVenta();
			datos[i][6] = venta.getCliente();
		}
		
		return datos;
	}
}
