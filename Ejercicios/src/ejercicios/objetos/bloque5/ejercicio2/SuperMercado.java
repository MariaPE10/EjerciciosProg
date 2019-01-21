package ejercicios.objetos.bloque5.ejercicio2;


public class SuperMercado {

	public static void main(String[] args) {
		Fila_Clientes fila = new Fila_Clientes();
		
		fila.agregarCliente(new Cliente("Maria", 1));
		fila.agregarCliente(new Cliente("Sandra", 2));
		fila.agregarCliente(new Cliente("Isa", 3));
		fila.agregarCliente(new Cliente("Juan", 4));
		fila.agregarCliente(new Cliente("Rafa", 5));
		fila.agregarCliente(new Cliente("Violet", 6));
		fila.imprimeFila();
		System.out.println();
		
		Cliente cliente01 = fila.sacarCliente();
		fila.imprimeFila();
		System.out.println();
		Cliente cliente02 = fila.sacarCliente();
		fila.imprimeFila();
		System.out.println();
		
		fila.agregarCliente(cliente01);
		fila.agregarCliente(cliente02);
		fila.imprimeFila();
		System.out.println();
		
		Fila_Clientes fila2 = new Fila_Clientes();
		fila2 = fila.dividirFila();
		System.out.println("CAJA 1");
		fila.imprimeFila();
		
		System.out.println("CAJA 2");
		fila2.imprimeFila();
	}
}
