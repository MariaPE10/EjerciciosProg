package awt_swing.JPA.Ejercicio_Provincias.gui.JTable;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.List;

import awt_swing.JPA.Ejercicio_Provincias.gui.PanelGestionPersonas;
import awt_swing.JPA.Ejercicio_Provincias.modelo.Persona;
import awt_swing.JPA.Ejercicio_Provincias.modelo.Provincia;
import awt_swing.JPA.Ejercicio_Provincias.modelo.controladores.PersonaControlador;

public class TablaEnScrollPane extends JPanel {

	MiTableModelPersonas tableModel = new MiTableModelPersonas();
	List<Persona> estudiantes = PersonaControlador.getControlador().findAllPersonas();
	private PanelGestionPersonas panelPersona = new PanelGestionPersonas(this);
	JTable jTable = new JTable(tableModel);
	
	public TablaEnScrollPane () {
		// Construyo el tableModel y la tabla
		
		// Configuro la tabla para que utilice un renderizador particular en diferentes tipos de objetos
		jTable.setDefaultRenderer(Object.class, new MiDefaultTableCellRenderer());
		jTable.setDefaultRenderer(Integer.class, new MiDefaultTableCellRenderer());
		jTable.setDefaultRenderer(Boolean.class, new MiBooleanTableCellRenderer());
		jTable.setDefaultEditor(Provincia.class, new MiProvinciaTableCellEditor());
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
					Persona persona = estudiantes.get(i);
					if(persona.getId() == idSeleccionado) {
						panelPersona.setActual(persona);
						panelPersona.cargarDatosActual();
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
	
	// Crear una conexion con una BBDD X
	// Crear los controladores y entidades JPA X
	// Crear la BBDD con el fichero sql X
	// Ventana de menú con 3 paneles 
	// JPanelGestionEstudiantes (parecido), WindowBuilder
	// GridBagLayout
	// JList, JTable, JCombo, JSlider, JSpinner (int y float), JFotmated con Fecha
	// JCheckbox, JRadioButton
	// Consulta sql mas elaborada (tipo fin por prof, materia y estudiante)
	
	/**
	 * @return the panelEstudiante
	 */
	public PanelGestionPersonas getPanelEstudiante() {
		return panelPersona;
	}

	/**
	 * @return the tableModel
	 */
	public MiTableModelPersonas getTableModel() {
		return tableModel;
	}
	
	/**
	 * 
	 * @param estudiante
	 */
	public void actualizaFila(Persona persona) {
		int idEstudianteSelec = persona.getId();
	
		for (int i = 0; i<jTable.getRowCount() ; i++) {
			int idTabla = (int) tableModel.getValueAt(i, 0);
			if(idEstudianteSelec == idTabla) {
				jTable.setRowSelectionInterval(i, i);
			}
		}
	}
}
