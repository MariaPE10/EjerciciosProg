package arkanoid;

public class PildoraRev extends Pildora{

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public PildoraRev(int x, int y) {
		super(x, y);
		this.setSpriteActual(SpriteCache.getInstancia().getSprite("revivir.png"));
	}

	/**
	 * 
	 */
	public void efecto() {
		Arkanoid.getInstancia().getNave().setVidas(5);
		Arkanoid.getInstancia().getNave().setPuntuacion(Arkanoid.getInstancia().getNave().getPuntuacion()+15);
	}
}
