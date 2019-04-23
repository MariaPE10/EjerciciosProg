package awt_swing.JPA.Ejercicio_curso.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import awt_swing.ejercicio3_BBDDRegistroCoches_JDBC.modelo.entidades.Fabricante;

public class JPanelDatosPersonales extends JPanel {

	JTextField jtfId = new JTextField(5);
	JTextField jtfNombre = new JTextField(20);
	JTextField jtfPrimerApellido = new JTextField(20);
	JTextField jtfSegundoApellido = new JTextField(20);
	JTextField jtfDni = new JTextField(20);
	JTextField jtfDireccion = new JTextField(20);
	JTextField jtfEmail = new JTextField(20);
	JTextField jtfTelefono = new JTextField(20);
	JComboBox<String> jcbSexo = new JComboBox<>();
	
	public static final String[] SEXO_TIPOS = {"Mujer", "Hombre", "Otro"};
	
	
	/**
	 * 
	 */
	public JPanelDatosPersonales() {
		super();
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		// Inclusion del JTextField para el Id
		c.gridx = 0;
	    c.gridy = 0;
	    c.insets = new Insets(5, 5, 5, 5);
	    c.anchor = GridBagConstraints.EAST;
	    this.add(new JLabel("Identificador: "), c);
		
		c.gridx = 1;
	    jtfId.setEnabled(false);
	    c.anchor = GridBagConstraints.WEST;
	    //jtfId.setMinimumSize(minimaDimensionJTextField);
	    this.add(jtfId, c);

		// Inclusion del JTextField para el nombre
		c.gridx = 0;
	    c.gridy = 1;
	    c.anchor = GridBagConstraints.EAST;
	    this.add(new JLabel("Nombre: "), c);
		
		c.gridx = 1;
	    c.anchor = GridBagConstraints.WEST;
	    this.add(jtfNombre, c);
	    
	    // Inclusion del JTextField para el primer apellid0
		c.gridx = 0;
	    c.gridy = 2;
	    c.anchor = GridBagConstraints.EAST;
	    this.add(new JLabel("Primer Apellido: "), c);
		
		c.gridx = 1;
	    c.anchor = GridBagConstraints.WEST;
	    this.add(jtfPrimerApellido, c);
	    
	    // Inclusion del JTextField para el segundo apellido
		c.gridx = 0;
	    c.gridy = 3;
	    c.anchor = GridBagConstraints.EAST;
	    this.add(new JLabel("Segundo Apellido: "), c);
		
		c.gridx = 1;
	    c.anchor = GridBagConstraints.WEST;
	    this.add(jtfSegundoApellido, c);
	    
	    // Inclusion del JComboBox para el sexo
		c.gridx = 0;
	    c.gridy = 4;
	    c.anchor = GridBagConstraints.EAST;
	    this.add(new JLabel("Sexo: "), c);
		
		c.gridx = 1;
	    c.anchor = GridBagConstraints.WEST;
	    inicializaComboBoxSexo();
	    this.add(jcbSexo, c);
	    
	    // Inclusion del JTextField para el dni
		c.gridx = 0;
	    c.gridy = 5;
	    c.anchor = GridBagConstraints.EAST;
	    this.add(new JLabel("DNI: "), c);
		
		c.gridx = 1;
	    c.anchor = GridBagConstraints.WEST;
	    this.add(jtfDni, c);
	    
	    // Inclusion del JTextField para el direccion
		c.gridx = 0;
	    c.gridy = 6;
	    c.anchor = GridBagConstraints.EAST;
	    this.add(new JLabel("Direccion: "), c);
		
		c.gridx = 1;
	    c.anchor = GridBagConstraints.WEST;
	    this.add(jtfDireccion, c);
	 		    
	    // Inclusion del JTextField para el email
		c.gridx = 0;
	    c.gridy = 7;
	    c.anchor = GridBagConstraints.EAST;
	    this.add(new JLabel("Email: "), c);
		
		c.gridx = 1;
	    c.anchor = GridBagConstraints.WEST;
	    this.add(jtfEmail, c);
	    
	    // Inclusion del JTextField para el tlf
		c.gridx = 0;
	    c.gridy = 8;
	    c.anchor = GridBagConstraints.EAST;
	    this.add(new JLabel("Telefono: "), c);
		
		c.gridx = 1;
	    c.anchor = GridBagConstraints.WEST;
	    this.add(jtfTelefono, c);
	}

	/**
	 * 
	 */
	public String getDireccion() {
		return jtfDireccion.getText();
	}

	/**
	 * 
	 */
	public void setDireccion(String texto) {
		this.jtfDireccion.setText(texto);
	}
	
	/**
	 * 
	 */
	public String getId() {
		return jtfId.getText();
	}

	/**
	 * 
	 */
	public void setId(String texto) {
		this.jtfId.setText(texto);
	}
	/**
	 * 
	 */
	public String getNombre() {
		return jtfNombre.getText();
	}

	/**
	 * 
	 */
	public void setNombre(String texto) {
		this.jtfNombre.setText(texto);
	}
	
	/**
	 * 
	 */
	public String getPrimerAp() {
		return jtfPrimerApellido.getText();
	}

	/**
	 * 
	 */
	public void setPrimerAp(String texto) {
		this.jtfPrimerApellido.setText(texto);
	}
	
	/**
	 * 
	 */
	public String getSegundoAp() {
		return jtfSegundoApellido.getText();
	}

	/**
	 * 
	 */
	public void setSegundoAp(String texto) {
		this.jtfSegundoApellido.setText(texto);
	}
	
	/**
	 * 
	 */
	public String getDni() {
		return jtfDni.getText();
	}

	/**
	 * 
	 */
	public void setDni(String texto) {
		this.jtfDni.setText(texto);
	}
	
	/**
	 * 
	 */
	public String getEmail() {
		return jtfEmail.getText();
	}

	/**
	 * 
	 */
	public void setEmail(String texto) {
		this.jtfEmail.setText(texto);
	}
	
	/**
	 * 
	 */
	public String getTelefono() {
		return jtfTelefono.getText();
	}

	/**
	 * 
	 */
	public void setTelefono(String texto) {
		this.jtfTelefono.setText(texto);
	}

	/**
	 * 
	 */
	public String getSexo() {
		return (String) jcbSexo.getSelectedItem();
	}

	/**
	 * 
	 */
	public void setSexo(String newSexo) {
		for (int i = 0; i < SEXO_TIPOS.length; i++) {
			if (SEXO_TIPOS[i].equals(newSexo)) {
				jcbSexo.setSelectedIndex(i);
			}
		}
	}
	
	/**
	 * 
	 */
	private void inicializaComboBoxSexo () {
		for (String sexo : SEXO_TIPOS) {
			jcbSexo.addItem(sexo);
		}
	}
}
