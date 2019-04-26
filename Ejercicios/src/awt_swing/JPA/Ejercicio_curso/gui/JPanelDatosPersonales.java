package awt_swing.JPA.Ejercicio_curso.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import awt_swing.JPA.Ejercicio_curso.modelo.TipologiaSexo;
import awt_swing.JPA.Ejercicio_curso.modelo.controladores.TipologiaSexoControlador;

public class JPanelDatosPersonales extends JPanel {

	JTextField jtfId = new JTextField(5);
	JTextField jtfNombre = new JTextField(20);
	JTextField jtfPrimerApellido = new JTextField(20);
	JTextField jtfSegundoApellido = new JTextField(20);
	JTextField jtfDni = new JTextField(20);
	JTextField jtfDireccion = new JTextField(20);
	JTextField jtfEmail = new JTextField(20);
	JTextField jtfTelefono = new JTextField(20);
	JTextField jtfColor = new JTextField(20); 
	JComboBox<TipologiaSexo> jcbSexo = new JComboBox<>();
	JButton jbtImagen = new JButton("Cambiar Imagen");
	JButton jbtColor = new JButton("Elegir Color");
	JScrollPane panelScroll = new JScrollPane();
	JFileChooser jfileChooser;
	JColorChooser jColorChooser;
	JPopupMenu popup;
	private byte[] imagen = new byte[0];
	private byte[] imagenEnBlanco = new byte[0];
	private String color = "#FFFFFF";
	
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
	    
	    // Inclusion del JScrollPane para la imagen
	    c.gridx = 2;
	    c.gridheight = 5;
	    c.fill = GridBagConstraints.BOTH;
	    this.panelScroll.setPreferredSize(new Dimension(200, 200));
	    this.add(panelScroll, c);

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
	    
	    // Inclusion del JButton para la imagen
	    c.gridx = 2;
	    c.gridy = 5;
	    this.add(jbtImagen, c);
	    
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
	    
	    // Inclusion del JButton para cambiar el color
	    c.gridx = 0;
	    c.gridy = 9;
	    c.anchor = GridBagConstraints.EAST;
	    this.add(new JLabel("Color Preferido: "), c);
		
		c.gridx = 1;
	    c.anchor = GridBagConstraints.WEST;
	    jtfColor.setEnabled(false);
	    this.add(jtfColor, c);
	    
	    c.gridx = 2;
	    c.anchor = GridBagConstraints.WEST;
	    this.add(jbtColor, c);
	    
	    // Funcionalidad de los botones
	    jbtImagen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				seleccionaImagen();
				}
		});
	    
	    jbtColor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				seleccionaColor();
			}
		});
	    
	    creaPopup();
	    panelScroll.addMouseListener(new MouseAdapter() {
	    	@Override
			public void mousePressed(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	    
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
	public TipologiaSexo getTipologiaSexo() {
		return (TipologiaSexo) jcbSexo.getSelectedItem();
	}

	/**
	 * 
	 */
	public void setTipologiaSexo(TipologiaSexo tipoSex) {
		for (int i = 0; i < this.jcbSexo.getItemCount(); i++) {
			if (tipoSex.getId() == this.jcbSexo.getItemAt(i).getId()) {
				this.jcbSexo.setSelectedIndex(i);
			}
		}
	}
	
	/**
	 * 
	 */
	public String getColorPreferido() {
		return jtfColor.getText();
	}

	/**
	 * 
	 */
	public void setColorPreferido(String texto) {
		this.jtfColor.setText(texto);
	}
	
	/**
	 * 
	 */
	private void inicializaComboBoxSexo () {
		List<TipologiaSexo> opciones = TipologiaSexoControlador.getControlador().findAllTipologiaSexos();
		for (TipologiaSexo opcion : opciones) {
			jcbSexo.addItem(opcion);
		}
	}

	/**
	 * @return the imagen
	 */
	public byte[] getImagen() {
		return imagen;
	}

	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
		ImageIcon icono = new ImageIcon(imagen);
		JLabel lbl = new JLabel (icono);
		this.panelScroll.setViewportView(lbl);
	}
	
	/**
	 * 
	 */
	private void seleccionaImagen () {
		this.jfileChooser = new JFileChooser();
		
		//this.jfileChooser.setCurrentDirectory(new File("C:\\"));
		this.jfileChooser.setCurrentDirectory(new File("/home/diurno/Escritorio"));
		
		// Tipo de selecci�n que se hace en el di�logo
		this.jfileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		// Filtro del tipo de ficheros que puede abrir
		this.jfileChooser.setFileFilter(new FileFilter() {
			
			@Override
			public boolean accept(File f) {
				if (f.isFile() && f.getAbsolutePath().endsWith(".png") || f.getAbsolutePath().endsWith(".jpg")) 
					return true;
				return false;
			}

			@Override
			public String getDescription() {
				return "Archivos de imagen *.png *.jpg";
			}
		});
		
		int seleccionUsuario = jfileChooser.showOpenDialog(null);
		
		if (seleccionUsuario == JFileChooser.APPROVE_OPTION) {
			File archivoImagen = this.jfileChooser.getSelectedFile();
			
			try {
				BufferedImage imagenUsu = ImageIO.read(archivoImagen);
				int ancho = imagenUsu.getWidth();
				int alto = imagenUsu.getHeight();
				
				if (archivoImagen != null && archivoImagen.isFile() && alto==300 && ancho == 300) {
					try {
						byte[] imagenEnBytes = Files.readAllBytes(archivoImagen.toPath());
						
						if (imagenEnBytes.length > 0) {
							setImagen(imagenEnBytes);
						}
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "La imagen seleccionada no tiene las dimensiones requeridas (300x300)", "Error", 0);
				}
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
	}

	/**
	 * @return the imagenEnBlanco
	 */
	public byte[] getImagenEnBlanco() {
		return imagenEnBlanco;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	
	/**
	 * 
	 */
	private void seleccionaColor () {
		Color color = jColorChooser.showDialog(null, "Seleccione un Color", Color.gray);
		// Si el usuario pulsa sobre aceptar, el color elegido no ser� nulo
		if (color != null) {
			String strColor = "#"+Integer.toHexString(color.getRGB()).substring(2);
			this.jtfColor.setText(strColor);
			this.setBackground(Color.decode(strColor));
		}
	}
	
	/**
	 * 
	 */
	private void creaPopup () {
		popup = new JPopupMenu();
		JMenuItem opcion1 = new JMenuItem("Dimensiones");
		JMenuItem opcion2 = new JMenuItem("Cambiar Imagen");
		
		opcion1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ImageIcon icono = new ImageIcon(imagen);
				int ancho = icono.getIconWidth();
				int alto = icono.getIconHeight();
				
				JOptionPane.showMessageDialog(null, "Tamaño: " + ancho + "x" + alto, "Dimensiones", 1);
			}
		});
		
		opcion2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				seleccionaImagen();
			}
		});
		
		popup.add(opcion1);
		popup.add(opcion2);
	}
	
}