package modelo;

import java.util.ArrayList;
import java.util.List;

public class Servicios {
	
	private String nombre;
	
	List<Turno>turnos=new ArrayList<Turno>();
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}

	
}
