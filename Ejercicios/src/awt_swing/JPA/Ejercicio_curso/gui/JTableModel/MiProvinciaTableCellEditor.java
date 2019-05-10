package awt_swing.JPA.Ejercicio_curso.gui.JTableModel;

import java.awt.Component;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;


public class MiProvinciaTableCellEditor extends DefaultCellEditor {
//
//	// Utilizaremos este puntero para hacer referencia al control mostrado en la tabla
//	private JComboBox<Provincia> jcbProvincias = null;
//	
//	/**
//	 * 
//	 */
	public MiProvinciaTableCellEditor() {
		super(new JComboBox</*Provincia*/>());
//		
//		// La celda se comenzar� a editar tras 2 clics
//		setClickCountToStart(2);
//		// Inicializaci�n del componente
//		jcbProvincias = (JComboBox<Provincia>) getComponent();
	}
//
//	/**
//	 * En este m�todo construimos el componente que el usuario ver� cuando haga clic sobre la celda en concreto
//	 */
//	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
//		JComboBox<Provincia> jcbProvincias = (JComboBox<Provincia>) super.getTableCellEditorComponent(table, value, isSelected, row, column);
//
//		// Si los hubiera, elimino los items actuales.
//		jcbProvincias.removeAllItems();
//		
//		// Inicializo los elementos del combobox a todas las provincias disponibles y selecciono la correcta
//		List<Provincia> provincias = ProvinciaControlador.getControlador().findAllProvincias();
//		for (Provincia provincia : provincias) {
//			jcbProvincias.addItem(provincia);
//			if (value != null && value instanceof Provincia) {
//				Provincia provinciaValue = (Provincia) value;
//				if (provinciaValue.getId() == provincia.getId()) {
//					jcbProvincias.setSelectedItem(provincia);
//				}
//			}
//		}
//		
//		return jcbProvincias;
//	}
//
//	/**
//	 * Devuelvo el objeto de tipo Provincia seleccionado por el usuario
//	 */
//	public Object getCellEditorValue() {
//		return (Provincia) jcbProvincias.getSelectedItem();
//	}

}
