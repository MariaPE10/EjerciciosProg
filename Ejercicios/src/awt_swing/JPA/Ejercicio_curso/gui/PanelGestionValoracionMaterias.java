package awt_swing.JPA.Ejercicio_curso.gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import awt_swing.JPA.Ejercicio_curso.modelo.Estudiante;
import awt_swing.JPA.Ejercicio_curso.modelo.Materia;
import awt_swing.JPA.Ejercicio_curso.modelo.Profesor;
import awt_swing.JPA.Ejercicio_curso.modelo.ValoracionMateria;
import awt_swing.JPA.Ejercicio_curso.modelo.controladores.EstudianteControlador;
import awt_swing.JPA.Ejercicio_curso.modelo.controladores.MateriaControlador;
import awt_swing.JPA.Ejercicio_curso.modelo.controladores.ProfesorControlador;
import awt_swing.JPA.Ejercicio_curso.modelo.controladores.ValoracionMateriaControlador;


public class PanelGestionValoracionMaterias extends JPanel {

			
	JButton jbtGuardarNotas = new JButton("Guardar las notas de todos los estudiantes");
	JComboBox<Materia> jcbMaterias = new JComboBox<>();
	JComboBox<Profesor> jcbProfesores = new JComboBox<>();
	JButton jbtrefrescarEst = new JButton("Refrescar Estudiantes");
	GridBagConstraints gridBagConstraints = new GridBagConstraints();
	List<JPanleNotaEstudiante> panelesNotasEstudiantes = new ArrayList<JPanleNotaEstudiante>();
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
				// Inclusion de JPanelNotasEstudiante
				c.gridx = 0;
			    c.gridy = i;
			    c.anchor = GridBagConstraints.EAST;
			    JPanleNotaEstudiante panelNota = new JPanleNotaEstudiante(estudiante);
			    panelGestion.add(panelNota, c);
			 
			    ValoracionMateria valoracion = new ValoracionMateria();
			    valoracion.setMateria((Materia) jcbMaterias.getSelectedItem());
			    valoracion.setProfesor((Profesor) jcbProfesores.getSelectedItem());
			    valoracion.setEstudiante(estudiante);
		    	if (ValoracionMateriaControlador.getControlador().findByProfesorAndMateriaAndEstudiante(valoracion) != null) {
		    		panelNota.setNota((int) ValoracionMateriaControlador.getControlador().findByProfesorAndMateriaAndEstudiante(valoracion).getValoracion());
				}
			    this.panelesNotasEstudiantes.add(panelNota);
			}
			
		    return panelGestion;
		}
		
		/**
		 * 
		 */
		private void guardar () {
			
			for (JPanleNotaEstudiante panelNotas : this.panelesNotasEstudiantes) {
				ValoracionMateria valoracion = new ValoracionMateria();
				
				valoracion.setEstudiante(panelNotas.getEstudiante());
				valoracion.setProfesor((Profesor) jcbProfesores.getSelectedItem());
				valoracion.setMateria((Materia) jcbMaterias.getSelectedItem()); 
				valoracion.setValoracion(panelNotas.getNota());
				
				ValoracionMateria valoracionAlmacenada = ValoracionMateriaControlador.getControlador().findByProfesorAndMateriaAndEstudiante(valoracion);
				if (valoracionAlmacenada != null) {
					valoracionAlmacenada.setValoracion(valoracion.getValoracion());
					ValoracionMateriaControlador.getControlador().merge(valoracionAlmacenada);
				}
				else {
					valoracion.setId(0);
					ValoracionMateriaControlador.getControlador().persist(valoracion);
				}
								
			}
			JOptionPane.showMessageDialog(this, "Guardado correctamente");
		
		}
		
//		/**
//		 * 
//		 * @param panelNotas
//		 * @return
//		 */
//		private int getNota(JPanleNotaEstudiante panelNotas) {
//			
//			return Integer.parseInt(panelNotas.getJspNota().getValue());
//		}
		
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
