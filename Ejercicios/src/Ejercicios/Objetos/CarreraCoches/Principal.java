package Ejercicios.Objetos.CarreraCoches;

public class Principal {

	public static void main(String[] args) {
		Vehiculo vehiculos[] = new Vehiculo[5];
		vehiculos[0] = new Coche ("Ruben", "#ff0000"); //Rojo
		vehiculos[1] = new Coche ("Maria", "#87006e"); //Morado
		vehiculos[2] = new Coche ("Sandra", "#89ff0c"); //Verde
		vehiculos[3] = new Moto ("Isa", "#0c96ff"); //Azul
		vehiculos[5] = new Moto ("Juan", "#faff0c"); //Amarillo
	}
}
