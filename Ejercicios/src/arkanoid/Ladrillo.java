package arkanoid;

public class Ladrillo extends Actor {

	public String ladrillos[]=new String[] {
			"ladrilloRosa.png",
			"ladrilloRojo.png",
			"ladrilloNaranja.png",
			"ladrilloAmarillo.png",
			"ladrilloCeleste.png",
			"ladrilloAzul.png",
			"ladrilloVerde.png",
			"ladrilloBlanco.png"
	};
	
	public Ladrillo(Stage stage, int i) {
		super(stage);
		setSpriteName(ladrillos[i]);
	}
	
	public void collision(Actor actor) {
		if (actor instanceof Pelota)
			eliminar();
			Arkanoid.soundCache.playSound("pick.wav");
	}
}
