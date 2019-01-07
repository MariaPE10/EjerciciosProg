package ejercicios;

import javax.swing.JOptionPane;

public class JuegoCaraoCruz {

	public static void main(String[] args) {
		int numeroAzar, ContJ1=0, ContIA=0;
		int numeroIntroducido;
		
		for (int i=1 ;ContJ1<3 && ContIA<3; i++) {
			numeroAzar = (int) Math.round(Math.random());	
			numeroIntroducido=Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero: \n0 - Cruz \n1 - Cara"));
			if (numeroIntroducido == numeroAzar) {
				ContJ1++;
				JOptionPane.showMessageDialog(null,
						"Has ganado la ronda!! " +i+ "!!\nTu Puntuacion: " + ContJ1 + "\nPuntuacion de la IA: "+ ContIA);
			}
			else {
				ContIA++;
				JOptionPane.showMessageDialog(null,
						"Has perdido la ronda " +i+ "!!\nTu Puntuacion: " + ContJ1 + "\nPuntuacion de la IA: "+ ContIA);
			}
		}
		if (ContIA==3) {
			JOptionPane.showMessageDialog(null,"¡¡HAS PERDIDO!! Soy una maquina inteligente!!");
		}
		else {
			JOptionPane.showMessageDialog(null,"¡¡HAS GANADO!! La proxima te reviento payaso!!");
		}
	}
}
