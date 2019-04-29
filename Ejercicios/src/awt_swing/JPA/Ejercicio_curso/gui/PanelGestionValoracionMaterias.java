package awt_swing.JPA.Ejercicio_curso.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
import awt_swing.JPA.Ejercicio_curso.modelo.Entidad;
import awt_swing.JPA.Ejercicio_curso.modelo.Estudiante;
import awt_swing.JPA.Ejercicio_curso.modelo.Materia;
import awt_swing.JPA.Ejercicio_curso.modelo.Profesor;
import awt_swing.JPA.Ejercicio_curso.modelo.ValoracionMateria;
import awt_swing.JPA.Ejercicio_curso.modelo.controladores.CursoControlador;
import awt_swing.JPA.Ejercicio_curso.modelo.controladores.EstudianteControlador;
import awt_swing.JPA.Ejercicio_curso.modelo.controladores.MateriaControlador;
import awt_swing.JPA.Ejercicio_curso.modelo.controladores.ProfesorControlador;
import awt_swing.JPA.Ejercicio_curso.modelo.controladores.ValoracionMateriaControlador;
import awt_swing.ejercicio3_BBDDRegistroCoches_JDBC.viejo.utils.CacheImagenes;


public class PanelGestionValoracionMaterias extends JPanel {

	
	public static int LOAD_FIRST = 0;
	public static int LOAD_PREV = 1;
	public static int LOAD_NEXT = 2;
	public static int LOAD_LAST = 3;
	public static int NEW = 4;
	public static int SAVE = 5;
	public static int REMOVE = 6;
			
	JButton jbtGuardarNotas = new JButton("Guardar las notas de todos los estudiantes");
	JComboBox<Materia> jcbMaterias = new JComboBox<>();
	JComboBox<Profesor> jcbProfesores = new JComboBox<>();
	JButton jbtrefrescarEst = new JButton("Refrescar Estudiantes");
	GridBagConstraints gridBagConstraints = new GridBagConstraints();
	List<EstudianteJTextField> textFieldValoraciones = new ArrayList<EstudianteJTextField>();
	JPanel panelCentro = null;
	
		/**
		 * 
		 */
		public PanelGestionValoracionMaterias() {
			super();
			this.setLayout(new BorderLayout());
			
			this.add(getPanelNorte(), BorderLayout.NORTH);
			panelCentro = getPanelGestion();
			this.add(panelCentro, BorderLayout.CENTER);
			this.add(getPanelSur(), BorderLayout.SOUTH);
			
			JPanel panel = this;
			jbtrefrescarEst.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					panel.remove(panelCentro);
					panelCentro = getPanelGestion();
					panel.add(panelCentro);
					panel.revalidate();
					panel.repaint();
				}
			});
			
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
		    
		    c.gridx = 2;
		    c.anchor = GridBagConstraints.WEST;
		    panel.add(jbtrefrescarEst, c);
		    
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
			c.insets = new Insets(5, 5, 5, 5);
			List<Estudiante> estudiantes = EstudianteControlador.getControlador().findAllEstudiantes();
			for (int i = 0; i < estudiantes.size(); i++) {
				Estudiante estudiante = estudiantes.get(i);
				// Inclusion del JTextField para el Nombre
				c.gridx = 0;
			    c.gridy = i;
			    c.anchor = GridBagConstraints.EAST;
			    panelGestion.add(new JLabel(estudiante.getNombre() + " " + estudiante.getPrimerApellido() + " " + estudiante.getSegundoApellido()), c);
			    
			    // Inclusion de JTextfield para la valoracion;
			    c.gridx = 1;
			    c.anchor = GridBagConstraints.WEST;
			    EstudianteJTextField textField = new EstudianteJTextField(estudiante);
			    ValoracionMateria valoracion = new ValoracionMateria();
			    valoracion.setMateria((Materia) jcbMaterias.getSelectedItem());
			    valoracion.setProfesor((Profesor) jcbProfesores.getSelectedItem());
			    valoracion.setEstudiante(estudiante);
		    	if (ValoracionMateriaControlador.getControlador().findByProfesorAndMateriaAndEstudiante(valoracion) != null) {
				    	textField.setText("" + ValoracionMateriaControlador.getControlador().findByProfesorAndMateriaAndEstudiante(valoracion).getValoracion());
				}
			    this.textFieldValoraciones.add(textField);
			    panelGestion.add(textField, c);
			}
			
		    return panelGestion;
		}
		
		/**
		 * 
		 */
		private void guardar () {
			
			for (EstudianteJTextField textField : this.textFieldValoraciones) {
				ValoracionMateria valoracion = new ValoracionMateria();
				
				valoracion.setEstudiante(textField.getEstudiante());
				valoracion.setProfesor((Profesor) jcbProfesores.getSelectedItem());
				valoracion.setMateria((Materia) jcbMaterias.getSelectedItem()); 
				valoracion.setValoracion(Float.parseFloat(textField.getText()));
				
				if (ValoracionMateriaControlador.getControlador().findByProfesorAndMateriaAndEstudiante(valoracion) != null) {
					//valoracion.setId(valoracion.getId());
					ValoracionMateriaControlador.getControlador().merge(valoracion);
				}
				else {
					valoracion.setId(0);
					ValoracionMateriaControlador.getControlador().persist(valoracion);
				}
								
			}
			JOptionPane.showMessageDialog(this, "Guardado correctamente");
		
		}
		
		/**
		 * 
		 * @return
		 */
		private JPanel getPanelSur() {
			JPanel panel = new JPanel();
			
			panel.add(jbtGuardarNotas);
			
			jbtGuardarNotas.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					guardar();
				}
			});
			
			return panel;
		}
}
