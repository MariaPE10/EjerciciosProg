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
	
	public float getVx() { return vx; }
	public void setVx(float i) {vx = i;	}
	
	public float getVy() { return vy; }
	public void setVy(float i) {vy = i;	}
}
