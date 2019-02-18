package arkanoid;

public class PildoraVida extends Pildora{

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public PildoraVida(int x, int y) {
		super(x, y);
		this.setSpriteActual(SpriteCache.getInstancia().getSprite("vida.png"));
		System.out.println("soy una pildoraVida");
	}
	
	/**
	 * 
	 */
	public void efecto() {
		if (Arkanoid.getInstancia().getNave().getVidas() < 5) {
			Arkanoid.getInstancia().getNave().setVidas(Arkanoid.getInstancia().getNave().getVidas()+1);
		}
	}

}
