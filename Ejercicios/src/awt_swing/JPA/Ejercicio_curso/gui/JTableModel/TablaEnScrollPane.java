package awt_swing.JPA.Ejercicio_curso.gui.JTableModel;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.util.ArrayList;
import java.util.List;

import awt_swing.JPA.Ejercicio_curso.gui.JSplitPaneTabla;
import awt_swing.JPA.Ejercicio_curso.gui.PanelGestionEstudiantes;
import awt_swing.JPA.Ejercicio_curso.modelo.Estudiante;
import awt_swing.JPA.Ejercicio_curso.modelo.TipologiaSexo;
import awt_swing.JPA.Ejercicio_curso.modelo.controladores.EstudianteControlador;

public class TablaEnScrollPane extends JPanel {

	MiTableModelEstudiantes tableModel = new MiTableModelEstudiantes();
	List<Estudiante> estudiantes = EstudianteControlador.getControlador().findAllEstudiantes();
	private PanelGestionEstudiantes panelEstudiante = new PanelGestionEstudiantes(this);
	JTable jTable = new JTable(tableModel);
	
	public TablaEnScrollPane () {
		// Construyo el tableModel y la tabla
		
		// Configuro la tabla para que utilice un renderizador particular en diferentes tipos de objetos
		jTable.setDefaultRenderer(Object.class, new MiDefaultTableCellRenderer());
		jTable.setDefaultRenderer(Integer.class, new MiDefaultTableCellRenderer());
		jTable.setDefaultRenderer(Boolean.class, new MiBooleanTableCellRenderer());
		jTable.setDefaultEditor(TipologiaSexo.class, new MiTipologiaTableCellEditor());
		jTable.setRowSelectionInterval(0, 0);
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
						panelEstudiante.setActual(estudiante);
						panelEstudiante.cargarDatosActual();
					}
				}
			}
		});
		
		//Creamos un JscrollPane y le agregamos la JTable
		JScrollPane scrollPane = new JScrollPane(jTable);
		//Agregamos el JScrollPane al contenedor
		this.setLayout(new BorderLayout());
//		this.add(getBarraHerramientas(), BorderLayout.NORTH);
		this.add(scrollPane, BorderLayout.CENTER);
		
	}
	
	// Crear una conexion con una BBDD
	// Crear los controladores y entidades JPA
	// Crear la BBDD con el fichero sql
	// Ventana de menú con 3 paneles
	// JPanelGestionEstudiantes (parecido), WindowBuilder
	// GridBagLayout
	// JList, JTable, JCombo, JSlider, JSpinner (int y float), JFotmated con Fecha
	// JCheckbox, JRadioButton
	// Consulta sql mas elaborada (tipo fin por prof, materia y estudiante)
	
	/**
	 * @return the panelEstudiante
	 */
	public PanelGestionEstudiantes getPanelEstudiante() {
		return panelEstudiante;
	}

	/**
	 * @return the tableModel
	 */
	public MiTableModelEstudiantes getTableModel() {
		return tableModel;
	}
	
	/**
	 * 
	 * @param estudiante
	 */
	public void actualizaFila(Estudiante estudiante) {
		int idEstudianteSelec = estudiante.getId();
	
		for (int i = 0; i<jTable.getRowCount() ; i++) {
			int idTabla = (int) tableModel.getValueAt(i, 0);
			if(idEstudianteSelec == idTabla) {
				jTable.setRowSelectionInterval(i, i);
			}
		}
	}
}
