package ejercicios.objetos.bloque3.bloque01.ejercicio01;

import java.util.List;

public abstract class ComandoEditor {
	
	public String id;
	
	public ComandoEditor(String id) {
		super();
		this.id = id;
	}

	
	public abstract void ejecutar (List<String> palabrasComando);
	
	public boolean identificar (List<String> palabrasComando) {
		return (palabrasComando != null && 
				palabrasComando.size() > 0 && 
				palabrasComando.get(0).toUpperCase().equals(this.id));
	}
}
