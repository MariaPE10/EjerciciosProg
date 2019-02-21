package ejercicios.listeners;

public class Maria extends PalabraSecretaAdapter{

	
	@Override
	public void palabraSecretaIntroducida(PalabraSecretaEvent e) {
		super.palabraSecretaIntroducida(e);
		System.out.println("Se ha encontrado la palabra secreta en: " + e.getPalabraIntroducida());
	}

	
}
