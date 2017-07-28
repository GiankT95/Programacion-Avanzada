
public class Cheque extends Pago{

	private String nombre;
	private String idBanco;
	
	public Cheque(){
		
	}
	
	public Cheque(String pNombre, String pIDbanco){
		
		this.nombre = pNombre;
		this.idBanco = pIDbanco;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdBanco() {
		return idBanco;
	}

	public void setIdBanco(String idBanco) {
		this.idBanco = idBanco;
	}
	
	
	
}
