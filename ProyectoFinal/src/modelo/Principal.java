package modelo;

import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * Clase que ejecuta la aplicacion.
 * 
 * @author	Giancarlo Tovar.
 * @author	Daniel Rojas.
 * @author	Javier Baron.
 * 
 * @version	19/05/2016
 */
public class Principal {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Instancia del cajero
		Cajero cajero= new Cajero();
		
		// Instancia del banco.
		Banco banco = new Banco("Banco Central");
		
		// Instancia de usuario 1.
		Usuario titular1 = banco.agregarUsuario("Giancarlo", "Tovar", "1234", 300000);


		// Instancia de usuario 2.
		Usuario titular2 = banco.agregarUsuario("Javier", "Baron", "5678", 200000);

		// Intancia de usuario 3.
		Usuario titular3 = banco.agregarUsuario("Daniel", "Rojas", "0123", 100000);

		
		/*banco.agregarCuenta(corriente);
		banco.agregarCuenta(corriente2);
		banco.agregarCuenta(corriente3);*/
		
		System.out.println("\tCAJEROS EXPRESS\t\n");
		
		int opcion;
		
		// Bucle infinito
		while(true){
			
			// Mostrar lista de usuarios del banco.
			banco.ListaUsuarios(); 
			
			String IDusuario;
			String clave;
			Usuario usuarioAut;

		
			// Mostrar menu de inicio de sesion hasta que el usuario ingrese correctamente.
			do {

				System.out.printf("\n\tBienvenido a %s\n\n", banco.getNombre());
				System.out.print("Digite su ID: ");
				IDusuario =sc.nextLine();
				System.out.print("Digite su clave: ");
				clave = sc.nextLine();
				System.out.println();
				
				usuarioAut = banco.IniciarSesion(IDusuario, clave);
				
				// Mensaje si el usuario no ingreso los datos correctamente.
				if (usuarioAut == null) {
					
					System.out.println("Combinacion de usuario y contraseña incorrecta \n"
										+ "Por favor intentelo de nuevo");
				}

			} while (usuarioAut == null);
			
			do{
				
				do {
					
					usuarioAut.ResumenCuentas();
					
					System.out.println("¿Que desea hacer?\n");
					System.out.println("  1) Mostrar historial de transacciones");
					System.out.println("  2) Retirar");
					System.out.println("  3) Depositar");
					System.out.println("  4) Transferencia");
					System.out.println("  5) Salir");
					System.out.println();
					System.out.print("Digite una opcion: ");
					opcion = sc.nextInt();
					
					if (opcion < 1 || opcion > 5) {
						System.out.println("\nOpcion invalida. Por favor seleccione una opcion (1-5).\n");
					}
		
		
				}while(opcion < 1 || opcion > 5);	// Verificar que la opcion sea valida.
			
				if(opcion == 1){
					
					int cuenta;
					
					// Recibir la cuenta a la que se va imprimir el historial de transacciones.
					do {
						
						System.out.printf("Ingrese el numero (1-%d) de la cuenta para ver su historial: ", usuarioAut.NumCuentas());
						cuenta = sc.nextInt()-1;	//Posicion de la cuenta en la lista de cuentas del usuario.
						
						// Verificar si la cuenta existe en la lista de cuentas del usuario.
						if (cuenta < 0 || cuenta >= usuarioAut.NumCuentas()) {
							
							System.out.println("Cuenta no valida. Intente de nuevo");
						}
						
					} while (cuenta < 0 || cuenta >= usuarioAut.NumCuentas());
					
					// Mostrar el historial de transacciones
					cajero.MostarHistorialConsola(usuarioAut, cuenta);
					
				}
			
				if(opcion == 2){
					
					int deCuenta;
					int monto;
					
					// Recibir la cuenta de la que se va a retirar.
					do{
						
						System.out.printf("Ingrese el numero (1-%d) de la cuenta de la cual va a retirar: ", usuarioAut.NumCuentas());
						deCuenta = sc.nextInt()-1;
						
						// Verificar si la cuenta existe en la lista de cuentas del usuario.
						if(deCuenta<0 || deCuenta>=usuarioAut.NumCuentas()){
							
							System.out.println("Cuenta invalida. Intente de nuevo");
						}
						
					}while(deCuenta<0 || deCuenta >= usuarioAut.NumCuentas());
					

					
					// Recibir el monto a retirar.
					do{
						
						System.out.printf("Ingrese el monto que desea retirar: ");
						monto = sc.nextInt();
						
						// Verificar que no sea una canttidad negativa.
						if(monto<0){
							
							System.out.println("Ingrese un monto mayor que 0\n");
						}
						
					}while(monto<0);
					
					cajero.Retirar(usuarioAut, deCuenta, monto);
				}
				
				if(opcion == 3){
					
					int aCuenta;
					int monto; 
					
					// Recibir la cuenta a la que se va a depositar.
					do{
						
						System.out.printf("Ingrese el numero (1-%d) de la cuenta a la cual va a depositar: ", usuarioAut.NumCuentas());
						aCuenta = sc.nextInt()-1;
						
						// Verificar si la cuenta existe en la lista de existe en la lista de cuentas del usuario.
						if(aCuenta<0 || aCuenta>=usuarioAut.NumCuentas()){
							
							System.out.println("Cuenta invalida. Intente de nuevo");
						}
				
							
					}while(aCuenta<0 || aCuenta >= usuarioAut.NumCuentas());
					
					
					// Recibir el monto que se va a depositar.
					do{
						
						System.out.printf("Ingrese el monto que desea depositar: ");
						monto = sc.nextInt();
						
						if(monto<0){
							
							System.out.println("Ingrese un monto mayor que 0\n");
						}
						
					}while(monto<0);
					
					cajero.Depositar(usuarioAut, aCuenta, monto);
				}
				
				if(opcion == 4){
					
					int deCuenta;
					int aCuenta;
					int pBalance;
					int sBalance;
					int monto;
					
					// Recibir la cuenta salida.
					do{
						usuarioAut.ResumenCuentas();
						System.out.printf("Ingrese el numero (1-%d) de la cuenta desde la que va a transferir: ", usuarioAut.NumCuentas());
						deCuenta = sc.nextInt()-1;
						
						// Verificar si la cuenta existe en la lista de cuentas del usuario.
						if(deCuenta<0 || deCuenta>=usuarioAut.NumCuentas()){
							
							System.out.println("Cuenta invalida. Intente de nuevo");
						}
						
					}while(deCuenta<0 || deCuenta >= usuarioAut.NumCuentas());
					
					
					// Recibir la cuenta destino.
					do{
						
						System.out.printf("Ingrese el numero (1-%d) de la cuenta a la que va a transferir: ", usuarioAut.NumCuentas());
						aCuenta = sc.nextInt()-1;
						
						if(aCuenta<0 || aCuenta>=usuarioAut.NumCuentas()){
							
							System.out.println("Cuenta invalida. Intente de nuevo");
						}
					
					// Verificar si la cuenta existe en la lista de cuentas del usuario.	
					}while(aCuenta<0 || aCuenta >= usuarioAut.NumCuentas());
					

					// Recibir balance de la cuenta salida.
					pBalance = usuarioAut.ConsultarBalance(deCuenta); 
					
					// Recibir balance de la cuenta destino.
					sBalance = usuarioAut.ConsultarBalance(aCuenta); 
					
					// Recibir el monto a transferir.
					do{
						
						System.out.printf("Ingrese el monto que desea transferir (maximo $%d): ", pBalance);
						monto = sc.nextInt();
						
						// Verificar que no sea una cantidad negativa.
						if(monto<=0){
							
							System.out.println("Ingrese un monto mayor que 0\n");
						}
						
						// Verificar que el monto no exceda el maximo.
						else if(monto>pBalance){
							
							System.out.printf("El monto no puede ser mayor a %d\n", pBalance);
						}
					}while(monto<=0 );
					
					cajero.Transferir(usuarioAut, deCuenta, aCuenta, monto);
				}
			
				if(opcion == 5){
					
					sc.nextLine();
				}
				
			}while(opcion!=5); 	// Volver al menu principal.
		}
	}
}
