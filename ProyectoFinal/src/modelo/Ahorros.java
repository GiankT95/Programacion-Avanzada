package modelo;

import java.util.ArrayList;

/**
 * Clase que define a la cuenta de ahorros.
 * 
 * @author	Giancarlo Tovar.
 * @author	Daniel Rojas.
 * @author	Javier Baron.
 * 
 * @version	19/05/2016
 */
public class Ahorros extends Cuenta{

	
	private static final String NOMBRE = "Ahorros"; // Nombre predeterminado de la cuenta
	private ArrayList<Transaccion> historialTrans; 	// Lista de transacciones para esta cuenta.
	
	/** 
	 * Constructor por defecto de la cuenta ahorros.
	 */
	public Ahorros() {
		
	}

	/**
	 * Constructor sobrecargado de la cuenta ahorros.
	 * @param balance		balance de la cuenta.
	 * @param titular		titular de la cuenta.
	 * @param banco			banco al que pertenece la cuenta.
	 */
	public Ahorros(int balance, Usuario titular, Banco banco) {
		
		Ahorros.getNombre(); 							// Recibir nombre de la cuenta ahorros.
		this.setBalance(balance); 						// Asignar balance a la cuenta ahorros.
		this.setTitular(titular);						// Asignar titular a la cuenta ahorros
		this.setId(banco.asignarID_Cuenta());			// Recibir id del banco y asignar a cuenta ahorros.
		historialTrans = new ArrayList<Transaccion>();	// Nueva lista de transacciones para la cuenta ahorros.
		this.setListaTrans(historialTrans);				// Asignar nueva lista de transacciones a la lista madre de cuenta.
		this.setTipo(2);								// Asignar tipo de cuenta.
	}


	public void agregarTransaccion(int monto, String tipo) {
		
		/* Crear nueva transaccion y agregar a lista de transacciones */
		Transaccion nuevaTrans = new Transaccion(this, monto, tipo);
		this.historialTrans.add(nuevaTrans);
	}
	
	public String ResumenDeCuenta() {
		
		
		/* Formato del resumen dependiendo si es un balance negativo */
		if(this.getBalance()>=0){
			
			return String.format("%s		ID: %d		$%d", Ahorros.getNombre(), this.getId(), this.getBalance()) ;
		}
		
		else{
			
			return String.format("%s		ID: %d		$0.0", Ahorros.getNombre(), this.getId());
		}
	}

	public void ImprimirHistorial() {
		
		if (this.historialTrans.size()==0) {
			System.out.println("\nNo ha realizado ninguna transaccion.\n");
		}
		
		else{
		System.out.printf("\nHistorial de transacciones de la cuenta %s ID: %d\n\n", Ahorros.getNombre(),this.getId());
		
			/* Imprime desde la ultima transaccion realizada hasta la primera */
			for(int t=this.historialTrans.size()-1; t>=0; t--){
					
				System.out.println(this.historialTrans.get(t).ResumenTransaccion());
			}
		
			System.out.println();
		}
	}
	
	/**
	 * Recibir nombre de la cuenta.
	 * @return nombre de la cuenta.
	 */
	public static String getNombre() {
		return NOMBRE;
	}

	
	public ArrayList<Transaccion> getHistorialTrans() {
		return historialTrans;
	}	
	
}
