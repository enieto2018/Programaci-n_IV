package controlador;

import java.util.ArrayList;
import java.util.List;

import modelo.Asesor;
import modelo.Servicios;

public class AdministrarAsesor{
	

	List<Asesor> asesores = new ArrayList<Asesor>();

	public List<Asesor> getAsesores() {
		return asesores;
	}

	public void setAsesores(List<Asesor> asesores) {
		this.asesores = asesores;
	}
	
	public void agregarAsesor(String nombre, String identificacion,boolean estado) {
		Asesor newAsesor= new Asesor(identificacion, nombre, estado);
		asesores.add(newAsesor);
	}
	
    public Asesor obtenerAsesor(String identificacion) {
    	for(Asesor asesor:asesores) {
			if(identificacion==asesor.getIdentificacion()) {
				return asesor;
			}
    	}
    	return null;
    }
    
    public void listarAsesor() {
    	for(Asesor asesor:asesores) {
			System.out.println(asesor.getNombre()+"-"+asesor.getIdentificacion());
    	}
    	
    }

	public void agregarServicioAsesor(String identificacion, List<Servicios> servicios) {
		for(Asesor asesor:asesores) {
			if(identificacion==asesor.getIdentificacion()) {
				asesor.setServicios(servicios);
			}
				
		}
	}
}