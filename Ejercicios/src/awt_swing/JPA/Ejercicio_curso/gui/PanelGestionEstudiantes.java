package awt_swing.JPA.Ejercicio_curso.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import awt_swing.JPA.Ejercicio_curso.modelo.Estudiante;
import awt_swing.JPA.Ejercicio_curso.modelo.controladores.EstudianteControlador;
import awt_swing.ejercicio3_BBDDRegistroCoches_JDBC.viejo.utils.CacheImagenes;


public class PanelGestionEstudiantes extends JPanel {

	
	public static int LOAD_FIRST = 0;
	public static int LOAD_PREV = 1;
	public static int LOAD_NEXT = 2;
	public static int LOAD_LAST = 3;
	public static int NEW = 4;
	public static int SAVE = 5;
	public static int REMOVE = 6;
	
	Estudiante actual = null;
	
	//Dimension minimaDimensionJTextField = new Dimension(150, 20);
	
	JPanelDatosPersonales panelDatosPersonales = new JPanelDatosPersonales();
		/**
		 * 
		 */
		public PanelGestionEstudiantes() {
			super();
			this.setLayout(new BorderLayout());
			
			this.add(getBarraHerramientas(), BorderLayout.NORTH);
			this.add(panelDatosPersonales, BorderLayout.CENTER);
			
			this.actual = EstudianteControlador.getControlador().findFirst();
			cargarDatosActual();
		}
		
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
					
					Estudiante obtenido = null;
					if (funcion == LOAD_FIRST)
						obtenido = EstudianteControlador.getControlador().findFirst();
					if (funcion == LOAD_PREV) 
						obtenido = EstudianteControlador.getControlador().findPrevious(actual);
					if (funcion == LOAD_NEXT) 
						obtenido = EstudianteControlador.getControlador().findNext(actual);
					if (funcion == LOAD_LAST) 
						obtenido = EstudianteControlador.getControlador().findLast();
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
		private void cargarDatosActual () {
			if (this.actual != null) {
				panelDatosPersonales.setId("" + this.actual.getId());
				panelDatosPersonales.setNombre(this.actual.getNombre());
				panelDatosPersonales.setPrimerAp(this.actual.getPrimerApellido());
				panelDatosPersonales.setSegundoAp(this.actual.getSegundoApellido());
				panelDatosPersonales.setDni(this.actual.getDni());
				panelDatosPersonales.setDireccion(this.actual.getDireccion());
				panelDatosPersonales.setEmail(this.actual.getEmail());
				panelDatosPersonales.setTelefono(this.actual.getTelefono());
				panelDatosPersonales.setTipologiaSexo(this.actual.getTipologiaSexo());
				panelDatosPersonales.setImagen(this.actual.getImagen());
				panelDatosPersonales.setColorPreferido(this.actual.getColorPreferido());
				panelDatosPersonales.setBackground(Color.decode(this.actual.getColorPreferido()));
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
			panelDatosPersonales.setId("");
			panelDatosPersonales.setNombre("");
			panelDatosPersonales.setPrimerAp("");
			panelDatosPersonales.setSegundoAp("");
			panelDatosPersonales.setDni("");
			panelDatosPersonales.setDireccion("");
			panelDatosPersonales.setEmail("");
			panelDatosPersonales.setTelefono("");
			panelDatosPersonales.setTipologiaSexo(panelDatosPersonales.jcbSexo.getItemAt(0));
			panelDatosPersonales.setImagen(panelDatosPersonales.getImagenEnBlanco());
			panelDatosPersonales.setColorPreferido(panelDatosPersonales.getColor());
			panelDatosPersonales.setBackground(Color.decode(panelDatosPersonales.getColor()));

		}
		
		/**
		 * 
		 */
		private void guardar () {
			Estudiante nuevoRegistro = new Estudiante();
			
			if (panelDatosPersonales.getId().trim().equals("")) 
				nuevoRegistro.setId(0);
			else 
				nuevoRegistro.setId(Integer.parseInt(panelDatosPersonales.getId()));
			
			nuevoRegistro.setNombre(panelDatosPersonales.getNombre());
			nuevoRegistro.setPrimerApellido(panelDatosPersonales.getPrimerAp());
			nuevoRegistro.setSegundoApellido(panelDatosPersonales.getSegundoAp());
			nuevoRegistro.setDni(panelDatosPersonales.getDni());
			nuevoRegistro.setDireccion(panelDatosPersonales.getDireccion());
			nuevoRegistro.setEmail(panelDatosPersonales.getEmail());
			nuevoRegistro.setTelefono(panelDatosPersonales.getTelefono());
			nuevoRegistro.setTipologiaSexo(panelDatosPersonales.getTipologiaSexo());
			nuevoRegistro.setImagen(panelDatosPersonales.getImagen());
			nuevoRegistro.setColorPreferido(panelDatosPersonales.getColorPreferido());

			
			if (nuevoRegistro.getId() == 0) {
				EstudianteControlador.getControlador().persist(nuevoRegistro);
			}
			else {
				EstudianteControlador.getControlador().merge(nuevoRegistro);
			}
			
			panelDatosPersonales.setId("" + nuevoRegistro.getId());
			JOptionPane.showMessageDialog(this, "Guardado correctamente");
			
			this.actual = nuevoRegistro;
		}
		
		/**
		 * 
		 * @return
		 */
		private Estudiante eliminar () {
			String respuestas[] = new String[] {"Si", "No"};
			int opcionElegida = JOptionPane.showOptionDialog(null, 
					"Realmente desea eliminar el registro?", "Eliminacion del registro", 
			        JOptionPane.OK_CANCEL_OPTION, 
			        JOptionPane.OK_CANCEL_OPTION, 
			        CacheImagenes.getCacheImagenes().getIcono("confirm.png"), 
			        respuestas, respuestas[1]);

		    if(opcionElegida == 0) {
		    	Estudiante nuevoAMostrar = EstudianteControlador.getControlador().findPrevious(actual);
		    	if (nuevoAMostrar == null) {
		    		nuevoAMostrar = EstudianteControlador.getControlador().findNext(actual);
		    	}
		    	EstudianteControlador.getControlador().remove(actual);
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
