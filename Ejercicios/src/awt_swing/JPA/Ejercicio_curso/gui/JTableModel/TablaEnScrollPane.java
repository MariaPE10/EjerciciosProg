package awt_swing.JPA.Ejercicio_curso.gui.JTableModel;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.util.List;

import awt_swing.JPA.Ejercicio_curso.gui.JSplitPaneTabla;
import awt_swing.JPA.Ejercicio_curso.gui.PanelGestionEstudiantes;
import awt_swing.JPA.Ejercicio_curso.modelo.Estudiante;
import awt_swing.JPA.Ejercicio_curso.modelo.controladores.EstudianteControlador;

public class TablaEnScrollPane extends JPanel {

	MiTableModel tableModel = null;
	private List<Estudiante> estudiantes = EstudianteControlador.getControlador().findAllEstudiantes();
	private PanelGestionEstudiantes panelEstudiante = new PanelGestionEstudiantes();
	
	public TablaEnScrollPane () {
		// Construyo el tableModel y la tabla
		tableModel = new MiTableModel();
		JTable jTable = new JTable(tableModel);
		// Configuro la tabla para que utilice un renderizador particular en diferentes tipos de objetos
		jTable.setDefaultRenderer(Object.class, new MiDefaultTableCellRenderer());
		jTable.setDefaultRenderer(Integer.class, new MiDefaultTableCellRenderer());
		jTable.setDefaultRenderer(Boolean.class, new MiBooleanTableCellRenderer());
		
		MiTableHeaderCellRenderer tableHeaderCellRenderer = new MiTableHeaderCellRenderer();
		for (int i = 0; i < jTable.getColumnCount(); i++) {
			jTable.getColumnModel().getColumn(i).setHeaderRenderer(tableHeaderCellRenderer);
		}
			
		// Detecci�n del clic sobre una fila
		jTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int idSeleccionado = ((Integer) tableModel.getValueAt(jTable.getSelectedRow(), 0)).intValue();
				for (int i = 0; i<estudiantes.size(); i++) {
					Estudiante estudiante = estudiantes.get(i);
					if(estudiante.getId() == idSeleccionado) {
						JSplitPaneTabla
					}
				}
				System.out.println(idSeleccionado);
			}
		});
		
		//Creamos un JscrollPane y le agregamos la JTable
		JScrollPane scrollPane = new JScrollPane(jTable);
		//Agregamos el JScrollPane al contenedor
		this.setLayout(new BorderLayout());
//		this.add(getBarraHerramientas(), BorderLayout.NORTH);
		this.add(scrollPane, BorderLayout.CENTER);
		this.add(new JTextArea("JTable construida con AbstractTableModel y CellRenderer personalizado.\n"
				+ "Gracias a esto podemos controlar la forma en la que los datos se muestran al usuario"), BorderLayout.SOUTH);
	}
	
	/**
	 * @return the panelEstudiante
	 */
	public PanelGestionEstudiantes getPanelEstudiante() {
		return panelEstudiante;
	}
}
