package Examenes;

import java.util.Date;

import javax.swing.JOptionPane;

public class Ex2017 {

	public static void main(String[] args) {
		Ejercicio03();
	}

	//Ejercicio 1
	
	public static void Ejercicio01 () {
		String menu = "MENU\n"
				+ "1.- Calculo del area de un triangulo.\n"
				+ "2.- Calculo del perimetro de una circunferencia.\n"
				+ "3.- Genera numeros al azar hasta crear el 47.\n"
				+ "0.- Salir de la aplicacion.";
		int opcion = -1,n1, n2;
		double resultado;
		
		do {
			try {
				opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
				switch (opcion) {
				case 0:
					System.exit(0); // Acaba radicalmente con la ejecuci�n
					break;
				case 1: //Area triangulo
					n1 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca la longitud de la base del triangulo"));
					n2 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca la altura del triangulo"));
					resultado = (n1*n2)/2;
					JOptionPane.showMessageDialog(null, "Area del triangulo: " + resultado);
					break;
				case 2: // Perimetro circunferencia
					n1 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca el radio de la circunferencia"));
					resultado = 2*Math.PI*n1;
					JOptionPane.showMessageDialog(null, "Perimetro: " + resultado);
					break;
				case 3: //Numero al azar hasta crear 47
					do {
						n1 = (int) Math.round(Math.random()*100);
						JOptionPane.showMessageDialog(null, "Numero: " + n1);
					} while (n1 != 47);
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opcion Incorrecta");
				}		
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Opcion Incorrecta");
			}
					
		} while (opcion!=0);
	}
	
	//Ejercicio 2
	
	public static void Ejercicio02 () {
		int num, limite;
		String mensaje = "Introduzca el numero";
		
		num = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
		limite = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el limite"));
		//Tabla de multiplicar de un numero
		for (int i = 1; i <= limite; i++) {
			if (i%num ==0) {
				System.out.println(i + " es multiplo de " + num);
				for (int j = 0; j <= 10; j++) {
					System.out.println(i + " x " + j + " = " + (i*j));	
				}
			}
		}
	}
	
	//Ejercicio 3
	
	public static void Ejercicio03 () {
		int num=1;
		String mensaje = "Introduzca numero";
		int acumulado;
		
		while (num != 0) { //Se repite MIENTRAS que "num" sea diferente de 0
			num = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
			acumulado = 0;
			if (num!=0) { //Sirve para que en caso de que el numero sea 0 no imprima nada
				// Toma del tiempo (en milisegundos) antes de comenzar la ordenaci�n HAY QUE HACER UN IMPORT!!
				long millisAntes = new Date().getTime();
						
				//Divisores de un numero
				for (int i = 1; i <= num; i++) { // se repite DURANTE el tiempo que la "i" sea menor o igual que "num"
					if (num%i == 0) { //El numero i es divisor
						System.out.println("El numero " + i + " es divisor de " + num);	
						acumulado++;
					}	
				}
				// Toma del tiempo (en milisegundos) despu�s de terminar la ordenaci�n
				long millisDespues = new Date().getTime();	
				// Impresi�n del tiempo transcurrido
				System.out.print("\nTiempo transcurrido (en segundos): " + ((float) (millisDespues - millisAntes) / 1000 )+ "\nResultados encontrados: " + acumulado);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
