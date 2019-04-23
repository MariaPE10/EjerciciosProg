package awt_swing.JPA.Ejercicio_curso.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import awt_swing.JPA.Ejercicio_coches.modelo.ControladorBBDDFabricante;
import awt_swing.JPA.Ejercicio_coches.modelo.entidades.Fabricante;
import awt_swing.JPA.Ejercicio_curso.modelo.Curso;
import awt_swing.JPA.Ejercicio_curso.modelo.Entidad;
import awt_swing.JPA.Ejercicio_curso.modelo.Materia;
import awt_swing.JPA.Ejercicio_curso.modelo.Profesor;
import awt_swing.JPA.Ejercicio_curso.modelo.controladores.CursoControlador;
import awt_swing.JPA.Ejercicio_curso.modelo.controladores.MateriaControlador;
import awt_swing.JPA.Ejercicio_curso.modelo.controladores.ProfesorControlador;
import awt_swing.ejercicio3_BBDDRegistroCoches_JDBC.viejo.utils.CacheImagenes;


public class PanelGestionValoracionMaterias extends JPanel {

	
	public static int LOAD_FIRST = 0;
	public static int LOAD_PREV = 1;
	public static int LOAD_NEXT = 2;
	public static int LOAD_LAST = 3;
	public static int NEW = 4;
	public static int SAVE = 5;
	public static int REMOVE = 6;
	
	Curso actual = null;
	
	//Dimension minimaDimensionJTextField = new Dimension(150, 20);
	
	JComboBox<Materia> jcbMaterias = new JComboBox<>();
	JComboBox<Profesor> jcbProfesores = new JComboBox<>();
	GridBagConstraints gridBagConstraints = new GridBagConstraints();
	
		/**
		 * 
		 */
		public PanelGestionValoracionMaterias() {
			super();
			this.setLayout(new BorderLayout());
			
			this.add(getBarraHerramientas(), BorderLayout.NORTH);
			this.add(getPanelGestion(), BorderLayout.CENTER);
			
			this.actual = CursoControlador.getControlador().findFirst();
			cargarDatosActual();
		}

		private JPanel getPanelNorte () {
			JPanel panel = new JPanel();
			
			panel.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();

			// Inclusion del JTextField para la materia
			c.gridx = 0;
		    c.gridy = 0;
		    c.insets = new Insets(5, 5, 5, 5);
		    c.anchor = GridBagConstraints.EAST;
		    panel.add(new JLabel("Materia: "), c);
			
			c.gridx = 1;
		    c.anchor = GridBagConstraints.WEST;
		    inicializaComboBoxMaterias();
		    panel.add(jcbMaterias, c);

			// Inclusion del JTextField para el profesor
			c.gridx = 0;
		    c.gridy = 1;
		    c.anchor = GridBagConstraints.EAST;
		    panel.add(new JLabel("Profesor: "), c);
			
			c.gridx = 1;
		    c.anchor = GridBagConstraints.WEST;
		    inicializaComboBoxProfesores();
		    panel.add(jcbProfesores, c);
			return panel;
		}
		
		/**
		 * 
		 */
		private void inicializaComboBoxMaterias () {
			List<Materia> materias = MateriaControlador.getControlador().findAllMaterias();
			for (Materia materia : materias) {
				jcbMaterias.addItem(materia);
			}
		}
		
		/**
		 * 
		 */
		private void inicializaComboBoxProfesores () {
			List<Profesor> profesores = ProfesorControlador.getControlador().findAllProfesores();
			for (Profesor profesor : profesores) {
				jcbProfesores.addItem(profesor);
			}
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

			// Inclusion del JTextField para la descripcion
			c.gridx = 0;
		    c.gridy = 1;
		    c.anchor = GridBagConstraints.EAST;
		    panelGestion.add(new JLabel("Descripcion: "), c);
			
			c.gridx = 1;
		    c.anchor = GridBagConstraints.WEST;
		    //jtfDescripcion.setMinimumSize(minimaDimensionJTextField);
		    panelGestion.add(jtfDescripcion, c);

		    return panelGestion;
		}


		/**
		 * 
		 */
		private void cargarDatosActual () {
			if (this.actual != null) {
				this.jtfId.setText("" + this.actual.getId());
				this.jtfDescripcion.setText(this.actual.getDescripcion());
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
			this.jtfDescripcion.setText("");
		}
		
		/**
		 * 
		 */
		private void guardar () {
			Curso nuevoRegistro = new Curso();
			
			if (this.jtfId.getText().trim().equals("")) 
				nuevoRegistro.setId(0);
			else 
				nuevoRegistro.setId(Integer.parseInt(this.jtfId.getText()));
			
			nuevoRegistro.setDescripcion(this.jtfDescripcion.getText());
			
			if (nuevoRegistro.getId() == 0) {
				CursoControlador.getControlador().persist(nuevoRegistro);
			}
			else {
				CursoControlador.getControlador().merge(nuevoRegistro);
			}
			
			this.jtfId.setText("" + nuevoRegistro.getId());
			JOptionPane.showMessageDialog(this, "Guardado correctamente");
			
			this.actual = nuevoRegistro;
		}
		
		/**
		 * 
		 * @return
		 */
		private Curso eliminar () {
			String respuestas[] = new String[] {"Si", "No"};
			int opcionElegida = JOptionPane.showOptionDialog(null, 
					"Realmente desea eliminar el registro?", "Eliminacion del registro", 
			        JOptionPane.OK_CANCEL_OPTION, 
			        JOptionPane.OK_CANCEL_OPTION, 
			        CacheImagenes.getCacheImagenes().getIcono("confirm.png"), 
			        respuestas, respuestas[1]);

		    if(opcionElegida == 0) {
		    	Curso nuevoAMostrar = CursoControlador.getControlador().findPrevious(actual);
		    	if (nuevoAMostrar == null) {
		    		nuevoAMostrar = CursoControlador.getControlador().findNext(actual);
		    	}
		    	CursoControlador.getControlador().remove(actual);
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
}
