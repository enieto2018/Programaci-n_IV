package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "TABLA_SERVICIOS")
public class Servicios implements Serializable {
	
	private static final long serialVersionUID = 1L; 
	
	@Id
	@Column (name ="ID_SERVICIO")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idServicio;
	
	
	@Column (name ="NOMBRE")
	private String nombre;
	
	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn (name="ASESOR_ID")
	private Asesor asesor;
	
	public Servicios() {
	}

	@OneToMany (mappedBy="servicio")
	List<Turno>turnos=new ArrayList<Turno>();
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Asesor getAsesor() {
		return asesor;
	}

	public void setAsesor(Asesor asesor) {
		this.asesor = asesor;
	}

	public List<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}
	
	
	public Integer getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}

	@Override
	public String toString() {
		return "Servicios [nombre=" + nombre + ", asesor=" + asesor + "]";
	}

}
