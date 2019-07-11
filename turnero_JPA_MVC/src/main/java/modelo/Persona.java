package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@MappedSuperclass
public class Persona implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "IDENTIFICACION")
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected  String identificacion;
	
	@Column(name = "NOMBRE")
	protected  String nombre;
	
	public Persona() {
	}
	
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


	@Override
	public String toString() {
		return "Persona [identificacion=" + identificacion + ", nombre=" + nombre + "]";
	}
	
	

}