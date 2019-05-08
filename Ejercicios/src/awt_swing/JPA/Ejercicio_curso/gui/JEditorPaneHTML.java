package awt_swing.JPA.Ejercicio_curso.gui;

import javax.swing.JEditorPane;

public class JEditorPaneHTML extends JEditorPane {

	private JEditorPaneHTML() {
		JEditorPane editor = new JEditorPane();

		// Marco el editor para que use HTML
		editor.setContentType("text/html");
		// Inserto un texto
		editor.setText("<b>hola</b><br>" + "<i>adios</i><br>" + "<font face=\"arial\">fuente arial</font><br>"
				+ "<font face=\"courier\">fuente courier</font><br>" + "<font size=\"24\">fuente grande</font><br>"
				+ "<font color=\"red\">color rojo</font><br>"
				+ "<img src=\"http://webdidacticarafaelmunoz.appspot.com/java/CursodeSpaceInvaders/res/nave.gif\"></img>");
	}
}
