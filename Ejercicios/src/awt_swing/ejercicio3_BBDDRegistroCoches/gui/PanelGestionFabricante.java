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
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import awt_swing.ejercicio3_BBDDRegistroCoches.modelo.ControladorBBDDCoche;
import awt_swing.ejercicio3_BBDDRegistroCoches.modelo.ControladorBBDDFabricante;
import awt_swing.ejercicio3_BBDDRegistroCoches.modelo.entidades.Coche;
import awt_swing.ejercicio3_BBDDRegistroCoches.modelo.entidades.Fabricante;
import awt_swing.ejercicio3_BBDDRegistroCoches.viejo.utils.*;

public class PanelGestionFabricante extends JPanel {

	GridBagConstraints gridBagConstraints = new GridBagConstraints();
	JTextField jtfId = new JTextField();
	JTextField jtfCif = new JTextField();
	JTextField jtfNombre = new JTextField();
	
	JButton jbtNavPrimero = new JButton();
	JButton jbtNavUltimo = new JButton();
	JButton jbtNavAnterior = new JButton();
	JButton jbtNavSiguiente = new JButton();
	JButton jbtGuardar = new JButton();
	JButton jbtNuevo = new JButton();
	JButton jbtEliminar = new JButton();
	
	Fabricante fabricante = new Fabricante(); // Coche mostrado en pantalla
	
	/**
	 * 
	 */
	public PanelGestionFabricante () {
		
		this.maquetarVentana();
		
		// Manejo de la navegaci�n de registros por rueda de rat�n
		//this.controlRuedaRaton();
		
		// Finalmente, despu�s de la construcci�n, cargamos el primer registro
		navegaAPrimero();
	}
	
	
//	/**
//	 * 
//	 */
//	private void controlRuedaRaton () {
//		this.addMouseWheelListener(new MouseWheelListener() {
//			@Override
//			public void mouseWheelMoved(MouseWheelEvent e) {
//				if (e.getUnitsToScroll() < 0) {
//					if (ControladorBBDDCoche.getSiguienteCoche(coche) != null) {
//						navegaASiguiente();
//					}
//				}
//				else {
//					if (ControladorBBDDCoche.getAnteriorCoche(coche) != null) {
//						navegaAAnterior();
//					}
//				}
//			}
//		});
//	}
	
	/**
	 * 
	 */
	private void maquetarVentana() {
		double pesoCol1 = 0.15, pesoCol2 = 1;
		
		this.setLayout(new GridBagLayout());

		gridBagConstraints.insets = new Insets(5, 5, 5, 5);

		// Incorporamos los components del Id
		colocaComponente(0, 0, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel("Id:"), gridBagConstraints);
		
		colocaComponente(1, 0, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		this.add(jtfId, gridBagConstraints);
		
		
		// Incorporamos el Cif
		colocaComponente(0, 2, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel("Cif:"), gridBagConstraints);
		
		colocaComponente(1, 2, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		this.add(jtfCif, gridBagConstraints);
		
		// Incorporamos el Nombre
		colocaComponente(0, 3, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel("Nombre:"), gridBagConstraints);
		
		colocaComponente(1, 3, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		this.add(jtfNombre, gridBagConstraints);
		
		
		// Incorporamos fila botones
		colocaComponente(0, 5, GridBagConstraints.NORTH, 1, 1, GridBagConstraints.BOTH);
		gridBagConstraints.gridwidth = 2;
		this.add(getBotonera(), gridBagConstraints);		
	}
	
	/**
	 * 
	 */
	private JPanel getBotonera() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		panel.setBackground(Color.yellow);
		
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
		Coche cocheAEliminar = this.coche;
		
		// Compruebo si el coche actual es el �ltimo coche
		if (ControladorBBDDCoche.getUltimoCoche().getId() == this.coche.getId()) {
			navegaAAnterior();
		}
		else {
			navegaASiguiente();
		}
		
		// Finalmente elimino el coche
		ControladorBBDDCoche.eliminarCoche(cocheAEliminar);
		
		// Actualizo la botonera
		this.actualizaEstadoBotonera();
	}
	
	
	/**
	 * 
	 */
	private void nuevo () {
		this.coche = new Coche();
		this.coche.setId(-1);
		this.jtfId.setText("" + -1);
		this.jtfCif.setText("");
		this.jtfNombre.setText("");

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
	
	
	
	private void guardar() {
		// Es un alta nueva o una modificaci�n
		cargaCocheDesdeComponentesVisuales();
		if (this.coche.getId() == -1) { // Alta
			ControladorBBDDCoche.guardarNuevoCoche(this.coche);
			this.navegaAUltimo();
		}
		else { // Modificaci�n
			ControladorBBDDCoche.modificarCoche(this.coche);
		}

		// Actualizo la botonera
		this.actualizaEstadoBotonera();
	}
	
	
	/**
	 * 
	 */
	private void navegaAPrimero () {
		fabricante = ControladorBBDDFabricante.getPrimerFabricante();
		cargaCocheEnComponentesVisuales();
		actualizaEstadoBotonera();
	}
	
	/**
	 * 
	 */
	private void navegaAUltimo () {
		fabricante = ControladorBBDDFabricante.getUltimoFabricante();
		cargaCocheEnComponentesVisuales();
		actualizaEstadoBotonera();
	}
	
	/**
	 * 
	 */
	private void navegaASiguiente () {
		fabricante = ControladorBBDDFabricante.getSiguienteFabricante(this.fabricante);
		cargaCocheEnComponentesVisuales();
		actualizaEstadoBotonera();
	}
	
	/**
	 * 
	 */
	private void navegaAAnterior () {
		coche = ControladorBBDDCoche.getAnteriorCoche(this.coche);
		cargaCocheEnComponentesVisuales();
		actualizaEstadoBotonera();
	}
	
	
	
	/**
	 * 
	 */
	private void actualizaEstadoBotonera () {
		if (ControladorBBDDCoche.getAnteriorCoche(this.coche) == null) {
			jbtNavPrimero.setEnabled(false);
			jbtNavAnterior.setEnabled(false);
		}
		else {
			jbtNavPrimero.setEnabled(true);
			jbtNavAnterior.setEnabled(true);
		}
		if (ControladorBBDDCoche.getSiguienteCoche(this.coche) == null) {
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
	private void cargaCocheEnComponentesVisuales () {
		this.jtfId.setText("" + coche.getId());
		this.jtfCif.setText(coche.getBastidor());
		this.jtfModelo.setText(coche.getModelo());
		this.jtfColor.setText(coche.getColor());
		// Cargo el valor del JComboBox del fabricante
		for (int i = 0; i < this.jcbFabricante.getItemCount(); i++) {
			if (coche.getIdFabricante() == this.jcbFabricante.getItemAt(i).getId()) {
				this.jcbFabricante.setSelectedIndex(i);
				break;
			}
		}		
	}
	
	/**
	 * 
	 */
	private void cargaCocheDesdeComponentesVisuales () {
		this.coche.setBastidor(this.jtfCif.getText());
		this.coche.setModelo(this.jtfNombre.getText());
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
