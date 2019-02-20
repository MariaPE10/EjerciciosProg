package arkanoid;

public class PildoraMusica extends Pildora{

	public long millisDesdeImpacto;

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public PildoraMusica(int x, int y) {
		super(x, y);
		this.setSpriteActual(SpriteCache.getInstancia().getSprite("Advance.png"));
		System.out.println("soy una pildoraMusica");
		millisDesdeImpacto = System.currentTimeMillis();
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

//	public void isTerminado() {
//		if (this.millisDesdeImpacto > 60000) {
//			Arkanoid.getInstancia().soundCache.loopSound("pokemon.wav");
//		}
//	}
}
