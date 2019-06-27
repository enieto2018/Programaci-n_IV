package modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TABLA_USUARIO")
public class Usuario extends Persona implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public Usuario() {
	}
	
	public Usuario(String identificacion, String nombre) {
		super(identificacion, nombre);
		// TODO Auto-generated constructor stub
	}

}
