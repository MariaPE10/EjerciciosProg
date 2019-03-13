package ejercicios.capitulo6.bloque7;

public class BuscaDigitos extends DigitoEncontradoAdapter {

	String nombre;

	/**
	 * @param nombre
	 */
	public BuscaDigitos(String nombre) {
		super();
		this.nombre = nombre;
		Main.addDigitoEncontradoListener(this);
	}

	@Override
	public void digitoEncontradoListener(DigitoEncontradoEvent evento) {
		super.digitoEncontradoListener(evento);
		System.out.println("Soy el BuscaDigitos " + this.nombre + " y he encontrado 3 digitos en la palabra: " + evento.getPalabra());
		StringBuffer sb = new StringBuffer("Digitos encontrados en la palabra");
		for (Integer entero : evento.getDigitosEncontrados()) {
			sb.append(" - " + entero.intValue());
		}
		System.out.println(sb);
	}
	
	
	
}
