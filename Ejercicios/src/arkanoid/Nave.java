package arkanoid;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;


public class Nave extends Actor {

	protected float velocidad;
	private boolean derecha,izquierda;
	protected static final int PLAYER_SPEED = 4;
	
	public Nave() {
		super();
		this.setSpriteActual(SpriteCache.getInstancia().getSprite("nave.png"));
		this.x = Arkanoid.ANCHO / 2;
		this.y = Arkanoid.ALTO - 30;
	}
	
	public void actua() {
		super.actua();
		x+=velocidad;
		if (x < 0 ) {
			 x = 0;
		}
		if (x > Arkanoid.ANCHO - this.getWidth()) {
			x = Arkanoid.ANCHO - this.getWidth();
		}
	}
	
	protected void updateSpeed() {
		velocidad=0;
	  	if (izquierda) velocidad = -PLAYER_SPEED;
	  	if (derecha) velocidad = PLAYER_SPEED;
	  }
	  
	  public void keyReleased(KeyEvent e) {
	   	switch (e.getKeyCode()) {
			  case KeyEvent.VK_LEFT : izquierda = false; break; 
			  case KeyEvent.VK_RIGHT : derecha = false;break;
	   	}
	   	updateSpeed();
	  }
	  
	  public void keyPressed(KeyEvent e) {
	  	switch (e.getKeyCode()) {
			  case KeyEvent.VK_LEFT : izquierda = true; break;
			  case KeyEvent.VK_RIGHT : derecha = true; break;
	  	}
	  	updateSpeed();
	  }
	  
	  public void mouseMoved (MouseEvent e) {
		 x = e.getX() - (getWidth()/2);
	  }
	  
	  public float getVelocidad() { return velocidad; }
	  public void setVelocidad(float i) {velocidad = i;}
}
