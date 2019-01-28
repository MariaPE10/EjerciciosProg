package arkanoid;

public class Explosion extends Actor {

	public Explosion(int x, int y, Stage stage) {
		super(stage);
		this.y = y;
		this.x = x;
		setFrameSpeed(35);
		spriteNames.add(spriteCache.getSprite("master.png"));
		spriteNames.add(spriteCache.getSprite("ultra.png"));
		spriteNames.add(spriteCache.getSprite("super.png"));
	}

	
}
