package tutorialJava.capitulo05.bloque01.ejercicio01;

import java.util.ArrayList;
import java.util.List;

import tutorialJava.Utils;

public class Editor {
	
	public static int EXITO = 0;
	public static int ERROR_DEMASIADAS_LINEAS_EN_FICHERO = 1;
	
	private List<String> lineas = null;
	private List<String> portaPapeles = null;
	private List<ComandoEditor> comandos = null;
	
	
	/**
	 * 
	 */
	public Editor () {
		lineas = new ArrayList<String>();
		portaPapeles = new ArrayList<String>();
		comandos = new ArrayList<ComandoEditor>();

		inicializaComandos();
	}
	
	
	
	private void inicializaComandos () {
		
		// Implementación del comando "PRINT"
		comandos.add(new ComandoEditor ("PRINT") {
			@Override
			public void ejecutar(List<String> palabrasComando) {
				System.out.println(getContenidoLineas());
			}
		});
		
		// Implementación de un comando estúpido
		comandos.add(new ComandoEditor ("ESTUPIDO") {
			@Override
			public void ejecutar(List<String> palabrasComando) {
				System.out.println("Estúpido tú");
			}
		});
		
		// Implementación de un comando para salir
		comandos.add(new ComandoEditor ("BYE") {
			@Override
			public void ejecutar(List<String> palabrasComando) {
				System.exit(0);
			}
		});
		
		// Implementación de un comando para agregar al final
		comandos.add(new ComandoEditor ("INSERT") {
			@Override
			public void ejecutar(List<String> palabrasComando) {
				agregarNuevaLinea(agrupaPalabras (palabrasComando, 1));
			}
		});
		
		// Implementación de un comando para insertar en un lugar determinado
		comandos.add(new ComandoEditor ("INSERTAT") {
			@Override
			public void ejecutar(List<String> palabrasComando) {
				if (palabrasComando != null & palabrasComando.size() > 2) {
					int numLineaAInsertar = Integer.parseInt(palabrasComando.get(1));
					insertarLinea(numLineaAInsertar-1, agrupaPalabras(palabrasComando, 2));
				}
			}			
		});
		
		// Implementación de un comando para eliminar una línea
		comandos.add(new ComandoEditor ("DELETE") {
			@Override
			public void ejecutar(List<String> palabrasComando) {
				if (palabrasComando != null & palabrasComando.size() > 1) {
					int numLineaAELiminar = Integer.parseInt(palabrasComando.get(1));
					eliminarLinea(numLineaAELiminar-1);
				}
			}			
		});
		
		// Implementación de un comando para modificar una línea
		comandos.add(new ComandoEditor ("SET") {
			@Override
			public void ejecutar(List<String> palabrasComando) {
				if (palabrasComando != null & palabrasComando.size() > 2) {
					int numLineaASobrescribir = Integer.parseInt(palabrasComando.get(1));
					reemplazarLinea(numLineaASobrescribir-1, agrupaPalabras(palabrasComando, 2));
				}
			}			
		});
		
		// Implementación de un comando para cortar desde un número de línea a otro
		comandos.add(new ComandoEditor ("CUT") {
			@Override
			public void ejecutar(List<String> palabrasComando) {
				if (palabrasComando != null & palabrasComando.size() > 2) {
					int lineaInicio = Integer.parseInt(palabrasComando.get(1));
					int lineaFin = Integer.parseInt(palabrasComando.get(2));
					cortarLineas(lineaInicio-1, lineaFin-1);
				}
			}			
		});
		
		// Implementación de un comando para pegar lo cortado en un lugar determinado
		comandos.add(new ComandoEditor ("PASTE") {
			@Override
			public void ejecutar(List<String> palabrasComando) {
				if (palabrasComando != null & palabrasComando.size() > 1) {
					int numLineaAPegar = Integer.parseInt(palabrasComando.get(1));
					pegarLineas(numLineaAPegar-1);
				}
			}			
		});

		// Implementación de un comando para obtener ayuda
		comandos.add(new ComandoEditor ("HELP") {
			@Override
			public void ejecutar(List<String> palabrasComando) {
				System.out.println("HELP -> Ayuda");
				System.out.println("BYE -> Terminar el programa");
				System.out.println("PRINT -> Imprimir el fichero editado");
				System.out.println("INSERT <Línea de texto> -> Insertar Línea de texto");
				System.out.println("INSERTAT <NUM_LINEA_INSERTAR> <Línea de texto> -> Insertar línea en lugar determinado");
				System.out.println("DELETE <NUM_LINEA_ELIMINAR> -> Eliminar línea por su número");
				System.out.println("SET <NUM_LINEA_MODIFICAR> <Línea de texto> -> Modificar línea de texto");
				System.out.println("CUT <NUM_LINEA_INICIO> <NUM_LINEA_FIN> -> Cortar al portapapeles un conjunto de líneas");
				System.out.println("PASTE <NUM_LINEA_INSERTAR> -> Insertar el contenido del portapapeles en una posición");
			}			
		});
	}
	
	
	
	/**
	 * 
	 * @param nuevaLinea
	 * @return
	 */
	public int agregarNuevaLinea (String nuevaLinea) {
		return insertarLinea (this.lineas.size(), nuevaLinea);
	}

	/**
	 * 
	 * @param posicion
	 * @param nuevaLinea
	 */
	public void reemplazarLinea (int posicion, String nuevaLinea) {
		if (posicion > (this.lineas.size()-1)) {
			posicion = this.lineas.size()-1;
		}
		if (posicion < 0) {
			posicion = 0;
		}
		this.lineas.remove(posicion);
		this.insertarLinea(posicion, nuevaLinea);
	}

	
	/**
	 * 
	 * @param posicion
	 * @param nuevaLinea
	 */
	public void eliminarLinea (int posicion) {
		if (posicion > (this.lineas.size()-1)) {
			posicion = this.lineas.size()-1;
		}
		if (posicion < 0) {
			posicion = 0;
		}
		this.lineas.remove(posicion);
	}

	
	public void cortarLineas (int posicionInicial, int posicionFinal) {
		while (this.portaPapeles.size() > 0) {
			this.portaPapeles.remove(0);
		}
		
		for (int i = posicionInicial; i <= posicionFinal; i++ ) {
			this.portaPapeles.add(this.lineas.get(posicionInicial));
			this.lineas.remove(posicionInicial);
		}
	}
	
	
	public void pegarLineas (int posicionInicial) {
		this.lineas.addAll(posicionInicial, this.portaPapeles);
	}
	
	
	/**
	 * 
	 * @param posicion
	 * @param nuevaLinea
	 * @return
	 */
	public int insertarLinea (int posicion, String nuevaLinea) {
		if (this.lineas.size() >= 80) {
			return ERROR_DEMASIADAS_LINEAS_EN_FICHERO;
		}
		if (posicion > this.lineas.size()) {
			posicion = this.lineas.size();
		}
		if (posicion < 0) {
			posicion = 0;
		}
		this.lineas.add(posicion, nuevaLinea);
		return EXITO;
	}
	
	
	
	/**
	 * 
	 * @param posicion
	 * @return
	 */
	public int adecuarPosicion (int posicion) {
		if (posicion > this.lineas.size()) {
			posicion = this.lineas.size();
		}
		if (posicion < 0) {
			posicion = 0;
		}
		return posicion;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String getContenidoLineas () {
		StringBuffer sbContenido = new StringBuffer("");
		for (int i = 0; i < this.lineas.size(); i++) {
			sbContenido.append((i + 1) + "\t" + this.lineas.get(i) + "\n"); 
		}
		return sbContenido.toString();
	}

	/**
	 * 
	 * @return
	 */
	public String getContenidoPortapapeles () {
		StringBuffer sbContenido = new StringBuffer("");
		for (int i = 0; i < this.portaPapeles.size(); i++) {
			sbContenido.append((i + 1) + "\t" + this.portaPapeles.get(i) + "\n"); 
		}
		return sbContenido.toString();
	}
	
	
	/**
	 * 
	 * @return
	 */
	public List<String> obtenerComandoUsuario () {
		System.out.print(": ");
		String lineaUsuario = Utils.obtenerLinea();
		String palabras[] = lineaUsuario.split(" ");
		List<String> resultado = new ArrayList<String>();
		for (int i = 0; i < palabras.length; i++) {
			if (!palabras[i].equals("")) {
				resultado.add(palabras[i]);
			}
		}
		return resultado;
	}
	
	
	
	/**
	 * 
	 * @param comando
	 */
	public void procesaComandoUsuario (List<String> lineaComando) {
		for (int i = 0; i < this.comandos.size(); i++) {
			if (this.comandos.get(i).identificar(lineaComando)) {
				comandos.get(i).ejecutar(lineaComando);
			}
		}
	}
	
	
	/**
	 * 
	 * @param palabras
	 * @param cant
	 * @return
	 */
	private String agrupaPalabras (List<String> palabras, int inicio) {
		StringBuffer sb = new StringBuffer();
		for (int i = inicio; i < palabras.size(); i++) {
			sb.append(palabras.get(i) + " ");
		}
		return sb.toString();
	}

}
