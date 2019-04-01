package awt_swing.ejercicio3_BBDDRegistroCoches.gui;

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

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import awt_swing.ejercicio3_BBDDRegistroCoches.modelo.ControladorBBDDCliente;
import awt_swing.ejercicio3_BBDDRegistroCoches.modelo.entidades.Cliente;
import awt_swing.ejercicio3_BBDDRegistroCoches.viejo.utils.*;

public class PanelGestionCliente extends JPanel {

	GridBagConstraints gridBagConstraints = new GridBagConstraints();
	//JTextField jtfId = new JTextField();
	private int id;
	JTextField jtfNombre = new JTextField();
	JTextField jtfApellidos = new JTextField();
	JTextField jtfLocalidad = new JTextField();
	JTextField jtfDni = new JTextField();
	JTextField jtfFechaNac = new JTextField();
	JSlider jslR = configuraSlider(0, 255, 0);
	JSlider jslG = configuraSlider(0, 255, 0);
	JSlider jslB = configuraSlider(0, 255, 0);
	JPanel panelBotones;
	
	JButton jbtNavPrimero = new JButton();
	JButton jbtNavUltimo = new JButton();
	JButton jbtNavAnterior = new JButton();
	JButton jbtNavSiguiente = new JButton();
	JButton jbtGuardar = new JButton();
	JButton jbtNuevo = new JButton();
	JButton jbtEliminar = new JButton();
	
	Cliente cliente = new Cliente(); // Coche mostrado en pantalla
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Date fechaParseada = null;
	
	/**
	 * 
	 */
	public PanelGestionCliente () {
		
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
					if (ControladorBBDDCliente.getSiguienteCliente(cliente) != null) {
						navegaASiguiente();
					}
				}
				else {
					if (ControladorBBDDCliente.getAnteriorCliente(cliente) != null) {
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
		
		// Incorporamos el Nombre
		colocaComponente(0, 1, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel("Nombre:"), gridBagConstraints);
		
		colocaComponente(1, 1, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		this.add(jtfNombre, gridBagConstraints);
		
		// Incorporamos el Apellidos
		colocaComponente(0, 2, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel("Apellidos:"), gridBagConstraints);
		
		colocaComponente(1, 2, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		this.add(jtfApellidos, gridBagConstraints);
		
		// Incorporamos el Localidad
		colocaComponente(0, 3, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel("Localidad:"), gridBagConstraints);
		
		colocaComponente(1, 3, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		this.add(jtfLocalidad, gridBagConstraints);
		
		// Incorporamos el Dni
		colocaComponente(0, 4, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel("Dni:"), gridBagConstraints);
		
		colocaComponente(1, 4, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		this.add(jtfDni, gridBagConstraints);
		
		// Incorporamos el FechaNac
		colocaComponente(0, 5, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel("Fecha Nacimiento:"), gridBagConstraints);
		
		colocaComponente(1, 5, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		this.add(jtfFechaNac, gridBagConstraints);
				
		// Incorporamos el R
		colocaComponente(0, 6, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel("R:"), gridBagConstraints);
		
		colocaComponente(1, 6, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		this.add(jslR, gridBagConstraints);
		
		// Incorporamos el G
		colocaComponente(0, 7, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel("G:"), gridBagConstraints);
		
		colocaComponente(1, 7, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		this.add(jslG, gridBagConstraints);
		
		// Incorporamos el B
		colocaComponente(0, 8, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel("B:"), gridBagConstraints);
		
		colocaComponente(1, 8, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		this.add(jslB, gridBagConstraints);
		
		// Incorporamos fila botones
		colocaComponente(0, 9, GridBagConstraints.NORTH, 1, 1, GridBagConstraints.BOTH);
		gridBagConstraints.gridwidth = 2;
		this.add(getBotonera(), gridBagConstraints);		
	}
	

	/**
	 * 
	 */
	private JPanel getBotonera() {
		panelBotones = new JPanel();
		panelBotones.setLayout(new FlowLayout());
		
		panelBotones.setBackground(Color.white);
		
		// Configuramos los botones
		configuraBoton(jbtNavPrimero, "gotostart.png", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				navegaAPrimero();
			}
		});
		configuraBoton(jbtNavAnterior, "previous.png", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				navegaAAnterior();
			}
		});
		configuraBoton(jbtNavSiguiente, "next.png", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				navegaASiguiente();
			}
		});
		configuraBoton(jbtNavUltimo, "gotoend.png", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				navegaAUltimo();
			}
		});
		configuraBoton(jbtGuardar, "guardar.png", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				guardar();
			}
		});
		configuraBoton(jbtNuevo, "nuevo.png", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				nuevo();
			}
		});
		configuraBoton(jbtEliminar, "eliminar.png", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				eliminar();
			}
		});
		
		//Inclu�mos los botones
		panelBotones.add(jbtNavPrimero);
		panelBotones.add(jbtNavAnterior);
		panelBotones.add(jbtNavSiguiente);
		panelBotones.add(jbtNavUltimo);
		panelBotones.add(jbtGuardar);
		panelBotones.add(jbtNuevo);
		panelBotones.add(jbtEliminar);
		
		
		return panelBotones;
	}
	
	/**
	 * 
	 */
	private void eliminar() {
		// Por regla general, siempre que eliminemos un coche navegaremos al siguiente
		// registro
		Cliente clienteAEliminar = this.cliente;
		
		// Compruebo si el coche actual es el �ltimo coche
		if (ControladorBBDDCliente.getUltimoCliente().getId() == this.cliente.getId()) {
			navegaAAnterior();
		}
		else {
			navegaASiguiente();
		}
		
		// Finalmente elimino el coche
		ControladorBBDDCliente.eliminarCliente(clienteAEliminar);
		
		// Actualizo la botonera
		this.actualizaEstadoBotonera();
	}
	
	
	/**
	 * 
	 */
	private void nuevo () {
		this.cliente = new Cliente();
		this.cliente.setId(-1);
		this.id = -1;
		this.jtfNombre.setText("");
		this.jtfApellidos.setText("");
		this.jtfLocalidad.setText("");
		this.jtfDni.setText("");
		this.jtfFechaNac.setText("");
		
		// Actualizo la botonera
		this.actualizaEstadoBotonera();
	}
	
	/**
	 * 
	 * @param jbt
	 * @param icono
	 */
	private void configuraBoton (JButton jbt, String icono, ActionListener actionListener) {
		jbt.setIcon(CacheImagenes.getCacheImagenes().getIcono(icono));
		jbt.addActionListener(actionListener);
	}
	
	/**
	 * 
	 * @param min
	 * @param max
	 * @param init
	 * @return
	 */
	private JSlider configuraSlider(int min, int max, int init) {
		JSlider slider = new JSlider(JSlider.HORIZONTAL, min, max, init);
		slider.setPaintLabels(true);
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//Llamar a coger valor de cada slider pasarlo a hezadecimal y concatenarlos
				getColor();
			}
		});
		return slider;
	 }
	
	/**
	 * 
	 */
	private void getColor() {
		String rojo, verde, azul;
		
		rojo = Integer.toHexString(jslR.getValue());
		if (rojo.length() < 2) rojo = "0" + rojo;
		verde = Integer.toHexString(jslG.getValue());
		if (verde.length() < 2) verde = "0" + verde;
		azul = Integer.toHexString(jslB.getValue());
		if (azul.length() < 2) azul = "0" + azul;
		
		String str = "#" + rojo + verde + azul; 
		
		//System.out.println("color: " + str);
		
		panelBotones.setBackground(Color.decode(str));
		
	}
	
	/**
	 * 
	 */
	private void guardar() {
		// Es un alta nueva o una modificaci�n
		cargaClienteDesdeComponentesVisuales();
		if (this.cliente.getId() == -1) { // Alta
			ControladorBBDDCliente.guardarNuevoCliente(this.cliente);
			this.navegaAUltimo();
		}
		else { // Modificaci�n
			ControladorBBDDCliente.modificarCliente(this.cliente);
		}

		// Actualizo la botonera
		this.actualizaEstadoBotonera();
	}
	
	
	/**
	 * 
	 */
	private void navegaAPrimero () {
		cliente = ControladorBBDDCliente.getPrimerCliente();
		cargaClienteEnComponentesVisuales();
		actualizaEstadoBotonera();
	}
	
	/**
	 * 
	 */
	private void navegaAUltimo () {
		cliente = ControladorBBDDCliente.getUltimoCliente();
		cargaClienteEnComponentesVisuales();
		actualizaEstadoBotonera();
	}
	
	/**
	 * 
	 */
	private void navegaASiguiente () {
		cliente = ControladorBBDDCliente.getSiguienteCliente(this.cliente);
		cargaClienteEnComponentesVisuales();
		actualizaEstadoBotonera();
	}
	
	/**
	 * 
	 */
	private void navegaAAnterior () {
		cliente = ControladorBBDDCliente.getAnteriorCliente(this.cliente);
		cargaClienteEnComponentesVisuales();
		actualizaEstadoBotonera();
	}
	
	
	
	/**
	 * 
	 */
	private void actualizaEstadoBotonera () {
		if (ControladorBBDDCliente.getAnteriorCliente(this.cliente) == null) {
			jbtNavPrimero.setEnabled(false);
			jbtNavAnterior.setEnabled(false);
		}
		else {
			jbtNavPrimero.setEnabled(true);
			jbtNavAnterior.setEnabled(true);
		}
		if (ControladorBBDDCliente.getSiguienteCliente(this.cliente) == null) {
			jbtNavSiguiente.setEnabled(false);
			jbtNavUltimo.setEnabled(false);
		}
		else {
			jbtNavSiguiente.setEnabled(true);
			jbtNavUltimo.setEnabled(true);
		}
	}
	
	/**
	 * 
	 */
	private void cargaClienteEnComponentesVisuales () {
		//this.jtfId.setText("" + cliente.getId());
		this.jtfNombre.setText(cliente.getNombre());
		this.jtfApellidos.setText(cliente.getApellidos());
		this.jtfLocalidad.setText(cliente.getLocalidad());
		this.jtfDni.setText(cliente.getDni());
		this.jtfFechaNac.setText(sdf.format(cliente.getFechaNacimiento()));
				
	}
	
	/**
	 * 
	 */
	private void cargaClienteDesdeComponentesVisuales () {
		this.cliente.setNombre(this.jtfNombre.getText());
		this.cliente.setApellidos(this.jtfApellidos.getText());
		this.cliente.setLocalidad(this.jtfLocalidad.getText());
		this.cliente.setDni(this.jtfDni.getText());
		try {
			fechaParseada = sdf.parse(this.jtfFechaNac.getText());
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Error en la introduccion de fecha /nLa fecha"
					+ " debe ser del formato: dd/mm/aaaa hh:mm:ss");
			System.out.println ("Error en el parseo de la fecha");
		}
		this.cliente.setFechaNacimiento(fechaParseada);
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
