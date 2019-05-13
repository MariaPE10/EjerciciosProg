package awt_swing.JPA.Ejercicio_Provincias.gui.JTable;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import awt_swing.JPA.Ejercicio_Provincias.modelo.Persona;
import awt_swing.JPA.Ejercicio_Provincias.modelo.controladores.PersonaControlador;
import awt_swing.JPA.Ejercicio_curso.gui.JTableModel.DatosTabla;
import awt_swing.JPA.Ejercicio_curso.modelo.Estudiante;
import awt_swing.JPA.Ejercicio_curso.modelo.controladores.EstudianteControlador;

public class MiTableModelPersonas  extends MiTableModelAbstract {
	Object datos[][] = null;
	String titulos[] = null;

	/**
	 * 
	 */
	public MiTableModelPersonas() {
		super();
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String[] getTitulosColumnas() {
		return new String[] {"Id", "Nombre", "1er apellido", "2do apellido","Fecha Nacimiento","Edad", "Activo", "Provincia", "Altura"};
	}

	/**
	 * 
	 * @return
	 */
	public Object[][] getDatosDeTabla() {
		// Obtengo todas las personas
		List<Persona> personas = PersonaControlador.getControlador().findAllPersonas();
		// Preparo una estructura para pasar al constructor de la JTable
		Object[][] datos = new Object[personas.size()][9];
		// Cargo los datos de la lista de personas en la matriz de los datos
		for (int i = 0; i < personas.size(); i++) {
			Persona persona = personas.get(i);
			datos[i][0] = persona.getId();
			datos[i][1] = persona.getNombre();
			datos[i][2] = persona.getPrimerApellido();
			datos[i][3] = persona.getSegundoApellido();
			datos[i][4] = persona.getFechaNacimiento();
			datos[i][5] = persona.getEdad();
			datos[i][6] = persona.getActivo();
			datos[i][7] = persona.getProvincia();
			datos[i][8] = persona.getAltura();
		}
		
		return datos;
	}
}
