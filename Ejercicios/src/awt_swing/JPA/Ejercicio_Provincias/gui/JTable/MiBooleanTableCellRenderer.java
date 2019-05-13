package awt_swing.JPA.Ejercicio_Provincias.gui.JTable;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class MiBooleanTableCellRenderer extends MiDefaultTableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		JCheckBox check = new JCheckBox();
		check.setHorizontalAlignment(JLabel.CENTER);
        if (value instanceof Boolean) {
        	boolean valorBooleano = ((Boolean) value).booleanValue();
        	check.setSelected(valorBooleano);
        }
        
        check.setBackground(this.getBackgroundColor(table, value, isSelected, hasFocus, row, column));

        return check;
	}

}
