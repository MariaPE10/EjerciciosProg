package ejercicios.objetos.carreraCoches;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class VentanaEmergente {

	 
	/**
	 * El método simplemente muestra en pantalla un mensaje con la posibilidad
	 * de personalizar los botones.
	 * @param mensaje
	 */
	public static void muestraVentanaEmergente (String mensaje, ImageIcon icono) {
		// Array con las opciones a mostrar en la ventana emergente
		String[] opciones = {"Continuar", "Abandonar el juego"};
		
		// La ventana emergente devuelve un valor entero, correspondiente
		// con la opción elegida por el usuario
		int opcionElegida = JOptionPane.showOptionDialog(null, // Componente "padre" de la ventana emergente, de momento utiliza siempre "null"
				mensaje, // Mensaje a mostrar en la ventana
				"Formula 1", // Título de la ventana
				JOptionPane.YES_NO_CANCEL_OPTION, // Tipo de ventana emergente 
				JOptionPane.INFORMATION_MESSAGE, // Tipo de mensaje a mostrar
				icono, // Icono personalizado para la ventana
				opciones, // Array de elementos a mostrar en forma de botón 
				0); // Botón "por defecto"
		
		// Comprobación de la opción elegida por el usuario
		if (opcionElegida == 1) { // Si la opción elegida es la de índice "1", salimos
			System.exit(0);
		}
	}
	
}
