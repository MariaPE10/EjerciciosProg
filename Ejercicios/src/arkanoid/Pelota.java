package arkanoid;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Pelota extends Actor {
	
	private long millisDesdeInicializacion = System.currentTimeMillis();
	protected long millisDespues;
	private boolean espacio= false;
	private boolean click= false;
	public static final int SEGUNDOS_DE_ESPERA = 5000;
	public static final float VELOCIDAD_MAXIMA = 12f;
	protected TrayectoriaRecta trayectoria = null;
	protected PuntoAltaPrecision coordenadas;
	private float incrementoVelocidad = 1.00035f, velocidad = 2.5f;
	

	
	public Pelota() {
		super();
		this.setSpriteActual(SpriteCache.getInstancia().getSprite("pokeball.png"));
		this.x = Arkanoid.ANCHO / 2;
		this.y = Arkanoid.ALTO - 30;
		this.coordenadas = new PuntoAltaPrecision(this.x, this.y);
	}
	
	public void actua() {
		millisDespues = System.currentTimeMillis();
		if(millisDespues - millisDesdeInicializacion < SEGUNDOS_DE_ESPERA
				&& !espacio && !click) {
			this.x= Arkanoid.getInstancia().getNave().getX() + (Arkanoid.getInstancia().getNave().getWidth()/2) 
					- (this.getWidth()/2);
			this.y = Arkanoid.getInstancia().getNave().getY()- Arkanoid.getInstancia().getNave().getHeight();
			this.coordenadas.x = this.x;
			this.coordenadas.y = this.y;
		} else { // La pelota se mueve
			if (this.trayectoria == null) {
				this.trayectoria = new TrayectoriaRecta(-3.8f, this.coordenadas, true);
				Arkanoid.soundCache.playSound("pick.wav");
			}
			
			PuntoAltaPrecision siguientePunto = this.trayectoria.getPuntoADistanciaDePunto(this.coordenadas, this.velocidad);
			this.x = Math.round(siguientePunto.x);
			this.y = Math.round(siguientePunto.y);
			
			this.coordenadas = siguientePunto;
			if (this.velocidad < VELOCIDAD_MAXIMA) {
				this.velocidad *= this.incrementoVelocidad;
			}

			if (x < -3 || x > Arkanoid.ANCHO-20) {
				this.trayectoria.reflejarHorizontalmenteRespectoAPunto(siguientePunto);
			}
			 
			if (y < 0 || y > Arkanoid.ALTO-getHeight()) {
				this.trayectoria.reflejarVerticalmenteRespectoAPunto(siguientePunto);
			}
		}
		
		System.out.println("Velocidad: " + this.velocidad);
	}
	
	public void collision(Actor actor) {
		if (actor instanceof Ladrillo) {
			
		}
		if (actor instanceof Nave) {
//			if (this.x < Arkanoid.getInstancia().getNave().getWidth()/2) {
//				
//			} else {
//			}
			Arkanoid.soundCache.playSound("pika2.wav");
		}
	}
	
	public void keyPressed(KeyEvent e) {
	  	switch (e.getKeyCode()) {
			  case KeyEvent.VK_SPACE : espacio = true; break;
	  	}
	  }
	
	public void mouseClicked (MouseEvent e) {
		if (!click && this.trayectoria == null) {
			PuntoAltaPrecision coordenadasRaton = new PuntoAltaPrecision(e.getX(), e.getY());
			this.trayectoria = new TrayectoriaRecta(new PuntoAltaPrecision(this.x, this.y), coordenadasRaton, (e.getX() > (Arkanoid.getInstancia().getNave().x + Arkanoid.getInstancia().getNave().getWidth() / 2))? true : false);
			Arkanoid.soundCache.playSound("pick.wav");
			
		}
		click = true;
	  }
	

}
