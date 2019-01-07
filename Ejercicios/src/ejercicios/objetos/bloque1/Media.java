package ejercicios.objetos.bloque1;

import javax.swing.JOptionPane;

/* Ejercicio 1: Realiza un m�todo que reciba como par�metros de entrada tres valores enteros y uno flotante.
  * El m�todo debe devolver la media aritm�tica de los cuatro valores, un valor flotante.
  * "main" debe usar a esta funci�n creada por ti, e imprimir el valor de la media en la consola de salida.
  */
public class Media {
	//Declaracion de propiedades de la clase.
	public int numeroEntero;
	public int numeroEntero2;
	public int numeroEntero3;
	public float numeroFloat;
	
	//Constructor, es un metodo que construye tu objeto
	public Media(int num1, int num2, int num3, float bollo) {
		this.numeroEntero = num1;
		this.numeroEntero2 = num2;
		this.numeroEntero3 = num3;
		this.numeroFloat = bollo;
	}
	
	//Constructor, es un metodo que construye tu objeto
	public Media() {
		this.numeroEntero = 0;
		this.numeroEntero2 = 0;
		this.numeroEntero3 = 0;
		this.numeroFloat = 0;
	}
	
	//Constructor, es un metodo que construye tu objeto.
	public Media(int num1) {
		this.numeroEntero = num1;
		this.numeroEntero2 = 0;
		this.numeroEntero3 = 0;
		this.numeroFloat = 0;
	}
	
	//metodo que suma tres numeros enteros.
	public int sumaEnteros() {
		int acumulado = 0;
		
		acumulado = sumar(acumulado,this.numeroEntero);
		acumulado = sumar(acumulado, this.numeroEntero2);
		acumulado = sumar(acumulado,this.numeroEntero3);
		
		return acumulado;
	}
	
	public float sumaTotal() {		
		
		float resultado = sumaEnteros() + this.numeroFloat;	
		
		return resultado;	
	}
	
	// metodo para encapsular funcionalidad repetida que en este caso es
	//sencilla pero en otra circunstancia puede que no lo sea
	private int sumar(int num1, int num2) {		
		int resultado = num1 + num2;
		return resultado;
	}

	public float mediaEnteros() {
		float resultado = 0;
		
		resultado = sumaEnteros()/3;
		
		return resultado;
	}
	
	public float mediaTotal() {
		float resultado = 0;
		
		resultado = sumaTotal()/4;
		
		return resultado;
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
