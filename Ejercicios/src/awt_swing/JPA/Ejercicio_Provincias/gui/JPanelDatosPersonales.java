package awt_swing.JPA.Ejercicio_Provincias.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import awt_swing.JPA.Ejercicio_Provincias.modelo.Provincia;
import awt_swing.JPA.Ejercicio_Provincias.modelo.controladores.ProvinciaControlador;

public class JPanelDatosPersonales extends JPanel {

	JTextField jtfId = new JTextField(5);
	JTextField jtfNombre = new JTextField(20);
	JTextField jtfPrimerApellido = new JTextField(20);
	JTextField jtfSegundoApellido = new JTextField(20);
	JFormattedTextField jftfFecha = null;
	JSpinner jspEdad = new JSpinner();
	JCheckBox jcheckActivo = new JCheckBox();
	JComboBox<Provincia> jcbProvincia = new JComboBox<>();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Dimension dimension = new Dimension(40, 20);

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
	    this.add(jtfId, c);

		// Inclusion del JTextField para el nombre
		c.gridx = 0;
	    c.gridy = 1;
	    c.gridheight = 1;
	    c.fill = GridBagConstraints.NONE;
	    c.anchor = GridBagConstraints.EAST;
	    this.add(new JLabel("Nombre: "), c);
		
		c.gridx = 1;
	    c.anchor = GridBagConstraints.WEST;
	    this.add(jtfNombre, c);

	    // Inclusion del JTextField para el primer apellido
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
	    this.add(new JLabel("Provincia: "), c);
		
		c.gridx = 1;
	    c.anchor = GridBagConstraints.WEST;
	    inicializaComboBoxProvincia();
	    this.add(jcbProvincia, c);
	    
	    // Inclusion del JTextField para el dni
		c.gridx = 0;
	    c.gridy = 5;
	    c.anchor = GridBagConstraints.EAST;
	    this.add(new JLabel("Fecha Nacimiento: "), c);
		
		c.gridx = 1;
	    c.anchor = GridBagConstraints.WEST;
	    getJFormattedTextFieldFecha();
	    this.add(jftfFecha, c);
	    
	    // Inclusion del JTextField para el direccion
		c.gridx = 0;
	    c.gridy = 6;
	    c.anchor = GridBagConstraints.EAST;
	    this.add(new JLabel("Edad: "), c);
		
		c.gridx = 1;
	    c.anchor = GridBagConstraints.WEST;
	    this.jspEdad.setMinimumSize(dimension);
		this.jspEdad.setPreferredSize(dimension);
	    this.add(jspEdad, c);
	 		    
	    // Inclusion del JTextField para el email
		c.gridx = 0;
	    c.gridy = 7;
	    c.anchor = GridBagConstraints.EAST;
	    this.add(new JLabel("Activo: "), c);
		
		c.gridx = 1;
	    c.anchor = GridBagConstraints.WEST;
	    this.add(jcheckActivo, c);
	    
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
	public int getEdad() {
		try {
			jspEdad.commitEdit();
		} catch ( java.text.ParseException e ) {}
		return (Integer) jspEdad.getValue();
	}

	/**
	 * 
	 */
	public void setEdad(int valor) {
		this.jspEdad.setValue(valor);;
	}
	
	/**
	 * 
	 */
	public String getFechaNac() {
		return jftfFecha.getText();
	}

	/**
	 * 
	 */
	public void setFechaNac(Date texto) {
		this.jftfFecha.setValue(texto);
	}
	
	/**
	 * 
	 */
	public boolean getActivo() {
		return jcheckActivo.isSelected();
	}

	/**
	 * 
	 */
	public void setActivo(boolean activo) {
		this.jcheckActivo.setSelected(activo);
	}

	/**
	 * 
	 */
	public Provincia getProvincia() {
		return (Provincia) jcbProvincia.getSelectedItem();
	}

	/**
	 * 
	 */
	public void setProvincia(Provincia tipoProvincia) {
		for (int i = 0; i < this.jcbProvincia.getItemCount(); i++) {
			if (tipoProvincia.getId() == this.jcbProvincia.getItemAt(i).getId()) {
				this.jcbProvincia.setSelectedIndex(i);
			}
		}
	}
	
	/**
	 * 
	 */
	private void inicializaComboBoxProvincia () {
		List<Provincia> opciones = ProvinciaControlador.getControlador().findAllProvincias();
		for (Provincia opcion : opciones) {
			jcbProvincia.addItem(opcion);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	private void getJFormattedTextFieldFecha() {

		 jftfFecha = new JFormattedTextField(new JFormattedTextField.AbstractFormatter() {
			 
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
		 jftfFecha.setColumns(7);
		 jftfFecha.setValue(new Date());
	}
	
}