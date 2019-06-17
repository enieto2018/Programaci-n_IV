package controlador;

import java.util.ArrayList;
import java.util.List;

import modelo.Servicios;

public class AdministrarServicios{
	
	public static List<Servicios> servicios;
	
	public AdministrarServicios() {
		servicios = new ArrayList<Servicios>();
	}
	
	public List<Servicios> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicios> servicios) {
		this.servicios = servicios;
	}

	public void AgregarServicio(String nombre) {
		
		Servicios newServicio= new Servicios();
		newServicio.setNombre(nombre);
		servicios.add(newServicio);
	
	}

}
