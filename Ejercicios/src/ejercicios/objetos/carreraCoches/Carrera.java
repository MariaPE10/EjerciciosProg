package ejercicios.objetos.carreraCoches;

import javax.swing.ImageIcon;

public class Carrera {

	public static Vehiculo vehiculos[] = new Vehiculo[5];
	public static void main(String[] args) {
	
		ImageIcon icono =  new ImageIcon(CacheImagenes.getCache().getIconoCarrera());
		ImageIcon iconoPodio =  new ImageIcon(CacheImagenes.getCache().getIconoPodio());
		Ventana ventana = new Ventana();
		
		
		vehiculos[0] = new Coche ("Ruben", "#ff0000"); //Rojo
		vehiculos[1] = new Coche ("Maria", "#87006e"); //Morado
		vehiculos[2] = new Coche ("Sandra", "#57e5a7"); //Verde
		vehiculos[3] = new Moto ("Isa", "#0c96ff"); //Azul
		vehiculos[4] = new Moto ("Juan", "#faff0c"); //Amarillo
		
		Pista pistas[] = Pista.generatePistas();
		
		for (int i = 0; i < vehiculos.length; i++) {
			vehiculos[i].setPista(pistas[i]);
			System.out.println(vehiculos[i].getNombre() +": " + vehiculos[i].getPista());
		}
		
		for (int i = 0; i < pistas.length; i++) {
			pistas[i].paint(ventana.getGraphics());
		}
		
		do {
			for (int i = 0; i < vehiculos.length; i++) {
				if (vehiculos[i].getPosicion() < Pista.META) {
					vehiculos[i].avanza();
					VentanaEmergente.muestraVentanaEmergente(vehiculos[i].getMensaje(), icono);
					vehiculos[i].setMensaje(vehiculos[i].getNombre() + " posicion inicial: " + vehiculos[i].getPosicion());
					if (vehiculos[i].getPosicion() >= Pista.META) {
						vehiculos[i].setPosicion(Pista.META);
						System.out.println("\n\n\t" + vehiculos[i].getNombre() + " ha terminado la carrera");
						VentanaEmergente.muestraVentanaEmergente(vehiculos[i].getNombre() + " ha terminado la carrera", icono);
						vehiculos[i].setPodium(getMayorPodio(vehiculos) + 1);
					}
				}
				ventana.repaint();
			}
		} while (!isCarreraTerminada(vehiculos));
		
		ordenaVehiculosPorPodio(vehiculos);
		String mensaje = vehiculos[0].getNombre() + " podio: " + vehiculos[0].getPodium();
		System.out.println(vehiculos[0].getNombre() + " podio: " + vehiculos[0].getPodium());
		for (int i = 1; i < vehiculos.length; i++) {
			mensaje = mensaje.concat( "\n" + vehiculos[i].getNombre() + " podio: " + vehiculos[i].getPodium());
			System.out.println(vehiculos[i].getNombre() + " podio: " + vehiculos[i].getPodium());
		}
		
		VentanaEmergente.muestraVentanaEmergente(mensaje, iconoPodio);
	}
	
	/**
	 * 
	 * @param vehiculos
	 * @return
	 */
	public static boolean isCarreraTerminada(Vehiculo vehiculos[]) {
		for (int i = 0; i < vehiculos.length; i++) {
			if (vehiculos[i].getPosicion() < Pista.META) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @param jugadores
	 * @return
	 */
	private static int getMayorPodio (Vehiculo vehiculos[]) {
		int mayor = 0;
		if (vehiculos.length > 0) {
			mayor = vehiculos[0].getPodium();
			for (int i = 1; i < vehiculos.length; i++) {
				if (vehiculos[i].getPodium() > mayor) { //Buscamos el podio mayor del array
					mayor = vehiculos[i].getPodium();
				}
			}
		}
		return mayor;
	}
	
	/**
	 * Ordena el array de vehiculos por el metodo de la burbuja
	 * @param jugador
	 */
	private static void ordenaVehiculosPorPodio (Vehiculo vehiculos[]) {
		for (int i = vehiculos.length-1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (vehiculos[j].getPodium() > vehiculos[j+1].getPodium()) {
					Vehiculo aux = vehiculos[j];
					vehiculos[j] = vehiculos[j+1];
					vehiculos [j+1] = aux;
				}
			}
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public static Vehiculo[] getVehiculos() {
		return vehiculos;
	}
	
}
