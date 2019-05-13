package awt_swing.JPA.Ejercicio_curso.gui.JTableModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;
import awt_swing.JPA.Ejercicio_curso.gui.JTableModel.DatosTabla;
import awt_swing.JPA.Ejercicio_curso.modelo.Estudiante;
import awt_swing.JPA.Ejercicio_curso.modelo.controladores.EstudianteControlador;

public class MiTableModelEstudiantes  extends MiTableModelAbstract {
	Object datos[][] = null;
	String titulos[] = null;

	/**
	 * 
	 */
	public MiTableModelEstudiantes() {
		super();
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String[] getTitulosColumnas() {
		return new String[] {"Id", "Nombre", "1er apellido", "2do apellido","DNI","Direccion", "Email", "Telefono", "Sexo", "Imagen", "Color Preferido", "Activo"};
	}

	/**
	 * 
	 * @return
	 */
	public Object[][] getDatosDeTabla() {
		// Obtengo todas las personas
		List<Estudiante> estudiantes = EstudianteControlador.getControlador().findAllEstudiantes();
		// Preparo una estructura para pasar al constructor de la JTable
		Object[][] datos = new Object[estudiantes.size()][12];
		// Cargo los datos de la lista de personas en la matriz de los datos
		for (int i = 0; i < estudiantes.size(); i++) {
			Estudiante estudiante = estudiantes.get(i);
			datos[i][0] = estudiante.getId();
			datos[i][1] = estudiante.getNombre();
			datos[i][2] = estudiante.getPrimerApellido();
			datos[i][3] = estudiante.getSegundoApellido();
			datos[i][4] = estudiante.getDni();
			datos[i][5] = estudiante.getDireccion();
			datos[i][6] = estudiante.getEmail();
			datos[i][7] = estudiante.getTelefono();
			datos[i][8] = estudiante.getTipologiaSexo();
			datos[i][9] = estudiante.getImagen();
			datos[i][10] = estudiante.getColorPreferido();
			datos[i][11] = estudiante.getActivo();
		}
		
		return datos;
	}
}
