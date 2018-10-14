package Ejercicios;

import javax.swing.JOptionPane;

public class JuegoAveriguaNumeros {

	public static void main(String[] args) {
		int numeroPensado = (int) Math.round(Math.random()*100);
		int numeroIntroducido = 0;
	
		
		do { //Pedimos numero
			numeroIntroducido=Integer.parseInt(JOptionPane.showInputDialog("Adivina el numero de 0 a 100"));
			//Interactuamos con el usuario
			if(numeroIntroducido > numeroPensado) {
				JOptionPane.showMessageDialog(null, "El numero es inferior a " + numeroIntroducido);
			}
			else {
				if (numeroIntroducido < numeroPensado){
				JOptionPane.showMessageDialog(null, "El numero es superior a " + numeroIntroducido);				
				}
				else  {
				JOptionPane.showMessageDialog(null, "¡¡¡ENHORABUENA LO HAS CONSEGUIDO!!!");
				}
			}	
		} while (numeroIntroducido != numeroPensado);
		
	}
}
