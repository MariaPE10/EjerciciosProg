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

public class Arkanoid extends Canvas {
	
	public static final int ANCHO = 640;
	public static final int ALTO = 700;
	public static final int FPS = 101; // Frames por segundo
	JFrame ventana = null;
	private BufferStrategy strategy;
	private SpriteCache spriteCache = new SpriteCache();
	private List<Actor>actores = new ArrayList<Actor>();
	Nave nave = new Nave();
	Pelota pelota = new Pelota();
	Fase faseActiva = null;
	//private Adorno cola = new Adorno(this);
	public static SoundCache soundCache;
	private List<Actor> actoresAInsertar = new ArrayList<Actor>();
	
	/**
	 * @return the actoresAInsertar
	 */
	public List<Actor> getActoresAInsertar() {
		return actoresAInsertar;
	}

	private static Arkanoid instancia = null;
	
	/**
	 * Getter Singleton
	 * @return
	 */
	public static Arkanoid getInstancia () {
		if (instancia == null) {
			instancia = new Arkanoid();
		}
		return instancia;
	}
	
	public Arkanoid() {
		
		soundCache = new SoundCache();
		
		ventana = new JFrame("Pokenoid");
		JPanel panel = (JPanel)ventana.getContentPane();
		this.setBounds(0,0,ANCHO,ALTO);
		panel.setPreferredSize(new Dimension(ANCHO,ALTO));
		panel.setLayout(null);
		panel.add(this);
		ventana.setBounds(0,0,ANCHO,ALTO+28);
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
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pelota.mouseClicked(e);
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
				pelota.keyPressed(e);
			}
		});
		
		this.createBufferStrategy(2);
		strategy = this.getBufferStrategy();
		ventana.setResizable(false);
		ventana.setIgnoreRepaint(true);
		this.requestFocus();
		
	}
	
	public void initWorld() {
		soundCache.loopSound("pokemon.wav");
		
		this.faseActiva = new Fase01();
		this.faseActiva.inicializaFase();

		this.actores.clear();
		this.actores.addAll(this.faseActiva.getActores());
		
		actores.add(nave);
		actores.add(pelota);
//		cola.setX(nave.getX());
//		cola.setY(nave.getY()-cola.getHeight()+15);
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
		
		this.actores.addAll(this.actoresAInsertar);
		this.actoresAInsertar.clear();
	}
	
	public void compruebaColisiones() {

		Rectangle rectPelota = pelota.getRectangulo();
		for (Actor actor : actores) {
			if(actor instanceof Ladrillo || actor instanceof Nave) {
				if (actor.getRectangulo().intersects(rectPelota)) {
					actor.collision(pelota);
					pelota.collision(actor);
					break;
				}
			}
		}

//		for (int i = 0; i < actores.size(); i++) {
//			Actor actor1 = actores.get(i);
//			Rectangle r1 = actor1.getBounds();
//		  for (int j = i+1; j < actores.size(); j++) {
//		  	Actor actor2 = actores.get(j);
//		  	Rectangle r2 = actor2.getBounds();
//		  	if (r1.intersects(r2)) {
//		  		actor1.collision(actor2);
//		  		actor2.collision(actor1);
//		  	}
//		  }
//		}
	}
	
	public void paintWorld() {
		Toolkit.getDefaultToolkit().sync();
		Graphics2D g = (Graphics2D)strategy.getDrawGraphics();
		g.drawImage( spriteCache.getSprite("pikachuFondo.jpg"), 0, 0, this);
		for (Actor actor : actores) {
			actor.paint(g);
		}
		
		//cola.paint(g);
		strategy.show();
	}

	
	public void game() {
		initWorld();
		while (isVisible()) {
			long millisAntesDeConstruirEscena = System.currentTimeMillis();
			updateWorld();
			compruebaColisiones();
			paintWorld();
			int millisUsados = (int) (System.currentTimeMillis()-millisAntesDeConstruirEscena);
			try { 
				int millisADetenerElJuego = 1000 / FPS - millisUsados;
				if (millisADetenerElJuego >= 0) {
					 Thread.sleep(millisADetenerElJuego);
				}
			} catch (InterruptedException e) {}
		}
	}
	
	// Getters
	public Nave getNave() { return nave; }
	public Pelota getPelota() { return pelota; }
	
	public static void main(String[] args) {
		Arkanoid.getInstancia().game();
	}
}
