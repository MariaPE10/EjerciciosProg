package ExamenMariaPerez.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import ExamenMariaPerez.gui.JTable.MiTableModelAnulados;


public class PanelGestionAnulados extends JPanel {
	
	JPanel panel = null;
	JPanel panelTabla = new JPanel();
	MiTableModelAnulados modelo = new MiTableModelAnulados(true);
	JTable jTabla = new JTable(modelo);
	JScrollPane scroll = new JScrollPane(jTabla);
	JRadioButton jrbActivas = new JRadioButton ("Ventas Activas");
	JRadioButton jrbAnuladas = new JRadioButton ("Ventas Anuladas");
	GridBagConstraints gridBagConstraints = new GridBagConstraints();
	
		/**
		 * 
		 */
		public PanelGestionAnulados() {
			super();
			this.setLayout(new BorderLayout());			
			this.add(getPanelGestion(), BorderLayout.NORTH);
			panelTabla.add(scroll);
			this.add(panelTabla, BorderLayout.CENTER);
			
		}

		/**
		 * 
		 */
		private JPanel getPanelGestion () {
			JPanel panelGestion = new JPanel();
			panelGestion.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();

			// Inclusion del JTextField para la venta
			c.gridx = 0;
		    c.gridy = 0;
		    c.insets = new Insets(5, 5, 5, 5);
		    c.anchor = GridBagConstraints.EAST;
		    panelGestion.add(new JLabel("Estado de la Venta: "), c);
			
			c.gridx = 1;
		    c.anchor = GridBagConstraints.WEST;
		    panel = getPanelRadio();
		    //jtfId.setMinimumSize(minimaDimensionJTextField);
		    panelGestion.add(panel, c);
 		    
		    return panelGestion;
		}
		
		/**
		 * 
		 * @param opciones
		 * @return
		 */
		private JPanel getPanelRadio () {
			
			ButtonGroup grupoOpciones = new ButtonGroup();
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			
			jrbActivas.addChangeListener(new ChangeListener() {
				
				@Override
				public void stateChanged(ChangeEvent e) {
					if (jrbActivas.isSelected()) {
						modelo.setAnulada(true);
						modelo.fireTableDataChanged();
						scroll.revalidate();
						scroll.repaint();
					}
				}
			});
			
			jrbAnuladas.addChangeListener(new ChangeListener() {
				
				@Override
				public void stateChanged(ChangeEvent e) {
					if (jrbAnuladas.isSelected()) {
						modelo.setAnulada(false);
						modelo.fireTableDataChanged();
						scroll.revalidate();
						scroll.repaint();
					}
				}
			});
			
			jrbActivas.setSelected(true);
			grupoOpciones.add(jrbActivas);
			panel.add(jrbActivas);
			grupoOpciones.add(jrbAnuladas);
			panel.add(jrbAnuladas);
			
			return panel;
		}
		
}
