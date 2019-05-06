package Turnero;

import java.util.List;

public class Asesor {
	
	private boolean estado ;
	List<Servicios> Servicios;
	
	

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public List<Servicios> getServicios() {
		return Servicios;
	}

	public void setServicios(List<Servicios> servicios) {
		Servicios = servicios;
	}
	
	

}
