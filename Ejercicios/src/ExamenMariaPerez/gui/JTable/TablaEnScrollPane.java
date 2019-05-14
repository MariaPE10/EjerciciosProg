package ExamenMariaPerez.gui.JTable;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import awt_swing.JPA.Ejercicio_curso.gui.JSplitPaneTabla;

public class TablaEnScrollPane extends JPanel {

	MiTableModelLotes tableModel = new MiTableModelLotes();
	JTable jTable = new JTable(tableModel);
	private Dimension dimension = new Dimension(500, 500);
	
	
	public TablaEnScrollPane () {
		// Construyo el tableModel y la tabla
		
		// Configuro la tabla para que utilice un renderizador particular en diferentes tipos de objetos
		jTable.setDefaultRenderer(Object.class, new MiDefaultTableCellRenderer());
		jTable.setDefaultRenderer(Integer.class, new MiDefaultTableCellRenderer());
		jTable.setDefaultRenderer(Boolean.class, new MiBooleanTableCellRenderer());
		jTable.setDefaultRenderer(Date.class, new MiDateTableCellRenderer());
		jTable.setDefaultEditor(Date.class, new MiDateTableCellEditor(new SimpleDateFormat("dd/MM/yyyy")));
		
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
				int idSeleccionado = ((Integer) tableModel.getValueAt(jTable.getSelectedRow(), 2)).intValue();
				System.out.println(idSeleccionado);
			}
		});
		
		//Creamos un JscrollPane y le agregamos la JTable
		JScrollPane scrollPane = new JScrollPane(jTable);
		scrollPane.setMaximumSize(dimension);
		//Agregamos el JScrollPane al contenedor
		this.setLayout(new BorderLayout());
		this.add(scrollPane, BorderLayout.CENTER);
		
	}

	/**
	 * @return the tableModel
	 */
	public MiTableModelLotes getTableModel() {
		return tableModel;
	}

	/**
	 * @return the jTable
	 */
	public JTable getjTable() {
		return jTable;
	}
	
	
}
