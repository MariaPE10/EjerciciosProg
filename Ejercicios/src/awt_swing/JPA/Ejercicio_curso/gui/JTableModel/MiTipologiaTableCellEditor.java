package awt_swing.JPA.Ejercicio_curso.gui.JTableModel;

import java.awt.Component;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;

import awt_swing.JPA.Ejercicio_curso.modelo.TipologiaSexo;
import awt_swing.JPA.Ejercicio_curso.modelo.controladores.TipologiaSexoControlador;


public class MiTipologiaTableCellEditor extends DefaultCellEditor {

	// Utilizaremos este puntero para hacer referencia al control mostrado en la tabla
	private JComboBox<TipologiaSexo> jcbSexo = null;
	
	/**
	 * 
	 */
	public MiTipologiaTableCellEditor() {
		super(new JComboBox<TipologiaSexo>());
		
		// La celda se comenzar� a editar tras 2 clics
		setClickCountToStart(2);
		// Inicializaci�n del componente
		jcbSexo = (JComboBox<TipologiaSexo>) getComponent();
	}

	/**
	 * En este m�todo construimos el componente que el usuario ver� cuando haga clic sobre la celda en concreto
	 */
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		JComboBox<TipologiaSexo> jcbSexo = (JComboBox<TipologiaSexo>) super.getTableCellEditorComponent(table, value, isSelected, row, column);

		// Si los hubiera, elimino los items actuales.
		jcbSexo.removeAllItems();
		
		// Inicializo los elementos del combobox a todas las provincias disponibles y selecciono la correcta
		List<TipologiaSexo> tipos = TipologiaSexoControlador.getControlador().findAllTipologiaSexos();
		for (TipologiaSexo sexo : tipos) {
			jcbSexo.addItem(sexo);
			if (value != null && value instanceof TipologiaSexo) {
				TipologiaSexo sexoValue = (TipologiaSexo) value;
				if (sexoValue.getId() == sexo.getId()) {
					jcbSexo.setSelectedItem(sexo);
				}
			}
		}
		
		return jcbSexo;
	}

	/**
	 * Devuelvo el objeto de tipo Provincia seleccionado por el usuario
	 */
	public Object getCellEditorValue() {
		return (TipologiaSexo) jcbSexo.getSelectedItem();
	}

}
