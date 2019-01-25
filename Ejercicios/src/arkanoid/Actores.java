package arkanoid;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Actores {

		protected int x,y;
		protected int ancho, alto;
		protected String spriteName;
		protected Stage stage;
		protected SpriteCache spriteCache;
		
		/**
		 * 
		 * @param stage
		 */
		public Actores(Stage stage) {
			this.stage = stage;
			spriteCache = stage.getSpriteCache();
		}
		
		/**
		 * 
		 * @param g
		 */
		public void paint(Graphics2D g){
			g.drawImage( spriteCache.getSprite(spriteName), x,y, stage );
		}
		
		/**
		 * 
		 * @return
		 */
		public int getX(){ 
			return x; }
		public void setX(int i){
			x = i; }

		/**
		 * 
		 * @return
		 */
		public int getY(){
			return y; }
		public void setY(int i){ 
			y = i; }
		
		/**
		 * 
		 * @return
		 */
		public String getSpriteName(){
			return spriteName; }
		public void setSpriteName(String string){ 
			spriteName = string;
			BufferedImage image = spriteCache.getSprite(spriteName);
			alto = image.getHeight();
			ancho = image.getWidth();
		}
		
		/**
		 * 
		 * @return
		 */
		public int getHeight() {
			return alto; }
		public void setHeight(int i) {
			alto = i;	}
		
		/**
		 * 
		 * @return
		 */
		public int getWidth() {
			return ancho;	}
		public void setWidth(int i) {
			ancho = i;	}

		public void actua() { }
	
}
