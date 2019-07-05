package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TABLA_ASESOR")
public class Asesor extends Persona implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column (name ="ESTADO")
	private boolean estado;
	
	@OneToMany (mappedBy="asesor",cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	List<Servicios> Servicios = new ArrayList<Servicios>();

	public Asesor() {
	}
	
    public Asesor(String identificacion, String nombre, boolean estado) {
		super(identificacion, nombre);
		this.estado = estado;
	}

	public List<Servicios> getServicios() {
		return Servicios;
	}

	public void setServicios(List<Servicios> servicios) {
		Servicios = servicios;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Asesor [estado=" + estado + ", Servicios=" + Servicios + ", identificacion=" + identificacion
				+ ", nombre=" + nombre + "]";
	}

	
	
	
}