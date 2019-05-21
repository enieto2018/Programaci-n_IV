package Turnero;

import java.util.ArrayList;
import java.util.List;

public class Asesor extends Persona{
	
	private boolean estado;
	List<Servicios> Servicios = new ArrayList<Servicios>();
	
    public Asesor(int identificacion, String nombre, boolean estado) {
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
}