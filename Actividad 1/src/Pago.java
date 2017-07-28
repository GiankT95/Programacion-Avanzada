
public abstract class Pago {

	private int monto;
	
	public Pago(){
		
	}
	
	public Pago(int pMonto){
		
		this.monto = pMonto;
	}

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}
	
}

