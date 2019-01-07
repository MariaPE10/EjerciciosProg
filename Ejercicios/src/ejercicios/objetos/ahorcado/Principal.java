package ejercicios.objetos.ahorcado;

public class Principal { 

	public static void main(String[] args) {
		
		// Pintamos una ventana en pantalla
		Ventana.getVentana();
//		System.out.println("Palabra oculta: " + palabras[indicePalabraAleatoria]);
		Juego.getJuego().empezar();
	}


	
}
