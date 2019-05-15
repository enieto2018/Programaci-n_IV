package Turnero;

import java.util.List;

public class Turnero {
	
	List<Turno>Llegada;
	AdministrarAsesor administrarAsesor = new AdministrarAsesor();
	
	
	public void agregarAsesor(String nombre, int identificacion,boolean estado) {
		administrarAsesor.AgregarAsesor(nombre, identificacion, estado);
	}
	
	public void agregarServicioAsesor() {
		
	}
	
	

}
