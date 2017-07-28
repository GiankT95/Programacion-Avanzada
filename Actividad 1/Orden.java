import java.util.ArrayList;


public class Orden {

	private String fecha;
	private String estado;
	private ArrayList<DetalleOrden> listaDetalles;
	
	public Orden(){
		
	}
	
	public Orden(String pFecha, String pEstado){
		
		this.fecha = pFecha;
		this.estado = pEstado;
	}
	
	public int calcInteres(int pInteres){
		
		return pInteres;
		
	}
	
	public int calcTotal(int pTotal){
		
		return pTotal;
		
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
