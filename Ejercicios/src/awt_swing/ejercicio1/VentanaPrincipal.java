package awt_swing.ejercicio1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import MySQL.ciclistas.ImposibleConectarException;
import MySQL.properties.ConnectionManagerV2;


public class VentanaPrincipal extends JFrame {

	JTextField tfid, tfnom, tfcif;
	
	
	public VentanaPrincipal () {
		super ("Primera gestion Fabricante");
		
		// Tama�o por defecto, basado en los valores est�ticos de esta misma clase
		setDimensionesBasicas();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Construcci�n elementos b�sicos sobre el ContentPanel
		this.setContentPane(getPanelPrincipal());

	}
	
	
	private JPanel getPanelPrincipal () {
		JPanel panel = new JPanel();
		panel.setBackground(Color.lightGray);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel.add(getPanelId("Id:"));
		panel.add(getPanelCif("Cif:"));
		panel.add(getPanelNombre("Nombre:"));
		panel.add(getButton());
		return panel;
	}
	
	/**
	 * 
	 * @param texto
	 * @return
	 */
	private JPanel getPanelId(String texto) {
		JPanel panel = new JPanel();
		JLabel lbl = new JLabel(texto);
		panel.add(lbl);
		
		tfid = new JTextField();
		tfid.setColumns(20);
		panel.add(tfid);
		
		return panel;
		
	}
	
	/**
	 * 
	 * @param texto
	 * @return
	 */
	private JPanel getPanelCif(String texto) {
		JPanel panel = new JPanel();
		JLabel lbl = new JLabel(texto);
		panel.add(lbl);
		
		tfcif = new JTextField();
		tfcif.setColumns(20);
		panel.add(tfcif);
		
		return panel;
		
	}
	
	/**
	 * 
	 * @param texto
	 * @return
	 */
	private JPanel getPanelNombre(String texto) {
		JPanel panel = new JPanel();
		JLabel lbl = new JLabel(texto);
		panel.add(lbl);
		
		tfnom = new JTextField();
		tfnom.setColumns(20);
		panel.add(tfnom);
		
		return panel;
		
	}
	
	/**
	 * 
	 * @return
	 */
	private JPanel getButton () {
		JPanel panel = new JPanel();
		JButton btng = new JButton("Guadar");
		JButton btnd = new JButton("Borrar");
		
		btng.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});

		btnd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				buscar();
				
			}
		});
		panel.add(btng);
		panel.add(btnd);
		return panel;
	}
	
	/**
	 * 
	 */
	private void setDimensionesBasicas () {
		this.setExtendedState(JFrame.NORMAL);
		this.setBounds(0, 0, 400, 300);
	}
	
	/**
	 * 
	 */
	private void guardar() {
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement("select id from tutorialjavacoches.fabricante where id= ?");
			
			ps.setInt(1, Integer.parseInt(tfid.getText()));
			
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				actualizar();
			} else {
				insertar();
			}
			
			ps.close();
			conn.close();
			
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 
	 */
	private void actualizar() {
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement("UPDATE tutorialjavacoches.fabricante SET cif = ?, nombre = ? where id = ?");
			
			ps.setString(1, tfcif.getText());
			ps.setString(2, tfnom.getText());
			ps.setInt(3, Integer.parseInt(tfid.getText()));
			
			int filasAfectadas = ps.executeUpdate();
			if (filasAfectadas == 1) {
				JOptionPane.showMessageDialog(null,"Registro actualizado");
			}
			
			ps.close();
			conn.close();
		}catch (SQLException | ImposibleConectarException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	private void insertar() {
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO tutorialjavacoches.fabricante (id, cif, nombre) VALUES (?,?,?)");
			
			ps.setInt(1, Integer.parseInt(tfid.getText()));
			ps.setString(2, tfcif.getText());
			ps.setString(3, tfnom.getText());
			
			int filasAfectadas = ps.executeUpdate();
			if (filasAfectadas == 1) {
				JOptionPane.showMessageDialog(null,"Registro insertado");
			}
			
			ps.close();
			conn.close();
		}catch (SQLException | ImposibleConectarException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	private void borrar() {
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement("delete from tutorialjavacoches.fabricante where id = ?");
			
			ps.setInt(1, Integer.parseInt(tfid.getText()));
			
			int filasAfectadas = ps.executeUpdate();
			if (filasAfectadas == 1) {
				JOptionPane.showMessageDialog(null,"Registro eliminado");
				tfid.setText("");
				tfcif.setText("");
				tfnom.setText("");
			}
			
			ps.close();
			conn.close();
		}catch (SQLException | ImposibleConectarException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	private void buscar() {
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement("select id from tutorialjavacoches.fabricante where id= ?");
			
			ps.setInt(1, Integer.parseInt(tfid.getText()));
			
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				borrar();
			} else {
				JOptionPane.showMessageDialog(null, "El id que ha introducido no existe, "
						+ "\n imposible eliminar el registro", "Error", 0);
			}
			
			ps.close();
			conn.close();
			
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
