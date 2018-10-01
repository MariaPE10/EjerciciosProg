package Ejercicios;

import javax.swing.JOptionPane;

public class MaquinaCambio {
 /* Maquina espendedora que devuelve el cambio en monedas.
  * Siempre con la minima cantidad de monedas.
  */
	public static void main (String [] args ) {
		int cantPagada = 0;
		int precioProducto = 220;
		
		int cambio = 0;
		
		int valor2e = 200;
		int valor1e = 100;
		int valor50c = 50;
		int valor20c = 20;
		int valor10c = 10;
		int valor5c = 5;		
		int valor2c = 2;	
		int valor1c = 1;
		
		int cont2e =0;
		int cont1e = 0;
		int cont50c = 0;
		int cont20c = 0;
		int cont10c = 0;
		int cont5c = 0;
		int cont2c = 0;
		int cont1c = 0;
							
		try {
			String str1 = JOptionPane.showInputDialog("Introduzca un importe: ");
			cantPagada = Integer.parseInt(str1);
			cantPagada = cantPagada*100;
		}	
		catch (NumberFormatException ex) {
			System.out.println("Error no has introducido un numero");
			ex.printStackTrace();
		}
		if (cantPagada < precioProducto) {
			System.out.println("Importe insuficiente");
		}
		cambio = cantPagada - precioProducto;
		
		cont2e = cambio / valor2e;
		cambio = cambio % valor2e;		
		
		cont1e = cambio / valor1e;
		cambio = cambio % valor1e;
		
		cont50c = cambio / valor50c;
		cambio = cambio % valor50c;
		
		cont20c = cambio / valor20c;
		cambio = cambio % valor20c;
		
		cont10c = cambio / valor10c;
		cambio = cambio % valor10c;
		
		cont5c = cambio / valor5c;
		cambio = cambio % valor5c;
		
		cont2c = cambio / valor2c;
		cambio = cambio % valor2c;
		
		cont1c = cambio / valor1c;
		cambio = cambio % valor1c;
	
		/* while (cambio > 0) {
			if (cambio >= valor2e) {
				cambio = cambio - valor2e;
				cont2e++;
			} else if(cambio >= valor1e) {
				cambio = cambio - valor1e;
				cont1e++;
			} else if(cambio >= valor50c) {
				cambio = cambio - valor50c;
				cont50c++;
			} else if(cambio >= valor20c) {
				cambio = cambio - valor20c;
				cont20c++;
			} else if(cambio >= valor10c) {
				cambio = cambio - valor10c;
				cont10c++;
			} else if(cambio >= valor5c) {
				cambio = cambio - valor5c;
				cont5c++;
			}  else if(cambio >= valor2c) {
				cambio = cambio - valor2c;
				cont2c++;
			}  else if(cambio >= valor1c) {
				cambio = cambio - valor1c;
				cont1c++;
			}
		}*/
		
		
		System.out.println("Numero de monedas de 2e: " + cont2e);
		System.out.println("Numero de monedas de 1e: " + cont1e);
		System.out.println("Numero de monedas de 0.50c: " + cont50c);
		System.out.println("Numero de monedas de 0.20c: " + cont20c);
		System.out.println("Numero de monedas de 0.10c: " + cont10c);
		System.out.println("Numero de monedas de 0.05c: " + cont5c);
		System.out.println("Numero de monedas de 0.02c: " + cont2c);
		System.out.println("Numero de monedas de 0.01c: " + cont1c);
	}
}
