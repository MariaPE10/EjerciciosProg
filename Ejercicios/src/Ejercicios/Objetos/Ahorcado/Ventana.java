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
		private static int fallos = 0;
		
		public Ventana () {
			// La clase JFrame nos permite mostrar una ventana en pantalla
			JFrame ventana = new JFrame("El Ahorcado");
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
			fallos = Juego.getJuego().getFallosUsuario();
			//Seleccion del color
			g.setColor(Color.orange);
			if (fallos > 0) {
				//Pintando de la base
				g.fillRect(70, 400, 400, 25);
			} else if (fallos > 1){
//				Pintado del palo			
				g.fillRect(90, 25, 25, 400);
			} else if (fallos > 2) {
				//Pintado de la barra superior
				g.fillRect(70, 25, 400, 25);
			} else if (fallos > 3) {
				// Pintando la cuerda
				g.fillRect(385, 50, 1, 50);
			} else if (fallos > 4) {
				// Pintando de la cabeza
				g.setColor(Color.black);
				g.drawOval(350, 100, 70, 70);
			} else if (fallos > 5) {
				//Pintado del cuerpo
				g.drawRect(360, 170, 50, 130);
			} else if (fallos > 6) {
				//Pintado de la mano1
				g.drawRect(335, 170, 25, 80);
			} else if (fallos > 7) {
				//Pintado de la mano2
				g.drawRect(410, 170, 25, 80);
			} else if (fallos > 8) {
				//Pintado de la pierna1
				g.drawRect(360, 300, 25, 90);
			} else if (fallos > 9) {
				//Pintado de la pierna2
				g.drawRect(385, 300, 25, 90);
			}
			//HACER UN SIGLETON EN LA VENTANA PARA PODER USAR EL REPAINT DESDE JUEGO.
		}
}
