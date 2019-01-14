package ejercicios.objetos.bloque4.ejercicios;

/* Realiza un programa que cree un array bidimensional, una matriz, de 5 filas x 5 columnas. Una vez hecho el array,
   realiza estos pasos:

    - 
    - Crea un 
    - Crea un método que compruebe si la matriz es dispersa. (Todos las filas y todas las columnas contienen
      al menos un elemento nulo)
    - Crea un método que construya un array unidimensional con todos los elementos de la matriz.
    - Crea un método que compruebe si la matriz es simétrica. (Los elementos de la matriz (i, j) y (j, i),
      si existen, son iguales).
    - Crea un método que realice la matriz traspuesta de la que recibe.
    - Crea un método que realice la matiz opuesta de la que recibe.
    - Crea un método que pida al usuario un número de fila sobre la matriz. Debes crear una matriz igual a 
    la original pero eliminando el número de fila que el usuario ha especificado. */
public class EjercicioMatriz {
	
	public static void main(String[] args) {
		int matriz[][] = creaMatriz();
		imprimeMatriz(matriz);
		
		//Apartado 3
		if (isMatrizPositiva(matriz)) {
			System.out.println("La matriz es positiva");
		} else {
			System.out.println("La matriz no es positiva");
		}
		
		//Apartado 4
		if (isMatrizDiagonal(matriz)) {
			System.out.println("La matriz es diagonal");
		} else {
			System.out.println("La matriz no es diagonal");
		}
		
		//Apartado 5
		if (isMatrizSuperior(matriz)) {
			System.out.println("La matriz es triangular superior");
		} else {
			System.out.println("La matriz no es triangular superior");
		}
	}
	
	/**
	 * Método que rellena la matriz con valores creados al azar.
	 * @return
	 */
	private static int[][] creaMatriz() {
//		int matriz[][] = new int [5][5];
//		
//		for (int i = 0; i < matriz.length; i++) {
//			for (int j = 0; j < matriz[0].length; j++) {
//				matriz[i][j]=(int) Math.round(Math.random()*(10+10))-10;
//			}
//		}
		
		int matriz[][] = new int [][] {
			{1, 0, 0, 0, 0},
			{0, 1, 0, 0, 0},
			{0, 0, 1, 0, 0},
			{0, 0, 0, 1, 0},
			{0, 0, 0, 0, 1}
		};
		return matriz;
	}
	
	/**
	 * Método que imprima la matriz en pantalla.
	 * @param matriz
	 */
	private static void imprimeMatriz(int matriz[][]) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print(matriz[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	/**
	 * Método que compruebe si la matriz es positiva. (Todos sus elementos son mayores o iguales a cero)
	 * @param matriz
	 * @return
	 */
	private static boolean isMatrizPositiva(int matriz[][]) {
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if (matriz[i][j] < 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Método que compruebe si la matriz es diagonal (Todos los elementos que no están en la diagonal
     * principal son nulos).
	 * @param matriz
	 * @return
	 */
	private static boolean isMatrizDiagonal(int matriz[][]) {
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if( i != j && matriz[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Método que compruebe si la matriz es triangular superior. (Todos los elementos que están por
     * debajo de la diagonal principal son nulos).
	 * @param matriz
	 * @return
	 */
	private static boolean isMatrizSuperior(int matriz[][]) {
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if( j < i && matriz[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}
	
}
