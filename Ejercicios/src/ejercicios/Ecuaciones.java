package ejercicios;

public class Ecuaciones {

	public static void main (String[] args) {
		 int a = 1, b = 0, c = -1;
		 float x1, x2;
		 float determinante;
		 
		 determinante = (float) Math.sqrt(b*b - 4*a*c);
		 x1 = ((0 - b) + determinante) / (2 * a);			 
		 x2 = ((0 - b) - determinante) / (2 * a);
				 
		System.out.println("la ecuacion es: " + a + "x(2) + " + b + "x + " + c + "= 0");
		System.out.println("la solucion de x1 es: " +  x1 + "la solucion de x2 es: " + x2);	 
	}
}
