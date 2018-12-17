package Ejercicios.Objetos.CarreraCoches;

public class Carrera {

public static void main(String[] args) {
		
		Vehiculo vehiculos[] = new Vehiculo[5];
		vehiculos[0] = new Coche ("Ruben", "#ff0000"); //Rojo
		vehiculos[1] = new Coche ("Maria", "#87006e"); //Morado
		vehiculos[2] = new Coche ("Sandra", "#89ff0c"); //Verde
		vehiculos[3] = new Moto ("Isa", "#0c96ff"); //Azul
		vehiculos[4] = new Moto ("Juan", "#faff0c"); //Amarillo
		
		for (int i = 0; i < vehiculos.length; i++) {
			vehiculos[i].setPista(new Pista());
			System.out.println(vehiculos[i].getNombre() +": " + vehiculos[i].getPista());
		}
		
		do {
			for (int i = 0; i < vehiculos.length; i++) {
				if (vehiculos[i].getPosicion() <= vehiculos[i].getMeta()) {
					vehiculos[i].avanza(vehiculos[i].getPosicion());
					vehiculos[i].paint();
				}
			}
		} while (!isCarreraTerminada(vehiculos));
		
		
		
	}
	
	/**
	 * 
	 * @param vehiculos
	 * @return
	 */
	private static boolean isCarreraTerminada(Vehiculo vehiculos[]) {
		for (int i = 0; i < vehiculos.length; i++) {
			if (vehiculos[i].getPosicion() < vehiculos[i].getMeta()) {
				return false;
			}
		}
		return true;
	}
	
}
