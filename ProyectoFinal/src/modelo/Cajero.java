package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Clase que define al cajero.
 * 
 * @author	Giancarlo Tovar.
 * @author	Daniel Rojas.
 * @author	Javier Baron.
 * 
 * @version	19/05/2016
 */
public class Cajero implements Op_Cajero{

	String fecha;
	
	/**
	 * Constructor por defecto del cajero.
	 */
	public Cajero(){
		
	}
	

	/**
	 * Mostrar el historial de transacciones para el usuario que inicio sesion.
	 * @param usuarioAut		Usuario que inicio sesion.
	 * @param cuenta			Cuenta a la que se va a mostrar el historial.
	 * @param					Transacciones de la cuenta.		
	 */
	public void MostarHistorialConsola(Usuario usuarioAut, int cuenta) {
		
		
		// Imprimir el historial de transacciones.
		usuarioAut.getCuentas().get(cuenta).ImprimirHistorial();;
			
		
	}
	
	/**
	 * Mostrar el historial de transacciones para el usuario que inicio sesion.
	 * @param usuarioAut		Usuario que inicio sesion.
	 * @param cuenta			Cuenta a la que se va a mostrar el historial.
	 * @param					Transacciones de la cuenta.		
	 */
	public String MostarHistorialInterfaz(Usuario usuarioAut, int cuenta, int trans) {
		
		

		
		// Imprimir el historial de transacciones.
		String t = usuarioAut.getCuentas().get(cuenta).getListaTrans().get(trans).ResumenTransaccion();
		
		return t; 	
		
	}

	/**
	 * Transferir fondos de una cuenta a otra.
	 * @param usuarioAut	Usuario que inicio sesion.	
	 * @param sc			Objeto Scanner que utiliza el usuario para ingresar los datos.		
	 */
	public void Transferir(Usuario usuarioAut, int deCuenta, int aCuenta, int monto) {

		int pBalance;			// Balance de la cuenta salida.
		int sBalance;			// Balance de la cuenta destino.
		int balanceFinal=0;		
		int balanceFinal2=0;
	
	
		// Recibir balance de la cuenta salida.
		pBalance = usuarioAut.ConsultarBalance(deCuenta); 
		
		// Recibir balance de la cuenta destino.
		sBalance = usuarioAut.ConsultarBalance(aCuenta); 
		
		/* Verificar si el tipo de cuenta salida es corriente(1) o ahorros(2),
		 * si es cuenta corriente se aplican intereses al monto que va a tranferir */
		if(usuarioAut.TipoCuenta(deCuenta)==1){
			
			// Actualizar el balance de la cuenta salida.
			balanceFinal = (int) ((pBalance - monto)-(monto*usuarioAut.Intereses())); 
			usuarioAut.SaldoCuenta(deCuenta, balanceFinal);
			
			//Acutalizar el balance de la cuenta destino.
			balanceFinal2 = sBalance + monto; 
			usuarioAut.SaldoCuenta(aCuenta, balanceFinal2);
			
			// Agregar transaccion a la cuenta salida.
			usuarioAut.AgregarTransCta(deCuenta, (int) ((-1*monto)-(monto*usuarioAut.Intereses())), String.format("Transferencia a cuenta ID: %d", usuarioAut.IdCuenta(aCuenta)));
			
			// Agregar transaccion a la cuenta destino.
			usuarioAut.AgregarTransCta(aCuenta, monto, String.format("Transferencia de cuenta ID: %d ", usuarioAut.IdCuenta(deCuenta)));
		}  
		
		else if(usuarioAut.TipoCuenta(deCuenta)==2){
			
			// Actualizar el balance de la cuenta salida.
			balanceFinal = pBalance - monto; 
			usuarioAut.SaldoCuenta(deCuenta, balanceFinal);
			
			//Acutalizar el balance de la cuenta destino.
			balanceFinal2 = sBalance + monto; 
			usuarioAut.SaldoCuenta(aCuenta, balanceFinal2);
			
			// Agregar transaccion a la cuenta salida.
			usuarioAut.AgregarTransCta(deCuenta, -1*monto, String.format("Transferencia a cuenta ID: %d", usuarioAut.IdCuenta(aCuenta)));
			
			// Agregar transaccion a la cuenta destino.
			usuarioAut.AgregarTransCta(aCuenta, monto, String.format("Transferencia de cuenta ID: %d ", usuarioAut.IdCuenta(deCuenta)));
		}
		
	}

	/**
	 * Depositar fondos a una cuenta.
	 * @param usuarioAut	Usuario que inicio sesion.
	 * @param cuena			Cuenta al a que se deposita.
	 * @param monto			Monto que se va a depositar.
	 */
	public void Depositar(Usuario usuarioAut, int aCuenta, int monto) {
		
		String tipo = "Deposito";	// Tipo de transaccion realizada.
		int balance;
		int balanceFinal=0;
		
		
		// Recibir el balance de la cuenta donde se deposita.
		balance = usuarioAut.ConsultarBalance(aCuenta); 
		
		// Actualizar el balance de la cuenta.
		balanceFinal = balance + monto;
		usuarioAut.SaldoCuenta(aCuenta, balanceFinal);
		
		// Agregar transaccion a la cuenta donde se deposito.
		usuarioAut.AgregarTransCta(aCuenta, monto, tipo);
	}

	/**
	 * Retirar fondos de una cuenta.
	 * @param usuarioAut	Usuario que inicio sesion.
	 * @param deCuenta		Cuenta de la que se realiza el retiro.
	 * @param Monto			Monto que se va a retirar.
	 */
	public void Retirar(Usuario usuarioAut, int deCuenta, int monto) {
		
		String tipo = "Retiro"; // Tipo de transaccion.
		int balanceFinal=0;
		int balance;
		
		// Recibir balance de la cuenta donde se retira.
		balance = usuarioAut.ConsultarBalance(deCuenta);	
		
		/* Verificar si el tipo de cuenta es corriente(1) o ahorros(2),
		 * si es cuenta corriente se aplican intereses al monto que va a retirar */
		if(usuarioAut.TipoCuenta(deCuenta)==1){
			
			balanceFinal = (int) ((balance - monto)-(monto*usuarioAut.Intereses())); 
			
			usuarioAut.SaldoCuenta(deCuenta, balanceFinal);
			
			usuarioAut.AgregarTransCta(deCuenta, (int) ((-1*monto)-(monto*usuarioAut.Intereses())), tipo);
		}
		
		else if(usuarioAut.TipoCuenta(deCuenta)==2){
			
			// Actualizar balance de la cuenta.
			balanceFinal = balance - monto;
			usuarioAut.SaldoCuenta(deCuenta, balanceFinal);
			
			// Agregar transaccion a la cuenta.
			usuarioAut.AgregarTransCta(deCuenta, -1*monto, tipo);
		}
		
	}

}
