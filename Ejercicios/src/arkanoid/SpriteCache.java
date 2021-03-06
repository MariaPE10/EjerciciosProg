package arkanoid;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.HashMap;

import javax.imageio.ImageIO;


public class SpriteCache {
	private HashMap<String, BufferedImage> sprites = new HashMap<String, BufferedImage>();
	private static SpriteCache instancia= null;
	
	/**
	 * 
	 */
	public SpriteCache() {
		sprites = new HashMap();
	}
	
	/**
	 * Getter Singleton
	 * @return
	 */
	public static SpriteCache getInstancia () {
		if (instancia == null) {
			instancia = new SpriteCache();
		}
		return instancia;
	}
	
	/**
	 * 
	 * @param nombre
	 * @return
	 */
	private BufferedImage cargarImagen(String nombre) {
		URL url=null;
		try {
			url = getClass().getResource(nombre);
			return ImageIO.read(url);
		} catch (Exception e) {
			System.out.println("No se pudo cargar la imagen " + nombre +" de "+url);
			System.out.println("El error fue : "+e.getClass().getName()+" "+e.getMessage());
			System.exit(0);
			return null;
		}
	}
	
	/**
	 * 
	 * @param nombre
	 * @return
	 */
	public BufferedImage getSprite(String nombre) {
		BufferedImage img = (BufferedImage)sprites.get(nombre);
		if (img == null) {
			img = cargarImagen("/imagenes/pokenoid/"+nombre);
			sprites.put(nombre,img);
		}
		return img;
	}
}
