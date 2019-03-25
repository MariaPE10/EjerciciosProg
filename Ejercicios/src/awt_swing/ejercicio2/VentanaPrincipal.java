package awt_swing.ejercicio2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.JobAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import utils.*;


public class VentanaPrincipal extends JFrame {

	private static char digitosHexadecimales[] = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	public static int ANCHO = 800;
	public static int ALTO = 600;
	public static String TITULO_APLICACION = "Titulo de la aplicacion";

	// Establecer la apariencia t�pica de Windows
	static {
		Apariencia.setApariencia(Apariencia.METAL);
	}
	
	
	public VentanaPrincipal () {
		super (TITULO_APLICACION);
		
		this.setExtendedState(JFrame.NORMAL);
		this.setBounds(0, 0, ANCHO, ALTO);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		JTabbedPane tabPanel = new JTabbedPane();
		
		tabPanel.add("01", getPanelTab01());
		tabPanel.add("02", getPanelTab02());
		tabPanel.add("03", getPanelTab03());
		
		this.setContentPane(tabPanel);
	}
	
	
	private JPanel getPanelTab02() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel.add(getPanel01());
		panel.add(getPanel02());
		panel.add(getPanel03());
		return panel;
	}
	
	private JPanel getPanelTab03() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JTextArea txta = new JTextArea("Texto del JTextArea");
		panel.add(txta);
		
		JSlider sli = new JSlider(JSlider.HORIZONTAL,-10,10,0);
		panel.add(sli);
		
		JProgressBar prbar = new JProgressBar(10,50);
		panel.add(prbar);
		
		String opciones[] = new String[10];
		
		for (int i = 0; i < opciones.length; i++) {
			opciones[i] = "JRadioButton Option " + i;
		}
		
		ButtonGroup grupoOpciones = new ButtonGroup();
		for (int i = 0; i < opciones.length; i++) {
			JRadioButton radiob = new JRadioButton(opciones[i]);
			radiob.setSelected(true);
			grupoOpciones.add(radiob);
			panel.add(radiob);
		}
		
		
		return panel;
	}
	
	/**
	 * 
	 * @return
	 */
	private JPanel getPanel01() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		panel.add(new JLabel("Etiqueta"));
		
		JTextField jtf = new JTextField("Texto", 40);
		panel.add(jtf);
		
		return panel;
	}
	
	/**
	 * 
	 * @return
	 */
	private JPanel getPanel02() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		panel.add(new JPasswordField(40));
		
		String opciones[] = new String[10];
		
		for (int i = 0; i < opciones.length; i++) {
			opciones[i] = "JComboBox Option " + i;
		}		
		
		JComboBox jcb = new JComboBox(opciones);
		
		jcb.setSelectedItem(0);
		jcb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Nueva opcion seleccionada: " + jcb.getSelectedIndex());
				
			}
		});
		panel.add(jcb);
		return panel;
	}
	
	/**
	 * 
	 * @return
	 */
	private JPanel getPanel03() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		String opciones[] = new String[10];
		
		for (int i = 0; i < opciones.length; i++) {
			opciones[i] = "JList Option " + i;
		}		
		JList jl = new JList(opciones);
		jl.setSelectedIndex(0);
		jl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jl.setLayoutOrientation(JList.VERTICAL);
		jl.setVisibleRowCount(5);
		
		panel.add(jl);
		
		JButton btn = new JButton("Cambiar Color");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setBackground(Color.decode(getColorAzar()));
				
			}
		});
		panel.add(btn);
		
		return panel;
	}
	
	/**
	 * 
	 * @return
	 */
	private JPanel getPanelTab01() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		panel.add(new JLabel("Etiqueta"));
		
		JTextField jtf = new JTextField("Texto", 40);
		panel.add(jtf);
		
		JCheckBox check = new JCheckBox("Esto es un check");
		check.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Ha cambiado el estado del check a: " + check.isSelected());
			}
		});
		panel.add(check);
		
		JButton btn = new JButton("Aceptar");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String texto = "Contenido del JTextField: " + jtf.getText() + " \n\nChechk : " + check.isSelected();
				JOptionPane.showMessageDialog(null, texto);
				
			}
		});
		
		panel.add(btn);
		
		return panel;
	}
	
	/**
	 * 
	 * @return
	 */
	private static String getColorAzar () {
		StringBuffer sb = new StringBuffer ("#");
		for (int i = 0; i < 6; i++) {
			sb.append(digitosHexadecimales[Utils.obtenerNumeroAzar(0, digitosHexadecimales.length-1)]);
		}
		return sb.toString();
	}
	
}
