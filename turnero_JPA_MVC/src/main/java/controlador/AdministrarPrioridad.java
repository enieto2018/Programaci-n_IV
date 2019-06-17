package controlador;

import java.util.ArrayList;
import java.util.List;

import modelo.Prioridad;

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
		Prioridad newPrioridad= new Prioridad();
		newPrioridad.setNombre(nombre);
		Prioridad.add(newPrioridad);
		
		
	}
}
