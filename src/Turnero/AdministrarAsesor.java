package Turnero;

import java.util.ArrayList;
import java.util.List;

public class AdministrarAsesor{
	

	List<Asesor> asesores = new ArrayList<Asesor>();

	
//	public AdministrarAsesor(int identificacion, String nombre, boolean estado) {
//		super(identificacion, nombre, estado);
//	}

	
	
	public void AgregarAsesor(String nombre, int identificacion,boolean estado) {
		Asesor newAsesor= new Asesor(identificacion, nombre, estado);
		asesores.add(newAsesor);
	}
	
	public List<Asesor> getAsesores() {
		return asesores;
	}

	public void setAsesores(List<Asesor> asesores) {
		this.asesores = asesores;
	}

	public void agregarServicioAsesor(int identificacion, List<Servicios> servicios) {
		for(Asesor asesor:asesores) {
			if(identificacion==asesor.getIdentificacion()) {
				
			}
				
		}
	}
}