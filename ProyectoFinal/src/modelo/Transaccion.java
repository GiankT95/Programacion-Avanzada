package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase que define a la transaccion.
 * 
 * @author	Giancarlo Tovar.
 * @author	Daniel Rojas.
 * @author	Javier Baron.
 * 
 * @version	19/05/2016
 */
public class Transaccion {

	/** Atributos de la transaccion */
	private int monto;
	private String tipo;
	private String fecha;
	private Cuenta cuenta;	// Cuenta en la cual se realizo la transaccion.
	
	/**
	 * Contrustor por defecto de la transaccion.
	 */
	public Transaccion(){
		
	}
	
	/**
	 * Constructor sobrecargado de la transaccion.
	 * @param cuenta		Cuenta a la que le pertenece la transaccion.
	 * @param pMonto		Monto de la transaccion.
	 * @param pTipo			Tipo de la transaccion.
	 */
	public Transaccion(Cuenta cuenta, int pMonto, String pTipo){
		
		this.cuenta = cuenta;
		this.getFecha();
		this.setMonto(pMonto);
		this.tipo = pTipo;
	}

	/**
	 * 	Recibir monto de la transaccion.
	 * @return
	 */
	public int getMonto() {
		return monto;
	}

	/**
	 * Asignar monto de la transaccion.
	 * @param monto		Monto de la transaccion.
	 */
	public void setMonto(int monto) {
		this.monto = monto;
	}
	
	/**
	 * Recibir fecha y hora en la que se realizo la transaccion.
	 * @return	fecha y hora de transaccion.
	 */
	public String getFecha() {
		SimpleDateFormat Fecha = new SimpleDateFormat("dd/MM/yyyy | HH:mm:ss | ");
		Date f = new Date();
		fecha = Fecha.format(f);
		
		return fecha;
	}
	
	/**
	 * Resumen de una transaccion.
	 * @return	resumen de la transaccion.
	 */
	public String ResumenTransaccion(){
		
		String h = this.fecha+"$"+this.getMonto()+" | "+ tipo + "\n";
		
		return h;
	}
	
}
