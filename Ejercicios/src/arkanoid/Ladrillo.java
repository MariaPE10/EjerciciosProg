package arkanoid;

public class Ladrillo extends Actor {
	public static final int ANCHO = 48;
	public static final int ALTO = 24;
	public static final int ESPACIO_ENTRE_LADRILLOS = 2;
	
	public static int LADRILLO_NORMAL = 0;
	public static int LADRILLO_2_TOQUES = 1;
	public static int LADRILLO_IRROMPIBLE = 2;
	
	private int contador = 0;
	public int tipo;
	
	//ladrillo normal
	public Ladrillo(int x, int y, int i, int tipo) {
		super();
		this.x = x;
		this.y = y;
		this.setSpriteActual(SpriteCache.getInstancia().getSprite(escogeColor(i)));
		this.tipo = tipo;
		//this.ancho = this.spriteActual.getWidth();else 
		//this.alto = this.spriteActual.getHeight();
	}
	
	//ladrillo 2 toques
	public Ladrillo(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.setSpriteActual(SpriteCache.getInstancia().getSprite("ladrilloEspecial1.png"));
		this.tipo = 1;
	}
	
	//ladrillo irrompible
		public Ladrillo(int x, int y, int i) {
			super();
			this.x = x;
			this.y = y;
			this.setSpriteActual(SpriteCache.getInstancia().getSprite("ladrilloEspecial2.png"));
			this.tipo = 3;
		}
	
	public void collision(Actor actor) {
		if (actor instanceof Pelota)
			if(tipo == LADRILLO_NORMAL) {
				this.eliminar();
				Arkanoid.soundCache.playSound("pick.wav");
				Explosion ex = new Explosion(this.x, this.y);
				Arkanoid.getInstancia().getActoresAInsertar().add(ex);
				return;
			}
		
			if (tipo == LADRILLO_2_TOQUES){
				if (this.contador == 0) {
					this.contador++;
					Arkanoid.soundCache.playSound("pick.wav");
					return;
				} else {
					this.eliminar();
					Arkanoid.soundCache.playSound("pick.wav");
					Explosion ex = new Explosion(this.x, this.y);
					Arkanoid.getInstancia().getActoresAInsertar().add(ex);
					return;
				}
			}
			
			if (tipo == LADRILLO_IRROMPIBLE) {
				Arkanoid.soundCache.playSound("metal.wav");
				System.out.println("soy indestructible");
				return;
			}
			
	}
	
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
}
