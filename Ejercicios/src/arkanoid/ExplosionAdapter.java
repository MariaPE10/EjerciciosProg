package arkanoid;

public class ExplosionAdapter implements ExplosionListener {

	/**
	 * 
	 */
	@Override
	public void explosionProducida (ExplosionEvent e) {
		System.out.println("Se ha creado una explosion");
	}
	

}
