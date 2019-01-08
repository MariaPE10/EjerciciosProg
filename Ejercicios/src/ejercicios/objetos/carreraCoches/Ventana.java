package ejercicios.objetos.carreraCoches;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;




public class Ventana extends Canvas {

	// Declaración de variables que nos permitirán introducir el ancho y el alto
	// de la ventana
	public static final int WIDTH = 550;
	public static final int HEIGHT = 300;
	public static Ventana ventana = null;
	private BufferedImage imagenFondo = CacheImagenes.getCache().getImagenFondoPodio();

	
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
	 * @param imagenFondo the imagenFondo to set
	 */
	public void setImagenFondo(BufferedImage imagenFondo) {
		this.imagenFondo = imagenFondo;
	}
	
	/**
	 * 
	 */
	public Ventana() {
		JFrame ventana = new JFrame("Carrera");
		ventana.setBounds(0,0,WIDTH,HEIGHT);
		
		JPanel panel = (JPanel)ventana.getContentPane();
		
		panel.add(this);
		this.setBounds(0,0,WIDTH,HEIGHT);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		
	}
	
	
	/**
	 * Sobrescribimos el mï¿½todo "paint" que tienen todos los componentes grï¿½ficos en AWT-SWING
	 */
	@Override
	public void paint(Graphics g) {
		Vehiculo vehiculos[] = Carrera.getVehiculos();
		
		if (!Carrera.isCarreraTerminada(vehiculos)) {
			g.setColor(Color.decode("#838487"));
			g.fillRect(0, 0, WIDTH, HEIGHT);
			g.setColor(Color.white);
			g.fillRect(0, 55, WIDTH, 3);
			g.fillRect(0, 105, WIDTH, 3);
			g.fillRect(0, 160, WIDTH, 3);
			g.fillRect(0, 205, WIDTH, 3);
			for (int j = 0; j < vehiculos.length; j++) {
				vehiculos[j].getPista().paint(g);
				vehiculos[j].paint(g, vehiculos[j].getPista().getPosicionY());
			}
		} else {
			g.drawImage(imagenFondo, 0, 0, this);
			for (int i = 0; i < vehiculos.length; i++) {
				if (vehiculos[i].getPodium() == 1) {
					vehiculos[i].paint(g, 195, 20);
				}
				if (vehiculos[i].getPodium() == 2) {
					vehiculos[i].paint(g, 70, 75);
				}
				if (vehiculos[i].getPodium() == 3) {
					vehiculos[i].paint(g, 315, 115);
				}
				if (vehiculos[i].getPodium() == 4) {
					vehiculos[i].paint(g, 425, 245);
				}
				if (vehiculos[i].getPodium() == 5) {
					vehiculos[i].paint(g, 475, 245);
				}
			}
			
		}
		
	}


}
