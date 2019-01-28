package arkanoid;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class Arkanoid extends Canvas implements Stage {
	
	private BufferStrategy strategy;
	private long usedTime;
	private SpriteCache spriteCache = new SpriteCache();
	private List<Actor>actores;
	private Nave nave = new Nave(this);
	//private Adorno cola = new Adorno(this);
	public static SoundCache soundCache;
	//private List<Explosion> explosiones;
	
	public Arkanoid() {
		
		soundCache = new SoundCache();
		
		JFrame ventana = new JFrame("Pokenoid");
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
		this.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved (MouseEvent e) {
				nave.mouseMoved(e);
				//cola.mouseMoved(e);
			}
		});
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				nave.keyReleased(e);
				//cola.keyReleased(e);
				
			}
			@Override
			public void keyPressed(KeyEvent e) {
				nave.keyPressed(e);
				//cola.keyPressed(e);
			}
		});
		ventana.setResizable(false);
		createBufferStrategy(2);
		strategy = getBufferStrategy();
		requestFocus();
		
	}
	
	public void initWorld() {
		soundCache.loopSound("pokemon.wav");
		actores = new ArrayList<Actor>();

		nave.setX(Stage.ANCHO/2);
		nave.setY(Stage.ALTO-30);
		actores.add(nave);
//		cola.setX(nave.getX());
//		cola.setY(nave.getY()-cola.getHeight()+15);
//		for(int i = 1, cont = 1; i <= 55; i++, cont++) {
//			Ladrillo ladrillo = new Ladrillo(this);
//			int anchoLadrillo = ladrillo.getWidth();
//			if(i<=11) {
//				ladrillo.setX((anchoLadrillo+1)*cont);
//				ladrillo.setY(100);
//				actores.add(ladrillo);
//			} else if (i > 11 && i <= 22 ) {
//				if(i == 12) {
//					cont = 1;
//				}
//				ladrillo.setSpriteName("ladrilloAzul.png");
//				ladrillo.setX((anchoLadrillo+1)*cont);
//				ladrillo.setY(125);
//				actores.add(ladrillo);
//			} else if (i > 22 && i <= 33 ) {
//				if(i == 23) {
//					cont = 1;
//				}
//				ladrillo.setSpriteName("ladrilloBlanco.png");
//				ladrillo.setX((anchoLadrillo+1)*cont);
//				ladrillo.setY(150);
//				actores.add(ladrillo);
//			} else if (i > 33 && i <= 44 ) {
//				if(i == 34) {
//					cont = 1;
//				}
//				ladrillo.setSpriteName("ladrilloRojo.png");
//				ladrillo.setX((anchoLadrillo+1)*cont);
//				ladrillo.setY(175);
//				actores.add(ladrillo);
//			} else if (i > 44 && i <= 55 ) {
//				if(i == 45) {
//					cont = 1;
//				}
//				ladrillo.setSpriteName("ladrilloAmarillo.png");
//				ladrillo.setX((anchoLadrillo+1)*cont);
//				ladrillo.setY(200);
//				actores.add(ladrillo);
//			}
//		}
		
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 11; j++) {
				Ladrillo ladrillo = new Ladrillo (this, i);
				ladrillo.setX(45+j*(ladrillo.getWidth()+1));
				ladrillo.setY(50+i*(ladrillo.getHeight()+1));
				actores.add(ladrillo);
			}
		}
		Pelota pelota = new Pelota(this);
		pelota.setX(Stage.ANCHO/2);
		pelota.setY(Stage.ALTO/2);
		pelota.setVx(1.5f);
		pelota.setVy(1.5f);
		actores.add(pelota);
		
	
	}
	
	public void updateWorld() {
		int i = 0;
		while (i < actores.size()) {
			Actor actor = actores.get(i);
			if (actor.isListoParaEliminar()) {
				actores.remove(i);
			} else {
				actor.actua();
				i++;
			}
		}
	}
	
	public void checkCollisions() {
//		Rectangle naveBounds = nave.getBounds();
//		for (Actor actor1 : actores) {
//			Rectangle r1 = actor1.getBounds();
//			for (Actor actor2 : actores) {
//				Rectangle r2 = actor2.getBounds();
//				if (!actor1.equals(actor2)) {
//					if (r1.intersects(r2)) {
//				  		actor1.collision(actor2);
//				  		actor2.collision(actor1);
//					}
//				}
//			}
//		}

		for (int i = 0; i < actores.size(); i++) {
			Actor actor1 = actores.get(i);
			Rectangle r1 = actor1.getBounds();
		  for (int j = i+1; j < actores.size(); j++) {
		  	Actor actor2 = actores.get(j);
		  	Rectangle r2 = actor2.getBounds();
		  	if (r1.intersects(r2)) {
		  		actor1.collision(actor2);
		  		actor2.collision(actor1);
		  	}
		  }
		}
	}
	
	public void paintWorld() {
		Toolkit.getDefaultToolkit().sync();
		Graphics2D g = (Graphics2D)strategy.getDrawGraphics();
		g.drawImage( spriteCache.getSprite("pikachuFondo.jpg"), 0, 0, this);
		for (Actor actor : actores) {
			actor.paint(g);
		}
		//cola.paint(g);
		g.setColor(Color.black);
		if (usedTime > 0) {
			g.drawString(String.valueOf(1000/usedTime)+" fps",0,Stage.ALTO-50);
		} else {
			g.drawString("--- fps",0,Stage.ALTO-50);
		}
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
			checkCollisions();
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
