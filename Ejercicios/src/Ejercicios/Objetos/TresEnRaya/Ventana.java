package Ejercicios.Objetos.TresEnRaya;

import java.awt.Canvas;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends Canvas{

	public static final int WIDTH = 150;
	public static final int HEIGHT = 150;
	
	public Ventana () {
		// La clase JFrame nos permite mostrar una ventana en pantalla
		JFrame ventana = new JFrame("Tres en Raya");
		// Establecemos las dimensiones que queremos que tenga
		ventana.setBounds(0,0,WIDTH,HEIGHT);
		
		// Obtengo una referencia al panel principal de la ventana.
		// Todas las ventanas tienen un panel principal	
		JPanel panel = (JPanel)ventana.getContentPane();

		// Al panel principal de la ventana le a�adimos el objeto this, un Canvas
		panel.add(this);

		// Establezco el tama�o del canvas (this) para que ocupe todo el tama�o de la ventana
		this.setBounds(0,0,WIDTH,HEIGHT);
		
		// Provocamos que el programa se acabe cuando cerramos la ventana 
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Hacemos visible la ventana
		ventana.setVisible(true);
		// Evitamos que la ventana pueda redimensionarse
		ventana.setResizable(false);
	}
}
