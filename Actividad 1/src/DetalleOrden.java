
public class DetalleOrden {

	private int cantidad;
	private String estadoInteres;
	
	public DetalleOrden(){
		
	}
	
	public DetalleOrden(int pCantidad, String pEstadoInteres){
		
		this.cantidad = pCantidad;
		this.estadoInteres = pEstadoInteres;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getEstadoInteres() {
		return estadoInteres;
	}

	public void setEstadoInteres(String estadoInteres) {
		this.estadoInteres = estadoInteres;
	}
	
	
}
