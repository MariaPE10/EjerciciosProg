package ExamenMariaPerez.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ExamenMariaPerez.gui.JTable.TablaEnScrollPane;
import ExamenMariaPerez.modelo.Cliente;
import ExamenMariaPerez.modelo.Lote;
import ExamenMariaPerez.modelo.Metodopago;
import ExamenMariaPerez.modelo.Venta;
import ExamenMariaPerez.modelo.controladores.ClienteControlador;
import ExamenMariaPerez.modelo.controladores.LoteControlador;
import ExamenMariaPerez.modelo.controladores.MetodoPagoControlador;
import ExamenMariaPerez.modelo.controladores.VentaControlador;



public class PanelGestionVentas extends JPanel {
	
	private Dimension dimension = new Dimension(40, 20);

	JFormattedTextField jftFecha = null;
	TablaEnScrollPane tablaLote = new TablaEnScrollPane();
	JComboBox<Metodopago> jcbMetodoPago = new JComboBox<Metodopago>();
	DefaultListModel<Cliente> modelClientes = new DefaultListModel<Cliente>();
	JList<Cliente> jlClientes = new JList<Cliente>(modelClientes);
	JScrollPane scroll;
	JSpinner jspPrecio = new JSpinner();
	JSlider jslUd = new JSlider(0, 100, 5);
	JLabel lblUd = new JLabel();
	JCheckBox chcAnulada = new JCheckBox();
	JButton jbtGuardar = new JButton("Guardar la venta");
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	List<Cliente> clientes = ClienteControlador.getControlador().findAllClientes();
	
	GridBagConstraints gridBagConstraints = new GridBagConstraints();
	
		/**
		 * 
		 */
		public PanelGestionVentas() {
			super();
			this.setLayout(new BorderLayout());
			
			inicializaListaClientes();
			jlClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			jlClientes.setLayoutOrientation(JList.VERTICAL);
			jlClientes.setVisibleRowCount(5);
			this.add(getPanelGestion(), BorderLayout.CENTER);
			this.add(jbtGuardar, BorderLayout.SOUTH);
			
			jbtGuardar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					guardar();
				}
			});
			
		}

		/**
		 * 
		 */
		private JPanel getPanelGestion () {
			JPanel panelGestion = new JPanel();
			panelGestion.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();

			// Inclusion del JTextField para la fecha
			c.gridx = 0;
		    c.gridy = 0;
		    c.insets = new Insets(5, 5, 5, 5);
		    c.anchor = GridBagConstraints.EAST;
		    panelGestion.add(new JLabel("Fecha: "), c);
			
			c.gridx = 1;
		    c.anchor = GridBagConstraints.WEST;
		    getJFormattedTextFieldFecha();
		    //jtfId.setMinimumSize(minimaDimensionJTextField);
		    panelGestion.add(jftFecha, c);

			// Inclusion del JTextField para el lote
			c.gridx = 0;
		    c.gridy = 1;
		    c.anchor = GridBagConstraints.EAST;
		    panelGestion.add(new JLabel("Lote: "), c);
			
			c.gridx = 1;
//			scroll = new JScrollPane(tablaLote);
		    c.anchor = GridBagConstraints.WEST;
		    panelGestion.add(tablaLote, c);
		    
		    // Inclusion del JTextField para el Metodo de pago
 			c.gridx = 0;
 		    c.gridy = 2;
 		    c.anchor = GridBagConstraints.EAST;
 		    panelGestion.add(new JLabel("Metodo de pago: "), c);
 			
 			c.gridx = 1;
 		    c.anchor = GridBagConstraints.WEST;
 		    inicializaComboBoxPago();
 		    panelGestion.add(jcbMetodoPago, c);
    
		    // Inclusion del JTextField para el Cliente
 			c.gridx = 0;
 		    c.gridy = 3;
 		    c.anchor = GridBagConstraints.EAST;
 		    panelGestion.add(new JLabel("Cliente: "), c);
 			
 			c.gridx = 1;
 		    c.anchor = GridBagConstraints.WEST;
 		    JPanel panelLista = new JPanel();
 		    panelLista.setLayout(new GridBagLayout());
 		    panelLista.add(jlClientes);
 		    panelGestion.add(panelLista, c);
 		    
 		    // Inclusion del JTextField para el Precio
 			c.gridx = 0;
 		    c.gridy = 4;
 		    c.anchor = GridBagConstraints.EAST;
 		    panelGestion.add(new JLabel("Precio de venta: "), c);
 			
 			c.gridx = 1;
 		    c.anchor = GridBagConstraints.WEST;
 		    this.jspPrecio.setMinimumSize(dimension);
 			this.jspPrecio.setPreferredSize(dimension);
 		    panelGestion.add(jspPrecio, c);
 		    
 		    // Inclusion del JTextField para las Ud
 			c.gridx = 0;
 		    c.gridy = 5;
 		    c.anchor = GridBagConstraints.EAST;
 		    panelGestion.add(new JLabel("Unidades: "), c);
 			
 			c.gridx = 1;
 		    c.anchor = GridBagConstraints.WEST;
 		    //getJSlider();
 		    panelGestion.add(jslUd, c);
 		    
 			c.gridx = 2;
 		    c.anchor = GridBagConstraints.WEST;
 		    lblUd.setText("Unidades: " + jslUd.getValue());
 		    panelGestion.add(lblUd, c);

 		    // Inclusion del JTextField para las Ud
 			c.gridx = 0;
 		    c.gridy = 6;
 		    c.anchor = GridBagConstraints.EAST;
 		    panelGestion.add(new JLabel("Venta anulada: "), c);
 			
 			c.gridx = 1;
 		    c.anchor = GridBagConstraints.WEST;
 		    panelGestion.add(chcAnulada, c);
 		    
 		    
 		    jslUd.addChangeListener(new ChangeListener() {
				
				@Override
				public void stateChanged(ChangeEvent e) {
					lblUd.setText("Unidades: " + jslUd.getValue());
				}
			});
 		    
 		    
		    return panelGestion;
		}
		
		/**
		 * 
		 */
		private void guardar () {
			Venta nuevoRegistro = new Venta();
			Date fechaEvaluacion = null;
			
			try {
				fechaEvaluacion = sdf.parse(jftFecha.getText());
			} catch (ParseException e1) {
				JOptionPane.showMessageDialog(null, "El formato de la fecha es erroneo. \n El formato requerido es dd/mm/aaaa", "Error en el campo fecha", 0);
				return;
			}
			
			nuevoRegistro.setId(0);
			nuevoRegistro.setCliente(jlClientes.getSelectedValue());
			nuevoRegistro.setMetodopago((Metodopago) this.jcbMetodoPago.getSelectedItem());
			nuevoRegistro.setFecha(fechaEvaluacion);
			nuevoRegistro.setPrecioVenta(Float.parseFloat("" + jspPrecio.getValue()));
			nuevoRegistro.setUnidades(jslUd.getValue());
			nuevoRegistro.setVentaAnulada(chcAnulada.isSelected());
		
			int idLote = ((Integer) tablaLote.getTableModel().getValueAt(tablaLote.getjTable().getSelectedRow(), 2)).intValue();
			
			Lote lote = LoteControlador.getControlador().findById(idLote);
			
			if (lote != null) {
				nuevoRegistro.setLote(lote);
				VentaControlador.getControlador().persist(nuevoRegistro);
			}
			
			JOptionPane.showMessageDialog(this, "Guardado correctamente");		
		}
		
		/**
		 * 
		 */
		private void inicializaComboBoxPago () {
			List<Metodopago> metodos = MetodoPagoControlador.getControlador().findAllMetodopagos();
			for (Metodopago metodo : metodos) {
				jcbMetodoPago.addItem(metodo);
			}
		}
		
		
		private void inicializaListaClientes() {
			
			for (Cliente cliente : clientes) {
				modelClientes.addElement(cliente);
			}
		}
		/**
		 * 
		 * @return
		 */
		private void getJFormattedTextFieldFecha() {

			jftFecha = new JFormattedTextField(new JFormattedTextField.AbstractFormatter() {
				 
				@Override
				public String valueToString(Object value) throws ParseException {
					if (value != null && value instanceof Date) {
						return sdf.format(((Date) value));
					}
					return "";
				}

				@Override
				public Object stringToValue(String text) throws ParseException {
					try {
						return sdf.parse(text);
					} catch (Exception e) {
						return null;
					}
				}
			});
			jftFecha.setColumns(7);
			jftFecha.setValue(new Date());
		}
		
		/**
		 * 
		 */
		private void getJSlider() {			
			jslUd = new JSlider(0, 100, 5);
			
		}
}
