package arkanoid;


public class Pelota extends Actor {
	protected float velocidadX = 2f;
	protected float velocidadY = -2f;
	
	public Pelota() {
		super();
		this.setSpriteActual(SpriteCache.getInstancia().getSprite("pokeball.png"));
		this.x = Arkanoid.ANCHO / 2;
		this.y = Arkanoid.ALTO / 2;
	}
	
	public void actua() {
		x+=velocidadX;
		y+=velocidadY;
		
		if (x < -3 || x > Arkanoid.ANCHO-25) {
			velocidadX = -velocidadX;
		}
		 
		if (y < 0 || y > Arkanoid.ALTO-getHeight()) {
			velocidadY = -velocidadY;
		}
		//System.out.println("Vx: " + this.vx + " Vy: " + this.vy);
	}
	
	public void collision(Actor actor) {
//		if (actor instanceof Ladrillo) {
//			velocidadY= -velocidadY;
//		}
//		if (actor instanceof Ladrillo) {
//			velocidadX= -velocidadX;
//		}
		if (actor instanceof Nave) {
			velocidadY= -velocidadY;
			System.out.println("Me he dado contra la nave");
			Arkanoid.soundCache.playSound("pika.wav");
		}
	}
	
	public float getvelocidadX() { return velocidadX; }
	public void setVelocidadX(float i) {velocidadX = i;	}
	
	public float getVelocidadY() { return velocidadY; }
	public void setVelocidadY(float i) {velocidadY = i;	}
}
