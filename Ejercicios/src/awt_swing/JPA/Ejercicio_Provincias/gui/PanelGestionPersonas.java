package awt_swing.JPA.Ejercicio_Provincias.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import awt_swing.JPA.Ejercicio_Provincias.modelo.Persona;
import awt_swing.JPA.Ejercicio_Provincias.modelo.controladores.PersonaControlador;
import awt_swing.JPA.Ejercicio_Provincias.gui.JTable.TablaEnScrollPane;
import awt_swing.ejercicio3_BBDDRegistroCoches_JDBC.viejo.utils.CacheImagenes;


public class PanelGestionPersonas extends JPanel {

	TablaEnScrollPane tablaEnScrollPane = null;
	
	public static int LOAD_FIRST = 0;
	public static int LOAD_PREV = 1;
	public static int LOAD_NEXT = 2;
	public static int LOAD_LAST = 3;
	public static int NEW = 4;
	public static int SAVE = 5;
	public static int REMOVE = 6;
	
	Persona actual = null;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	JPanelDatosPersonales panelDatosPersonales = new JPanelDatosPersonales();
		/**
		 * 
		 */
		public PanelGestionPersonas(TablaEnScrollPane tablaEnScrollPane ) {
			super();
			this.tablaEnScrollPane = tablaEnScrollPane;
			
			this.setLayout(new BorderLayout());
			
			this.add(getBarraHerramientas(), BorderLayout.NORTH);
			this.add(panelDatosPersonales, BorderLayout.CENTER);
			
			this.actual = PersonaControlador.getControlador().findFirst();
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
					
					Persona obtenido = null;
					if (funcion == LOAD_FIRST)
						obtenido = PersonaControlador.getControlador().findFirst();
					if (funcion == LOAD_PREV) 
						obtenido = PersonaControlador.getControlador().findPrevious(actual);
					if (funcion == LOAD_NEXT) 
						obtenido = PersonaControlador.getControlador().findNext(actual);
					if (funcion == LOAD_LAST) 
						obtenido = PersonaControlador.getControlador().findLast();
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
					if (tablaEnScrollPane != null) {
						tablaEnScrollPane.getTableModel().actualizaDatosEnTabla();
						//tablaEnScrollPane.actualizaFila(actual);
					}
				}});
		}


		/**
		 * 
		 */
		public void cargarDatosActual () {
			if (this.actual != null) {
				
				panelDatosPersonales.setId("" + this.actual.getId());
				panelDatosPersonales.setNombre(this.actual.getNombre());
				panelDatosPersonales.setPrimerAp(this.actual.getPrimerApellido());
				panelDatosPersonales.setSegundoAp(this.actual.getSegundoApellido());
				panelDatosPersonales.setFechaNac(this.actual.getFechaNacimiento());
				panelDatosPersonales.setEdad(this.actual.getEdad());
				panelDatosPersonales.setActivo(this.actual.getActivo());
				panelDatosPersonales.setProvincia(this.actual.getProvincia());
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
			panelDatosPersonales.setFechaNac(new Date());
			panelDatosPersonales.setEdad(0);
			panelDatosPersonales.setActivo(false);
			panelDatosPersonales.setProvincia(panelDatosPersonales.jcbProvincia.getItemAt(0));
	
		}
		
		/**
		 * 
		 */
		private void guardar () {
			Persona nuevoRegistro = new Persona();
			Date fechaEvaluacion = null;
			
			try {
				fechaEvaluacion = sdf.parse(panelDatosPersonales.getFechaNac());
			} catch (ParseException e1) {
				JOptionPane.showMessageDialog(null, "El formato de la fecha es erroneo. \n El formato requerido es dd/mm/aaaa", "Error en el campo fecha", 0);
				return;
			}
			
			if (panelDatosPersonales.getId().trim().equals("")) 
				nuevoRegistro.setId(0);
			else 
				nuevoRegistro.setId(Integer.parseInt(panelDatosPersonales.getId()));
			
			nuevoRegistro.setNombre(panelDatosPersonales.getNombre());
			nuevoRegistro.setPrimerApellido(panelDatosPersonales.getPrimerAp());
			nuevoRegistro.setSegundoApellido(panelDatosPersonales.getSegundoAp());
			nuevoRegistro.setFechaNacimiento(fechaEvaluacion);
			nuevoRegistro.setEdad(panelDatosPersonales.getEdad());
			nuevoRegistro.setActivo(panelDatosPersonales.getActivo());
			nuevoRegistro.setProvincia(panelDatosPersonales.getProvincia());

			PersonaControlador.getControlador().save(nuevoRegistro);
			
			panelDatosPersonales.setId("" + nuevoRegistro.getId());
			JOptionPane.showMessageDialog(this, "Guardado correctamente");
			
			this.actual = nuevoRegistro;
		}
		
		/**
		 * 
		 * @return
		 */
		private Persona eliminar () {
			String respuestas[] = new String[] {"Si", "No"};
			int opcionElegida = JOptionPane.showOptionDialog(null, 
					"Realmente desea eliminar el registro?", "Eliminacion del registro", 
			        JOptionPane.OK_CANCEL_OPTION, 
			        JOptionPane.OK_CANCEL_OPTION, 
			        CacheImagenes.getCacheImagenes().getIcono("confirm.png"), 
			        respuestas, respuestas[1]);

		    if(opcionElegida == 0) {
		    	Persona nuevoAMostrar = PersonaControlador.getControlador().findPrevious(actual);
		    	if (nuevoAMostrar == null) {
		    		nuevoAMostrar = PersonaControlador.getControlador().findNext(actual);
		    	}
		    	PersonaControlador.getControlador().remove(actual);
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
		 * @param actual the actual to set
		 */
		public void setActual(Persona actual) {
			this.actual = actual;
		}
		
		
		
}
