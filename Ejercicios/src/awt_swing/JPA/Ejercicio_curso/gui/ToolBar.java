package awt_swing.JPA.Ejercicio_curso.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import awt_swing.JPA.Ejercicio_curso.gui.utils.CacheImagenes;


public class ToolBar extends JToolBar {

	private static final long serialVersionUID = 1L;
	
	public ToolBar () {
		
		JButton jbtCursosAcademicos = new JButton();
		jbtCursosAcademicos.setIcon(CacheImagenes.getCacheImagenes().getIcono("ruedadentada.png"));
		jbtCursosAcademicos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("El usuario quiere abrir el panel de cursos academicos");
				
			}
		});
		
		JButton jbtMaterias = new JButton();
		jbtMaterias.setIcon(CacheImagenes.getCacheImagenes().getIcono("ruedadentada.png"));
		jbtMaterias.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("El usuario quiere abrir el panel de materias");
				
			}
		});
		
		JButton jbtProfesores = new JButton();
		jbtProfesores.setIcon(CacheImagenes.getCacheImagenes().getIcono("ruedadentada.png"));
		jbtProfesores.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("El usuario quiere abrir el panel de profesores");
				
			}
		});
		
		JButton jbtAlumnos = new JButton();
		jbtAlumnos.setIcon(CacheImagenes.getCacheImagenes().getIcono("ruedadentada.png"));
		jbtAlumnos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("El usuario quiere abrir el panel de estudiantes");
				
			}
		});
		
        this.add(jbtCursosAcademicos);
        this.add(jbtMaterias);
        this.add(jbtProfesores);
        this.add(jbtAlumnos);
    }
}
