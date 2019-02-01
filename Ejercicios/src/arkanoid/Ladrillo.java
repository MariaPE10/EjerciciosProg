package arkanoid;

public class Ladrillo extends Actor {
	public static final int ANCHO = 48;
	public static final int ALTO = 24;
	public static final int ESPACIO_ENTRE_LADRILLOS = 2;
	
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
	
	public Ladrillo(int x, int y, int i) {
		super();
		this.x = x;
		this.y = y;
		this.setSpriteActual(SpriteCache.getInstancia().getSprite(ladrillos[i]));
		//this.ancho = this.spriteActual.getWidth();
		//this.alto = this.spriteActual.getHeight();
	}
	
	public void collision(Actor actor) {
		if (actor instanceof Pelota)
			this.eliminar();
			Arkanoid.soundCache.playSound("pick.wav");
			Explosion ex = new Explosion(this.x, this.y);
			Arkanoid.getInstancia().getActoresAInsertar().add(ex);
	}
}
