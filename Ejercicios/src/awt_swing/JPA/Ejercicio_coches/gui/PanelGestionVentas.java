package awt_swing.JPA.Ejercicio_coches.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import awt_swing.JPA.Ejercicio_coches.modelo.ControladorBBDDCliente;
import awt_swing.JPA.Ejercicio_coches.modelo.ControladorBBDDCoche;
import awt_swing.JPA.Ejercicio_coches.modelo.ControladorBBDDConcesionario;
import awt_swing.JPA.Ejercicio_coches.modelo.ControladorBBDDFabricante;
import awt_swing.JPA.Ejercicio_coches.modelo.ControladorBBDDVentas;
import awt_swing.JPA.Ejercicio_coches.modelo.entidades.Cliente;
import awt_swing.JPA.Ejercicio_coches.modelo.entidades.Coche;
import awt_swing.JPA.Ejercicio_coches.modelo.entidades.Concesionario;
import awt_swing.JPA.Ejercicio_coches.modelo.entidades.Venta;

public class PanelGestionVentas extends JPanel {

	GridBagConstraints gridBagConstraints = new GridBagConstraints();
	//JTextField jtfId = new JTextField();
	private int id;
	JComboBox<Cliente> jcbCliente = new JComboBox<Cliente>();
	JComboBox<Concesionario> jcbConcesionario = new JComboBox<Concesionario>();
	JComboBox<Coche> jcbCoche = new JComboBox<Coche>();
	JTextField jtfFecha = new JTextField();
	JTextField jtfPrecioVenta = new JTextField();
	
	JButton jbtNavPrimero = new JButton();
	JButton jbtNavUltimo = new JButton();
	JButton jbtNavAnterior = new JButton();
	JButton jbtNavSiguiente = new JButton();
	JButton jbtGuardar = new JButton();
	JButton jbtNuevo = new JButton();
	JButton jbtEliminar = new JButton();
	
	Venta venta = new Venta(); // Coche mostrado en pantalla
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Date fechaParseada = null;
	
	/**
	 * 
	 */
	public PanelGestionVentas () {
		
		this.maquetarVentana();
		
		// Manejo de la navegaci�n de registros por rueda de rat�n
		this.controlRuedaRaton();
		
		// Finalmente, despu�s de la construcci�n, cargamos el primer registro
		navegaAPrimero();
	}
	
	
	/**
	 * 
	 */
	private void controlRuedaRaton () {
		this.addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				if (e.getUnitsToScroll() < 0) {
					if (ControladorBBDDVentas.findNext(venta) != null) {
						navegaASiguiente();
					}
				}
				else {
					if (ControladorBBDDVentas.findPrevious(venta) != null) {
						navegaAAnterior();
					}
				}
			}
		});
	}
	
	/**
	 * 
	 */
	private void maquetarVentana() {
		double pesoCol1 = 0.15, pesoCol2 = 1;
		
		this.setLayout(new GridBagLayout());

		gridBagConstraints.insets = new Insets(5, 5, 5, 5);

		// Incorporamos los components del Id
//		colocaComponente(0, 0, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
//		this.add(new JLabel("Id:"), gridBagConstraints);
//		
//		colocaComponente(1, 0, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
//		this.add(jtfId, gridBagConstraints);
		
		// Incorporamos el cliente
		colocaComponente(0, 1, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel("Cliente:"), gridBagConstraints);
		
		colocaComponente(1, 1, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		inicializaComboBoxCliente();
		this.add(jcbCliente, gridBagConstraints);
		
		// Incorporamos el concesionario
		colocaComponente(0, 2, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel("Concesionario:"), gridBagConstraints);
		
		colocaComponente(1, 2, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		inicializaComboBoxConcesionario();
		this.add(jcbConcesionario, gridBagConstraints);
		
		// Incorporamos el Coche
		colocaComponente(0, 3, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel("Coche:"), gridBagConstraints);
		
		colocaComponente(1, 3, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		inicializaComboBoxCoche();
		this.add(jcbCoche, gridBagConstraints);
		
		// Incorporamos el Fecha
		colocaComponente(0, 4, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel("Fecha:"), gridBagConstraints);
		
		colocaComponente(1, 4, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		this.add(jtfFecha, gridBagConstraints);
		
		// Incorporamos el Precio Venta
		colocaComponente(0, 5, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel("Precio Venta:"), gridBagConstraints);
		
		colocaComponente(1, 5, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		this.add(jtfPrecioVenta, gridBagConstraints);
		
		// Incorporamos fila botones
		colocaComponente(0, 6, GridBagConstraints.NORTH, 1, 1, GridBagConstraints.BOTH);
		gridBagConstraints.gridwidth = 2;
		this.add(getBotonera(), gridBagConstraints);		
	}
	
	
	/**
	 * 
	 */
	private void inicializaComboBoxCliente () {
		List<Cliente> clientes = ControladorBBDDCliente.findAll();
		for (Cliente cliente : clientes) {
			jcbCliente.addItem(cliente);
		}
	}
	
	/**
	 * 
	 */
	private void inicializaComboBoxCoche () {
		List<Coche> coches = ControladorBBDDCoche.findAll();
		for (Coche coche : coches) {
			jcbCoche.addItem(coche);
		}
	}
	
	/**
	 * 
	 */
	private void inicializaComboBoxConcesionario () {
		List<Concesionario> concesionarios = ControladorBBDDConcesionario.findAll();
		for (Concesionario concesionario : concesionarios) {
			jcbConcesionario.addItem(concesionario);
		}
	}
	
	/**
	 * 
	 */
	private JPanel getBotonera() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		panel.setBackground(Color.yellow);
		
		// Configuramos los botones
		configuraBoton(jbtNavPrimero, "Primero", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				navegaAPrimero();
			}
		});
		configuraBoton(jbtNavAnterior, "Anterior", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				navegaAAnterior();
			}
		});
		configuraBoton(jbtNavSiguiente, "Siguiente", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				navegaASiguiente();
			}
		});
		configuraBoton(jbtNavUltimo, "Ultimo", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				navegaAUltimo();
			}
		});
		configuraBoton(jbtGuardar, "Guardar", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				guardar();
			}
		});
		configuraBoton(jbtNuevo, "Nuevo", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				nuevo();
			}
		});
		configuraBoton(jbtEliminar, "Eliminar", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				eliminar();
			}
		});
		
		//Inclu�mos los botones
		panel.add(jbtNavPrimero);
		panel.add(jbtNavAnterior);
		panel.add(jbtNavSiguiente);
		panel.add(jbtNavUltimo);
		panel.add(jbtGuardar);
		panel.add(jbtNuevo);
		panel.add(jbtEliminar);
		
		return panel;
	}

	
	/**
	 * 
	 */
	private void eliminar() {
		// Por regla general, siempre que eliminemos un coche navegaremos al siguiente
		// registro
		Venta ventaAEliminar = this.venta;
		
		// Compruebo si el coche actual es el �ltimo coche
		if (ControladorBBDDVentas.findLast().getId() == this.venta.getId()) {
			navegaAAnterior();
		}
		else {
			navegaASiguiente();
		}
		
		// Finalmente elimino el coche
		ControladorBBDDVentas.remove(ventaAEliminar);
		
		// Actualizo la botonera
		this.actualizaEstadoBotonera();
	}
	
	
	/**
	 * 
	 */
	private void nuevo () {
		this.venta = new Venta();
		//this.venta.setId(-1);
		//this.id = -1;
		this.jcbCliente.setSelectedIndex(0);
		this.jcbConcesionario.setSelectedIndex(0);
		this.jcbCoche.setSelectedIndex(0);
		this.jtfFecha.setText("");
		this.jtfPrecioVenta.setText("");

		// Actualizo la botonera
		this.actualizaEstadoBotonera();
	}
	
	/**
	 * 
	 * @param jbt
	 * @param icono
	 */
	private void configuraBoton (JButton jbt, String texto, ActionListener actionListener) {
		jbt.setText(texto);
		jbt.addActionListener(actionListener);
	}
	
	
	
	private void guardar() {
		// Es un alta nueva o una modificaci�n
		cargaVentaDesdeComponentesVisuales();
		ControladorBBDDVentas.persist(this.venta);
		if (!ControladorBBDDVentas.exists(this.venta)) {
			this.navegaAUltimo();
		}

		// Actualizo la botonera
		this.actualizaEstadoBotonera();
	}
	
	
	/**
	 * 
	 */
	private void navegaAPrimero () {
		venta = ControladorBBDDVentas.findFirst();
		cargaVentaEnComponentesVisuales();
		actualizaEstadoBotonera();
	}
	
	/**
	 * 
	 */
	private void navegaAUltimo () {
		venta = ControladorBBDDVentas.findLast();
		cargaVentaEnComponentesVisuales();
		actualizaEstadoBotonera();
	}
	
	/**
	 * 
	 */
	private void navegaASiguiente () {
		venta = ControladorBBDDVentas.findNext(this.venta);
		cargaVentaEnComponentesVisuales();
		actualizaEstadoBotonera();
	}
	
	/**
	 * 
	 */
	private void navegaAAnterior () {
		venta = ControladorBBDDVentas.findPrevious(this.venta);
		cargaVentaEnComponentesVisuales();
		actualizaEstadoBotonera();
	}
	
	
	
	/**
	 * 
	 */
	private void actualizaEstadoBotonera () {
		if (ControladorBBDDVentas.findPrevious(this.venta) == null) {
			jbtNavPrimero.setEnabled(false);
			jbtNavAnterior.setEnabled(false);
		}
		else {
			jbtNavPrimero.setEnabled(true);
			jbtNavAnterior.setEnabled(true);
		}
		if (ControladorBBDDVentas.findNext(this.venta) == null) {
			jbtNavSiguiente.setEnabled(false);
			jbtNavUltimo.setEnabled(false);
		}
		else {
			jbtNavSiguiente.setEnabled(true);
			jbtNavUltimo.setEnabled(true);
		}
		if (this.venta.getId() != -1) {
			jbtEliminar.setEnabled(true);
		}
		else {
			jbtEliminar.setEnabled(false);
		}
	}
	
	/**
	 * 
	 */
	private void cargaVentaEnComponentesVisuales () {
		//this.jtfId.setText("" + venta.getId());
		this.jtfFecha.setText(sdf.format(venta.getFecha()));
		this.jtfPrecioVenta.setText("" + venta.getPrecioVenta());

		// Cargo el valor del JComboBox del cliente
		for (int i = 0; i < this.jcbCliente.getItemCount(); i++) {
			if (venta.getCliente().getId() == this.jcbCliente.getItemAt(i).getId()) {
				this.jcbCliente.setSelectedIndex(i);
				break;
			}
		}
		
		// Cargo el valor del JComboBox del concesionario
		for (int i = 0; i < this.jcbConcesionario.getItemCount(); i++) {
			if (venta.getConcesionario().getId() == this.jcbConcesionario.getItemAt(i).getId()) {
				this.jcbConcesionario.setSelectedIndex(i);
				break;
			}
		}
		
		// Cargo el valor del JComboBox del coche
		for (int i = 0; i < this.jcbCoche.getItemCount(); i++) {
			if (venta.getCoche().getId() == this.jcbCoche.getItemAt(i).getId()) {
				this.jcbCoche.setSelectedIndex(i);
				break;
			}
		}
	}
	
	/**
	 * 
	 */
	private void cargaVentaDesdeComponentesVisuales () {
		try {
			fechaParseada = sdf.parse(this.jtfFecha.getText());
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Error en la introduccion de fecha \nLa fecha"
					+ " debe ser del formato: dd/mm/aaaa hh:mm:ss");
			System.out.println ("Error en el parseo de la fecha");
		}
		this.venta.setFecha(fechaParseada);
		
		this.venta.setPrecioVenta(Float.parseFloat(this.jtfPrecioVenta.getText()));
	
		this.venta.setCliente(((Cliente) this.jcbCliente.getSelectedItem()));
		this.venta.setConcesionario(((Concesionario) this.jcbConcesionario.getSelectedItem()));
		this.venta.setCoche(((Coche) this.jcbCoche.getSelectedItem()));
		
	}
	
	/**
	 * 
	 * @param gridX
	 * @param gridY
	 * @param pesoColumna
	 * @param pesoFila
	 * @param fill
	 */
	private void colocaComponente (int gridX, int gridY, int anchor, double pesoColumna, double pesoFila, int fill) {
		gridBagConstraints.gridx = gridX;
		gridBagConstraints.gridy = gridY;
		gridBagConstraints.anchor = anchor;
		gridBagConstraints.weightx = pesoColumna;
		gridBagConstraints.weighty = pesoFila;
		gridBagConstraints.fill = fill;
		
	}
}
