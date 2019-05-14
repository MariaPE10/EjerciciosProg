package awt_swing.JPA.Ejercicio_Provincias.gui;

import java.awt.BorderLayout;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import awt_swing.JPA.Ejercicio_Provincias.modelo.Provincia;
import awt_swing.JPA.Ejercicio_Provincias.modelo.controladores.ProvinciaControlador;

public class JPanelGestionProvinciasCheckBox extends JPanel {

	List<Provincia> provincias = ProvinciaControlador.getControlador().findAllProvincias();
	private Dimension dimension = new Dimension(250, 250);

	
	/**
	 * 
	 * @param opciones
	 * @return
	 */
	public JPanelGestionProvinciasCheckBox () {
		
		//Si se sacan del grupo, dejan de ser excluyentes.
		ButtonGroup grupoOpciones = new ButtonGroup();
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		for (int i = 0; i < provincias.size(); i++) {
			Provincia provincia = provincias.get(i);
			JCheckBox jch = new JCheckBox (provincia.toString());
//			jch.setSelected(true);
//			grupoOpciones.add(jch);
			panel.add(jch);
			
		}
		
		JScrollPane scroll = new JScrollPane(panel);
		scroll.setPreferredSize(dimension);
		this.setLayout(new BorderLayout());
		this.add(scroll,BorderLayout.CENTER );
	}
	
}
