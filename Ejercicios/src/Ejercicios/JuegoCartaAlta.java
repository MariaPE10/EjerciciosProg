package Ejercicios;

import javax.swing.JOptionPane;

public class JuegoCartaAlta {

	public static void main(String[] args) {
		/* Picas
		 * Diamantes
		 * Treboles
		 * Corazones
		 */
		int CartaJ1, CartaIA, PaloIA, PaloJ1;
		
		JOptionPane.showMessageDialog(null, "¡Vamos a jugar!");
		
		CartaJ1=  (int) (Math.random() * 13)+1;
		CartaIA=  (int) (Math.random() * 13)+1;
		PaloJ1=  (int) (Math.random() * 4);
		PaloIA=  (int) (Math.random() * 4);
		
		if(CartaJ1 > CartaIA) {
			JOptionPane.showMessageDialog(null,
					"Has ganado la ronda!!\nTu carta: " + CartaJ1 + "\nCarta de la IA: "+ CartaIA);
		}
		else {
			if (CartaJ1<CartaIA) {
				JOptionPane.showMessageDialog(null,
						"Has perdido la ronda!!\nTu carta: " + CartaJ1 + "\nCarta de la IA: "+ CartaIA);
			}
			else {
				if (CartaJ1==CartaIA) {
					if (PaloJ1>PaloIA) {
						JOptionPane.showMessageDialog(null,
								"Has ganado la ronda!!\nTu carta: " + CartaJ1 + "y Palo: " + PaloJ1 +
								"\nCarta de la IA: "+ CartaIA + " y Palo: "+ PaloIA);
					}
					else {
						if (PaloJ1<PaloIA) {
							JOptionPane.showMessageDialog(null,
									"Has perdido la ronda!!\nTu carta: " + CartaJ1 + "y Palo: " + PaloJ1 +
									"\nCarta de la IA: "+ CartaIA + " y Palo: "+ PaloIA);
						}
						else {
							JOptionPane.showMessageDialog(null,
									"Empate!!\nTu carta: " + CartaJ1 + "y Palo: " + PaloJ1 +
									"\nCarta de la IA: "+ CartaIA + " y Palo: "+ PaloIA);
						}
					}
				}
			}
		}
	}

}
