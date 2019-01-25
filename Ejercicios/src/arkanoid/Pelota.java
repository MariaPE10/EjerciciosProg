package arkanoid;


public class Pelota extends Actores {
	protected float vx;
	protected float vy;
	
	public Pelota(Stage stage) {
		super(stage);
		setSpriteName("ball.png");
	}
	
	public void actua() {
		x+=vx;
		y+=vy;
		
		if (x < -5 || x > Stage.ANCHO-20) {
			 vx = -vx;
		}
		 
		if (y < 0 || y > Stage.ALTO-50) {
			 vy = -vy;
		}
	}

	public float getVx() { return vx; }
	public void setVx(float i) {vx = i;	}
	
	public float getVy() { return vy; }
	public void setVy(float i) {vy = i;	}
}
