package awt_swing.JPA.Ejercicio_Provincias.gui;


import javax.swing.JFrame;

import awt_swing.JPA.Ejercicio_curso.gui.utils.Apariencia;


public class VentanaPrincipal extends JFrame {
	
	static {
		Apariencia.setAparienciasOrdenadas(Apariencia.aparienciasOrdenadas);
	}

	/**
	 * 
	 */
	public VentanaPrincipal () {
		super ("Gestion Provincias");
		this.setBounds(0, 0, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		// Menu de la aplicacion
		this.setJMenuBar(new Menu());
	}
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		VentanaPrincipal ventana = new VentanaPrincipal();
		ventana.setVisible(true);
	}

}
