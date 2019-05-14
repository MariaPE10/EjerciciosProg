package ExamenMariaPerez.gui.JTable;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import ExamenMariaPerez.modelo.Lote;
import ExamenMariaPerez.modelo.controladores.LoteControlador;


public class MiTableModelLotes  extends MiTableModelAbstract {
	Object datos[][] = null;
	String titulos[] = null;

	/**
	 * 
	 */
	public MiTableModelLotes() {
		super();
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String[] getTitulosColumnas() {
		return new String[] {"Id Distribuidor", "Distribuidor", "Id Lote", "Fecha","Color","Unidades"};
	}

	/**
	 * 
	 * @return
	 */
	public Object[][] getDatosDeTabla() {
		// Obtengo todas las personas
		List<Lote> lotes = LoteControlador.getControlador().findAllLotes();
		// Preparo una estructura para pasar al constructor de la JTable
		Object[][] datos = new Object[lotes.size()][6];
		// Cargo los datos de la lista de personas en la matriz de los datos
		for (int i = 0; i < lotes.size(); i++) {
			Lote lote = lotes.get(i);
			datos[i][0] = lote.getDistribuidor().getId();
			datos[i][1] = lote.getDistribuidor().getNombre();
			datos[i][2] = lote.getId();
			datos[i][3] = lote.getFechaRecepcion();
			datos[i][4] = lote.getColor();
			datos[i][5] = lote.getUnidadesStock();
		}
		
		return datos;
	}
}
