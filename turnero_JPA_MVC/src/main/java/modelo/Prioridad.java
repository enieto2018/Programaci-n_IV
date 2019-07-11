package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TABLA_PRIORIDAD")
public class Prioridad implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID_PRIORIDAD")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idPrioridad;
	
	@Column(name = "NOMBRE")
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

	public Integer getIdPrioridad() {
		return idPrioridad;
	}

	public void setIdPrioridad(Integer idPrioridad) {
		this.idPrioridad = idPrioridad;
	}

	@Override
	public String toString() {
		return "Prioridad [idPrioridad=" + idPrioridad + ", nombre=" + nombre + "]";
	}

	
}
