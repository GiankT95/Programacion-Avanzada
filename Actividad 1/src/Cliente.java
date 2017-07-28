import java.util.ArrayList;


public class Cliente {

	private String nombre;
	private String direccion;
	private ArrayList<Orden> ordenes;
	
	public Cliente(){
		
	}
	
	public Cliente(String pNombre, String pDireccion){
		
		this.nombre = pNombre;
		this.direccion = pDireccion;
		ordenes = new ArrayList<Orden>();
		
	}
	
	public Cliente(String pNombre, String pDireccion, ArrayList<Orden> listaOrdenes){
		
		this.nombre = pNombre;
		this.direccion = pDireccion;
		ordenes = listaOrdenes;
		
	}
	
	public void AgregarOrden(Orden orden){
		
		this.ordenes.add(orden);
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
}
