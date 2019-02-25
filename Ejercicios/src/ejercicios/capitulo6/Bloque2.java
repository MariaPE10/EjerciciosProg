package ejercicios.capitulo6;

public class Bloque2 {

	/*
	 * Ejercicio 1: Crear un programa que resuelva ecuaciones de segundo grado con una incógnita.
	 * El programa debe pedir los parámetros a, b y c de la ecuación, e imprimir, en caso de
	 * que las haya, la solución o soluciones de la ecuación.
	 */
	
	public static void resuelveEcuacionSegundoGrado(float a, float b, float c) {
		double valorX []= new double[2];
		
		valorX[0] = (-b + Math.sqrt(Math.pow(b, 2) - (4*a*c)))/2*a;
		valorX[1] = (-b - Math.sqrt(Math.pow(b, 2) - (4*a*c)))/2*a;
		
		for (double x : valorX) {
			System.out.println("valor de x:" + x);
		}
	}
	
	/*
	 * Ejercicio 2: Averiguar, con una precisión inferior a 0.001, en qué punto (x,y)
	 * se cortan las gráficas de las siguientes funciones:
	 * 	y = sqrt(x)
	 *  y = - ln(x)
	 */
	
	public static void corteDeGraficas() {
		float x;
		
		//x = Math.sqrt(x)-(-Math.log(Math.pow(x, 2));
		
	}
	
	public static void main(String[] args) {
		resuelveEcuacionSegundoGrado(1,3,0);
	}
}
