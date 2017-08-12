package InterfazGrafica;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import modelo.*;

public class Ventana extends JFrame implements ActionListener{

	private JMenu menu,consulta,transacciones,team;
	private JMenuBar menuBar;
	private JPanel  panelprincipal,panelInf;
	private JPanel ipanel, ipanel2, iSup, iInf;
	private JPanel p1, p2, p3, p4, p5;
	private PanelImagen imagen;
	private JLabel bienvenido, b2;
	private JLabel lid_in, lclave_in, lmonto_dep, lmonto_ret, lmonto_tran, ldeCta, laCta, hcuenta;
	private JLabel lnombre_reg, lapellido_reg, lclave_reg, lbalance_reg; 
	private JTextField tfID_in, nombre_reg, apellido_reg, clave_reg, balance_reg, monto_dep, monto_ret, monto_tran;
	private JTextArea taLista, taCuentas, taCuentas2, taCuentas3, taHist,taCont;
	private JPasswordField PFclave_in;
	private JButton iniciar, limpiar_in, btnRegistrar, limpiar_reg, btndep, btnret, btntrans, btnmostrar;
	private JComboBox combo1, combo2, combo_ret, combo_dep, combo_hist;
	private JMenuItem iniciarSesion;
	private JMenuItem registrar;
	private JMenuItem cerrar;
	private JMenuItem retiro;
	private JMenuItem deposito;
    private JMenuItem transferencia;
    private JMenuItem consultar;
    private JMenuItem contacto;
    private JMenuItem mlista;
    private JPanel inicio, reg, dep, ret, trans, cons, lista,panelConctacto;
    private Banco banco;
    private Cajero cajero;

	String[] cuenta = {"Ahorros", "Corriente"};
	
    
	public Ventana() {

		/* Instancia del banco. */
		banco = new Banco("Banco Central");
		
		/* Instancia del cajero */
		cajero = new Cajero();
		
		/* Instancia de los usuarios predeterminados. */
		
		// Instancia de usuario predeterminado 1.
		Usuario titular1 = banco.agregarUsuario("Giancarlo", "Tovar", "1234", 300000);

		// Instancia de usuario predeterminado 2.
		Usuario titular2 = banco.agregarUsuario("Javier", "Baron", "5678", 200000);

		// Intancia de usuario predeterminado 3.
		Usuario titular3 = banco.agregarUsuario("Daniel", "Rojas", "0123", 100000);
		
		/* Diseño de la ventana principal. */
		
		this.setTitle("BANCO CENTRAL PROGRAMACION");
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/bcp.jpg"));
		this.setIconImage(icon);
		
	
		this.setLayout(new BorderLayout());
		this.setBackground(Color.white);
		
		menu = new JMenu("Menu");
		transacciones = new JMenu("Transaccion");
		consulta = new JMenu("Consulta");
		team = new JMenu("Contacto");

		menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
		
		iniciarSesion = new JMenuItem("Iniciar Sesion");
		iniciarSesion.addActionListener(this);
		registrar = new JMenuItem("Registrar Usuario");
		registrar.addActionListener(this);
		cerrar = new JMenuItem("Cerrar Sesion");
		cerrar.addActionListener(this);
		mlista = new JMenuItem("Lista de Usuarios");
		mlista.addActionListener(this);
		
		menu.add(iniciarSesion);
		menu.add(registrar);
		menu.add(cerrar);
		menu.add(mlista);
		
		retiro = new JMenuItem("Retiro");
		retiro.addActionListener(this);
		deposito = new JMenuItem("Deposito");
		deposito.addActionListener(this);
		transferencia = new JMenuItem("Transferencia");
		transferencia.addActionListener(this);

		transacciones.add(deposito);
		transacciones.add(retiro);
		transacciones.add(transferencia);
		
        consultar = new JMenuItem("Movimientos Bancarios");
		consultar.addActionListener(this);

		consulta.add(consultar);

		contacto = new JMenuItem("Acerca de");
		contacto.addActionListener(this);

		team.add(contacto);
		
		menuBar.add(menu);
		menuBar.add(transacciones);
		menuBar.add(consulta);
		menuBar.add(team);
		
		
		panelprincipal = new JPanel();
		panelprincipal.setBackground(Color.white);
		panelprincipal.setLayout(new GridLayout(2, 1));
		
		imagen = new PanelImagen();
		
		
		
		panelInf = new JPanel();
		panelInf.setBackground(Color.white);
		panelInf.setLayout(new FlowLayout(FlowLayout.CENTER, 80, 60));
		
		bienvenido = new JLabel("Bienvenido");
		bienvenido.setFont(new Font ( "Calisto MT", Font.BOLD, 30));
		bienvenido.setForeground(new Color(29, 34, 143));
		
		b2 = new JLabel("        Banco Central de Programacion        ");
		b2.setBorder(new LineBorder(Color.black));
		b2.setBackground(new Color(29, 34, 143));
		b2.setForeground(Color.white);
		b2.setOpaque(true);
		b2.setFont(new Font ( "Calisto MT", Font.BOLD, 30));
		
		panelInf.add(b2);
		panelInf.add(bienvenido);
		
		
		panelprincipal.add(imagen);
		panelprincipal.add(panelInf);
		
		this.add(panelprincipal, BorderLayout.CENTER);
		
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		/* PANEL PARA INICIAR SESION */
		
		inicio =  new JPanel();
		inicio.setVisible(false);

		inicio.setBackground(Color.white);
		LineBorder borde_in = new LineBorder(new Color(29,34, 143), 3, true);
		inicio.setBorder(new TitledBorder(BorderFactory.createTitledBorder(borde_in, "Iniciar Sesion", TitledBorder.CENTER, TitledBorder.TOP, new Font ( "Calisto MT", Font.BOLD, 20 ), Color.black)));
		inicio.setLayout(new GridLayout(2,1));
		
		ipanel = new JPanel();
		ipanel.setLayout(new GridLayout(2,1));
		
		iSup = new JPanel();
		iSup.setLayout(new FlowLayout(FlowLayout.CENTER,10,25));
		iSup.setBackground(Color.white);
		
		iInf = new JPanel();
		iInf.setLayout(new FlowLayout(FlowLayout.CENTER));
		iInf.setBackground(Color.white);
		
		lid_in =  new JLabel("Ingrese ID:       ");
		lclave_in = new JLabel("Ingrese clave: ");
		
		tfID_in= new JTextField(10);
		PFclave_in = new JPasswordField(10);
		
		iSup.add(lid_in);
		iSup.add(tfID_in);
		
		iInf.add(lclave_in);
		iInf.add(PFclave_in);
		
		ipanel.add(iSup);
		ipanel.add(iInf);
		
		ipanel2 = new JPanel();
		ipanel2.setLayout(new FlowLayout(FlowLayout.CENTER,20,35));
		
		iniciar = new JButton("Iniciar");
		iniciar.addActionListener(this);
		
		iniciar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/icono-de-aceptar.png")));
		
		limpiar_in = new JButton("Limpiar");
		limpiar_in.addActionListener(this);
		
		limpiar_in.setIcon(new ImageIcon(getClass().getResource("/Imagenes/limpiar.png")));
		
		ipanel2.add(iniciar);
		ipanel2.add(limpiar_in);
		ipanel2.setBackground(Color.white);
		
		inicio.add(ipanel);
		inicio.add(ipanel2);
		
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		/* PANEL DE LISTA DE USUARIOS */
		
		lista = new JPanel();
		lista.setVisible(false);
		
		lista.setLayout(new FlowLayout(FlowLayout.CENTER));
		lista.setBackground(Color.white);
		LineBorder borde_list = new LineBorder(new Color(29,34, 143),3,true);
		lista.setBorder(new TitledBorder(BorderFactory.createTitledBorder(borde_list, "Lista de Usuarios", TitledBorder.CENTER, TitledBorder.TOP, new Font ( "Calisto MT", Font.BOLD, 20 ), Color.black)));
		
		taLista = new JTextArea(11, 50);
		taLista.setBackground(new Color(29,34, 143));
		taLista.setBorder(new LineBorder(Color.black));
		taLista.setCaretColor(Color.white);
		taLista.setForeground(Color.white);
		taLista.setFont(new Font ( "Consolas", Font.PLAIN, 16));
		taLista.setEditable(false);
		
		JScrollPane scroll_list = new JScrollPane(taLista);
				
		lista.add(scroll_list);
	
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		/* PANEL PARA REGISTRAR USUARIO */
		
		reg = new JPanel();
		reg.setVisible(false);
		
		reg.setLayout(new GridLayout(5, 1));
		reg.setBackground(Color.white);
		
		LineBorder borde_reg = new LineBorder(new Color(29,34, 143),3,true);
		reg.setBorder(new TitledBorder(BorderFactory.createTitledBorder(borde_reg, "Registrar Usuario", TitledBorder.CENTER, TitledBorder.TOP, new Font ( "Calisto MT", Font.BOLD, 20 ), Color.black)));
		
		lnombre_reg = new JLabel("Ingrese nombre:   ");
		lapellido_reg = new JLabel("Ingrese apellido:  " );
		lclave_reg = new JLabel("Ingrese clave:      ");
		lbalance_reg = new JLabel("Ingrese balance: ");
				
		nombre_reg = new JTextField(10);
		apellido_reg = new JTextField(10);
		clave_reg = new JTextField(10);
		balance_reg = new JTextField(10);
		
		btnRegistrar = new JButton("REGISTRARSE");
		btnRegistrar.addActionListener(this);
		
		btnRegistrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/users.png")));
		
		limpiar_reg = new JButton("Limpiar");
		limpiar_reg.addActionListener(this);
		
		limpiar_reg.setIcon(new ImageIcon(getClass().getResource("/Imagenes/limpiar.png")));
		
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		
		p1.setLayout(new FlowLayout(FlowLayout.CENTER));
		p1.setBackground(Color.white);
		p2.setLayout(new FlowLayout(FlowLayout.CENTER));
		p2.setBackground(Color.white);
		p3.setLayout(new FlowLayout(FlowLayout.CENTER));
		p3.setBackground(Color.white);
		p4.setLayout(new FlowLayout(FlowLayout.CENTER));
		p4.setBackground(Color.white);
		p5.setLayout(new FlowLayout(FlowLayout.CENTER, 10,0));
		p5.setBackground(Color.white);
		
		p1.add(lnombre_reg);
		p1.add(nombre_reg);
		p2.add(lapellido_reg);
		p2.add(apellido_reg);
		p3.add(lclave_reg);
		p3.add(clave_reg);
		p4.add(lbalance_reg);
		p4.add(balance_reg);
		p5.add(btnRegistrar);
		p5.add(limpiar_reg);
		
		reg.add(p1);
		reg.add(p2);
		reg.add(p3);
		reg.add(p4);
		reg.add(p5);
		
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		/* PANEL DE DEPOSITOS */
		
		dep = new JPanel();
		dep.setVisible(false);
		
		dep.setBackground(Color.white);
		dep.setLayout(new FlowLayout(FlowLayout.CENTER, 10,20));
		
		LineBorder borde_dep = new LineBorder(new Color(29,34, 143),3,true);
		dep.setBorder(new TitledBorder(BorderFactory.createTitledBorder(borde_dep, "Deposito", TitledBorder.CENTER, TitledBorder.TOP, new Font ( "Calisto MT", Font.BOLD, 20 ), Color.black)));
	
		taCuentas = new JTextArea(8, 18);
		taCuentas.setBackground(new Color(29,34, 143));
		taCuentas.setBorder(new LineBorder(Color.black));
		taCuentas.setCaretColor(Color.white);
		taCuentas.setForeground(Color.white);
		taCuentas.setFont(new Font ( "Consolas", Font.PLAIN, 15));
		taCuentas.setEditable(false);

		
		combo_dep = new JComboBox(cuenta);
		lmonto_dep = new JLabel("Monto: ");
		monto_dep = new JTextField(10);
		

		btndep = new JButton("DEPOSITAR");
		btndep.addActionListener(this);
        btndep.setBorder(null);
		btndep.setBackground(Color.white);
		btndep.setIcon(new ImageIcon(getClass().getResource("/Imagenes/deposito.png")));
		
		dep.add(taCuentas);
		dep.add(combo_dep);
		dep.add(lmonto_dep);
		dep.add(monto_dep);
		dep.add(btndep);
		
		
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		/* PANEL DE RETIROS */
		
		ret = new JPanel();
		ret.setVisible(false);
		
		ret.setBackground(Color.white);
		ret.setLayout(new FlowLayout(FlowLayout.CENTER, 10,20));
		
		LineBorder borde_ret = new LineBorder(new Color(29,34, 143),3,true);
		ret.setBorder(new TitledBorder(BorderFactory.createTitledBorder(borde_ret, "Retiro", TitledBorder.CENTER, TitledBorder.TOP, new Font ( "Calisto MT", Font.BOLD, 20 ), Color.black)));

		taCuentas2 = new JTextArea(8, 18);
		taCuentas2.setBackground(new Color(29,34, 143));
		taCuentas2.setBorder(new LineBorder(Color.black));
		taCuentas2.setCaretColor(Color.white);
		taCuentas2.setForeground(Color.white);
		taCuentas2.setFont(new Font ( "Consolas", Font.PLAIN, 15));
		taCuentas2.setEditable(false);
		
		combo_ret = new JComboBox(cuenta);
		lmonto_ret = new JLabel("Monto: ");
		monto_ret = new JTextField(10);
		
		btnret = new JButton("RETIRAR");
		btnret.addActionListener(this);
		btnret.setBorder(null);
		btnret.setBackground(null);
		btnret.setIcon(new ImageIcon(getClass().getResource("/Imagenes/retirar.png")));
		
		ret.add(taCuentas2);
		ret.add(combo_ret);
		ret.add(lmonto_ret);
		ret.add(monto_ret);
		ret.add(btnret);
		
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		/* PANEL DE TRANSFERENCIAS */
		
		trans = new JPanel();
		trans.setVisible(false);
		
		trans.setBackground(Color.white);
		trans.setLayout(new FlowLayout(FlowLayout.CENTER, 33,15));
		
		LineBorder borde_tran = new LineBorder(new Color(29,34, 143),3,true);
		trans.setBorder(new TitledBorder(BorderFactory.createTitledBorder(borde_tran, "Transferencia", TitledBorder.CENTER, TitledBorder.TOP, new Font ( "Calisto MT", Font.BOLD, 20 ), Color.black)));
		
		taCuentas3 = new JTextArea(7, 18);
		taCuentas3.setBackground(new Color(29,34, 143));
		taCuentas3.setBorder(new LineBorder(Color.black));
		taCuentas3.setCaretColor(Color.white);
		taCuentas3.setForeground(Color.white);
		taCuentas3.setFont(new Font ( "Consolas", Font.PLAIN, 15));
		taCuentas3.setEditable(false);
		
		lmonto_tran = new JLabel("Monto:");
		monto_tran = new JTextField(10);
		btntrans = new JButton("TRANFERIR");
		btntrans.addActionListener(this);
		btntrans.setBorder(null);
		btntrans.setBackground(null);
		btntrans.setIcon(new ImageIcon(getClass().getResource("/Imagenes/trans-icon.png")));
		
		combo1 = new JComboBox(cuenta);
		combo2 = new JComboBox(cuenta);
		
		ldeCta = new JLabel("De cuenta: ");
		laCta = new JLabel("A cuenta: ");
		
		trans.add(taCuentas3);
		trans.add(ldeCta);
		trans.add(combo1);
		trans.add(laCta);
		trans.add(combo2);
		trans.add(lmonto_tran);
		trans.add(monto_tran);
		trans.add(btntrans);
		
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		/* PANEL DE CONSULTAS */
		
		cons  = new JPanel();
		cons.setVisible(false);
		
		cons.setBackground(Color.white);
		cons.setLayout(new FlowLayout(FlowLayout.CENTER, 10,8));
		
		LineBorder borde_cons = new LineBorder(new Color(29,34, 143),3,true);
		cons.setBorder(new TitledBorder(BorderFactory.createTitledBorder(borde_cons, "Historial de Transacciones", TitledBorder.CENTER, TitledBorder.TOP, new Font ( "Calisto MT", Font.BOLD, 20 ), Color.black)));
		
		taHist = new JTextArea(10, 60);
		taHist.setBackground(new Color(29,34, 143));
		taHist.setBorder(new LineBorder(Color.black));
		taHist.setCaretColor(Color.white);
		taHist.setForeground(Color.white);
		taHist.setFont(new Font ( "Consolas", Font.PLAIN, 12));
		taHist.setEditable(false);
		
		JScrollPane scroll_hist = new JScrollPane(taHist);
		
		combo_hist = new JComboBox(cuenta);
		
		btnmostrar = new JButton("CONSULTAR");
		btnmostrar.addActionListener(this);
		btnmostrar.setBorder(null);
		btnmostrar.setBackground(null);
		btnmostrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/mostrar-icon.png")));
		
		
		cons.add(combo_hist);
		cons.add(btnmostrar);
		cons.add(scroll_hist);
		
		
		
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		
		panelConctacto = new JPanel();
		
		panelConctacto.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelConctacto.setBackground(Color.white);
		LineBorder conc = new LineBorder(new Color(29,34, 143),3,true);
		panelConctacto.setBorder(new TitledBorder(BorderFactory.createTitledBorder(conc, "Creadores", TitledBorder.CENTER, TitledBorder.TOP, new Font ( "Calisto MT", Font.BOLD, 20 ), Color.black)));
		
		taCont = new JTextArea(11, 50);
		taCont.setBackground(new Color(29,34, 143));
		taCont.setBorder(new LineBorder(Color.black));
		taCont.setCaretColor(Color.white);
		taCont.setForeground(Color.white);
		taCont.setFont(new Font ( "Consolas", Font.PLAIN, 16));
		//taCont.set
		taCont.append("\t\t  Proyecto Final\n"
					+ "\t Programacion Orientada a Objetos\n"
					+ "\t   Simulador Cajero Automatico\n\n"
					+ "- Giancarlo Tovar	gtovarv2@ucentral.edu.co\n"
					+ "- Daniel Rojas		drojasa2@ucentral.edu.co\n"
					+ "- Javier Baron		jbaronf@ucentral.edu.co\n\n\n"
					+ "\t\tUniversidad Central");
		taCont.setEditable(false);
		
		JScrollPane s = new JScrollPane(taCont);
		panelConctacto.add(s);
		
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			

		transacciones.setEnabled(false);
		consulta.setEnabled(false);
		cerrar.setEnabled(false);
			
		// Mostrar lista de ususarios creados.
		for(int i=0; i<banco.NumUsuarios(); i++){
			
			taLista.append(String.format("%d) %s", i+1, banco.getUsuarios().get(i).MostrarUsuario()));
		}

		
	}

	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource()==iniciarSesion) {
			
			panelprincipal.remove(panelInf);
			panelprincipal.remove(reg);
			panelprincipal.remove(dep);
			panelprincipal.remove(ret);
			panelprincipal.remove(trans);
			panelprincipal.remove(cons);
			panelprincipal.remove(lista);
			panelprincipal.remove(panelConctacto);
			
			reg.setVisible(false);
			ret.setVisible(false);
			dep.setVisible(false);
			trans.setVisible(false);
			cons.setVisible(false);
			lista.setVisible(false);
			panelConctacto.setVisible(false);

			panelprincipal.add(inicio);
			inicio.setVisible(true);

		}
		
		if(e.getSource()==mlista){
			
			panelprincipal.remove(panelInf);
			panelprincipal.remove(reg);
			panelprincipal.remove(dep);
			panelprincipal.remove(ret);
			panelprincipal.remove(trans);
			panelprincipal.remove(cons);
			panelprincipal.remove(inicio);
			panelprincipal.remove(panelConctacto);
			
			reg.setVisible(false);
			ret.setVisible(false);
			dep.setVisible(false);
			trans.setVisible(false);
			cons.setVisible(false);
			inicio.setVisible(false);
			panelConctacto.setVisible(false);

			panelprincipal.add(lista);
			lista.setVisible(true);
			
			
		}
		
		if(e.getSource()==registrar){
			
			panelprincipal.remove(panelInf);
			panelprincipal.remove(inicio);
			panelprincipal.remove(dep);
			panelprincipal.remove(ret);
			panelprincipal.remove(trans);
			panelprincipal.remove(cons);
			panelprincipal.remove(lista);
			panelprincipal.remove(panelConctacto);
			
			inicio.setVisible(false);
			ret.setVisible(false);
			dep.setVisible(false);
			trans.setVisible(false);
			cons.setVisible(false);
			lista.setVisible(false);
			panelConctacto.setVisible(false);
			
			panelprincipal.add(reg);
			reg.setVisible(true);
		}
		
		if(e.getSource()==deposito){
			
			panelprincipal.remove(panelInf);
			panelprincipal.remove(reg);
			panelprincipal.remove(inicio);
			panelprincipal.remove(ret);
			panelprincipal.remove(trans);
			panelprincipal.remove(cons);
			panelprincipal.remove(lista);
			panelprincipal.remove(panelConctacto);
			
			
			reg.setVisible(false);
			ret.setVisible(false);
			inicio.setVisible(false);
			trans.setVisible(false);
			cons.setVisible(false);
			lista.setVisible(false);
			panelConctacto.setVisible(false);

			
			panelprincipal.add(dep);
			dep.setVisible(true);
			
		}
		
		if(e.getSource()==retiro){
			
			panelprincipal.remove(panelInf);
			panelprincipal.remove(reg);
			panelprincipal.remove(inicio);
			panelprincipal.remove(dep);
			panelprincipal.remove(cons);
			panelprincipal.remove(trans);
			panelprincipal.remove(lista);
			panelprincipal.remove(panelConctacto);

			
			reg.setVisible(false);
			inicio.setVisible(false);
			dep.setVisible(false);
			trans.setVisible(false);
			cons.setVisible(false);
			lista.setVisible(false);
			panelConctacto.setVisible(false);

			
			panelprincipal.add(ret);
			ret.setVisible(true);
		}
		
		if(e.getSource()==transferencia){
			
			panelprincipal.remove(panelInf);
			panelprincipal.remove(reg);
			panelprincipal.remove(inicio);
			panelprincipal.remove(dep);
			panelprincipal.remove(ret);
			panelprincipal.remove(cons);
			panelprincipal.remove(lista);
			panelprincipal.remove(panelConctacto);

			
			reg.setVisible(false);
			inicio.setVisible(false);
			dep.setVisible(false);
			ret.setVisible(false);
			cons.setVisible(false);
			lista.setVisible(false);
			panelConctacto.setVisible(false);

			
			panelprincipal.add(trans);
			trans.setVisible(true);
			
		}
		
		if (e.getSource()==consultar) {
			
			panelprincipal.remove(panelInf);
			panelprincipal.remove(reg);
			panelprincipal.remove(inicio);
			panelprincipal.remove(dep);
			panelprincipal.remove(ret);
			panelprincipal.remove(trans);
			panelprincipal.remove(lista);
			panelprincipal.remove(panelConctacto);
			
			reg.setVisible(false);
			inicio.setVisible(false);
			dep.setVisible(false);
			ret.setVisible(false);
			trans.setVisible(false);
			lista.setVisible(false);
			panelConctacto.setVisible(false);

			
			panelprincipal.add(cons);
			cons.setVisible(true);
			
		}

		if (e.getSource()==contacto) {
			
			panelprincipal.remove(panelInf);
			panelprincipal.remove(reg);
			panelprincipal.remove(dep);
			panelprincipal.remove(ret);
			panelprincipal.remove(trans);
			panelprincipal.remove(cons);
			panelprincipal.remove(lista);
			panelprincipal.remove(inicio);
			
			reg.setVisible(false);
			ret.setVisible(false);
			dep.setVisible(false);
			trans.setVisible(false);
			cons.setVisible(false);
			lista.setVisible(false);
			inicio.setVisible(false);

			panelprincipal.add(panelConctacto);
			panelConctacto.setVisible(true);
			
		}
		if(e.getSource()==iniciar){
			
			// Recibir datos del usuario.
			String id = tfID_in.getText();
			String clave_in = PFclave_in.getText();
			
			//Iniciar sesion con los datos ingresados.
			Usuario usuarioAut = banco.IniciarSesion(id, clave_in);
			
			// Verificar si el usuario es valido.
			if(usuarioAut==null){
				
				JOptionPane.showMessageDialog(null, "ID y/o Contraseña incorrecta. Intente de nuevo", "Iniciar Sesion", JOptionPane.WARNING_MESSAGE);
			}
			
			else{
				
				JOptionPane.showMessageDialog(null, "Bienvenido "+usuarioAut.getNombre()+" "+usuarioAut.getApellido(), "Iniciar Sesion", JOptionPane.INFORMATION_MESSAGE);
				
				inicio.setVisible(false);
				panelprincipal.remove(inicio);
				panelprincipal.add(panelInf);
				iniciarSesion.setEnabled(false);
				registrar.setEnabled(false);
				panelInf.setVisible(true);
				
				
				// Mostrar resumen de cuentas.
				for(int i=0; i<usuarioAut.NumCuentas(); i++){
					
					taCuentas.append(String.format("%d) %s\n", i+1, usuarioAut.getCuentas().get(i).ResumenDeCuenta()));
					taCuentas2.append(String.format("%d) %s\n", i+1, usuarioAut.getCuentas().get(i).ResumenDeCuenta()));
					taCuentas3.append(String.format("%d) %s\n", i+1, usuarioAut.getCuentas().get(i).ResumenDeCuenta()));
				}
				
				transacciones.setEnabled(true);
				consulta.setEnabled(true);
				cerrar.setEnabled(true);
				

				
			}
			
			
		}
		
		if(e.getSource()==btnRegistrar){
			
			try{
				
				// Recibir datos del usuario.
				String nombre = nombre_reg.getText();
				String apellido = apellido_reg.getText();
				String clave = clave_reg.getText();
				String balance = balance_reg.getText();
				int b = Integer.parseInt(balance);
				
				if(nombre.length()==0 || apellido.length()==0 || clave.length()==0 || balance.length()==0){
					
					JOptionPane.showMessageDialog(null, "No pueden quedar campos vacios", "Error", JOptionPane.WARNING_MESSAGE);
					
				}
				
				else{
					
					// Registrar usuario al banco.
					Usuario usuarioN = banco.agregarUsuario(nombre, apellido, clave, b);
					
					JOptionPane.showMessageDialog(null, "Usuario creado con exito "+usuarioN.getNombre()+" "+usuarioN.getApellido());
					
					// Recibir usuarios creados.
					int i = banco.getUsuarios().size();
					
					//Actualizar lista de usuarios.
					taLista.append(String.format("%d) %s",i, usuarioN.MostrarUsuario()));
					
					reg.setVisible(false);
					panelprincipal.remove(reg);
					panelprincipal.add(panelInf);
					
					nombre_reg.setText("");
					apellido_reg.setText("");
					clave_reg.setText("");
					balance_reg.setText("");
				
				}
				
			}
			
			catch(Exception ex){
				
				JOptionPane.showMessageDialog(null, "Ingrese un balance valido", "Error", JOptionPane.ERROR_MESSAGE);
				
				balance_reg.setText("");
			}
			
		}
		
		if(e.getSource()==btndep){
			
			// Recibir el usuario que inicio sesion.
			Usuario usuarioAut = banco.getUsuarioAut();
			
			try{
				
				taCuentas.setText("");
				taCuentas2.setText("");
				taCuentas3.setText("");
				
	
				// Recibir la cuenta a depositar.
				int aCuenta = combo_dep.getSelectedIndex();
				
				// Recibir el monto.
				String m = monto_dep.getText();
				int monto = Integer.parseInt(m);

				// Verificar que el monto sea positivo.
				if(monto<=0){
					
					for(int i=0; i<usuarioAut.NumCuentas(); i++){
						
						taCuentas.append(String.format("%d) %s\n", i+1, usuarioAut.getCuentas().get(i).ResumenDeCuenta()));
						taCuentas2.append(String.format("%d) %s\n", i+1, usuarioAut.getCuentas().get(i).ResumenDeCuenta()));
						taCuentas3.append(String.format("%d) %s\n", i+1, usuarioAut.getCuentas().get(i).ResumenDeCuenta()));
					}
					
					JOptionPane.showMessageDialog(null, "Ingrese un valor mayor que 0", "Error", JOptionPane.ERROR_MESSAGE);
					
					monto_dep.setText("");
				}
				
				
				else{
					
					// Hacer el deposito.
					cajero.Depositar(usuarioAut, aCuenta, monto);

				
					// Actualizar resumen de cuentas.
					for(int i=0; i<usuarioAut.NumCuentas(); i++){
						
						taCuentas.append(String.format("%d) %s\n", i+1, usuarioAut.getCuentas().get(i).ResumenDeCuenta()));
						taCuentas2.append(String.format("%d) %s\n", i+1, usuarioAut.getCuentas().get(i).ResumenDeCuenta()));
						taCuentas3.append(String.format("%d) %s\n", i+1, usuarioAut.getCuentas().get(i).ResumenDeCuenta()));
					}
					
					monto_dep.setText("");
				}
				
			}
			// Verificar que solo se ingresen numeros.
			catch(Exception ex){
				
				for(int i=0; i<usuarioAut.NumCuentas(); i++){
					
					taCuentas.append(String.format("%d) %s\n", i+1, usuarioAut.getCuentas().get(i).ResumenDeCuenta()));
					taCuentas2.append(String.format("%d) %s\n", i+1, usuarioAut.getCuentas().get(i).ResumenDeCuenta()));
					taCuentas3.append(String.format("%d) %s\n", i+1, usuarioAut.getCuentas().get(i).ResumenDeCuenta()));
				}
				
				monto_dep.setText("");
				
				JOptionPane.showMessageDialog(null, "Ingrese valores numericos enteros", "Error", JOptionPane.ERROR_MESSAGE);
			
			}
			
		}
		
		if(e.getSource()==btnret){
			
			taCuentas.setText("");
			taCuentas2.setText("");
			taCuentas3.setText("");
			
			// Recibir el usuario que inicio sesion.
			Usuario usuarioAut = banco.getUsuarioAut();
			
			try{
				
				taCuentas.setText("");
				taCuentas2.setText("");
				taCuentas3.setText("");
				
	
				// Recibir la cuenta a depositar.
				int deCuenta = combo_ret.getSelectedIndex();
				
				// Recibir el monto.
				String m = monto_ret.getText();
				int monto = Integer.parseInt(m);

				// Verificar que el monto sea positivo y no sea mayor al balance que se tiene.
				if(monto<=0 || monto>usuarioAut.ConsultarBalance(deCuenta)){
					
					for(int i=0; i<usuarioAut.NumCuentas(); i++){
						
						taCuentas.append(String.format("%d) %s\n", i+1, usuarioAut.getCuentas().get(i).ResumenDeCuenta()));
						taCuentas2.append(String.format("%d) %s\n", i+1, usuarioAut.getCuentas().get(i).ResumenDeCuenta()));
						taCuentas3.append(String.format("%d) %s\n", i+1, usuarioAut.getCuentas().get(i).ResumenDeCuenta()));
					}
					
					JOptionPane.showMessageDialog(null, "Monto ingresado no es valido", "Error", JOptionPane.ERROR_MESSAGE);
					
					monto_ret.setText("");
				}
				
				
				else{
					
					// Hacer el deposito.
					cajero.Retirar(usuarioAut, deCuenta, monto);

				
					// Actualizar resumen de cuentas.
					for(int i=0; i<usuarioAut.NumCuentas(); i++){
						
						taCuentas.append(String.format("%d) %s\n", i+1, usuarioAut.getCuentas().get(i).ResumenDeCuenta()));
						taCuentas2.append(String.format("%d) %s\n", i+1, usuarioAut.getCuentas().get(i).ResumenDeCuenta()));
						taCuentas3.append(String.format("%d) %s\n", i+1, usuarioAut.getCuentas().get(i).ResumenDeCuenta()));
					}
					
					monto_ret.setText("");
				}
				
			}
			// Verificar que solo se ingresen numeros.
			catch(Exception ex){
				
				for(int i=0; i<usuarioAut.NumCuentas(); i++){
					
					taCuentas.append(String.format("%d) %s\n", i+1, usuarioAut.getCuentas().get(i).ResumenDeCuenta()));
					taCuentas2.append(String.format("%d) %s\n", i+1, usuarioAut.getCuentas().get(i).ResumenDeCuenta()));
					taCuentas3.append(String.format("%d) %s\n", i+1, usuarioAut.getCuentas().get(i).ResumenDeCuenta()));
				}
				
				monto_ret.setText("");
				
				JOptionPane.showMessageDialog(null, "Ingrese valores numericos enteros", "Error", JOptionPane.ERROR_MESSAGE);
			
			}
			
		}
		
		if(e.getSource()==btntrans){
			
			taCuentas.setText("");
			taCuentas2.setText("");
			taCuentas3.setText("");
			
			// Recibir el usuario que inicio sesion.
			Usuario usuarioAut = banco.getUsuarioAut();
			
			try{
			// Recibir la cuenta de la que se retira.
				int deCuenta = combo1.getSelectedIndex();
				
				// Recibir la cuenta a transferir
				int aCuenta = combo2.getSelectedIndex();
				
				// Recibir el monto.
				String m = monto_tran.getText();
				int monto = Integer.parseInt(m);
				
				if(monto<=0 || monto>=usuarioAut.ConsultarBalance(deCuenta)){
					
					for(int i=0; i<usuarioAut.NumCuentas(); i++){
						
						taCuentas.append(String.format("%d) %s\n", i+1, usuarioAut.getCuentas().get(i).ResumenDeCuenta()));
						taCuentas2.append(String.format("%d) %s\n", i+1, usuarioAut.getCuentas().get(i).ResumenDeCuenta()));
						taCuentas3.append(String.format("%d) %s\n", i+1, usuarioAut.getCuentas().get(i).ResumenDeCuenta()));
					}
					
					monto_ret.setText("");
					
					JOptionPane.showMessageDialog(null, "Monto ingresado no es valido", "Error", JOptionPane.ERROR_MESSAGE);
					
				}
				
				else{
					
					// Hacer la transferencia.
					cajero.Transferir(usuarioAut, deCuenta, aCuenta, monto);
					
					// Actualizar resumen de cuentas.
					for(int i=0; i<usuarioAut.NumCuentas(); i++){
						
						taCuentas.append(String.format("%d) %s\n", i+1, usuarioAut.getCuentas().get(i).ResumenDeCuenta()));
						taCuentas2.append(String.format("%d) %s\n", i+1, usuarioAut.getCuentas().get(i).ResumenDeCuenta()));
						taCuentas3.append(String.format("%d) %s\n", i+1, usuarioAut.getCuentas().get(i).ResumenDeCuenta()));
					}
					
					monto_tran.setText("");
			
				}
			}catch(Exception ex){
				
				for(int i=0; i<usuarioAut.NumCuentas(); i++){
					
					taCuentas.append(String.format("%d) %s\n", i+1, usuarioAut.getCuentas().get(i).ResumenDeCuenta()));
					taCuentas2.append(String.format("%d) %s\n", i+1, usuarioAut.getCuentas().get(i).ResumenDeCuenta()));
					taCuentas3.append(String.format("%d) %s\n", i+1, usuarioAut.getCuentas().get(i).ResumenDeCuenta()));
				}
				
				monto_ret.setText("");
				
				JOptionPane.showMessageDialog(null, "Ingrese valores numericos enteros", "Error", JOptionPane.ERROR_MESSAGE);
				
			}
			
		}
		
		if(e.getSource()==btnmostrar){
			
			Usuario usuarioAut = banco.getUsuarioAut();
			
			taHist.setText("");
			
			int cta = combo_hist.getSelectedIndex();
			
			for(int t=usuarioAut.NumTrans(cta)-1; t>=0; t--){
				
				taHist.append(cajero.MostarHistorialInterfaz(usuarioAut, cta, t));
			}
		}
		
		if(e.getSource()==cerrar){
			
			JOptionPane.showMessageDialog(null, "Sesion finalizada.\n", "Cerrar sesion", JOptionPane.INFORMATION_MESSAGE);
			
			/* Mostrar el menu principal */
			
			reg.setVisible(false);
			inicio.setVisible(false);
			dep.setVisible(false);
			ret.setVisible(false);
			cons.setVisible(false);
			lista.setVisible(false);
			trans.setVisible(false);
			panelConctacto.setVisible(false);
			
			panelprincipal.remove(panelInf);
			panelprincipal.remove(cons);
			panelprincipal.remove(reg);
			panelprincipal.remove(inicio);
			panelprincipal.remove(dep);
			panelprincipal.remove(ret);
			panelprincipal.remove(trans);
			panelprincipal.remove(lista);
			panelprincipal.remove(panelConctacto);
	
			panelprincipal.add(panelInf);

			transacciones.setEnabled(false);
			consulta.setEnabled(false);
			iniciarSesion.setEnabled(true);
			registrar.setEnabled(true);
			cerrar.setEnabled(true);
			
			panelInf.setVisible(true);
			
			taCuentas.setText("");
			taCuentas2.setText("");
			taCuentas3.setText("");
			tfID_in.setText("");
			PFclave_in.setText("");
			taHist.setText("");
			
		}
		
		
		if(e.getSource()==limpiar_in){
			
			tfID_in.setText("");
			PFclave_in.setText("");
		}
		
		if(e.getSource()==limpiar_reg){
			
			nombre_reg.setText("");
			apellido_reg.setText("");
			clave_reg.setText("");
			balance_reg.setText("");
		}
	}

}
