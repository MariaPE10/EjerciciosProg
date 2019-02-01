package arkanoid;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


import java.awt.Rectangle;

public class Actor {

		protected int x,y;
		protected int ancho, alto;
		protected BufferedImage spriteActual;
		protected SpriteCache spriteCache;
		protected boolean listoParaEliminar;
		protected int currentFrame;
		protected int frameSpeed;
		protected int t;
		protected List<BufferedImage>spriteNames = new ArrayList<BufferedImage>();
		
		/**
		 * 
		 * @param stage
		 */
		public Actor() {
			spriteActual = SpriteCache.getInstancia().getSprite("sin-imagen.png");
			currentFrame = 0;
			frameSpeed = 1;
			t=0;
		}
		
		/**
		 * 
		 * @param g
		 */
		public void paint(Graphics2D g){
			if (this.spriteActual != null) {
				g.drawImage(this.spriteActual, this.x, this.y, null);
			}
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
		public BufferedImage getSpriteActual(){
			return spriteActual; }
		public void setSpriteActual(BufferedImage spriteActual){ 
			this.spriteActual = spriteActual;
			alto = spriteActual.getHeight(); 
			ancho = spriteActual.getWidth();
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

		/**
		 * 
		 */
		public void eliminar() {
			listoParaEliminar = true;
		}
		
		/**
		 * 
		 * @return
		 */
		public int getFrameSpeed() {return frameSpeed;	}
		public void setFrameSpeed(int i) {frameSpeed = i;	}
		
		/**
		 * 
		 * @return
		 */
		public boolean isListoParaEliminar() {
			return listoParaEliminar;
		}
		
		/**
		 * 
		 * @return
		 */
		public Rectangle getBounds() {
			return new Rectangle(x,y,ancho,alto);
		}
		
		public void collision(Actor actor) { }
		
		public void actua() {
			t++;
			if (this.spriteNames != null && t % frameSpeed == 0){
				t=0;
				if (spriteNames.size() > 0) {
					currentFrame = (currentFrame + 1) % spriteNames.size();
					this.spriteActual = this.spriteNames.get(currentFrame);
				}
			}
		}
	
}
