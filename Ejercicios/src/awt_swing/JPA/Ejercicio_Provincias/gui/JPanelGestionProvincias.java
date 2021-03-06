package awt_swing.JPA.Ejercicio_Provincias.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import awt_swing.JPA.Ejercicio_Provincias.modelo.Provincia;
import awt_swing.JPA.Ejercicio_Provincias.modelo.controladores.ProvinciaControlador;

public class JPanelGestionProvincias extends JPanel {

	List<Provincia> provincias = ProvinciaControlador.getControlador().findAllProvincias();
	private Dimension dimension = new Dimension(250, 250);

	
	/**
	 * 
	 * @param opciones
	 * @return
	 */
	public JPanelGestionProvincias () {
		
		ButtonGroup grupoOpciones = new ButtonGroup();
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		for (int i = 0; i < provincias.size(); i++) {
			Provincia provincia = provincias.get(i);
			JRadioButton jrb = new JRadioButton (provincia.toString());
			jrb.setSelected(true);
			grupoOpciones.add(jrb);
			panel.add(jrb);
		}
		
		JScrollPane scroll = new JScrollPane(panel);
		scroll.setPreferredSize(dimension);
		this.setLayout(new BorderLayout());
		this.add(scroll,BorderLayout.CENTER );
	}
	
}
