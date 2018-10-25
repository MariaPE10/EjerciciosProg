import javax.swing.JOptionPane;

public class ApartadoB {
	/* Crea una clase con un método “main” que cree un array con 100 elementos de
	 * longitud, los elementos deben ser números enteros al azar comprendidos entre dos límites, que
	 * deben ser preguntados al usuario. Muestra el array en orden normal y también en orden 
	 * invertido.
	 */
	
	public static void main(String[] args) {
		apartadoB();
	}

	public static void apartadoB() {	
		int array[] = new int [100];
		int max, min;
		
		//Peticion de los limites maximo y minimo al usuario
		min=Integer.parseInt(JOptionPane.showInputDialog("Introduzca el limite inferior:"));
		max=Integer.parseInt(JOptionPane.showInputDialog("Introduzca el limite superior:"));
		
		//Impresion de los limites en pantalla (para conocimiento del usuario)
		System.out.println("Limite superior: " + max);
		System.out.println("Limite inferior: " + min);
		
		//Genera un array de 100 elementos entre los limites dados por el usuario y lo muestra en pantalla.
		for (int i = 0; i < array.length; i++) {
			array[i] = ((int) Math.round(Math.random() * (max-min)))+min; //Genera un numero aleatorio entre un maximo y un minimo
			System.out.print("[" + i + "]:" + array[i] + " ");
		}
		
		System.out.println("\nArray a la inversa");
		
		//Imprime el array de forma inversa.
		for (int i = array.length-1; i > -1; i--) {
			System.out.print("[" + i + "]:" + array[i] + " ");
		}
	}
}
