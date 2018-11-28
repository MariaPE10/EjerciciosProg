package Ejercicios.Objetos.Ahorcado;

public class Principal { 

	public static void main(String[] args) {
		
		// Pintamos una ventana en pantalla
		Ventana ventana = new Ventana();
		
		//Array de palabras posibles
		String palabras[] = new String[] {"cosplay", "jaula", "olas", "articulacion", "negativo", "inflacion", "barro", "ahri", "akali", "zinogre"};
		//Genera un numero aleatorio que sera mi palabra aleatoria
		int indicePalabraAleatoria = (int) Math.round(Math.random()*(palabras.length-1));
		
//		System.out.println("Palabra oculta: " + palabras[indicePalabraAleatoria]);
		
		//Creacion de un array con la longitud de nuestra palabra aleatoria
		String palabraAleatoria = palabras[indicePalabraAleatoria];
		String coincidencias[]= new String [palabraAleatoria.length()];
		
		Juego.Empezar(coincidencias, palabraAleatoria);

		
	
	}

	
	
}
