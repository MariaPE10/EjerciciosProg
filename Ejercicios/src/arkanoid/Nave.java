package arkanoid;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Nave extends Actor {

	protected float vx;
	private boolean left,right;
	protected static final int PLAYER_SPEED = 4;
	
	public Nave(Stage stage) {
		super(stage);
		setSpriteName("nave.png");
	}
	
	public void actua() {
		super.actua();
		x+=vx;
		if (x < 0 ) {
			 x = 0;
		}
		if (x > Stage.ANCHO - getWidth()) {
			x = Stage.ANCHO - getWidth();
		}
	}
	
	protected void updateSpeed() {
	  	vx=0;
	  	if (left) vx = -PLAYER_SPEED;
	  	if (right) vx = PLAYER_SPEED;
	  }
	  
	  public void keyReleased(KeyEvent e) {
	   	switch (e.getKeyCode()) {
			  case KeyEvent.VK_LEFT : left = false; break; 
			  case KeyEvent.VK_RIGHT : right = false;break;
	   	}
	   	updateSpeed();
	  }
	  
	  public void keyPressed(KeyEvent e) {
	  	switch (e.getKeyCode()) {
			  case KeyEvent.VK_LEFT : left = true; break;
			  case KeyEvent.VK_RIGHT : right = true; break;
	  	}
	  	updateSpeed();
	  }
	  
	  public void mouseMoved (MouseEvent e) {
		 x = e.getX()- (getWidth()/2);
	  }
	  
	  public float getVx() { return vx; }
	  public void setVx(float i) {vx = i;}
}
