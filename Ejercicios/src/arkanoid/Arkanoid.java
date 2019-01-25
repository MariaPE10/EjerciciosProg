package arkanoid;
/**
 * Curso B�sico de desarrollo de Juegos en Java - Invaders
 * 
 * (c) 2004 Planetalia S.L. - Todos los derechos reservados. Prohibida su reproducci�n
 * 
 * http://www.planetalia.com
 * 
 */

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Arkanoid extends Canvas implements Stage {
	
	private BufferStrategy strategy;
	private long usedTime;
	
	private SpriteCache spriteCache;
	private List<Actores>actores; 
	
	public Arkanoid() {
		spriteCache = new SpriteCache();

		JFrame ventana = new JFrame("Invaders");
		JPanel panel = (JPanel)ventana.getContentPane();
		this.setBounds(0,0,Stage.ANCHO,Stage.ALTO);
		panel.setPreferredSize(new Dimension(Stage.ANCHO,Stage.ALTO));
		panel.setLayout(null);
		panel.add(this);
		ventana.setBounds(0,0,Stage.ANCHO,Stage.ALTO+28);
		ventana.setVisible(true);
		ventana.addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		ventana.setResizable(false);
		createBufferStrategy(2);
		strategy = getBufferStrategy();
		requestFocus();
	}
	
	public void initWorld() {
		
		actores = new ArrayList<Actores>();

		Pelota pelota = new Pelota(this);
		pelota.setX(60);
		pelota.setY(40);
		pelota.setVx(1.2f);
		pelota.setVy(1.2f);
		actores.add(pelota);
		
		Nave nave = new Nave(this);
		nave.setX(Stage.ANCHO/2);
		nave.setY(Stage.ALTO-100);
		nave.setVx(1.2f);
		actores.add(nave);
	}
	
	public void updateWorld() {
		for (Actores actor : actores) {
			actor.actua();
		}
	}
	
	public void paintWorld() {
		Toolkit.getDefaultToolkit().sync();
		Graphics2D g = (Graphics2D)strategy.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0,0,getWidth(),getHeight());
		for (Actores actor : actores) {
			actor.paint(g);
		}

		g.setColor(Color.white);
		if (usedTime > 0)
		  g.drawString(String.valueOf(1000/usedTime)+" fps",0,Stage.ALTO-50);
  	else
	  	g.drawString("--- fps",0,Stage.ALTO-50);
		strategy.show();
	}
	
	public SpriteCache getSpriteCache() {
		return spriteCache;
	}
	
	public void game() {
		usedTime=1000;
		initWorld();
		while (isVisible()) {
			long startTime = System.currentTimeMillis();
			updateWorld();
			paintWorld();
			usedTime = System.currentTimeMillis()-startTime;
			try { 
				 Thread.sleep(SPEED);
			} catch (InterruptedException e) {}
		}
	}
	
	public static void main(String[] args) {
		Arkanoid arka = new Arkanoid();
		arka.game();
	}
}
