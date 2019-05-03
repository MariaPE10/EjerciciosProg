package awt_swing.JPA.Ejercicio_curso.gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import awt_swing.JPA.Ejercicio_curso.modelo.Estudiante;
import awt_swing.JPA.Ejercicio_curso.modelo.Materia;
import awt_swing.JPA.Ejercicio_curso.modelo.Profesor;
import awt_swing.JPA.Ejercicio_curso.modelo.ValoracionMateria;
import awt_swing.JPA.Ejercicio_curso.modelo.controladores.EstudianteControlador;
import awt_swing.JPA.Ejercicio_curso.modelo.controladores.MateriaControlador;
import awt_swing.JPA.Ejercicio_curso.modelo.controladores.ProfesorControlador;
import awt_swing.JPA.Ejercicio_curso.modelo.controladores.ValoracionMateriaControlador;
import awt_swing.ejercicio3_BBDDRegistroCoches_JDBC.viejo.utils.CacheImagenes;


public class PanelGestionValoracionMateriasSlider extends JPanel {

	
	JButton jbtGuardarNotas = new JButton("Guardar las notas de todos los estudiantes");
	JButton jbtDerecha = new JButton();
	JButton jbtIzqda = new JButton();
	JButton jbtIzqdaTodos = new JButton();
	JButton jbtDerechaTodos = new JButton();
	JComboBox<Materia> jcbMaterias = new JComboBox<>();
	JComboBox<Profesor> jcbProfesores = new JComboBox<>();
	JSlider jsNotas;
	JButton jbtrefrescarEst = new JButton("Refrescar Estudiantes");
	JPanel panelCentro = null;
	DefaultListModel<Estudiante> modelEstudiantesNoSeleccionados = new DefaultListModel<Estudiante>();
	JList<Estudiante> jlNoSeleccionados = new JList<Estudiante>(modelEstudiantesNoSeleccionados);
	DefaultListModel<Estudiante> modelEstudiantesSeleccionados = new DefaultListModel<Estudiante>();
	JList<Estudiante> jlSeleccionados = new JList<Estudiante>(modelEstudiantesSeleccionados);
	List<Estudiante> estudiantes = EstudianteControlador.getControlador().findAllEstudiantes();
	
		/**
		 * 
		 */
		public PanelGestionValoracionMateriasSlider() {
			super();
			this.setLayout(new BorderLayout());
			
			this.add(getPanelNorte(), BorderLayout.NORTH);
			panelCentro = getPanelGestion();
			this.add(panelCentro, BorderLayout.CENTER);
			this.add(getPanelSur(), BorderLayout.SOUTH);
			
			jlNoSeleccionados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			jlNoSeleccionados.setLayoutOrientation(JList.VERTICAL);
			jlNoSeleccionados.setVisibleRowCount(5);
			jlSeleccionados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			jlSeleccionados.setLayoutOrientation(JList.VERTICAL);
			jlSeleccionados.setVisibleRowCount(5);
			
			JPanel panel = this;
			jbtrefrescarEst.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					panel.remove(panelCentro);
					panelCentro = getPanelGestion();
					panel.add(panelCentro);
					panel.revalidate();
					panel.repaint();
					jbtDerechaTodos.setEnabled(true);
					jbtDerecha.setEnabled(true);
					jbtIzqdaTodos.setEnabled(false);
					jbtIzqda.setEnabled(false);
				}
			});
			
		}

		/**
		 * 
		 * @return
		 */
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
		    
		    // Inclusion del JTextField para la nota
		    c.gridx = 0;
 		    c.gridy = 2;
 		    c.anchor = GridBagConstraints.EAST;
 		    panel.add(new JLabel("Notas: "), c);
 			
 			c.gridx = 1;
 		    c.anchor = GridBagConstraints.WEST;
 		    getJSlider();
 		    panel.add(jsNotas, c);
 		    
 		    jsNotas.addChangeListener(new ChangeListener() {
				
				@Override
				public void stateChanged(ChangeEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		    
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
			panelGestion.setLayout(new BorderLayout());
			
			// Creacion del panel izquierda
			JPanel panelIzqda = getPanelTodosEstudiantes();
			// Creacion del panel botonera
			JPanel panelBotonera = getPanelBotonera();
			// Creacion del panel derecho
			JPanel panelDrcha = new JPanel();
			panelDrcha.setLayout(new GridBagLayout());
			modelEstudiantesSeleccionados.removeAllElements();
			panelDrcha.add(jlSeleccionados);
					
			panelGestion.add(panelIzqda, BorderLayout.WEST);
			panelGestion.add(panelBotonera, BorderLayout.CENTER);
			panelGestion.add(panelDrcha, BorderLayout.EAST);
			
		    return panelGestion;
		}
		
		/**
		 * 
		 * @return
		 */
		private JPanel getPanelTodosEstudiantes() {
			JPanel panelIzqda = new JPanel();
			panelIzqda.setLayout(new GridBagLayout());
			modelEstudiantesNoSeleccionados.removeAllElements();
			for (Estudiante estudiante : estudiantes) {
				modelEstudiantesNoSeleccionados.addElement(estudiante);
			}
			panelIzqda.add(jlNoSeleccionados);
			return panelIzqda;
		}
		
		
		/**
		 * 
		 * @return
		 */
		private JPanel getPanelBotonera() {
			JPanel panelBotonera = new JPanel();
			panelBotonera.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.insets = new Insets(5, 5, 5, 5);
			c.gridy = 0;
			c.anchor = GridBagConstraints.WEST;
			panelBotonera.add(jbtIzqdaTodos,c);
			configuraBoton(jbtIzqdaTodos, "gotostart.png");
			
			jbtIzqdaTodos.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					quitaTodosEstudiantes();
					
				}
			});
			c.gridy = 1;
			panelBotonera.add(jbtIzqda,c);
			configuraBoton(jbtIzqda, "previous.png");
			
			jbtIzqda.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					quitaUnEstudiante();
					
				}
			});
			c.gridy = 2;
			panelBotonera.add(jbtDerecha, c);
			configuraBoton(jbtDerecha, "next.png");
			
			jbtDerecha.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					agregaUnEstudiante();
					
				}
			});
			c.gridy = 3;
			panelBotonera.add(jbtDerechaTodos,c);
			configuraBoton(jbtDerechaTodos, "gotoend.png");

			jbtDerechaTodos.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					agregaTodosEstudiantes();
					
				}
			});
			
			return panelBotonera;
		}
		
		/**
		 * 
		 */
		private void quitaTodosEstudiantes() {
			modelEstudiantesSeleccionados.removeAllElements();
			modelEstudiantesNoSeleccionados.removeAllElements();
			for (Estudiante estudiante : estudiantes) {
				modelEstudiantesNoSeleccionados.addElement(estudiante);
			}
			jbtDerechaTodos.setEnabled(true);
			jbtDerecha.setEnabled(true);
			jbtIzqdaTodos.setEnabled(false);
			jbtIzqda.setEnabled(false);
		}
		
		/**
		 * 
		 */
		private void agregaTodosEstudiantes() {
			modelEstudiantesSeleccionados.removeAllElements();
			modelEstudiantesNoSeleccionados.removeAllElements();
			for (Estudiante estudiante : estudiantes) {
				modelEstudiantesSeleccionados.addElement(estudiante);
			}
			jbtDerechaTodos.setEnabled(false);
			jbtDerecha.setEnabled(false);
			jbtIzqdaTodos.setEnabled(true);
			jbtIzqda.setEnabled(true);
		}
		
		/**
		 * 
		 */
		private void quitaUnEstudiante() {
			if (!jlSeleccionados.isSelectionEmpty()) {
				modelEstudiantesNoSeleccionados.addElement(jlSeleccionados.getSelectedValue());
				modelEstudiantesSeleccionados.removeElementAt(jlSeleccionados.getSelectedIndex());
				jbtDerechaTodos.setEnabled(true);
				jbtDerecha.setEnabled(true);
				jbtIzqdaTodos.setEnabled(true);
				jbtIzqda.setEnabled(true);
			}
		}
		
		/**
		 * 
		 */
		private void agregaUnEstudiante() {
			if (!jlNoSeleccionados.isSelectionEmpty()) {
				modelEstudiantesSeleccionados.addElement(jlNoSeleccionados.getSelectedValue());
				modelEstudiantesNoSeleccionados.removeElementAt(jlNoSeleccionados.getSelectedIndex());
				jbtDerechaTodos.setEnabled(true);
				jbtDerecha.setEnabled(true);
				jbtIzqdaTodos.setEnabled(true);
				jbtIzqda.setEnabled(true);
			}
		}
		/**
		 * 
		 */
		private void guardar () {
//			
//			for (JPanleNotaEstudiante panelNotas : this.panelesNotasEstudiantes) {
//				ValoracionMateria valoracion = new ValoracionMateria();
//				
//				valoracion.setEstudiante(panelNotas.getEstudiante());
//				valoracion.setProfesor((Profesor) jcbProfesores.getSelectedItem());
//				valoracion.setMateria((Materia) jcbMaterias.getSelectedItem()); 
//				valoracion.setValoracion(getNota(panelNotas));
//				
//				ValoracionMateria valoracionAlmacenada = ValoracionMateriaControlador.getControlador().findByProfesorAndMateriaAndEstudiante(valoracion);
//				if (valoracionAlmacenada != null) {
//					//valoracion.setId(valoracion.getId());
//					valoracionAlmacenada.setValoracion(valoracion.getValoracion());
//					ValoracionMateriaControlador.getControlador().merge(valoracionAlmacenada);
//				}
//				else {
//					valoracion.setId(0);
//					ValoracionMateriaControlador.getControlador().persist(valoracion);
//				}
//								
//			}
//			JOptionPane.showMessageDialog(this, "Guardado correctamente");
		
		}
		
		/**
		 * 
		 * @param panelNotas
		 * @return
		 */
		private float getNota(JPanleNotaEstudiante panelNotas) {
			try {
				 return Float.parseFloat(panelNotas.getJtfNota().getText());
			} catch (Exception e) {
				return 0f;
			}
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
		
		/**
		 * 
		 */
		private void getJSlider() {			
			jsNotas = new JSlider(0, 10, 0);
			jsNotas.setMinorTickSpacing(1);
			jsNotas.setMajorTickSpacing(1);
			jsNotas.setPaintTicks(true);
			jsNotas.setPaintLabels(true);
			
		}
		
		/**
		 * 
		 * @param jbt
		 * @param icono
		 */
		private void configuraBoton (JButton jbt, String icono) {
			jbt.setIcon(CacheImagenes.getCacheImagenes().getIcono(icono));
		}
}
