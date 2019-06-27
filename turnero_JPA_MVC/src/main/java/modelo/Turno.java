package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TABLA_TURNO")
public class Turno implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@OneToOne (fetch=FetchType.LAZY)
	@JoinColumn (name="USUARIO_ID")
	private Usuario usuario;
	
	@OneToOne (fetch=FetchType.LAZY)
	@JoinColumn (name="SERVICIO")
	private Servicios servicio;
	
	@OneToOne (fetch=FetchType.LAZY)
	@JoinColumn (name="PRIORIDAD")
	private Prioridad prioridad;
	
	@Id
	@Column(name="ID_TURNO")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idTurno;
	
	public Turno() {
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Servicios getServicio() {
		return servicio;
	}
	public void setServicio(Servicios servicio) {
		this.servicio = servicio;
	}
	public Prioridad getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad;
	}
	
	public int getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(int idTurno) {
		this.idTurno = idTurno;
	}

	@Override
	public String toString() {
		return "Turno [usuario=" + usuario + ", servicio=" + servicio + ", prioridad=" + prioridad + ", idTurno="
				+ idTurno + "]";
	}

}
