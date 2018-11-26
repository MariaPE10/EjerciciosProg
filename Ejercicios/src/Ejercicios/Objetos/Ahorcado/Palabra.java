package Ejercicios.Objetos.Ahorcado;

public class Palabra {
 
	
//	
//	public static void ComparaCaracteres(String caracterUsuario, String palabraAleatoria, String coincidencias[]){
//		if (CompruebaPalabraOCaracter(caracterUsuario) == true){
//			for (int i = 0; i < coincidencias.length; i++) {
//				if (palabraAleatoria.charAt(i) (caracterUsuario)) {
//					coincidencias[i].replace(palabraAleatoria.charAt(i), caracterUsuario);
//				} else {
//					coincidencias[i] = "_ ";
//				} 
//			}
//		}
//		ImprimePalabraOculta(coincidencias);
//	}	 
//	
	/**
	 * Devuelve true cuando el usuario introduce un caracter y false si introduce una palabra
	 * @param palabraUsuario
	 * @param palabraAleatoria
	 * @return
	 */
	public static boolean CompruebaPalabraOCaracter(String palabraUsuario) {
		if (palabraUsuario.length() == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 
	 */
	public static void ImprimePalabraOculta(String coincidencias[]) {
		for (int i = 0; i < coincidencias.length; i++) {
			System.out.print("_ ");
		}
	}

}
