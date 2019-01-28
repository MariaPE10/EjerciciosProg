package arkanoid;

public class Explosion extends Actor {

	public Explosion(int x, int y, Stage stage) {
		super(stage);
		this.y = y;
		this.x = x;
		setFrameSpeed(10);
		spriteNames.add(spriteCache.getSprite("ex1.png"));
		spriteNames.add(spriteCache.getSprite("ex2.png"));
		spriteNames.add(spriteCache.getSprite("ex3.png"));
		spriteNames.add(spriteCache.getSprite("ex4.png"));
		spriteNames.add(spriteCache.getSprite("ex5.png"));
		spriteNames.add(spriteCache.getSprite("ex6.png"));
		spriteNames.add(spriteCache.getSprite("ex7.png"));
		spriteNames.add(spriteCache.getSprite("ex8.png"));
		spriteNames.add(spriteCache.getSprite("ex9.png"));
		spriteNames.add(spriteCache.getSprite("ex10.png"));
		spriteNames.add(spriteCache.getSprite("ex11.png"));
		spriteNames.add(spriteCache.getSprite("ex12.png"));
	}

	
}
