package awt_swing.ejercicio3_BBDDRegistroCoches.viejo;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import awt_swing.ejercicio3_BBDDRegistroCoches.viejo.utils.CacheImagenes;

public class PanelGestionCoche extends JPanel {

	JTextField jtfId = new JTextField();
	JTextField jtfBastidor = new JTextField();
	JTextField jtfModelo = new JTextField();
	JTextField jtfColor = new JTextField();
	JComboBox<String> jcbFabricante = new JComboBox<String>();
	GridBagConstraints gridBag = new GridBagConstraints();
	JButton btnPrimero = new JButton();
	JButton btnAnterior = new JButton();
	JButton btnSiguiente = new JButton();
	JButton btnUltimo = new JButton();
	
	/**
	 * 
	 */
	public PanelGestionCoche () {
		double pesoColumna1 = 0.3, pesoColumna2 = 1;
		
		this.setLayout(new GridBagLayout());
		
		//Primera fila "ID"
		colocaComponente(0, 0, GridBagConstraints.EAST, pesoColumna1, 0, GridBagConstraints.NONE);
		gridBag.insets = new Insets(5, 5, 5, 5);
		this.add(getEtiqueta("Id: "), gridBag);
		
		colocaComponente(1, 0, GridBagConstraints.EAST, pesoColumna2, 0, GridBagConstraints.HORIZONTAL);
		jtfId = getCampoTexto("Id", 20);
		this.add(jtfId, gridBag);
		
		//Segunda fila "FABRICANTE"
		colocaComponente(0, 1, GridBagConstraints.EAST, pesoColumna1, 0, GridBagConstraints.NONE);
		this.add(getEtiqueta("Fabricante: "), gridBag);
		
		colocaComponente(1, 1, GridBagConstraints.EAST, pesoColumna2, 0, GridBagConstraints.HORIZONTAL);
		this.add(jcbFabricante, gridBag);
		
		//Tercera Fila "BASTIDOR"
		colocaComponente(0, 2, GridBagConstraints.EAST, pesoColumna1, 0, GridBagConstraints.NONE);
		this.add(getEtiqueta("Bastidor: "), gridBag);
		
		colocaComponente(1, 2, GridBagConstraints.EAST, pesoColumna2, 0, GridBagConstraints.HORIZONTAL);
		jtfBastidor = getCampoTexto("Bastidor", 20);
		this.add(jtfBastidor, gridBag);
		
		//Cuarta Fila "MODELO"
		colocaComponente(0, 3, GridBagConstraints.EAST, pesoColumna1, 0, GridBagConstraints.NONE);
		this.add(getEtiqueta("Modelo: "), gridBag);
		
		colocaComponente(1, 3, GridBagConstraints.EAST, pesoColumna2, 0, GridBagConstraints.HORIZONTAL);
		jtfModelo = getCampoTexto("Modelo", 20);
		this.add(jtfModelo, gridBag);
		
		//Cuarta Fila "MODELO"
		colocaComponente(0, 4, GridBagConstraints.EAST, pesoColumna1, 0, GridBagConstraints.NONE);
		this.add(getEtiqueta("Color: "), gridBag);
		
		colocaComponente(1, 4, GridBagConstraints.EAST, pesoColumna2, 0, GridBagConstraints.HORIZONTAL);
		jtfColor = getCampoTexto("Color", 20);
		this.add(jtfColor, gridBag);
		
		//Quinta Fila "BOTONES"
		colocaComponente(0, 5, GridBagConstraints.NORTH, 1, 1, GridBagConstraints.BOTH);
		gridBag.gridwidth = 2;
		this.add(getPanelBonotes(), gridBag);
		
	}
	
	private JPanel getPanelBonotes() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		configuraBoton(btnAnterior, "gotostart.png");
		
		panel.add(btnAnterior);
		panel.add(btnPrimero);
		panel.add(btnSiguiente);
		panel.add(btnUltimo);
		
		return panel;
	}
	
	/**
	 * 
	 * @param texto
	 * @return
	 */
	private void configuraBoton (JButton boton, String texto) {
		boton.setIcon(CacheImagenes.getCacheImagenes().getIcono(texto));
	}
	
	/**
	 * 
	 * @param gridx
	 * @param gridy
	 * @param anchor
	 * @param pesoColumna
	 * @param pesoFila
	 * @param fill
	 */
	private void colocaComponente (int gridx, int gridy, int anchor, double pesoColumna, double pesoFila, int fill) {
		gridBag.gridx = gridx;
		gridBag.gridy = gridy;
		gridBag.anchor = anchor;
		gridBag.weightx = pesoColumna;
		gridBag.weighty = pesoFila;
		gridBag.fill = fill;
	}
	
	/**
	 * 
	 * @param texto
	 * @return
	 */
	private JLabel getEtiqueta (String texto) {
		JLabel etiqueta = new JLabel(texto);
		return etiqueta;
	}
	
	/**
	 * 
	 * @param texto
	 * @param columna
	 * @return
	 */
	private JTextField getCampoTexto(String texto, int columna) {
		JTextField txt = new JTextField(texto, columna);
		return txt;
	}
}
