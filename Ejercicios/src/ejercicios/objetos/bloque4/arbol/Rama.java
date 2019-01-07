package ejercicios.objetos.bloque4.arbol;

public class Rama extends ComponenteDeArbol {

	private ComponenteDeArbol extension1;
	private ComponenteDeArbol extension2;
	private ComponenteDeArbol extension3;
	
	/**
	 * 
	 */
	public Rama(String nombre) {
		super(nombre);
	}

	/**
	 * @return the extension1
	 */
	public ComponenteDeArbol getExtension1() {
		return extension1;
	}
	public void setExtension1(ComponenteDeArbol extension1) {
		this.extension1 = extension1;
	}

	/**
	 * @return the extension2
	 */
	public ComponenteDeArbol getExtension2() {
		return extension2;
	}
	public void setExtension2(ComponenteDeArbol extension2) {
		this.extension2 = extension2;
	}

	/**
	 * @return the extension3
	 */
	public ComponenteDeArbol getExtension3() {
		return extension3;
	}
	public void setExtension3(ComponenteDeArbol extension3) {
		this.extension3 = extension3;
	}
	
	
}
