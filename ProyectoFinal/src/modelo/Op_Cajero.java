package modelo;

import java.util.Scanner;

public interface Op_Cajero {

	public abstract void MostarHistorialConsola(Usuario titular, int cuenta);
	public abstract String MostarHistorialInterfaz(Usuario titular, int cuenta, int trans);
	public abstract void Transferir(Usuario titular, int deCuenta, int aCuenta, int monto);
	public abstract void Depositar(Usuario titular, int aCuenta, int monto);
	public abstract void Retirar(Usuario titular, int deCuenta, int monto);

	
}
