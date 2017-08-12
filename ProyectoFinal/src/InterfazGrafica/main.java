package InterfazGrafica;

import javax.swing.JFrame;


public class main{
	
	public static void main(String[] args) {
		
			Ventana v = new Ventana();
			v.setVisible(true);
			v.setBounds(100, 100, 500, 600);
			v.setResizable(false);
			v.setLocationRelativeTo(null);
			v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
