package ejercicios.objetos.ahorcado;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends Canvas {

	// Declaraci�n de variables que nos permitir�n introducir el ancho y el alto
	// de la ventana
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	private static int fallos = 0;
	private static Ventana ventana = null;
	private static Font monoFont = new Font("Calibri", Font.BOLD, 17);
	
	private String colorCarne = "#FAE5D3";
	private String colorPantalon = "#6E2C00";
	private String colorCamiseta = "#FAD7A0";
	private String colorHorca = "#873600";
	private String colorLetras = "#F9E79F";
	private String colorPalabra = "#000000";
	private String colorBotones = "#873600";
	private String colorZapatos = "#441a01";
	private String colorMangas = "#873600";
	private BufferedImage imagenFondo = CacheImagenes.getCache().getImagenFondoAhorcado();
	
	/**
	 * 
	 * @return
	 */
	public static Ventana getVentana() {
		if(ventana == null) {
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
	 * @param colorZapatos the colorZapatos to set
	 */
	public void setColorZapatos(String colorZapatos) {
		this.colorZapatos = colorZapatos;
	}

	/**
	 * @param colorMangas the colorMangas to set
	 */
	public void setColorMangas(String colorMangas) {
		this.colorMangas = colorMangas;
	}

	/**
	 * @param colorBotones the colorBotones to set
	 */
	public void setColorBotones(String colorBotones) {
		this.colorBotones = colorBotones;
	}

	/**
	 * @param colorPantalon the colorPantalon to set
	 */
	public void setColorPantalon(String colorPantalon) {
		this.colorPantalon = colorPantalon;
	}

	/**
	 * @param colorCamiseta the colorCamiseta to set
	 */
	public void setColorCamiseta(String colorCamiseta) {
		this.colorCamiseta = colorCamiseta;
	}

	/**
	 * @param colorHorca the colorHorca to set
	 */
	public void setColorHorca(String colorHorca) {
		this.colorHorca = colorHorca;
	}

	/**
	 * @param colorLetras the colorLetras to set
	 */
	public void setColorLetras(String colorLetras) {
		this.colorLetras = colorLetras;
	}

	/**
	 * @param colorPalabra the colorPalabra to set
	 */
	public void setColorPalabra(String colorPalabra) {
		this.colorPalabra = colorPalabra;
	}

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
		String cara = "o _ o";
		fallos = Juego.getJuego().getFallosUsuario();
		// Pintamos la imagen del tablero sobre la pantalla
		g.drawImage(imagenFondo, 0, 0, this);
		
		//Seleccion del color
		g.setColor(Color.decode(colorHorca));
		if (fallos > 0) {
			//Pintando de la base
			g.fillRect(70, 400, 400, 25);
		}
		if (fallos > 1){
			//Pintado del palo			
			g.fillRect(90, 25, 25, 400);
		}
		if (fallos > 2) {
			//Pintado de la barra superior
			g.fillRect(70, 25, 400, 25);
		}
		if (fallos > 3) {
			// Pintando la cuerda
			g.fillRect(383, 50, 4, 50);
		}
		if (fallos > 4) {
			// Pintando de la cabeza
			g.setColor(Color.black);
			g.drawOval(349, 99, 72, 72);
			g.setColor(Color.decode(colorCarne));
			g.fillOval(350, 100, 70, 70);
			if (fallos <= 9) {
				g.setColor(Color.black);
				g.setFont(monoFont);
				g.drawString(cara, 364, 135);
				g.drawString("__", 377, 150);
			}
		}
		if (fallos > 5) {
			//Pintado del cuerpo
			g.setColor(Color.black);
			g.drawRect(359, 169, 51, 101);
			g.setColor(Color.decode(colorCamiseta));
			g.fillRect(360, 170, 50, 100);
			g.setColor(Color.decode(colorBotones));
			g.fillRect(383, 180, 4, 4);
			g.fillRect(383, 200, 4, 4);
			g.fillRect(383, 220, 4, 4);
			g.fillRect(383, 240, 4, 4);
			g.fillRect(360, 250, 50, 20);
		}
		if (fallos > 6) {
			//Pintado de la mano1
			g.setColor(Color.black);
			g.drawRect(334, 169, 26, 81);
			g.setColor(Color.decode(colorCarne));
			g.fillRect(335, 170, 25, 80);
			g.setColor(Color.decode(colorCamiseta));
			g.fillRect(335, 170, 25, 70);
			g.setColor(Color.decode(colorMangas));
			g.fillRect(335, 235, 25, 5);
		}
		if (fallos > 7) {
			//Pintado de la mano2
			g.setColor(Color.black);
			g.drawRect(409, 169, 26, 81);
			g.setColor(Color.decode(colorCarne));
			g.fillRect(410, 170, 25, 80);
			g.setColor(Color.decode(colorCamiseta));
			g.fillRect(410, 170, 25, 70);
			g.setColor(Color.decode(colorMangas));
			g.fillRect(410, 235, 25, 5);
		}
		if (fallos > 8) {
			//Pintado de la pierna1
			g.setColor(Color.black);
			g.drawRect(359, 271, 26, 89);
			g.setColor(Color.decode(colorPantalon));
			g.fillRect(360, 270, 25, 90);
			g.setColor(Color.decode(colorZapatos));
			g.fillRect(360, 340, 25, 20);
		}
		if (fallos > 9) {
			cara = "X _ X";
			//Pintado de la pierna2
			g.setColor(Color.black);
			g.drawRect(384, 271, 26, 89);
			g.setColor(Color.decode(colorPantalon));
			g.fillRect(385, 270, 25, 90);
			g.setColor(Color.decode(colorZapatos));
			g.fillRect(385, 340, 25, 20);
			//Cara
			g.setColor(Color.black);
			g.setFont(monoFont);
			g.drawString(cara, 364, 135);
			g.drawString("__", 377, 150);
			//Cuerda cuello
			g.setColor(Color.decode(colorHorca));
			g.fillRect(363, 165, 48, 4);
		}
		
		g.setFont(monoFont);
		g.setColor(Color.decode(colorLetras));
		String strFallos = "";
		if (Juego.getJuego().isModoInmortal()) {
			g.drawString("MODO INMORTAL", 200, 440);
		} else {
			for (int i = 0; i < Juego.getJuego().getAuxFallos().length; i++) {
				strFallos += Juego.getJuego().getAuxFallos()[i];
				if (i != (Juego.getJuego().getAuxFallos().length-1)) {
					strFallos += ", ";
				}
			}
			g.drawString("Fallos: " + strFallos, 200, 440);
		}
		
		
		String strPalabra = "";
		for (int i = 0; i < Juego.getJuego().getCoincidencias().length; i++) {
			strPalabra += Juego.getJuego().getCoincidencias()[i] + " ";
		}
		g.setColor(Color.decode(colorPalabra));
		g.drawString("Palabra: " + strPalabra, 386, 85);
	}
}
