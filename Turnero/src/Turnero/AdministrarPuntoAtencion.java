package Turnero;

import java.util.ArrayList;
import java.util.List;

public class AdministrarPuntoAtencion 
{
	List<PuntoAtencion> listaPuntoAtencion;
	
	public List<PuntoAtencion> getListaPuntoAtencion() {
		return listaPuntoAtencion;
	}



	public void setListaPuntoAtencion(List<PuntoAtencion> listaPuntoAtencion) {
		this.listaPuntoAtencion = listaPuntoAtencion;
	}



	public AdministrarPuntoAtencion() {
		listaPuntoAtencion = new ArrayList<PuntoAtencion>();
	}


	
	public void AgregarPuntoAtencion(Asesor asesor,boolean disponible) {
		if (listaPuntoAtencion.size()<=10) {
			PuntoAtencion newPuntoAte=new PuntoAtencion();
			newPuntoAte.setAsesor(asesor);
			listaPuntoAtencion.add(newPuntoAte);
		}
	}
	
	
}
