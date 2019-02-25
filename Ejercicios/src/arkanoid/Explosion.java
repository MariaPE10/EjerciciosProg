package arkanoid;

import java.awt.Graphics2D;

public class Explosion extends Actor {

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public Explosion(int x, int y) {
		super();
		this.y = y;
		this.x = x;
		setFrameSpeed(8);
		this.spriteActual = null;
		spriteNames.add(SpriteCache.getInstancia().getSprite("ex1.png"));
		spriteNames.add(SpriteCache.getInstancia().getSprite("ex2.png"));
		spriteNames.add(SpriteCache.getInstancia().getSprite("ex3.png"));
		spriteNames.add(SpriteCache.getInstancia().getSprite("ex4.png"));
		spriteNames.add(SpriteCache.getInstancia().getSprite("ex5.png"));
		spriteNames.add(SpriteCache.getInstancia().getSprite("ex6.png"));
		spriteNames.add(SpriteCache.getInstancia().getSprite("ex7.png"));
		spriteNames.add(SpriteCache.getInstancia().getSprite("ex8.png"));
		spriteNames.add(SpriteCache.getInstancia().getSprite("ex9.png"));
		spriteNames.add(SpriteCache.getInstancia().getSprite("ex10.png"));
		spriteNames.add(SpriteCache.getInstancia().getSprite("ex11.png"));
		spriteNames.add(SpriteCache.getInstancia().getSprite("ex12.png"));
		this.spriteActual = this.spriteNames.get(0);
	}

	/**
	 * 
	 */
	public void actua() {
		super.actua();
		if(this.spriteActual.equals(spriteNames.get(spriteNames.size()-1))) {
			this.eliminar();
		}
	}
		
}
