package awt_swing.JPA.Ejercicio_curso.gui;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class Menu extends JMenuBar {

	/**
	 * 
	 */
	public Menu () {
		// Men� Archivo de la aplicaci�n
        JMenu menuArchivo = new JMenu("Entidades");
        
        menuArchivo.add(getItem("Cursos Academicos", "Gestion de Cursos Academicos", new PanelGestionCursosAcademicos()));
        menuArchivo.add(getItem("Materias", "Gestion de Materias", new PanelGestionMaterias()));
        menuArchivo.add(getItem("Profesores", "Gestion de Profesores", new PanelGestionProfesores()));
        menuArchivo.add(getItem("Estudiantes", "Gestion de Estudiante", new PanelGestionEstudiantes()));
        menuArchivo.add(getItem("Valoracion de Materia", "Gestion de Valoracion de Materias", new PanelGestionValoracionMaterias()));
        
        this.add(menuArchivo);        
        
	}

	private JMenuItem getItem(String nombreItem, String titulo, JPanel panel) {
		JMenuItem item = new JMenuItem(nombreItem);
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialogo = new JDialog();
				dialogo.setResizable(false);
				dialogo.setTitle(titulo);
				dialogo.setContentPane(panel);
				dialogo.pack();
				dialogo.setModal(true);
				dialogo.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - dialogo.getWidth()/2, 
						(Toolkit.getDefaultToolkit().getScreenSize().height)/2 - dialogo.getHeight()/2);
				dialogo.setVisible(true);
			}
		});
        
        return item;
	}

}
