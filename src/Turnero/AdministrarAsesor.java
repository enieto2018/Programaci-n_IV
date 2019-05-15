package Turnero;

import java.util.ArrayList;
import java.util.List;

public class AdministrarAsesor extends Asesor{
	

	List<Asesor> Asesor;

	
	public AdministrarAsesor(int identificacion, String nombre, boolean estado) {
		super(identificacion, nombre, estado);
		Asesor = new ArrayList<Asesor>();
	}

	public List<Asesor> getAsesor() {
		return Asesor;
	}

	public void setAsesor(List<Asesor> asesor) {
		Asesor = asesor;
	}
	
	public void AgregarAsesor(String nombre, int identificacion,boolean estado) {
		Asesor newAsesor= new Asesor(identificacion, nombre, estado);
		Asesor.add(newAsesor);

}
}