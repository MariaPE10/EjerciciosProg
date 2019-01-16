package ejercicios.objetos.bloque4.ejercicios;

/* Realiza un programa que cree un array bidimensional, una matriz, de 5 filas x 5 columnas. Una vez hecho el array,
   realiza estos pasos: 
    - Crea un Metodo que pida al usuario un numero de fila sobre la matriz. Debes crear una matriz igual a 
    la original pero eliminando el numero de fila que el usuario ha especificado. */
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
		
		//Apartado 6
		if (isMatrizDispersa(matriz)) {
			System.out.println("La matriz es dispersa");
		} else {
			System.out.println("La matriz no es dispersa");
		}
		
		//Apartado 7
		arrayUnidimensional(matriz);
		
		//Apartado 8
		System.out.println();
		if (isMatrizSimetrica(matriz)) {
			System.out.println("La matriz es simetrica");
		} else {
			System.out.println("La matriz no es simetrica");
		}
		
		//Apartado 9
		System.out.println("MATRIZ TRASPUESTA");
		int matrizTrans[][]= getMatrizTraspuesta(matriz);
		imprimeMatriz(matrizTrans);
		
		//Apartado 10
		System.out.println("MATRIZ OPUESTA");
		int matrizOp[][]= getMatrizOpuesta(matriz);
		imprimeMatriz(matrizOp);
	}
	
	/**
	 * Metodo que rellena la matriz con valores creados al azar.
	 * @return
	 */
	private static int[][] creaMatriz() {
		int matriz[][] = new int [5][5];
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j]=(int) Math.round(Math.random()*(10+10))-10;
			}
		}
		
//		int matriz[][] = new int [][] {
//			{1, 0, 0, 0, 0},
//			{1, 0, 1, 1, 1},
//			{1, 1, 0, 1, 1},
//			{1, 1, 1, 0, 1},
//			{1, 1, 1, 1, 0}
//		};
		return matriz;
	}
	
	/**
	 * Metodo que imprima la matriz en pantalla.
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
	 * Metodo que compruebe si la matriz es positiva. (Todos sus elementos son mayores o iguales a cero)
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
	 * Metodo que compruebe si la matriz es diagonal (Todos los elementos que no estan en la diagonal
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
	 * Metodo que compruebe si la matriz es triangular superior. (Todos los elementos que estan por
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
	
	/**
	 * Metodo que compruebe si la matriz es dispersa. (Todos las filas y todas las columnas contienen
     * al menos un elemento nulo).
	 * @param matriz
	 * @return
	 */
	private static boolean isMatrizDispersa(int matriz[][]) {
		
		for (int i = 0; i < matriz.length; i++) {
			int count = 0;
			for (int j = 0; j < matriz[0].length; j++) {
				if( matriz[i][j] == 0) {
					count += 1;
				}
				if ( j== matriz.length-1 && count == 0) {
					return false;
				}
			}
		}
		return true;
	}	
	
	/**
	 * Metodo que construya un array unidimensional con todos los elementos de la matriz.
	 * @param matriz
	 * @return
	 */
	private static void arrayUnidimensional(int matriz[][]) {
		int array[] = new int[matriz.length*matriz[0].length];
		
		for (int j = 0; j < matriz[0].length; j++) {
			array[j] = matriz[0][j];
		}
		
		for (int j = 0; j < matriz[0].length; j++) {
			array[j+5] = matriz[1][j];
		}
		
		for (int j = 0; j < matriz[0].length; j++) {
			array[j+10] = matriz[2][j];
		}
			
		for (int j = 0; j < matriz[0].length; j++) {
			array[j+15] = matriz[3][j];
		}
	
		for (int j = 0; j < matriz[0].length; j++) {
			array[j+20] = matriz[4][j];
		}
	
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "  ");
		}
	}
	
	/**
	 * Metodo que compruebe si la matriz es simetrica. (Los elementos de la matriz (i, j) y (j, i),
     * si existen, son iguales).
	 * @param matriz
	 * @return
	 */
	private static boolean isMatrizSimetrica (int matriz[][]) {
		boolean simetrica = true;

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] != matriz[j][i])
					simetrica = false;
			}
		}
		return simetrica;
	}
	
	/**
	 * Metodo que realice la matriz traspuesta de la que recibe.
	 * @param matriz
	 * @return
	 */
	private static int[][] getMatrizTraspuesta(int matriz[][]){
		int matrizTras[][] = new int [5][5];
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matrizTras[j][i]= matriz[i][j];
			}
		}
		
		return matrizTras;
	}
	
	/**
	 * Metodo que realice la matiz opuesta de la que recibe.
	 * @param matriz
	 * @return
	 */
	private static int[][] getMatrizOpuesta(int matriz[][]){
		int matrizOp[][] = new int [5][5];
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matrizOp[i][j]= matriz[i][j]*(-1);
			}
		}
		
		return matrizOp;
	}
}
