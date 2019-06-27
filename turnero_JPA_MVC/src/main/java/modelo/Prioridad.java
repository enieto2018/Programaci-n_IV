package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TABLA_PRIORIDAD")
public class Prioridad implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "NOMBRE")
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Prioridad [nombre=" + nombre + "]";
	}
	
	
}
