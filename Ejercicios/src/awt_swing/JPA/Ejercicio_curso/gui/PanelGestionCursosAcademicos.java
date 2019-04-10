package awt_swing.JPA.Ejercicio_curso.gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import awt_swing.JPA.Ejercicio_curso.modelo.Curso;
import awt_swing.JPA.Ejercicio_curso.modelo.controladores.CursoControlador;
import awt_swing.ejercicio3_BBDDRegistroCoches_JDBC.viejo.utils.CacheImagenes;


public class PanelGestionCursosAcademicos extends JPanel {

	
	public static int LOAD_FIRST = 0;
	public static int LOAD_PREV = 1;
	public static int LOAD_NEXT = 2;
	public static int LOAD_LAST = 3;
	public static int NEW = 4;
	public static int SAVE = 5;
	public static int REMOVE = 6;
	
	Curso actual = null;
	
	JTextField jtfId = new JTextField(5);
	JTextField jtfDescripcion = new JTextField(30);
	GridBagConstraints gridBagConstraints = new GridBagConstraints();
		/**
		 * 
		 */
		public PanelGestionCursosAcademicos() {
			super();
			this.add(getBarraHerramientas(), BorderLayout.CENTER);
			this.add(getPanel(), BorderLayout.CENTER);
		}
		
		private JToolBar getBarraHerramientas() {
			JToolBar toolbar = new JToolBar();
			JButton jbtPrimero = new JButton();
			asignarFuncion(jbtPrimero, "gotostart.png", LOAD_FIRST);
			JButton jbtSiguiente = new JButton();
			asignarFuncion(jbtSiguiente, "next.png", LOAD_NEXT);
			JButton jbtAnterior = new JButton();
			asignarFuncion(jbtAnterior, "previous.png", LOAD_PREV);
			JButton jbtUltimo = new JButton();
			asignarFuncion(jbtUltimo, "gotoend.png", LOAD_LAST);
			JButton jbtNuevo = new JButton();
			asignarFuncion(jbtNuevo, "nuevo.png", NEW);
			JButton jbtGuardar = new JButton();
			asignarFuncion(jbtGuardar, "guardar.png", SAVE);
			JButton jbtEliminar = new JButton();
			asignarFuncion(jbtEliminar, "eliminar.png", REMOVE);
		
			toolbar.add(jbtPrimero);
			toolbar.add(jbtSiguiente);
			toolbar.add(jbtAnterior);
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
					
					Curso obtenido = null;
					if (funcion == LOAD_FIRST) 
						//obtenido = CursoControlador.getControlador().findFirst();
					if (funcion == LOAD_PREV) 
						//obtenido = CursoControlador.getControlador().findPrevious(actual);
					if (funcion == LOAD_NEXT) 
						//obtenido = CursoControlador.getControlador().findNext(actual);
					if (funcion == LOAD_LAST) 
						//obtenido = CursoControlador.getControlador().findLast();
					if (funcion == NEW) 
						//nuevo();
					if (funcion == SAVE) 
						//guardar();
					if (funcion == REMOVE) 
						//obtenido = eliminar();
					
					if (obtenido != null) {
						//actual = obtenido;
						//cargarDatosActual();
					}
				}});
		}
		
		private JPanel getPanel() {
			JPanel panel = new JPanel();
			panel.setLayout(new GridBagLayout());
			
			gridBagConstraints.insets = new Insets(5, 5, 5, 5);
			colocaComponente(0, 0, GridBagConstraints.CENTER, 0.15d, 0, GridBagConstraints.NONE);
			this.add(new JLabel("Id:"), gridBagConstraints);
			jtfId.setEnabled(false);
			colocaComponente(1, 0, GridBagConstraints.CENTER, 1d, 0, GridBagConstraints.HORIZONTAL);
			this.add(jtfId, gridBagConstraints);
			
			// Incorporamos el Apellidos
			colocaComponente(0, 1, GridBagConstraints.CENTER, 0.15d, 0, GridBagConstraints.NONE);
			this.add(new JLabel("Descripcion:"), gridBagConstraints);
			
			colocaComponente(1, 1, GridBagConstraints.CENTER, 1d, 0, GridBagConstraints.HORIZONTAL);
			this.add(jtfDescripcion, gridBagConstraints);
			
			return panel;
		}
		
		/**
		 * 
		 * @param gridX
		 * @param gridY
		 * @param pesoColumna
		 * @param pesoFila
		 * @param fill
		 */
		private void colocaComponente (int gridX, int gridY, int anchor, double pesoColumna, double pesoFila, int fill) {
			gridBagConstraints.gridx = gridX;
			gridBagConstraints.gridy = gridY;
			gridBagConstraints.anchor = anchor;
			gridBagConstraints.weightx = pesoColumna;
			gridBagConstraints.weighty = pesoFila;
			gridBagConstraints.fill = fill;
			
		}
}
