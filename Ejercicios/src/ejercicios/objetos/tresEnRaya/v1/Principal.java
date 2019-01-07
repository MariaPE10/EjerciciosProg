package ejercicios.objetos.tresEnRaya.v1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.naming.InitialContext;
import javax.swing.JOptionPane;

public class Principal {
	
	private static Jugador jugadores[] = new Jugador[2];
	private static int indiceJugadorActivo = 0;
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		Ventana ventana = new Ventana();
		
		initJugadores();
		
	}

	
	/**
	 * 
	 */
	private static void initJugadores () {
		jugadores[0] = new Jugador (JOptionPane.showInputDialog("Introduce nombre jugador 'X'"), 1) {
			@Override
			public void paint(Graphics g, int offsetX, int offsetY) {
				Graphics2D g2d = (Graphics2D) g;
				g2d.setStroke(GuiUtil.WIDE_STROKE);
				g2d.setColor(Color.decode("#a6d83a"));
				g2d.drawLine(offsetX + Celda.PADDING, offsetY + Celda.PADDING, offsetX + Celda.LADO - Celda.PADDING, offsetY + Celda.LADO - Celda.PADDING);
				g2d.drawLine(offsetX + Celda.LADO - Celda.PADDING, offsetY + Celda.PADDING, offsetX + Celda.PADDING, offsetY + Celda.LADO - Celda.PADDING);
			}
		};
		
		jugadores[1] = new Jugador (JOptionPane.showInputDialog("Introduce nombre jugador 'O'"), 2) {
			@Override
			public void paint(Graphics g, int offsetX, int offsetY) {
				g.setColor(Color.decode("#aa39d3"));
				g.fillOval(offsetX + Celda.PADDING, offsetY + Celda.PADDING, Celda.LADO - 2 * Celda.PADDING, Celda.LADO - 2 * Celda.PADDING);
			}
		};
		
		JOptionPane.showMessageDialog(null, "Comienza el jugador: " + jugadores[0].getNombre());
	}
	
	/**
	 * 
	 * @return
	 */
	public static Jugador getJugadorTurnoActivo () {
		return jugadores[indiceJugadorActivo];
	}
	
	/**
	 * 
	 */
	public static void avanzaTurno () {
		if (indiceJugadorActivo == 0) {
			indiceJugadorActivo = 1;
		}
		else {
			indiceJugadorActivo = 0;
		}
	}
}
