package arkanoid;

public class PildoraMusica extends Pildora{


	/**
	 * 
	 * @param x
	 * @param y
	 */
	public PildoraMusica(int x, int y) {
		super(x, y);
		this.setSpriteActual(SpriteCache.getInstancia().getSprite("Advance.png"));
	}
	
	/**
	 * @throws InterruptedException 
	 * 
	 */
	public void efecto() {
		Arkanoid.getInstancia().musicaUsado = true;
		Arkanoid.getInstancia().soundCache.stop("pokemon.wav");
		Arkanoid.getInstancia().soundCache.stop("HazteConTodos.wav");
		Arkanoid.getInstancia().soundCache.stop("NuestroMundo.wav");
		Arkanoid.getInstancia().soundCache.loopSound("AdvanceBattle.wav");
		Arkanoid.getInstancia().getNave().setPuntuacion(Arkanoid.getInstancia().getNave().getPuntuacion()+20);
		
	}
}
