package arkanoid;

public class ExplosionEvent {

	private Explosion explosionProducida;
	
	/**
	 * 
	 * @param palabra
	 */
	public ExplosionEvent(Explosion ex) {
		super();
		this.explosionProducida = ex;
		Arkanoid.getInstancia().getActoresAInsertar().add(ex);
		Arkanoid.soundCache.playSound("ladrilloRoto.wav");
	}

	/**
	 * @return the palabraIntroducida
	 */
	public Explosion getExplosionProducida() {
		return explosionProducida;
	}
}
