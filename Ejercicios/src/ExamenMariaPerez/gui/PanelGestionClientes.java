package ExamenMariaPerez.gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import ExamenMariaPerez.modelo.Cliente;
import ExamenMariaPerez.modelo.Provincia;
import ExamenMariaPerez.modelo.controladores.ClienteControlador;
import ExamenMariaPerez.modelo.controladores.ProvinciaControlador;
import awt_swing.ejercicio3_BBDDRegistroCoches_JDBC.viejo.utils.CacheImagenes;


public class PanelGestionClientes extends JPanel {

	
	public static int LOAD_FIRST = 0;
	public static int LOAD_PREV = 1;
	public static int LOAD_NEXT = 2;
	public static int LOAD_LAST = 3;
	public static int NEW = 4;
	public static int SAVE = 5;
	public static int REMOVE = 6;
	
	Cliente actual = null;
	
	//Dimension minimaDimensionJTextField = new Dimension(150, 20);
	
	JTextField jtfId = new JTextField(5);
	JTextField jtfPrimerAp = new JTextField(20);
	JTextField jtfSegundoAp = new JTextField(20);
	JTextField jtfCP = new JTextField(20);
	JTextField jtfDireccion = new JTextField(20);
	JTextField jtfEmail = new JTextField(20);
	JTextField jtfLocalidad = new JTextField(20);
	JTextField jtfNombre = new JTextField(20);
	JTextField jtfTlf = new JTextField(20);
	JComboBox<Provincia> jcbProvincia = new JComboBox<Provincia>();
	
	GridBagConstraints gridBagConstraints = new GridBagConstraints();
	
		/**
		 * 
		 */
		public PanelGestionClientes() {
			super();
			this.setLayout(new BorderLayout());
			
			this.add(getBarraHerramientas(), BorderLayout.NORTH);
			this.add(getPanelGestion(), BorderLayout.CENTER);
			
			this.actual = ClienteControlador.getControlador().findFirst();
			cargarDatosActual();
		}
		
		/**
		 * 
		 * @return
		 */
		private JToolBar getBarraHerramientas() {
			JToolBar toolbar = new JToolBar();
			JButton jbtPrimero = new JButton();
			asignarFuncion(jbtPrimero, "gotostart.png", LOAD_FIRST);
			JButton jbtAnterior = new JButton();
			asignarFuncion(jbtAnterior, "previous.png", LOAD_PREV);
			JButton jbtSiguiente = new JButton();
			asignarFuncion(jbtSiguiente, "next.png", LOAD_NEXT);
			JButton jbtUltimo = new JButton();
			asignarFuncion(jbtUltimo, "gotoend.png", LOAD_LAST);
			JButton jbtNuevo = new JButton();
			asignarFuncion(jbtNuevo, "nuevo.png", NEW);
			JButton jbtGuardar = new JButton();
			asignarFuncion(jbtGuardar, "guardar.png", SAVE);
			JButton jbtEliminar = new JButton();
			asignarFuncion(jbtEliminar, "eliminar.png", REMOVE);
		
			toolbar.add(jbtPrimero);
			toolbar.add(jbtAnterior);
			toolbar.add(jbtSiguiente);
			toolbar.add(jbtUltimo);
			toolbar.add(jbtNuevo);
			toolbar.add(jbtGuardar);
			toolbar.add(jbtEliminar);
			
			return toolbar;
		}
		
		/**
		 * 
		 * @param jbt
		 * @param funcion
		 */
		private void asignarFuncion (JButton jbt, String icono, final int funcion) {
			jbt.setIcon(CacheImagenes.getCacheImagenes().getIcono(icono));
			jbt.addActionListener(new ActionListener () {
				public void actionPerformed(ActionEvent arg0) {
					
					Cliente obtenido = null;
					if (funcion == LOAD_FIRST)
						obtenido = ClienteControlador.getControlador().findFirst();
					if (funcion == LOAD_PREV) 
						obtenido = ClienteControlador.getControlador().findPrevious(actual);
					if (funcion == LOAD_NEXT) 
						obtenido = ClienteControlador.getControlador().findNext(actual);
					if (funcion == LOAD_LAST) 
						obtenido = ClienteControlador.getControlador().findLast();
					if (funcion == NEW) 
						nuevo();
					if (funcion == SAVE) 
						guardar();
					if (funcion == REMOVE) 
						obtenido = eliminar();
					
					if (obtenido != null) {
						actual = obtenido;
						cargarDatosActual();
					}
				}});
		}
		

		/**
		 * 
		 */
		private JPanel getPanelGestion () {
			JPanel panelGestion = new JPanel();
			panelGestion.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();

			// Inclusion del JTextField para el Id
			c.gridx = 0;
		    c.gridy = 0;
		    c.insets = new Insets(5, 5, 5, 5);
		    c.anchor = GridBagConstraints.EAST;
		    panelGestion.add(new JLabel("Identificador: "), c);
			
			c.gridx = 1;
		    jtfId.setEnabled(false);
		    c.anchor = GridBagConstraints.WEST;
		    //jtfId.setMinimumSize(minimaDimensionJTextField);
		    panelGestion.add(jtfId, c);

			// Inclusion del JTextField para el primer apellido
			c.gridx = 0;
		    c.gridy = 1;
		    c.anchor = GridBagConstraints.EAST;
		    panelGestion.add(new JLabel("Primer Apellido: "), c);
			
			c.gridx = 1;
		    c.anchor = GridBagConstraints.WEST;
		    panelGestion.add(jtfPrimerAp, c);
		    
		    // Inclusion del JTextField para el segundo apellido
 			c.gridx = 0;
 		    c.gridy = 2;
 		    c.anchor = GridBagConstraints.EAST;
 		    panelGestion.add(new JLabel("Segundo Apellido: "), c);
 			
 			c.gridx = 1;
 		    c.anchor = GridBagConstraints.WEST;
 		    panelGestion.add(jtfSegundoAp, c);
    
		    // Inclusion del JTextField para el CP
 			c.gridx = 0;
 		    c.gridy = 3;
 		    c.anchor = GridBagConstraints.EAST;
 		    panelGestion.add(new JLabel("Codigo Postal: "), c);
 			
 			c.gridx = 1;
 		    c.anchor = GridBagConstraints.WEST;
 		    panelGestion.add(jtfCP, c);
 		    
 		    // Inclusion del JTextField para el direccion
 			c.gridx = 0;
 		    c.gridy = 4;
 		    c.anchor = GridBagConstraints.EAST;
 		    panelGestion.add(new JLabel("Direccion: "), c);
 			
 			c.gridx = 1;
 		    c.anchor = GridBagConstraints.WEST;
 		    panelGestion.add(jtfDireccion, c);
 		    
 		    // Inclusion del JTextField para el email
 			c.gridx = 0;
 		    c.gridy = 5;
 		    c.anchor = GridBagConstraints.EAST;
 		    panelGestion.add(new JLabel("Email: "), c);
 			
 			c.gridx = 1;
 		    c.anchor = GridBagConstraints.WEST;
 		    panelGestion.add(jtfEmail, c);
 		    
 		    // Inclusion del JTextField para el localidad
 			c.gridx = 0;
 		    c.gridy = 6;
 		    c.anchor = GridBagConstraints.EAST;
 		    panelGestion.add(new JLabel("Localidad: "), c);
 			
 			c.gridx = 1;
 		    c.anchor = GridBagConstraints.WEST;
 		    panelGestion.add(jtfLocalidad, c);
 		    
 		    // Inclusion del JTextField para el Nombre
 			c.gridx = 0;
 		    c.gridy = 7;
 		    c.anchor = GridBagConstraints.EAST;
 		    panelGestion.add(new JLabel("Nombre: "), c);
 			
 			c.gridx = 1;
 		    c.anchor = GridBagConstraints.WEST;
 		    panelGestion.add(jtfNombre, c);
 		    
 		    // Inclusion del JTextField para el tlf
 			c.gridx = 0;
 		    c.gridy = 8;
 		    c.anchor = GridBagConstraints.EAST;
 		    panelGestion.add(new JLabel("Telefono: "), c);
 			
 			c.gridx = 1;
 		    c.anchor = GridBagConstraints.WEST;
 		    panelGestion.add(jtfTlf, c);
 		    
 		    // Inclusion del JCombo para el provincia
 			c.gridx = 0;
 		    c.gridy = 9;
 		    c.anchor = GridBagConstraints.EAST;
 		    panelGestion.add(new JLabel("Provincia: "), c);
 			
 			c.gridx = 1;
 		    c.anchor = GridBagConstraints.WEST;
 		    inicializaComboBoxProvincia();
 		    panelGestion.add(jcbProvincia, c);

		    return panelGestion;
		}


		/**
		 * 
		 */
		private void cargarDatosActual () {
			if (this.actual != null) {
				this.jtfId.setText(""+this.actual.getId());
				this.jtfPrimerAp.setText(this.actual.getPrimerApellido());
				this.jtfSegundoAp.setText(this.actual.getSegundoApellido());
				this.jtfCP.setText(this.actual.getCodigoPostal());
				this.jtfDireccion.setText(this.actual.getDireccion());
				this.jtfEmail.setText(this.actual.getEmail());
				this.jtfLocalidad.setText(this.actual.getLocalidad());
				this.jtfNombre.setText(this.actual.getNombre());
				this.jtfTlf.setText(this.actual.getTelefono());
				
				//Cargar los componentes del JCombo
				for (int i = 0; i < this.jcbProvincia.getItemCount(); i++) {
					if (this.actual.getProvincia().getId() == this.jcbProvincia.getItemAt(i).getId()) {
						this.jcbProvincia.setSelectedIndex(i);
						break;
					}
				}
			}
		}
		
		/**
		 * 
		 */
		private void nuevo () {
			limpiarPantalla();
			JOptionPane.showMessageDialog(this, "Por favor, introduzca los datos del nuevo registro");
		}
		

		/**
		 * 
		 */
		private void limpiarPantalla() {
			this.jtfId.setText("");
			this.jtfPrimerAp.setText("" );
			this.jtfSegundoAp.setText("");
			this.jtfCP.setText("");
			this.jtfDireccion.setText("");
			this.jtfEmail.setText("");
			this.jtfLocalidad.setText("");
			this.jtfNombre.setText("");
			this.jtfTlf.setText("");
			this.jcbProvincia.setSelectedIndex(0);
		}
		
		/**
		 * 
		 */
		private void guardar () {
			Cliente nuevoRegistro = new Cliente();
			
			if (this.jtfId.getText().trim().equals("")) 
				nuevoRegistro.setId(0);
			else 
				nuevoRegistro.setId(Integer.parseInt(this.jtfId.getText()));
			
			nuevoRegistro.setPrimerApellido(this.jtfPrimerAp.getText());
			nuevoRegistro.setSegundoApellido(this.jtfSegundoAp.getText());
			nuevoRegistro.setCodigoPostal(this.jtfCP.getText());
			nuevoRegistro.setDireccion(this.jtfDireccion.getText());
			nuevoRegistro.setEmail(this.jtfEmail.getText());
			nuevoRegistro.setLocalidad(this.jtfLocalidad.getText());
			nuevoRegistro.setNombre(this.jtfNombre.getText());
			nuevoRegistro.setTelefono(this.jtfTlf.getText());
			nuevoRegistro.setProvincia((Provincia) this.jcbProvincia.getSelectedItem());
			
	
			ClienteControlador.getControlador().save(nuevoRegistro);
			
			
			this.jtfId.setText("" + nuevoRegistro.getId());
			JOptionPane.showMessageDialog(this, "Guardado correctamente");
			
			this.actual = nuevoRegistro;
		}
		
		/**
		 * 
		 * @return
		 */
		private Cliente eliminar () {
			String respuestas[] = new String[] {"Si", "No"};
			int opcionElegida = JOptionPane.showOptionDialog(null, 
					"Realmente desea eliminar el registro?", "Eliminacion del registro", 
			        JOptionPane.OK_CANCEL_OPTION, 
			        JOptionPane.OK_CANCEL_OPTION, 
			        CacheImagenes.getCacheImagenes().getIcono("confirm.png"), 
			        respuestas, respuestas[1]);

		    if(opcionElegida == 0) {
		    	Cliente nuevoAMostrar = ClienteControlador.getControlador().findPrevious(actual);
		    	if (nuevoAMostrar == null) {
		    		nuevoAMostrar = ClienteControlador.getControlador().findNext(actual);
		    	}
		    	ClienteControlador.getControlador().remove(actual);
				JOptionPane.showMessageDialog(this, "Eliminacion correcta");

		    	if (nuevoAMostrar != null) {
		    		actual = nuevoAMostrar;
		    	}
		    	else {
		    		limpiarPantalla();
		    	} 
		    }
		    return actual;
		}
		
		/**
		 * 
		 */
		private void inicializaComboBoxProvincia () {
			List<Provincia> provincias = ProvinciaControlador.getControlador().findAllProvincias();
			for (Provincia provincia : provincias) {
				jcbProvincia.addItem(provincia);
			}
		}
}
