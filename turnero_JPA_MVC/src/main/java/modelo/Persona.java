package modelo;

public class Persona {
	
	protected  String identificacion;
	protected  String nombre;
	
	public Persona(String identificacion, String nombre) {
		this.identificacion = identificacion;
		this.nombre = nombre;
	}

	
	public String getIdentificacion() {
		return identificacion;
	}


	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}