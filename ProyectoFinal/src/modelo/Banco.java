
package modelo;

import java.util.ArrayList;
import java.util.Random;

/**
 * Clase que define al banco.
 * 
 * @author	Giancarlo Tovar.
 * @author	Daniel Rojas.
 * @author	Javier Baron.
 * 
 * @version	19/05/2016
 */
public class Banco {

	private String nombre; 					// Nombre del banco.
	private ArrayList <Usuario> usuarios;	// Lista de usuarios del banco.
	private ArrayList <Cuenta> cuentas;		// Lista de cuenta del banco.
	private Usuario usuarioAut;
	
	/**
	 * Constructor por defecto del banco.
	 */
	public Banco(){
		
	}
	
	/**
	 * Constructor sobrecargado del banco.
	 * @param pNombre	Nombre del banco.
	 */
	public Banco(String pNombre){
		
		this.setNombre(pNombre);
		this.usuarios = new ArrayList<Usuario>(); 	// Nueva lista de usuarios para el banco.
		this.cuentas = new ArrayList<Cuenta>();		// Nueva lista de cuenta para el banco.
	}
	
	/**
	 * Generar un ID para un usuario.
	 * @return	ID aleatorio.
	 */
	public String asignarID_Usuario(){
		
		String id="";
		
		Random id_aleatorio = new Random();
		
		id = String.valueOf( 10000000 + id_aleatorio.nextInt(90000000));
		
		return id;
	}
	
	/**
	 * Generar ID para una cuenta. 
	 * @return	ID aleatorio.
	 */
	public int asignarID_Cuenta(){
		
		int id=0;
		Random id_aleatorio = new Random();
		
		id = 10000000 + id_aleatorio.nextInt(90000000);
		
		return id;
	}
	
	/**
	 * Crear un nuevo usuario del banco.
	 * @param pNombre			nombre del usuario.
	 * @param pApellido			apellido del usuario.
	 * @param pClave			clave del usuario.
	 * @param pBalanceAhorros	balance de las cuentas.
	 * @return					Nuevo usuario.
	 */
	public Usuario agregarUsuario(String pNombre, String pApellido, String pClave, int pBalance){
		
		Usuario usuarioNuevo = new Usuario(pNombre, pApellido, pClave, this);

		this.usuarios.add(usuarioNuevo);
		
		Ahorros ahorros = new Ahorros((int) (pBalance*0.5), usuarioNuevo, this);	    // Nueva cuenta de ahorros para el usuario.
		usuarioNuevo.AgregarCuenta(ahorros);											// Asignar cuenta de ahorros al usuario.
		this.agregarCuenta(ahorros);													// Agregar cuenta de ahorros a lista de cuentas del banco.
		
		Corriente corriente = new Corriente((int) (pBalance*0.5), usuarioNuevo, this); 	// Nueva cuenta corriente para el usuario.
		usuarioNuevo.AgregarCuenta(corriente);											// Asignar cuenta corriente al usuario.
		this.agregarCuenta(corriente);													// Agregar cuenta corriente a lista de cuentas del banco.
		
		return usuarioNuevo;
		
	}
	

	/**
	 * Agregar una cuenta a la lista de cuentas del banco.
	 * @param nuevaCta		Cuenta nueva.
	 */
	public void agregarCuenta(Cuenta nuevaCta){
		
		this.cuentas.add(nuevaCta);
	}
	
	/**
	 * Iniciar sesion con un usuario.
	 * @param id		ID del usuario.
	 * @param clave		Clave del usuario.
	 * @return			Usuario autorizado si el inicio de sesion es exitoso, o null, si no lo es.
	 */
	public Usuario IniciarSesion(String id, String clave){
		
		/* Busca en la lista de usuarios del banco. */
		for(Usuario aut : this.usuarios){
			
			/* Si se encuentra el ID del usuario y su clave es correcta, retorna el objeto usuario. */
			if(aut.getId().compareTo(id)==0 && aut.getClave().compareTo(clave)==0){
				
				this.setUsuarioAut(aut);
				
				return aut;
			}
		}
		
		return null;
	}
	
	/**
	 * Imprimir la lista de los usuarios del banco.
	 */
	public void ListaUsuarios(){
		
		System.out.printf("Usuarios creados %d", usuarios.size());
		System.out.println("\n");
		
		for(int i=0; i<usuarios.size(); i++){
			
			System.out.printf("%d. %s\n", i+1, this.usuarios.get(i).MostrarUsuario());
		}
		
		System.out.println();
	}
	
	/**
	 * Numero de usuarios registrados en el banco.
	 * @return		numero de usuarios.
	 */
	public int NumUsuarios(){
		
		return usuarios.size();
	}
	
	/**
	 * Recibir nombre del banco.
	 * @return	nombre del banco.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Asignar nombre al banco.
	 * @param nombre	Nombre del banco.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}


	public ArrayList<Cuenta> getCuentas() {
		return cuentas;
	}

	public Usuario getUsuarioAut() {
		return usuarioAut;
	}

	public void setUsuarioAut(Usuario usuarioAut) {
		this.usuarioAut = usuarioAut;
	}

	
}
