package ejercicios.capitulo6;

public class Bloque2 {

	/*
	 * Ejercicio 1: Crear un programa que resuelva ecuaciones de segundo grado con una incógnita.
	 * El programa debe pedir los parámetros a, b y c de la ecuación, e imprimir, en caso de
	 * que las haya, la solución o soluciones de la ecuación.
	 */
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @param c
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
	 * 	y = sqrt(x) (funcion 1)
	 *  y = - ln(x) (funcion 2)
	 */
	
	/**
	 * x e y1 son la x e y de la funcion 1
	 * x e y2 son la x e y de la funcion 2
	 */
	public static void corteDeGraficas() {
	
		for (float x = 0.0001f; x<1; x+=0.0001) {
			float y1 = (float) Math.sqrt(x);
			System.out.println("x: " + x + ", y1= sqrt(x): " + y1);
			float y2 = (float) (0-Math.log(x));
			System.out.println("x: " + x + ", y2= -ln(x): " + y2);
			
			if (Math.abs(y2-y1)<0.0001) {
				System.out.println("Solución encontrada en x = " + x + ", y = " + y1);
				break;
			}
		}
		
	}
	
	public static void main(String[] args) {
		resuelveEcuacionSegundoGrado(1,3,0);
		corteDeGraficas();
	}
}
