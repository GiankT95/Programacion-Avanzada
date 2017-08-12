package modelo;

import java.util.ArrayList;

/**
 * Clase abstracta que define a una cuenta.
 * 
 * @author	Giancarlo Tovar.
 * @author	Daniel Rojas.
 * @author	Javier Baron.
 * 
 * @version	19/05/2016
 */

public abstract class Cuenta {

	/** Atributos de la cuenta */
	private int id;
	private int balance;
	private int tipo;
	private Usuario titular; // Usuario al que le pertenece la cuenta.
	private ArrayList<Transaccion> ListaTrans;

	
	/** Getters y Setters de la cuenta */
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public Usuario getTitular() {
		return titular;
	}
	public void setTitular(Usuario titular) {
		this.titular = titular;
	}
	
	public ArrayList<Transaccion> getListaTrans() {
		return ListaTrans;
	}

	public void setListaTrans(ArrayList<Transaccion> listaTrans) {
		ListaTrans = listaTrans;
	}
	
	/**
	 * Agregar una transaccion a la cuenta.
	 * @param monto		monto de la transaccion.
	 * @param tipo		tipo de la transaccion.
	 */
	public abstract void agregarTransaccion(int monto, String tipo);
	
	/**
	 * Resumen de la cuenta.
	 */
	public abstract String ResumenDeCuenta();
	
	/**
	 * Imprimir historial de transacciones de la cuenta.
	 */
	public abstract void ImprimirHistorial();




}
