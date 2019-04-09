package awt_swing.JPA.Ejercicio_curso.gui.utils;

import java.net.URL;
import java.util.HashMap;

public abstract class CacheRecursos {
	protected HashMap resources;
	
	public CacheRecursos() {
	  resources = new HashMap();
	}
	
	protected Object loadResource(String name) {
		URL url=null;
		url = getClass().getClassLoader().getResource(name);
		return loadResource(url);
	}
	
	protected Object getResource(String name) {
		Object res = resources.get(name);
		if (res == null) {
			res = loadResource("imagenes/botones/" + name);
			resources.put (name,res);
		}
		return res;
	}
	
	protected abstract Object loadResource(URL url);

}
