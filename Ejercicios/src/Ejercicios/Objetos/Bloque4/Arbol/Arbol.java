package Ejercicios.Objetos.Bloque4.Arbol;

public class Arbol {
	/* Ejercicio 3: Crear un programa que implemente un árbol. Los árboles pueden tener tres elementos:
	 * un tronco, ramas, hojas y frutos. Cada rama tiene tres ramificaciones, que puede
	 * estar conectadas a otra rama, una hoja o un fruto. El tronco puede ser considerado
	 * como una rama. Realizar una clase de prueba, en la que se cree un árbol instanciando
	 * un tronco, varias ramas conectadas, hojas y frutos. Posteriormente imprimir en pantalla
	 * el árbol.
	 */
	public static void main(String[] args) {
		Rama tronco = new Rama("Tronco");
		Rama rama01 = new Rama("Rama 01");
		
		tronco.setExtension1(rama01);
		tronco.setExtension2(new Fruto("Fruto 01"));
		tronco.setExtension3(new Hoja("Hoja 01"));

		Rama rama02 = new Rama("Rama 02");
		rama01.setExtension1(new Fruto("Fruto 02"));
		rama01.setExtension2(rama02);
	}

}
//para que deje de crecer se le da a todo que sean frutos u hojas o a alguna extension le demos un null.
//