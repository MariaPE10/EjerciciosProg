package arkanoid;


public class Pelota extends Actor {
	protected float vx;
	protected float vy;
	
	public Pelota(Stage stage) {
		super(stage);
		setSpriteName("pokeball.png");
	}
	
	public void actua() {
		x+=vx;
		y+=vy;
		
		if (x < -3 || x > Stage.ANCHO-25) {
			 vx = -vx;
		}
		 
		if (y < 0 || y > Stage.ALTO-getHeight()) {
			 vy = -vy;
		}
		//System.out.println("Vx: " + this.vx + " Vy: " + this.vy);
	}
	
	public void collision(Actor actor) {
		if (actor instanceof Ladrillo) {
			vy= -vy;
		}
		if (actor instanceof Ladrillo) {
			vx= -vx;
		}
		if (actor instanceof Nave) {
			vy= -vy;
			Arkanoid.soundCache.playSound("pika.wav");
		}
	}
	
	public float getVx() { return vx; }
	public void setVx(float i) {vx = i;	}
	
	public float getVy() { return vy; }
	public void setVy(float i) {vy = i;	}
}
