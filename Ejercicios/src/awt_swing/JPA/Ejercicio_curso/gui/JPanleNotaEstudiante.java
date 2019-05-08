package awt_swing.JPA.Ejercicio_curso.gui;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.eclipse.persistence.jaxb.xmlmodel.XmlBindings.JavaTypes;

import awt_swing.JPA.Ejercicio_curso.modelo.Estudiante;

public class JPanleNotaEstudiante extends JPanel {

	private JSpinner jspnota;
	private Estudiante estudiante;
	private JLabel lbl;
	private Dimension dimension = new Dimension(40, 20);
	
	/**
	 * @param estud
	 */
	public JPanleNotaEstudiante(Estudiante estudiante) {
		super();
		this.estudiante = estudiante;
		this.jspnota = new JSpinner();
		this.lbl = new JLabel(estudiante.getNombre() + " " + estudiante.getPrimerApellido() + " " + estudiante.getSegundoApellido());
		this.jspnota.setMinimumSize(dimension);
		this.jspnota.setPreferredSize(dimension);
		this.add(lbl);
		this.add(jspnota);
	}

	/**
	 * @param jspnota the jspnota to set
	 */
	public void setNota(int nota) {
		this.jspnota.setValue(nota);
	}

	/**
	 * @return the nota
	 */
	public int getNota() {
		try {
			jspnota.commitEdit();
		} catch ( java.text.ParseException e ) {}
		return (Integer) jspnota.getValue();
	}

	/**
	 * @return the estudiante
	 */
	public Estudiante getEstudiante() {
		return estudiante;
	}
	
	
}
