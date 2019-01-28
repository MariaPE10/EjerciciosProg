package arkanoid;

public class Ladrillo extends Actor {

	public Ladrillo(Stage stage) {
		super(stage);
		setSpriteName("ladrilloRosa.png");
	}
	
	public void collision(Actor actor) {
		if (actor instanceof Pelota)
			eliminar();
			//Arkanoid.soundCache.playSound("pick.wav");
	}
}
