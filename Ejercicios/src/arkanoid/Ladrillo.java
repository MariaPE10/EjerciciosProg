package arkanoid;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import ejercicios.listeners.Maria;
import ejercicios.listeners.PalabraSecretaEvent;
import ejercicios.listeners.PalabraSecretaListener;

public class Ladrillo extends Actor {
	public static final int ANCHO = 48;
	public static final int ALTO = 24;
	public static final int ESPACIO_ENTRE_LADRILLOS = 2;
	
	public static int LADRILLO_NORMAL = 0;
	public static int LADRILLO_2_TOQUES = 1;
	public static int LADRILLO_IRROMPIBLE = 2;
	
	private int contador = 0;
	public int tipo;
	
	static List<ExplosionListener> explosionListener = new ArrayList<ExplosionListener>();
	
	/**
	 * ladrillo normal
	 * @param x
	 * @param y
	 * @param i
	 * @param tipo
	 */
	public Ladrillo(int x, int y, int i, int tipo) {
		super();
		this.x = x;
		this.y = y;
		this.setSpriteActual(SpriteCache.getInstancia().getSprite(escogeColor(i)));
		this.tipo = tipo;
		//this.ancho = this.spriteActual.getWidth();else 
		//this.alto = this.spriteActual.getHeight();
	}
	/**
	 * ladrillo 2 toques
	 * @param x
	 * @param y
	 */
	public Ladrillo(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.setSpriteActual(SpriteCache.getInstancia().getSprite("ladrilloEspecial1.png"));
		this.tipo = 1;
	}
	
	/**
	 * ladrillo irrompible
	 * @param x
	 * @param y
	 * @param i
	 */
	public Ladrillo(int x, int y, int i) {
		super();
		this.x = x;
		this.y = y;
		this.setSpriteActual(SpriteCache.getInstancia().getSprite("ladrilloEspecial2.png"));
		this.tipo = 2;
	}
	
	/**
	 * 
	 */
	public void collision(Actor actor) {
		addExplosionListener(new ControladorExplosion());
		double random = Math.random();
		if (actor instanceof Pelota)
			if(tipo == LADRILLO_NORMAL) {
				this.eliminar();
				ExplosionEvent event = new ExplosionEvent(new Explosion(this.x, this.y));
				fireExplosionListener(event);
				Arkanoid.getInstancia().getNave().setPuntuacion(Arkanoid.getInstancia().getNave().getPuntuacion()+5);
				if(random > 0.03 && random < 0.06) { //Probabilidad de 6% pildora Vida
					Pildora pildoraV = new PildoraVida(this.x, this.y);
					Arkanoid.getInstancia().getActoresAInsertar().add(pildoraV);
				}
				if(random > 0.15 && random < 0.2 && !Arkanoid.getInstancia().musicaUsado) { //Probabilidad de 15% a 20% pildora Musica
					Pildora pildoraM = new PildoraMusica(this.x, this.y);
					Arkanoid.getInstancia().getActoresAInsertar().add(pildoraM);
				}
				if(random < 0.4 && !Arkanoid.getInstancia().masterUsado) { //Probabilidad de 2% pildora Master
					Pildora pildoraMas = new PildoraMaster(this.x, this.y);
					Arkanoid.getInstancia().getActoresAInsertar().add(pildoraMas);
				}
				return;
			}
		
			if (tipo == LADRILLO_2_TOQUES){
				if (this.contador == 0) {
					this.contador++;
					Arkanoid.soundCache.playSound("pick.wav");
					Arkanoid.getInstancia().getNave().setPuntuacion(Arkanoid.getInstancia().getNave().getPuntuacion()+10);
					return;
				} else {
					this.eliminar();
					Arkanoid.getInstancia().getNave().setPuntuacion(Arkanoid.getInstancia().getNave().getPuntuacion()+15);
					ExplosionEvent event = new ExplosionEvent(new Explosion(this.x, this.y));
					fireExplosionListener(event);
					if(random < 0.30) { //Probabilidad de 10% pildora Rev
						Pildora pildoraR = new PildoraRev(this.x, this.y);
						Arkanoid.getInstancia().getActoresAInsertar().add(pildoraR);
					}
					return;
				}
			}
			
			if (tipo == LADRILLO_IRROMPIBLE) {
				if (Arkanoid.getInstancia().getPelota().getSpriteActual() == SpriteCache.getInstancia().getSprite("master.png")) {
					this.eliminar();
					Arkanoid.getInstancia().getNave().setPuntuacion(Arkanoid.getInstancia().getNave().getPuntuacion()+50);
					ExplosionEvent event = new ExplosionEvent(new Explosion(this.x, this.y));
					fireExplosionListener(event);
				} else {
					Arkanoid.soundCache.playSound("ladrilloOro.wav");
				}
				
				//System.out.println("soy indestructible");
				return;
			}
			
	}
	
	/**
	 * 
	 * @param i
	 * @return
	 */
	public String escogeColor(int i) {
		if (i == 1) {
			return "ladrilloRosa.png";
		}
		if (i == 2) {
			return "ladrilloRojo.png";
		}
		if (i == 3) {
			return "ladrilloNaranja.png";
		}
		if (i == 4) {
			return "ladrilloAmarillo.png";
		}
		if (i == 5) {
			return "ladrilloCeleste.png";
		}
		if (i == 6) {
			return "ladrilloAzul.png";
		}
		if (i == 7) {
			return "ladrilloVerde.png";
		} 
		return "ladrilloBlanco.png";
	}
	
	/**
	 * 
	 * @param listener
	 */
	public static void addExplosionListener(ExplosionListener listener) {
		explosionListener.add(listener);
	}
	
	/**
	 * 
	 * @param listener
	 */
	public static void removeExplosionListener(ExplosionListener listener) {
		explosionListener.remove(listener);
	}
	
	/**
	 * 
	 * @param e
	 */
	public static void fireExplosionListener (ExplosionEvent e) {
		for (ExplosionListener listener : explosionListener) {
			listener.explosionProducida(e);
		}
	}
}
