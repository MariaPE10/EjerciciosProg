package awt_swing.JPA.Ejercicio_curso.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.eclipse.persistence.jaxb.xmlmodel.XmlBindings.JavaTypes;

import awt_swing.JPA.Ejercicio_curso.modelo.Estudiante;

public class JPanleNotaEstudiante extends JPanel {

	private JTextField jtfnota;
	private Estudiante estudiante;
	private JLabel lbl;
	
	/**
	 * @param estud
	 */
	public JPanleNotaEstudiante(Estudiante estudiante) {
		super();
		this.estudiante = estudiante;
		this.jtfnota = new JTextField();
		this.lbl = new JLabel(estudiante.getNombre() + " " + estudiante.getPrimerApellido() + " " + estudiante.getSegundoApellido());
		this.jtfnota.setColumns(5);
		this.add(lbl);
		this.add(jtfnota);
	}

	/**
	 * @return the nota
	 */
	public JTextField getJtfNota() {
		return jtfnota;
	}

	/**
	 * @return the estudiante
	 */
	public Estudiante getEstudiante() {
		return estudiante;
	}
	
	
}
