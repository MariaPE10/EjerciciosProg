/**
 * Curso B�sico de desarrollo de Juegos en Java - Invaders
 * 
 * (c) 2004 Planetalia S.L. - Todos los derechos reservados. Prohibida su reproducci�n
 * 
 * http://www.planetalia.com
 * 
 */
package arkanoid;

import java.awt.image.ImageObserver;

public interface Stage extends ImageObserver {
	public static final int ANCHO=600;
	public static final int ALTO=700;
	public static final int SPEED=10;
	public SpriteCache getSpriteCache();

}
