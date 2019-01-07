package ejercicios.objetos.tresEnRaya.v1;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JOptionPane;

public class Celda {
	
	private int x, y;
	private Jugador jugador = null;
	private Ventana ventana = null;
	public static final int LADO = 200;
	public static final int PADDING = 15;
	
	public Celda (int x, int y, Ventana ventana) {
		this.x = x;
		this.y = y;
		this.ventana = ventana;
	}

	
	/**
	 * 
	 * @param g
	 */
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.black);
		g2d.setStroke(GuiUtil.WIDE_STROKE);
		g2d.drawRect(this.x, this.y, LADO, LADO);
		
		if (this.jugador != null) {
			this.jugador.paint(g2d, this.x, this.y);
		}
	}
	
	
	
	public boolean isEnCoordenadas(int xPunto, int yPunto) {
		if (xPunto > this.x && xPunto < (this.x + LADO) 
				&&
				yPunto > this.y && yPunto < (this.y + LADO)) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * 
	 */
	public void mouseClicked () {
		
		if (this.jugador != null && !this.jugador.equals(Principal.getJugadorTurnoActivo())) {
			JOptionPane.showMessageDialog(null, "Esta casilla no te pertenece");
			return;
		}
		
		if (this.jugador != null && this.jugador.equals(Principal.getJugadorTurnoActivo())) {
			JOptionPane.showMessageDialog(null, "Casilla ocupada");
			return;
		}
		
		
		this.jugador = Principal.getJugadorTurnoActivo();

		Matriz.getInstance().getMatriz()[this.y/LADO][this.x/LADO] = this.jugador.getCodigo();
		Matriz.getInstance().print();
		System.out.println();
		
		Principal.avanzaTurno();
		
		ventana.revalidate();
		ventana.repaint();
		
		if (Matriz.getInstance().isJuegoConVictoria()) {
			JOptionPane.showMessageDialog(null, "Juego Terminado  \nGanador/a: " + this.jugador.getNombre());
			System.exit(0);
		}
		
		if (Matriz.getInstance().isJuegoConEmpate()) {
			JOptionPane.showMessageDialog(null, "Juego Terminado \nEmpate!!");
			System.exit(0);
		}
		
	}
	
	
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	
	
	
}
