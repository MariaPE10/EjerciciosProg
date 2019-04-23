package awt_swing.JPA.Ejercicio_curso.gui;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

import awt_swing.JPA.Ejercicio_curso.gui.utils.CacheImagenes;




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
				dialogo.setBounds(100, 100, 450, 230);
				if (panel instanceof PanelGestionProfesores || panel instanceof PanelGestionEstudiantes ) {
					dialogo.setBounds(100, 100, 400, 350);
				}
				dialogo.setModal(true);
				dialogo.setContentPane(panel);
				dialogo.setVisible(true);
			}
		});
        
        return item;
	}

}
