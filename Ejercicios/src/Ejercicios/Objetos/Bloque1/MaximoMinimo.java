package Ejercicios.Objetos.Bloque1;

import javax.swing.JOptionPane;

/* Ejercicio 2: Realiza un m�todo que pida al usuario dos n�meros. Los dos n�meros deben estar comprendidos entre un m�ximo y un m�nimo.
  * "main" debe pedir al usuario dos valores: uno m�nimo y otro m�ximo. "main" debe enviar esos dos valores del usuario a
  * otra funci�n que, a su vez, pida dos valores al usuario teniendo en cuenta el m�nimo y m�ximo introducidos previamente.
  * El m�todo no debe devolver ning�n valor.
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
			System.out.println("tu numero: " + numeroPedido1 + " est� entre " + this.atributoMaximo + " y " + this.atributoMinimo);
		} else {
			System.out.println("tu numero: " + numeroPedido1 + " no est� entre " + this.atributoMaximo + " y " + this.atributoMinimo);
		}
		if (numeroPedido2 >= this.atributoMinimo && numeroPedido2 <= this.atributoMaximo) {
			System.out.println("tu numero: " + numeroPedido2 + " est� entre " + this.atributoMaximo + " y " + this.atributoMinimo);
		} else {
			System.out.println("tu numero: " + numeroPedido2 + " no est� entre " + this.atributoMaximo + " y " + this.atributoMinimo);
		}
	}
	
	
	public static void main(String[] args) {
		int maximo = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el maximo"));
		int minimo = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el minimo"));
		
		MaximoMinimo objetoNumero = new MaximoMinimo(maximo, minimo);
		objetoNumero.PedirNumeros();
		
		
	}
}
