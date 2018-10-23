package Ejercicios.Objetos.Bloque1;

import javax.swing.JOptionPane;

/* Ejercicio 1: Realiza un método que reciba como parámetros de entrada tres valores enteros y uno flotante.
  * El método debe devolver la media aritmética de los cuatro valores, un valor flotante.
  * "main" debe usar a esta función creada por ti, e imprimir el valor de la media en la consola de salida.
  */
public class Media {
	
	public int numeroEntero;
	public int numeroEntero2;
	public int numeroEntero3;
	public float numeroFloat;
	
	//Constructor, es un método que construye tu objeto
	public Media(int num1, int num2, int num3, float bollo) {
		this.numeroEntero = num1;
		this.numeroEntero2 = num2;
		this.numeroEntero3 = num3;
		this.numeroFloat = bollo;
	}
	
	public Media() {
		this.numeroEntero = 0;
		this.numeroEntero2 = 0;
		this.numeroEntero3 = 0;
		this.numeroFloat = 0;
	}
	
	public Media(int num1) {
		this.numeroEntero = num1;
		this.numeroEntero2 = 0;
		this.numeroEntero3 = 0;
		this.numeroFloat = 0;
	}
	
	public int sumaEnteros() {
		
		int acumulado = 0;
		
		acumulado = sumar(acumulado,this.numeroEntero);
		acumulado = sumar(acumulado, this.numeroEntero2);
		acumulado = sumar(acumulado,this.numeroEntero3);
		
		return acumulado;
	}
	
	public float sumaTotal() {		
		
		float sumaTotal = sumaEnteros() + this.numeroFloat;	
		
		return sumaTotal;		
	}
	
	// metodo para encapsular funcionalidad repetida que en este caso es
	//sencilla pero en otra circunstancia puede que no lo sea
	private int sumar(int num1, int num2) {		
		int resultado = num1 + num2;
		return resultado;
	}

	public float mediaEnteros() {
		
		float mediaEnteros = 0;
		
		mediaEnteros = sumaEnteros()/3;
		
		return mediaEnteros;
	}
	
	public float mediaTotal() {
		
		float mediaTotal = 0;
		
		mediaTotal = sumaTotal()/4;
		
		return mediaTotal;
	}
	
	public static void main(String[] args) {
		int numeroPedido1 = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el primer numero"));
		int numeroPedido2 = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el segundo numero"));
		int numeroPedido3 = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el tercer numero"));
		float numeroPedido4 = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el cuarto numero"));
		
		Media objetoMedia = new Media(numeroPedido1,numeroPedido2,numeroPedido3,numeroPedido4);
		objetoMedia.sumaEnteros();
		
		System.out.println("Suma total: " + objetoMedia.sumaTotal());
		System.out.println("Media total: " + objetoMedia.mediaTotal());
	}
	
}
