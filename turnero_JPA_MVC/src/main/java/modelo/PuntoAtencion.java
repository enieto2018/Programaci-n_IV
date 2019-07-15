package modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "TABLA_PUNTO_ATENCION")
public class PuntoAtencion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "IDENTIFICACION")
	Asesor asesor;
	
	@Column(name = "DISPONIBLE")
	private boolean disponible ;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	public Asesor getAsesor() {
		return asesor;
	}
	public void setAsesor(Asesor asesor) {
		this.asesor = asesor;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "PuntoAtencion [id=" + id + ", asesor=" + asesor + ", disponible=" + disponible + ", nombre=" + nombre
				+ "]";
	}
	
		
	}
