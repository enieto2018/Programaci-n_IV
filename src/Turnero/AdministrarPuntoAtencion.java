package Turnero;

import java.util.ArrayList;
import java.util.List;

public class AdministrarPuntoAtencion 
{
	List<PuntoAtencion> PuntoAtencion;
	
	

	public AdministrarPuntoAtencion(Asesor asesor,boolean disponible) {
				PuntoAtencion = new ArrayList<PuntoAtencion>();
	}

	public List<PuntoAtencion> getPuntoAtencion() {
		return PuntoAtencion;
	}

	public void setPuntoAtencion(List<PuntoAtencion> puntoAtencion) {
		PuntoAtencion = puntoAtencion;
	}
	
	public void AgregarPuntoAtencion(Asesor asesor,boolean disponible) {
		PuntoAtencion newPuntoAte=new PuntoAtencion();
		PuntoAtencion.add(newPuntoAte);
	}

}
