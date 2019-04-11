package awt_swing.JPA.Ejercicio_curso.gui;

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

import awt_swing.JPA.Ejercicio_coches.modelo.ControladorBBDDFabricante;
import awt_swing.JPA.Ejercicio_coches.modelo.entidades.Fabricante;
import awt_swing.JPA.Ejercicio_curso.modelo.Curso;
import awt_swing.JPA.Ejercicio_curso.modelo.Materia;
import awt_swing.JPA.Ejercicio_curso.modelo.controladores.CursoControlador;
import awt_swing.JPA.Ejercicio_curso.modelo.controladores.MateriaControlador;
import awt_swing.ejercicio3_BBDDRegistroCoches_JDBC.viejo.utils.CacheImagenes;


public class PanelGestionMaterias extends JPanel {

	
	public static int LOAD_FIRST = 0;
	public static int LOAD_PREV = 1;
	public static int LOAD_NEXT = 2;
	public static int LOAD_LAST = 3;
	public static int NEW = 4;
	public static int SAVE = 5;
	public static int REMOVE = 6;
	
	Materia actual = null;
	
	//Dimension minimaDimensionJTextField = new Dimension(150, 20);
	
	JTextField jtfId = new JTextField(5);
	JTextField jtfNombre = new JTextField(20);
	JTextField jtfAcronimo = new JTextField(20);
	JComboBox<Curso> jcbCurso = new JComboBox<Curso>();
	
	GridBagConstraints gridBagConstraints = new GridBagConstraints();
	
		/**
		 * 
		 */
		public PanelGestionMaterias() {
			super();
			this.setLayout(new BorderLayout());
			
			this.add(getBarraHerramientas(), BorderLayout.NORTH);
			this.add(getPanelGestion(), BorderLayout.CENTER);
			
			this.actual = MateriaControlador.getControlador().findFirst();
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
					
					Materia obtenido = null;
					if (funcion == LOAD_FIRST)
						obtenido = MateriaControlador.getControlador().findFirst();
					if (funcion == LOAD_PREV) 
						obtenido = MateriaControlador.getControlador().findPrevious(actual);
					if (funcion == LOAD_NEXT) 
						obtenido = MateriaControlador.getControlador().findNext(actual);
					if (funcion == LOAD_LAST) 
						obtenido = MateriaControlador.getControlador().findLast();
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

			// Inclusion del JTextField para el nombre
			c.gridx = 0;
		    c.gridy = 1;
		    c.anchor = GridBagConstraints.EAST;
		    panelGestion.add(new JLabel("Nombre: "), c);
			
			c.gridx = 1;
		    c.anchor = GridBagConstraints.WEST;
		    panelGestion.add(jtfNombre, c);
		    
		    // Inclusion del JTextField para el acronimo
 			c.gridx = 0;
 		    c.gridy = 2;
 		    c.anchor = GridBagConstraints.EAST;
 		    panelGestion.add(new JLabel("Acronimo: "), c);
 			
 			c.gridx = 1;
 		    c.anchor = GridBagConstraints.WEST;
 		    panelGestion.add(jtfAcronimo, c);
 		    
 		    // Inclusion del JCombo para el curso
 			c.gridx = 0;
 		    c.gridy = 3;
 		    c.anchor = GridBagConstraints.EAST;
 		    panelGestion.add(new JLabel("Curso: "), c);
 			
 			c.gridx = 1;
 		    c.anchor = GridBagConstraints.WEST;
 		    inicializaComboBoxCurso();
 		    panelGestion.add(jcbCurso, c);

		    return panelGestion;
		}


		/**
		 * 
		 */
		private void cargarDatosActual () {
			if (this.actual != null) {
				this.jtfId.setText("" + this.actual.getId());
				this.jtfNombre.setText(this.actual.getNombre());
				this.jtfAcronimo.setText(this.actual.getAcronimo());
				
				//Cargar los componentes del JCombo
				for (int i = 0; i < this.jcbCurso.getItemCount(); i++) {
					if (this.actual.getCurso().getId() == this.jcbCurso.getItemAt(i).getId()) {
						this.jcbCurso.setSelectedIndex(i);
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
			this.jtfNombre.setText("");
			this.jtfAcronimo.setText("");
			this.jcbCurso.setSelectedIndex(0);
		}
		
		/**
		 * 
		 */
		private void guardar () {
			Materia nuevoRegistro = new Materia();
			
			if (this.jtfId.getText().trim().equals("")) 
				nuevoRegistro.setId(0);
			else 
				nuevoRegistro.setId(Integer.parseInt(this.jtfId.getText()));
			
			nuevoRegistro.setNombre(this.jtfNombre.getText());
			nuevoRegistro.setAcronimo(this.jtfAcronimo.getText());
			nuevoRegistro.setCurso((Curso) this.jcbCurso.getSelectedItem());
			
			if (nuevoRegistro.getId() == 0) {
				MateriaControlador.getControlador().persist(nuevoRegistro);
			}
			else {
				MateriaControlador.getControlador().merge(nuevoRegistro);
			}
			
			this.jtfId.setText("" + nuevoRegistro.getId());
			JOptionPane.showMessageDialog(this, "Guardado correctamente");
			
			this.actual = nuevoRegistro;
		}
		
		/**
		 * 
		 * @return
		 */
		private Materia eliminar () {
			String respuestas[] = new String[] {"Si", "No"};
			int opcionElegida = JOptionPane.showOptionDialog(null, 
					"Realmente desea eliminar el registro?", "Eliminacion del registro", 
			        JOptionPane.OK_CANCEL_OPTION, 
			        JOptionPane.OK_CANCEL_OPTION, 
			        CacheImagenes.getCacheImagenes().getIcono("confirm.png"), 
			        respuestas, respuestas[1]);

		    if(opcionElegida == 0) {
		    	Materia nuevoAMostrar = MateriaControlador.getControlador().findPrevious(actual);
		    	if (nuevoAMostrar == null) {
		    		nuevoAMostrar = MateriaControlador.getControlador().findNext(actual);
		    	}
		    	MateriaControlador.getControlador().remove(actual);
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
		private void inicializaComboBoxCurso () {
			List<Curso> cursos = CursoControlador.getControlador().findAllCursos();
			for (Curso curso : cursos) {
				jcbCurso.addItem(curso);
			}
		}
}
