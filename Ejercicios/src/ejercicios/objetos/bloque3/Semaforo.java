package ejercicios.objetos.bloque3;

public class Semaforo {

	private String estado[] = new String[] {"ROJO", "AMBAR", "VERDE"};
	private String color = "";
	private String estadoPeatones[] = new String[] {"ROJO", "VERDE"};
	private String colorPeatones = "";
	public Semaforo() {
		super();
		this.color = this.estado[0];
		this.colorPeatones = this.estadoPeatones[1];
	}

	/**
	 * 
	 */
	public void cambiaColorAleatorio () {
		int indice = (int) Math.round(Math.random()*(estado.length-1));
		System.out.println("Color Semaforo: " + this.color + " Color peatones: " + this.colorPeatones);
		
		
		for (int i = 0; i < 5; i++) {
			indice = (int) Math.round(Math.random()*(estado.length-1));
			this.color = estado[indice];
			if (this.color == estado[0]) {
				this.colorPeatones = estadoPeatones[1];
			} else {
				this.colorPeatones = estadoPeatones[0];
			}
			System.out.println("Color Semaforo: " + this.color + " Color peatones: " + this.colorPeatones);
		}
	}
	
	/**
	 * 
	 */
	public void cambiaColor() {

		for (int i = 0; i < estado.length; i++) {
			this.color = estado[i];
			if (this.color == estado[0]) {
				this.colorPeatones = estadoPeatones[1];
			} else {
				this.colorPeatones = estadoPeatones[0];
			}
			System.out.println("Color Semaforo: " + this.color + " Color peatones: " + this.colorPeatones);
		}
	}
	
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

}
