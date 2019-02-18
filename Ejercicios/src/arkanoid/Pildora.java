package arkanoid;

import java.awt.Rectangle;

public class Pildora extends Actor {
	
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public Pildora (int x, int y) {
		this.y = y;
		this.x = x;
	}
	
	/**
	 * 
	 */
	public void actua() {
		this.y = this.y+1;
	}
	
	/**
	 * 
	 */
	 public void collision(Actor actor) {
		 if (actor instanceof Nave) {
			colisionConNave((Nave)actor);
		}
	  }
	  
	  /**
	   * 
	   * @param nave
	   */
	  public void colisionConNave(Nave nave) {
			Rectangle recPildora = new Rectangle(this.x, this.y, this.getWidth(), this.getHeight());
			Rectangle recNave = new Rectangle(nave.getX(), nave.getY(), nave.getWidth(), 2);
			
			if (recPildora.intersects(recNave)) {
				this.eliminar();
			}
		}
}
