package Turnero;

public class Persona {
	protected int identificacion;
	protected String nombre;
	
	public Persona(int identificacion, String nombre) {
		this.identificacion = identificacion;
		this.nombre = nombre;
	}

	public int getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}