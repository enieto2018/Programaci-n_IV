package Turnero;

import java.util.ArrayList;
import java.util.List;

public class AdministrarAsesor{
	

	List<Asesor> asesores = new ArrayList<Asesor>();

	public List<Asesor> getAsesores() {
		return asesores;
	}

	public void setAsesores(List<Asesor> asesores) {
		this.asesores = asesores;
	}
	
	public void AgregarAsesor(String nombre, int identificacion,boolean estado) {
		Asesor newAsesor= new Asesor(identificacion, nombre, estado);
		asesores.add(newAsesor);
	}
	
    public Asesor ObtenerAsesor(int identificacion) {
    	for(Asesor asesor:asesores) {
			if(identificacion==asesor.getIdentificacion()) {
				return asesor;
			}
    	}
    	return null;
    }

	public void agregarServicioAsesor(int identificacion, List<Servicios> servicios) {
		for(Asesor asesor:asesores) {
			if(identificacion==asesor.getIdentificacion()) {
				asesor.setServicios(servicios);
			}
				
		}
	}
}