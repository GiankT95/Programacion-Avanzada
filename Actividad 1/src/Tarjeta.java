
public class Tarjeta extends Pago{

	private String numTarjeta;
	private String tipo;
	private String fechaExp;
	
	public Tarjeta(){
		
	}
	
	public Tarjeta(String pNumTarjeta, String pTipo, String pFechaExp){
		
		this.numTarjeta = pNumTarjeta;
		this.tipo = pTipo;
		this.fechaExp = pFechaExp;
		
	}

	public String getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFechaExp() {
		return fechaExp;
	}

	public void setFechaExp(String fechaExp) {
		this.fechaExp = fechaExp;
	}
	
	
	
}
