package arkanoid;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Pelota extends Actor {
	
//	Reunificar código de inicio de trayectoria
//	Fin de fase cuando quedan 2-3 ladrillos (alguno dorado)
//	Muerte súbita
//	Explosión cambio de fase
//	Ladrillos dorados no suenan
	
	private long millisDesdeInicializacion = System.currentTimeMillis();
	protected long millisDespues;
	private boolean espacio= false;
	private boolean click= false;
	public static final long SEGUNDOS_DE_ESPERA = 5000;
	public static final float VELOCIDAD_MAXIMA = 8f;
	protected TrayectoriaRecta trayectoria = null;
	protected PuntoAltaPrecision coordenadas;
	private float incrementoVelocidad = 1.00035f, velocidad = 2.5f;

	/**
	 * 
	 */
	public Pelota() {
		super();
		this.setSpriteActual(SpriteCache.getInstancia().getSprite("pokeball.png"));
		this.x = Arkanoid.ANCHO / 2;
		this.y = Arkanoid.ALTO - 30;
		this.coordenadas = new PuntoAltaPrecision(this.x, this.y);
	}
	
	/**
	 * 
	 */
	public void actua() {
		
		millisDespues = System.currentTimeMillis();
		if(millisDespues - millisDesdeInicializacion < SEGUNDOS_DE_ESPERA
				&& !espacio && !click) {
			this.x= Arkanoid.getInstancia().getNave().getX() + (Arkanoid.getInstancia().getNave().getWidth()/2) 
					- (this.getWidth()/2);
			this.y = Arkanoid.getInstancia().getNave().getY()- Arkanoid.getInstancia().getNave().getHeight();
			this.coordenadas.x = this.x;
			this.coordenadas.y = this.y;
		} else { // La pelota se mueve
			if (this.trayectoria == null) {
				if (Math.random()>0.5) {
					modificaTrayectoria(0.5f, 3, false);
					//this.trayectoria = new TrayectoriaRecta(((float)Math.random()+4), this.coordenadas, false);
				} else {
					modificaTrayectoria(-0.5f, -3, true);
					//this.trayectoria = new TrayectoriaRecta(0f-((float)Math.random()+4), this.coordenadas, true);
				}
				//Arkanoid.soundCache.playSound("pika.wav");
			}
			
			this.coordenadas = this.trayectoria.getPuntoADistanciaDePunto(this.coordenadas, this.velocidad);
			this.x = Math.round(coordenadas.x);
			this.y = Math.round(coordenadas.y);
			
			if (this.velocidad < VELOCIDAD_MAXIMA) {
				this.velocidad *= this.incrementoVelocidad;
			}
			if (x < -3) {
				this.x = 0;
				this.trayectoria.reflejarHaciaDerecha(coordenadas);
				return;
			}

			if (x > Arkanoid.ANCHO-20) {
				this.x = Arkanoid.ANCHO-20;
				this.trayectoria.reflejarHaciaIzquierda(coordenadas);
				return;
			}
			 
			if (y < 0) {
				this.trayectoria.reflejarHaciaAbajo(coordenadas);
				return;
			}
			
			if (y > Arkanoid.ALTO-getHeight()) {
				Arkanoid.soundCache.playSound("muerto.wav");
			try { 
				this.y = Arkanoid.ALTO-getHeight();
				Thread.sleep(2000);
			} catch (InterruptedException e) {}
				reiniciaPelota();
				Arkanoid.getInstancia().nave.setVidas(Arkanoid.getInstancia().nave.getVidas() - 1);
			}
		}
		
		//System.out.println("Velocidad: " + this.velocidad);
	}
	
	/**
	 * 
	 */
	public void collision(Actor actor) {
		if (actor instanceof Ladrillo) {
			colisionConLadrillo ((Ladrillo) actor);
		}
		if (actor instanceof Nave) {
			colisionConNave((Nave) actor);
			//Arkanoid.soundCache.playSound("pika.wav");
		}
	}
	
	/**
	 * 
	 * @param e
	 */
	public void keyPressed(KeyEvent e) {
	  	switch (e.getKeyCode()) {
			  case KeyEvent.VK_SPACE : espacio = true; break;
	  	}
	  }
	
	/**
	 * 
	 * @param e
	 */
	public void mouseClicked (MouseEvent e) {
		if (!click && this.trayectoria == null) {
			if (e.getX()- this.x < 30 && e.getX()-this.x >= 0) {
				modificaTrayectoria(-0.3f, -1, true);
				//this.trayectoria = new TrayectoriaRecta( 0f-(float)Math.random(),new PuntoAltaPrecision(this.x, this.y), true);
				
			} else if (e.getX()- this.x > -30 && e.getX()- this.x < 0) {
				modificaTrayectoria(0.3f, 1, false);
				//this.trayectoria = new TrayectoriaRecta( (float)Math.random(),new PuntoAltaPrecision(this.x, this.y), false);
				//Arkanoid.soundCache.playSound("pick.wav");
			} else {
				PuntoAltaPrecision coordenadasRaton = new PuntoAltaPrecision(e.getX(), e.getY());
				this.trayectoria = new TrayectoriaRecta(new PuntoAltaPrecision(this.x, this.y), coordenadasRaton, (e.getX() > (Arkanoid.getInstancia().getNave().x + Arkanoid.getInstancia().getNave().getWidth() / 2))? true : false);
				//Arkanoid.soundCache.playSound("pick.wav");
			}
			Arkanoid.soundCache.playSound("pick.wav");
		}
		click = true;
	  }
	
	/**
	 * 
	 * @param ladrillo
	 */
	public void colisionConLadrillo (Ladrillo ladrillo) {
		Rectangle recAbajo = new Rectangle(ladrillo.getX(), ladrillo.getY()+ ladrillo.getHeight()-2, ladrillo.getWidth(), 2);
		Rectangle recArriba = new Rectangle(ladrillo.getX(), ladrillo.getY()+2, ladrillo.getWidth(), 2);
		Rectangle recIzq = new Rectangle(ladrillo.getX()+2, ladrillo.getY(), 2, ladrillo.getHeight());
		Rectangle recDrcha = new Rectangle(ladrillo.getX()+ ladrillo.getWidth()-2, ladrillo.getY(), 2, ladrillo.getHeight());
		Rectangle recPelota = new Rectangle(this.x+5, this.y+5, this.getWidth()/2, this.getHeight()/2);
		
		boolean arriba = false, abajo = false, izquierda = false, derecha = false;
		
		if (recPelota.intersects(recAbajo)) abajo = true;
		if (recPelota.intersects(recArriba)) arriba = true;
		if (recPelota.intersects(recIzq)) izquierda = true;
		if (recPelota.intersects(recDrcha)) derecha = true;
		
		if (arriba && izquierda) {
			this.trayectoria.setPendiente(Math.abs(this.trayectoria.getPendiente()+0.1f), this.coordenadas, false);
			return;
		}
		if (arriba && derecha) {
			this.trayectoria.setPendiente(0-Math.abs(this.trayectoria.getPendiente()+0.1f), this.coordenadas, true);
			return;
		}
		if (abajo && izquierda) {
			this.trayectoria.setPendiente(0-Math.abs(this.trayectoria.getPendiente()), this.coordenadas, false);
			return;
		}
		if (abajo && derecha) {
			this.trayectoria.setPendiente(Math.abs(this.trayectoria.getPendiente()), this.coordenadas, true);
			return;
		}
		if (abajo) {
			this.trayectoria.reflejarHaciaAbajo(this.coordenadas);
			return;
		}
		if (arriba) {
			this.trayectoria.reflejarHaciaArriba(this.coordenadas);
			return;
		}
		if (derecha) {
			this.trayectoria.reflejarHaciaDerecha(this.coordenadas);
			return;
		}
		this.trayectoria.reflejarHaciaIzquierda(this.coordenadas);
	}
	
	/**
	 * 
	 * @param nave
	 */
	public void colisionConNave(Nave nave) {
		Rectangle recPelota = new Rectangle(this.x+5, this.y+5, this.getWidth()/2, this.getHeight()/2);
		Rectangle recCentro = new Rectangle(nave.getX()+15, nave.getY(), nave.getWidth()-30, 2);
		Rectangle recDrcha = new Rectangle(nave.x + nave.getWidth()-15, nave.getY(), 15, 2);
		Rectangle recIzq = new Rectangle(nave.getX(), nave.getY(), 15, 2);
		
		boolean centro = false, izquierda = false, derecha = false;
		
		if (recPelota.intersects(recCentro)) centro = true;
		if (recPelota.intersects(recIzq)) izquierda = true;
		if (recPelota.intersects(recDrcha)) derecha = true;
		
		if (derecha) {
			modificaTrayectoria(-0.3f, -1, true);
			System.out.println("derecha");
			return;
		}
		if (izquierda) {
			modificaTrayectoria(0.3f, 1, false);
			System.out.println("izq");
			return;
		}
		if (centro) {
			this.trayectoria.reflejarHaciaArriba(coordenadas);
			System.out.println("Centro");
			return;
		}
		
	}
	
	/**
	 * 
	 */
	public void modificaTrayectoria (float minPendiente, float maxPendiente, boolean direccionCreciente) {
		this.trayectoria = new TrayectoriaRecta( (float)(Math.random() * (maxPendiente - minPendiente)) + minPendiente ,new PuntoAltaPrecision(this.x, this.y), direccionCreciente);
	}
	

	/**
	 * 
	 */
	public void reiniciaPelota() {
		millisDesdeInicializacion = System.currentTimeMillis();
		espacio= false;
		click= false;
		trayectoria = null;
		incrementoVelocidad = 1.00035f;
		velocidad = 2.5f;
		
	}
	

}
