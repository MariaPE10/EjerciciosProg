package arkanoid.versiones1y2;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Ventana extends Canvas {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final int SPEED = 10;
	
	public HashMap sprites;
	public int posX,posY,vX;
	public BufferedImage buffer;
	
	/**
	 * 
	 */
	public Ventana() {
		sprites = new HashMap();
		posX = WIDTH/2;
		posY = HEIGHT/2;
		vX = 2;
		buffer = new BufferedImage(WIDTH,HEIGHT, BufferedImage.TYPE_INT_RGB);
		
		JFrame ventana = new JFrame("Arkanoid");
		JPanel panel = (JPanel)ventana.getContentPane();
		setBounds(0,0,WIDTH,HEIGHT);
		panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		panel.setLayout(null);
		panel.add(this);
		ventana.setBounds(0,0,WIDTH,HEIGHT);
		ventana.setVisible(true);
		ventana.addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		ventana.setIgnoreRepaint(true);
		ventana.setResizable(false);
	}
	
	/**
	 * 
	 * @param nombre
	 * @return
	 */
	public BufferedImage loadImage(String nombre) {
		URL url=null;
		try {
			url = getClass().getResource(nombre);
			return ImageIO.read(url);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se pudo cargar la imagen " + nombre +" de "+url);
			System.out.println("El error fue : "+e.getClass().getName()+" "+e.getMessage());
			System.exit(0);
			return null;
		}
	}
	
	/**
	 * 
	 * @param nombre
	 * @return
	 */
	public BufferedImage getSprite(String nombre) {
		BufferedImage img = (BufferedImage)sprites.get(nombre);
		if (img == null) {
			img = loadImage("/Imagenes/"+nombre);
			sprites.put(nombre,img);
		}
		return img;
	}
	
	/**
	 * 
	 */
	public void paintWorld() {
		Graphics g = buffer.getGraphics();
		g.setColor(getBackground());
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(getSprite("Nave.png"), posX, posY,this);
		getGraphics().drawImage(buffer,0,0,this);
	}
	

	public void paint(Graphics g) {}
	public void update(Graphics g) {}
		
	/**
	 * 
	 */
	public void updateWorld() {
		posX += vX;
		if (posX < -25 || posX > (WIDTH - 125)) vX = -vX; //###############################
	}
	
	/**
	 * 
	 */
	public void game() {
		while (isVisible()) {
			updateWorld();
			paintWorld();
			try {
				Thread.sleep(SPEED);
			} catch (InterruptedException e) {
			}
		}
	}
	
	public static void main(String[] args) {
		Ventana ventana = new Ventana();
		ventana.game();
	}
}
