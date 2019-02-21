package ejercicios.listeners;

public class PalabraSecretaEvent {

	private String palabraIntroducida;
	
	/**
	 * 
	 * @param palabra
	 */
	public PalabraSecretaEvent(String palabra) {
		super();
		this.palabraIntroducida = palabra;
	}

	/**
	 * @return the palabraIntroducida
	 */
	public String getPalabraIntroducida() {
		return palabraIntroducida;
	}
}
