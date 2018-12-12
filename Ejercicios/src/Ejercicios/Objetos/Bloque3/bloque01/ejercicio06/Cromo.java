package tutorialJava.capitulo05.bloque01.ejercicio06;

public class Cromo {
	
	private int id;
	private String descripcion;
	public Cromo(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "Cromo [id=" + id + ", descripcion=" + descripcion + "]";
	}
	
	
	public static int TIPO_CROMO_FUTBOL = 0;
	
	public static String traduceTipo (int tipo) {
		if (tipo == TIPO_CROMO_FUTBOL) {
			return "Fútbol";
		}
		return "Desconocido";
	}

}
