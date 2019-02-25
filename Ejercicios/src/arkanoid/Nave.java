package arkanoid;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;


public class Nave extends Actor {

	protected float velocidad;
	private boolean derecha,izquierda;
	protected static final int VELOCIDAD_NAVE = 4;
	protected int vidas = 3, puntuacion;
	
	/**
	 * 
	 */
	public Nave() {
		super();
		this.setSpriteActual(SpriteCache.getInstancia().getSprite("nave.png"));
		this.x = Arkanoid.ANCHO / 2;
		this.y = Arkanoid.ALTO - 30;
		this.puntuacion = 0;
	}
	
	/**
	 * 
	 */
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
	
	/**
	 * 
	 */
	protected void updateSpeed() {
		velocidad=0;
	  	if (izquierda) velocidad = -VELOCIDAD_NAVE;
	  	if (derecha) velocidad = VELOCIDAD_NAVE;
	  }
	  
	/**
	 * 
	 * @param e
	 */
	 public void keyReleased(KeyEvent e) {
	   	switch (e.getKeyCode()) {
			  case KeyEvent.VK_LEFT : izquierda = false; break; 
			  case KeyEvent.VK_RIGHT : derecha = false;break;
	   	}
	   	updateSpeed();
	 }
	  
	  /**
	   * 
	   * @param e
	   */
	 public void keyPressed(KeyEvent e) {
	  	switch (e.getKeyCode()) {
			  case KeyEvent.VK_LEFT : izquierda = true; break;
			  case KeyEvent.VK_RIGHT : derecha = true; break;
	  	}
	  	updateSpeed();
	 }
	  
	  /**
	   * 
	   * @param e
	   */
	 public void mouseMoved (MouseEvent e) {
		 if (!e.isControlDown() || !e.isShiftDown()) {
			  x = e.getX() - (getWidth()/2);  
		 }
		 
	 }
	 
	  /**
	   * 
	   */
	 public void collision(Actor actor) {
		if (actor instanceof Pildora) {
			colisionConPildora((Pildora)actor);
			
		}
	 }
	 
	 /**
	  * 
	  * @param nave
	  */
	 public void colisionConPildora(Pildora pildora) {
		Rectangle recNave = new Rectangle(this.x, this.y, this.getWidth(), 2);
		Rectangle  recPildora= new Rectangle(pildora.getX(), pildora.getY(), pildora.getWidth(), pildora.getHeight());
		
		if (recNave.intersects(recPildora)) {
			if (pildora instanceof PildoraVida) {
				((PildoraVida) pildora).efecto();
			}
			if (pildora instanceof PildoraRev) {
				((PildoraRev) pildora).efecto();
			}
			if (pildora instanceof PildoraMusica) {
				((PildoraMusica) pildora).efecto();
			}
			if (pildora instanceof PildoraMaster) {
				((PildoraMaster) pildora).efecto();
			}
			Arkanoid.soundCache.playSound("sonido01.wav");
		}
	  }
	  
	 /**
	  * Getters y Setters
	  * @return
	  */
	  public int getVidas() {return vidas; }
	  public void setVidas(int i) { vidas = i;}
	  public int getPuntuacion() {return puntuacion; }
	  public void setPuntuacion(int i) { puntuacion = i;}
	  public float getVelocidad() { return velocidad; }
	  public void setVelocidad(float i) {velocidad = i;}
}
