package ejercicios;

import javax.swing.JOptionPane;

public class JuegoParesoNones {

	public static void main(String[] args) {
		int ManoDerJ1, ManoIzqJ1, ManoDerIA, ManoIzqIA,Resultado, Equipo;
		
		ManoDerIA= (int) (Math.random() * 6); //numero al azar
		ManoIzqIA= (int) (Math.random() * 6);
	
		Equipo =Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero: \n0 - Pares \n1 - Nones"));
		ManoDerJ1=Integer.parseInt(JOptionPane.showInputDialog("Dedos Mano Derecha(0-5)")); //numero del jugador
		ManoIzqJ1=Integer.parseInt(JOptionPane.showInputDialog("Dedos Mano Izquierda (0-5)"));
		
		Resultado = ManoDerIA+ManoIzqIA+ManoDerJ1+ManoIzqJ1;
		if (Resultado%2==0) { //es par
			if(Equipo==0) {
				JOptionPane.showMessageDialog(null,"　HAS GANADO!!");
			}
			else {
				JOptionPane.showMessageDialog(null,"　HAS PERDIDO!!");
			}
		}
		else { //es impar
			if(Equipo==1) {
				JOptionPane.showMessageDialog(null,"　HAS GANADO!!");
			}
			else {
				JOptionPane.showMessageDialog(null,"　HAS PERDIDO!!");
			}
		}
	}
}
