package InterfazGrafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelImagen extends JPanel{

	private  JLabel l1;
	
	public PanelImagen() {
		
		this.setBackground(Color.white);
		l1= new JLabel();
		l1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/logo_bcp.gif")));
		add(l1);
	}
	
}
