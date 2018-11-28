package Ejercicios.Objetos.Ahorcado;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends Canvas {

	// Declaraci�n de variables que nos permitir�n introducir el ancho y el alto
		// de la ventana
		public static final int WIDTH = 640;
		public static final int HEIGHT = 480;

		
		public Ventana () {
			// La clase JFrame nos permite mostrar una ventana en pantalla
			JFrame ventana = new JFrame("El juego de la Oca");
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
			
			// Hacemos visible la ventana.
			ventana.setVisible(true);
			// Evitamos que la ventana pueda redimensionarse.
			ventana.setResizable(false);
		}
		
		
		
		/**
		 * Sobrescribimos el m�todo "paint" que tienen todos los componentes gr�ficos en AWT-SWING
		 */
		@Override
		public void paint(Graphics g) {
			// Establecimiento del color del pincel
			g.setColor(Color.blue);

			// Pintando una l�nea
			g.drawLine(0, 0, WIDTH, HEIGHT);
			
			// Pintando un cuadrado vac�o
			g.setColor(Color.red);
			g.drawRect(120, 20, 100, 50);
			
			// Pintando un cuadrado
			g.setColor(Color.yellow);
			g.fillRect(80, 200, 140, 25);
			
			// Pintando un �valo
			g.setColor(Color.green);
			g.drawOval(300, 130, 120, 90);
			
			// Pintando un �valo relleno
			g.setColor(Color.pink);
			g.fillOval(300, 300, 120, 90);
			
		}
}
