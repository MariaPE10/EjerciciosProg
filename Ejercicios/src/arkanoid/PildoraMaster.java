package arkanoid;

public class PildoraMaster extends Pildora{

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public PildoraMaster(int x, int y) {
		super(x, y);
		this.setSpriteActual(SpriteCache.getInstancia().getSprite("pildora01.png"));
		System.out.println("soy una pildora Master");
	}

	/**
	 * 
	 */
	public void efecto() {
		Arkanoid.getInstancia().masterUsado = true;
		Arkanoid.getInstancia().getPelota().listoParaEliminar = true;
		Arkanoid.getInstancia().setPelota(new Pelota("master.png"));
		Arkanoid.getInstancia().getActoresAInsertar().add(Arkanoid.getInstancia().getPelota());
	}
}
