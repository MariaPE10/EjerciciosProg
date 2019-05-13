package awt_swing.JPA.Ejercicio_curso.gui;

import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import awt_swing.JPA.Ejercicio_curso.gui.JTableModel.TablaEnScrollPane;

public class JSplitPaneTabla extends JSplitPane {

	TablaEnScrollPane panelTabla = new TablaEnScrollPane();
	
	public JSplitPaneTabla() {
		super();
		this.setOrientation(JSplitPane.VERTICAL_SPLIT);
		this.setLeftComponent(panelTabla);
		this.setRightComponent(panelTabla.getPanelEstudiante());
	}

	
	
}
