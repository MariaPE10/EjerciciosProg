package awt_swing.ejercicio3_BBDDRegistroCoches.utils;

import javax.swing.UIManager;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

public class Apariencia {

	public static int SO_ANFITRION = 0;
	public static int METAL = 1;
	public static int GTK = 2;
	public static int MOTIF = 3;
	public static int WINDOWS = 4;
	
	/**
	 * 
	 */
	public static void setApariencia (int apariencia) {
		try {
			switch (apariencia) {
			case 0: // SO_ANFITRION
		        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); // Look and Feel del sistema operativo instalado
				break;
			case 1: // METAL
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); // L&F c�silo Java, llamado "Metal"
				MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
				//MetalLookAndFeel.setCurrentTheme(new OceanTheme());
				break;
			case 2: // GTK
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel"); // Look and Feel GTK - S�lo en entornos Linux, Unix y Solaris
				break;
			case 3: // MOTIF
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel"); // Look and Feel Motif
				break;
			case 4: // WINDOWS
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); // Look and Feel Windows - S�lo en entornos Windows
				break;
			}
	       
	        
	    } catch (Exception e) { 
	    	e.printStackTrace();
	    }
	}

}
