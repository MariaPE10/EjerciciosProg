package ejercicios.objetos.carreraCoches;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class Ventana extends Canvas {

	// Declaración de variables que nos permitirán introducir el ancho y el alto
	// de la ventana
	public static final int WIDTH = 550;
	public static final int HEIGHT = 300;
	public static Ventana ventana = null;
	
	/**
	 * Patrón Singleton
	 * @return
	 */
	public static Ventana getVentana() {
		if (ventana == null) {
			ventana = new Ventana();
		}
		return ventana;
	}

	/**
	 * 
	 */
	public Ventana () {
		JFrame ventana = new JFrame("Carrera");
		ventana.setBounds(0,0,WIDTH,HEIGHT);
		
		JPanel panel = (JPanel)ventana.getContentPane();

		panel.add(this);
		this.setBounds(0,0,WIDTH,HEIGHT);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		
	}
	


}
