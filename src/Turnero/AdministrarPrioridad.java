package Turnero;

import java.util.ArrayList;
import java.util.List;

public class AdministrarPrioridad {
	
	List<Prioridad> Prioridad;
	
	public AdministrarPrioridad() {
		Prioridad = new ArrayList<Prioridad>();
	}

	public List<Prioridad> getPrioridad() {
		return Prioridad;
	}

	public void setPrioridad(List<Prioridad> prioridad) {
		Prioridad = prioridad;
	}

	public void AgregarPrioridad(String nombre) {
		//Servicios newServicio= new Servicios();
		Prioridad newPrioridad= new Prioridad();
		newPrioridad.setNombre(nombre);
		Prioridad.add(newPrioridad);
		
		
	}
}
