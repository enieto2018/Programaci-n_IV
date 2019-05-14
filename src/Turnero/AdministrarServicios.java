package Turnero;

import java.util.ArrayList;
import java.util.List;

public class AdministrarServicios{
	
	List<Servicios> Servicios;
	

	public AdministrarServicios() {
		Servicios = new ArrayList<Servicios>();
	}
	
	public List<Servicios> getServicios() {
		return Servicios;
	}

	public void setServicios(List<Servicios> servicios) {
		Servicios = servicios;
	}

	public void AgregarServicio(String nombre) {
		
	Servicios newServicio= new Servicios();
	newServicio.setNombre(nombre);
	Servicios.add(newServicio);
	
	}

}
