package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class PuntoAtencion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID")
	int id;
	
	Asesor asesor;
	
	@Column(name = "DISPONIBLE")
	private boolean disponible ;
	
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
		
	}
