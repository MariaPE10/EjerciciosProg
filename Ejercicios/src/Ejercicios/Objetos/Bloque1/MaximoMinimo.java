package Ejercicios.Objetos.Bloque1;

import javax.swing.JOptionPane;

/* Ejercicio 2: Realiza un método que pida al usuario dos números. Los dos números deben estar comprendidos entre un máximo y un mínimo.
  * "main" debe pedir al usuario dos valores: uno mínimo y otro máximo. "main" debe enviar esos dos valores del usuario a
  * otra función que, a su vez, pida dos valores al usuario teniendo en cuenta el mínimo y máximo introducidos previamente.
  * El método no debe devolver ningún valor.
  */
public class MaximoMinimo {

	public int atributoMaximo;
	public int atributoMinimo;
	
	//constructor
	public MaximoMinimo(int max, int min) {
		this.atributoMaximo = max;
		this.atributoMinimo = min;
	}
	
	public void PedirNumeros() {
		
		int numeroPedido1 = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el primer numero"));
		int numeroPedido2 = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el segundo numero"));
		
		if (numeroPedido1 >= this.atributoMinimo && numeroPedido1 <= this.atributoMaximo) {
			System.out.println("tu numero: " + numeroPedido1 + " está entre " + this.atributoMaximo + " y " + this.atributoMinimo);
		} else {
			System.out.println("tu numero: " + numeroPedido1 + " no está entre " + this.atributoMaximo + " y " + this.atributoMinimo);
		}
		if (numeroPedido2 >= this.atributoMinimo && numeroPedido2 <= this.atributoMaximo) {
			System.out.println("tu numero: " + numeroPedido2 + " está entre " + this.atributoMaximo + " y " + this.atributoMinimo);
		} else {
			System.out.println("tu numero: " + numeroPedido2 + " no está entre " + this.atributoMaximo + " y " + this.atributoMinimo);
		}
	}
	
	
	public static void main(String[] args) {
		int maximo = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el maximo"));
		int minimo = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el minimo"));
		
		MaximoMinimo objetoNumero = new MaximoMinimo(maximo, minimo);
		objetoNumero.PedirNumeros();
		
		
	}
}
