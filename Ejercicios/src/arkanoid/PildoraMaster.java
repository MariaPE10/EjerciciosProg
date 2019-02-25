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
	}

	/**
	 * 
	 */
	public void efecto() {
		Arkanoid.getInstancia().masterUsado = true;
		Arkanoid.getInstancia().getPelota().listoParaEliminar = true;
		Arkanoid.getInstancia().setPelota(new Pelota("master.png"));
		Arkanoid.getInstancia().getActoresAInsertar().add(Arkanoid.getInstancia().getPelota());
		Arkanoid.getInstancia().getNave().setPuntuacion(Arkanoid.getInstancia().getNave().getPuntuacion()+25);
	}
}
