package arkanoid;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Pelota extends Actor {
	protected float velocidadX = 3f;
	protected float velocidadY = 3f;
	private long millisDesdeInicializacion = System.currentTimeMillis();
	protected long millisDespues;
	private boolean espacio= false;
	private boolean click= false;
	public static final int SEGUNDOS_DE_ESPERA = 5000;
	
	public Pelota() {
		super();
		this.setSpriteActual(SpriteCache.getInstancia().getSprite("pokeball.png"));
		this.x = Arkanoid.ANCHO / 2;
		this.y = Arkanoid.ALTO - 30;
	}
	
	public void actua() {
		millisDespues = System.currentTimeMillis();
		if(millisDespues - millisDesdeInicializacion < SEGUNDOS_DE_ESPERA
				&& !espacio && !click) {
			this.x= Arkanoid.getInstancia().getNave().getX() + (Arkanoid.getInstancia().getNave().getWidth()/2) 
					- (this.getWidth()/2);
			y = Arkanoid.getInstancia().getNave().getY()- Arkanoid.getInstancia().getNave().getHeight();
		} else {
			x+=velocidadX;
			y+=velocidadY;
			
			if (x < -3 || x > Arkanoid.ANCHO-25) {
				velocidadX = -velocidadX;
			}
			 
			if (y < 0 || y > Arkanoid.ALTO-getHeight()) {
				velocidadY = -velocidadY;
			}
		}
		
		//System.out.println("Vx: " + this.vx + " Vy: " + this.vy);
	}
	
	public void collision(Actor actor) {
//		if (actor instanceof Ladrillo) {
//			velocidadY= -velocidadY;
//		}
//		if (actor instanceof Ladrillo) {
//			velocidadX= -velocidadX;
//		}
		if (actor instanceof Nave) {
			velocidadY= -velocidadY;
			Arkanoid.soundCache.playSound("pika.wav");
		}
	}
	
	public void keyPressed(KeyEvent e) {
	  	switch (e.getKeyCode()) {
			  case KeyEvent.VK_SPACE : espacio = true; break;
	  	}
	  }
	
	public void mouseClicked (MouseEvent e) {
		 click = true;
	  }
	
	public float getvelocidadX() { return velocidadX; }
	public void setVelocidadX(float i) {velocidadX = i;	}
	
	public float getVelocidadY() { return velocidadY; }
	public void setVelocidadY(float i) {velocidadY = i;	}
}
