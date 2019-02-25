package arkanoid;

public class ControladorExplosion extends ExplosionAdapter{

	/**
	 * 
	 */
	@Override
	public void explosionProducida(ExplosionEvent e) {
		super.explosionProducida(e);
		System.out.println("Soy el controlador, se ha producido una explosion en:  " + 
				e.getExplosionProducida().getX() + ", " + e.getExplosionProducida().getY());
	}

	
}
