package awt_swing.JPA.Ejercicio_curso.gui;

import javax.swing.JSplitPane;
import javax.swing.JTable;

public class JSplitPaneTabla extends JSplitPane {

	public JSplitPaneTabla() {
		super();
		this.setOrientation(JSplitPane.VERTICAL_SPLIT);
		this.setLeftComponent(getJTable());
		this.setRightComponent(new PanelGestionEstudiantes());
	}
	
	/**
	 * s
	 * @return
	 */
	private JTable getJTable() {
		JTable panelTabla = new JTable();
		return panelTabla;
	}
}
