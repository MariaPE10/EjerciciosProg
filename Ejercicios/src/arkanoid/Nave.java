package arkanoid;

public class Nave extends Actores {

	protected float vx;
		
	
	public Nave(Stage stage) {
		super(stage);
		setSpriteName("Nave.png");
	}
	
	public void actua() {
		super.actua();
		x+=vx;
		
		if (x < 0 || x > Stage.ANCHO)
		  vx = -vx;
	}

	public float getVx() { return vx; }
	public void setVx(float i) {vx = i;}
}
