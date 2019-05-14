package Turnero;


public class Asesor extends Persona{
	
    public Asesor(int identificacion, String nombre, boolean estado) {
		super(identificacion, nombre);
		this.estado = estado;
	}

	private boolean estado ;
	
		
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}