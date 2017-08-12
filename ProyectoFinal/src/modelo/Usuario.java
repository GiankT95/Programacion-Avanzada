package modelo;

import java.util.ArrayList;

/**
 * Clase que define al usuario.
 * 
 * @author	Giancarlo Tovar.
 * @author	Daniel Rojas.
 * @author	Javier Baron.
 * 
 * @version	19/05/2016
 */

public class Usuario{
	
	/** Atributos del usuario */
	private String nombre;
	private String apellido;
  	private String clave;
  	private String id;
  	private ArrayList<Cuenta> cuentas; // Lista de cuentas.
  	
  	/** Constructor por defecto */
	public Usuario() {
		
	}
	
	/**
	 * Constructor sobrecargado de usuario.
	 * @param pNombre  		nombre del usuario.
	 * @param pApellido  	apellido del usuario.
	 * @param pCalve  		clave del usuario.
	 */
	public Usuario(String pNombre, String pApellido, String pClave, Banco banco){
		
		this.nombre = pNombre;
		this.apellido = pApellido;
		this.clave = pClave;
		this.setId(banco.asignarID_Usuario()); // Recibir una identificacion del banco.
		cuentas = new ArrayList<Cuenta>(); // 	Crear lista vacia de cuentas.

	}
	
	/**
	 * Asignar una cuenta al usuario
	 * @param cuenta		la cuenta que se va a asignar
	 */
	public void AgregarCuenta(Cuenta cuenta){
		
		this.cuentas.add(cuenta);
	}
	
	/**
	 * Recibir el numero de cuentas del usuario.
	 * @return  la cantidad de cuentas que tiene el usuario.
	 */
	public int NumCuentas(){
		
		return this.cuentas.size();
	}
	
	/**
	 * Consultar el balance de una cuenta.
	 * @param pos		el indice de la cuenta a consultar
	 * @return 			balance de la cuenta
	 */
	public int ConsultarBalance(int pos){
		
		return this.cuentas.get(pos).getBalance();
	}
	
	/**
	 * Agregar una transaccion a una cuenta.
	 * @param pos		indice de la cuenta.
	 * @param monto		monto de la transaccion.
	 * @param tipo		tipo de la transaccion.
	 */
	public void AgregarTransCta(int pos, int monto, String tipo){
		
		this.cuentas.get(pos).agregarTransaccion(monto, tipo);
	}
	
	
	/**
	 * Imprimir el resumen de cuentas de un usuario.
	 */
	public void ResumenCuentas(){
		
		System.out.printf("Resumen de cuentas de %s %s\n", this.getNombre(), this.getApellido());
		
		for(int i=0; i<cuentas.size(); i++){
			
			System.out.printf("%d) %s\n", i+1, this.cuentas.get(i).ResumenDeCuenta());
		}
		
		System.out.println();
	}

	/**
	 * Imprimir el historial de transacciones para una cuenta.
	 * @param pos		indice de la cuenta.
	 */
	public void ImprimirResumenTrans(int pos){
		
		this.cuentas.get(pos).ImprimirHistorial();
	}
	
	/**
	 * Imprimir un usuario creado.
	 * @return 		usuario creado.
	 */
	public String MostrarUsuario(){
		
		return String.format("%s %s (ID: %s)\n", this.getNombre(), this.getApellido(), this.getId());
	}
	
	/**
	 * Recibir el id de una cuenta.
	 * @param pos		indice de la cuenta.
	 * @return			id de la cuenta.
	 */
	public int IdCuenta(int pos){
		return this.cuentas.get(pos).getId();
	}

	/**
	 * Asignar un nuevo balance a una cuenta.
	 * @param pos		indice de la cuenta.
	 * @param balance	balance final.
	 */
	public void SaldoCuenta(int pos,int balanceFinal){
		
		this.cuentas.get(pos).setBalance(balanceFinal);
	}
	
	/**
	 * Recibir el tipo de una cuenta
	 * @param pos		indice de la cuenta.
	 * @return			tipo de cuenta.
	 */
	public int TipoCuenta(int pos){
		
		return this.cuentas.get(pos).getTipo();
	}
	
	/**
	 * Recibir intereses
	 * @return		intereses para un tipo de cuenta
	 */
	public double Intereses(){
		
		double intereses = 0.03;
		
		return intereses;
	}
	
	/**
	 * Numero de transacciones de una cuenta del usuario.
	 * @param cuenta		Cuenta del usuario.
	 * @return				Numero de transacciones de una cuenta del usuario.
	 */
	public int NumTrans(int cuenta){
		
		return this.getCuentas().get(cuenta).getListaTrans().size();
	}
	
	/** Getters y Setters del usuario */
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getClave() {
		return clave;
	}
	
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String string) {
		this.id = string;
	}
	
	public ArrayList<Cuenta> getCuentas() {
		return cuentas;
	}

}
