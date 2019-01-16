package ejercicios.objetos.bloque5.ejercicio1;
// Escribe un programa editor de textos. Cada linea del texto sera¡ representada como un String.
// El texto puede tener como maximo 80 lineas. El usuario podra realizar las siguientes acciones:
//    a) Añadir una linea al texto.
//    b) Insertar una linea en cualquier posicion del texto.
//    c) Editar una linea (reescribir su contenido).
//    d) Borrar una linea.
//    e) Cortar un conjunto de lineas, (marcadas por su posicion inicial y final).
//    f) Pegar un conjunto de lineas cortadas en una determinada posicion.
//    g) Imprimir el texto. Cada linea aparecera numerada. 

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class BlocDeNotas {

	public static void main(String[] args) {
		List<String> lineas = new ArrayList<String>();
		List<String> subList = new ArrayList<String>();
		
		String menu = "MENU\n"
				+ "1.- Añadir una linea al texto.\n"
				+ "2.- Insertar una linea en cualquier posicion del texto.\n"
				+ "3.- Editar una linea.\n"
				+ "4.- Borrar una linea.\n"
				+ "5.- Cortar un conjunto de lineas.\n"
				+ "6.- Pegar un conjunto de lineas cortadas en una determinada posicion.\n"
				+ "7.- Imprimir el texto.\n"
				+ "0.- Salir del programa.\n";
		int opcion = -1;
		do {
			try {
				opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
		
				switch (opcion) {
				case 0: // Acaba radicalmente con la ejecucion
					System.exit(0); 
					break;
				case 1: //Añadir una linea al texto.
					lineas.add(JOptionPane.showInputDialog("Escriba el texto que quiere introducir:"));
					break;
				case 2: //Insertar una linea en cualquier posicion del texto.
					int opcionUsuario = Integer.parseInt(JOptionPane.showInputDialog("Indice en el que quiere introducir la línea:"));
					if(opcionUsuario > lineas.size()) {
						lineas.add(JOptionPane.showInputDialog("Escriba el texto que quiere introducir:"));
					} else {
						lineas.add(opcionUsuario, JOptionPane.showInputDialog("Escriba el texto que quiere introducir:"));
					}
					break;
				case 3: //Editar una linea
					opcionUsuario = Integer.parseInt(JOptionPane.showInputDialog("Indice de la línea que quiere editar:"));
					if (opcionUsuario > lineas.size()) {
						JOptionPane.showMessageDialog(null, "El indice que intenta editar no existe");
					} else {
						lineas.set(opcionUsuario, JOptionPane.showInputDialog("Escriba el nuevo texto:"));
					}
					break;
				case 4: //Borrar una linea.
					int borrado = Integer.parseInt(JOptionPane.showInputDialog("Inserte el indice de la linea que desea eliminar"));
					lineas.remove(borrado);
					break;
				case 5: //Cortar un conjunto de lineas
					subList = cortarLista(lineas);
					break;
				case 6: //Pegar un conjunto de lineas cortadas en una determinada posicion.
					pegarLista(subList, lineas);
					break;
				case 7: //Imprimir el texto. 
					imprimeList(lineas);
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opcion Incorrecta");
				}		
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Opcion Incorrecta");
			}
			
		} while (opcion!=0);
	}
	
	/**
	 * Imprimir el texto. Cada linea aparecera numerada.
	 * @param lista
	 */
	private static void imprimeList (List<String> lista) {
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(i + ". " + lista.get(i).toString());
		}
	}
	
	/**
	 * 
	 * @param lista
	 * @return
	 */
	private static List<String> cortarLista(List<String> lista) {
		List<String> subList = new ArrayList<String>();
		subList = lista.subList(Integer.parseInt(JOptionPane.showInputDialog("Introduzca el primer indice")), Integer.parseInt(JOptionPane.showInputDialog("Introduzca el ultimo indice")));
		//HAY QUE BORRAR LOS ELEMENTOS QUE SE CORTAN DE LA LISTA
		return subList;
	}
	
	/**
	 * 
	 * @param subLista
	 * @param lista
	 * @return
	 */
	private static List<String> pegarLista(List<String> subLista, List<String> lista){
		int opcionUsuario = Integer.parseInt(JOptionPane.showInputDialog("Indice en el que quiere pegar el conjunto de línea:"));
		if(opcionUsuario > lista.size()) {
			lista.addAll(subLista);
		}else {
			lista.addAll(opcionUsuario, subLista);
		}
		return lista;
	}
}
