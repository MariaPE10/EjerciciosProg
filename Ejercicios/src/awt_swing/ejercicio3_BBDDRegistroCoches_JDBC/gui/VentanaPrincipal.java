package awt_swing.ejercicio3_BBDDRegistroCoches_JDBC.gui;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	public VentanaPrincipal () {
		this.setBounds(0, 0, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane jtabbedPane = new JTabbedPane();
		
		jtabbedPane.add("Gestion de coches", new PanelGestionCoche());
		jtabbedPane.add("Gestion de fabricantes", new PanelGestionFabricante());
		jtabbedPane.add("Gestion de concesionarios", new PanelGestionConcesionario());
		jtabbedPane.add("Gestion de clientes", new PanelGestionCliente());
		jtabbedPane.add("Gestion de clientes", new PanelGestionCliente());
		jtabbedPane.add("Gestion de ventas", new PanelGestionVentas());
		
		this.setContentPane(jtabbedPane);
	}
	
}
