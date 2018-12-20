package Ejercicios.Objetos.TresEnRaya;

public class Matriz {

	private static Matriz matriz = null;
	public static final int FILAS = 3;
	public static final int COLUMNAS = 3;
	int tablero[][] = new int [FILAS][COLUMNAS];
	
	
	/**
	 * 
	 */
	public Matriz() {
		inicializa();
	}
	
	/**
	 * 
	 * @return
	 */
	public static Matriz getInstance() {
		if (matriz == null) {
			matriz = new Matriz();
		}
		return matriz;
	}
	
	/**
	 * 
	 */
	private void imprimir() {
	
		
	}
	
	/**
	 * 
	 */
	private void inicializa() {
		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				tablero[i][j]=0;
			}
		}
	}
}
