package awt_swing.JPA.Ejercicio_curso.gui;

import java.util.List;

import javax.swing.JEditorPane;
import javax.swing.JPanel;

import awt_swing.JPA.Ejercicio_curso.modelo.Estudiante;
import awt_swing.JPA.Ejercicio_curso.modelo.Materia;
import awt_swing.JPA.Ejercicio_curso.modelo.ValoracionMateria;
import awt_swing.JPA.Ejercicio_curso.modelo.controladores.EstudianteControlador;
import awt_swing.JPA.Ejercicio_curso.modelo.controladores.MateriaControlador;
import awt_swing.JPA.Ejercicio_curso.modelo.controladores.ValoracionMateriaControlador;

public class JEditorPaneHTML extends JPanel {
	
	List<Estudiante> estudiantes = EstudianteControlador.getControlador().findAllEstudiantes();
	StringBuffer texto = new StringBuffer();
	List<Materia> materias =	MateriaControlador.getControlador().findAllMaterias();
	
	/**
	 * 
	 */
	public JEditorPaneHTML() {
		
		JEditorPane editor = new JEditorPane();

		// Marco el editor para que use HTML
		editor.setContentType("text/html");
		// Inserto un texto
		creaTabla();
		editor.setText("<b>Resumen de valoracion de materias</b><br>" +
				"<table>" + texto + "</table>");
		
		this.add(editor);
	}
	
	/**
	 * 
	 */
	private void creaTabla() {
		texto.append("<tr> <th></th>");
		for(int i = 0; i < materias.size(); i++) {
			Materia materia = materias.get(i);
			texto.append("<th>" + materia.getAcronimo() +"</th>");
		}
		texto.append(" </tr>");
		
		for ( int i = 0; i < estudiantes.size(); i++) {
			Estudiante estudiante = estudiantes.get(i);
			texto.append("<tr> <td>" + estudiante.toString() + "</td>");
			for (int k = 0; k < materias.size(); k++) {
				Materia materia = materias.get(k);
				ValoracionMateria valoracion = new ValoracionMateria();
				valoracion.setEstudiante(estudiante);
				valoracion.setMateria(materia);
				List<ValoracionMateria> valoraciones = ValoracionMateriaControlador.getControlador().findByMateriaAndEstudiante(valoracion);
				float media = 0f;
				if (!valoraciones.isEmpty()) {
					for(int j = 0; j < valoraciones.size(); j++) {
						ValoracionMateria val = valoraciones.get(j);
						media = media + val.getValoracion();
					}
					media = media/(valoraciones.size());
					texto.append("<td>" + media +"</td>");
				} else {
					texto.append("<td>" + media +"</td>");
				}
			}
			texto.append("</tr>");
		}
		
		texto.append("</tr>");
	}
}
