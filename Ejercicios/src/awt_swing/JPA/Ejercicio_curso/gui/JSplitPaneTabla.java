package awt_swing.JPA.Ejercicio_curso.gui;

import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import awt_swing.JPA.Ejercicio_curso.gui.JTableModel.TablaEnScrollPane;

public class JSplitPaneTabla extends JSplitPane {

	
	public JSplitPaneTabla() {
		super();
		this.setOrientation(JSplitPane.VERTICAL_SPLIT);
		this.setLeftComponent(getJTable());
		this.setRightComponent(panelGestionEstudiantes);
	}
	
	/**
	 * s
	 * @return
	 */
	private JScrollPane getJTable() {
		TablaEnScrollPane panelTabla = new TablaEnScrollPane();
		JScrollPane panelScroll = new JScrollPane(panelTabla);
		return panelScroll;
	}

	
	
}
