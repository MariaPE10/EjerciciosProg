package arkanoid;

public class Pildora extends Actor {
	
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public Pildora (int x, int y) {
		this.y = y;
		this.x = x;
		this.setSpriteActual(SpriteCache.getInstancia().getSprite("pildora01.png"));
		System.out.println("soy una pildora");
	}
	
	/**
	 * 
	 */
	public void actua() {
		this.y = this.y+1;
	}
}
