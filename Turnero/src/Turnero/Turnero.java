package Turnero;

import java.util.ArrayList;
import java.util.List;

public class Turnero {
	
	List<Turno>listaLlegada = new ArrayList<Turno>();
	
	public void enturnar(int identificacion,String nombre,Servicios servicio,Prioridad prioridad) {
		List<Servicios> listaServicios = AdministrarServicios.servicios;
		
		Turno turno =new Turno();
		turno.setUsuario(new Usuario(identificacion, nombre));
		turno.setServicio(servicio);
		turno.setPrioridad(prioridad);
		
		listaLlegada.add(turno);
		
		for(Servicios serv:listaServicios) {
			if(serv.getNombre().equals(servicio.getNombre())){
				serv.getTurnos().add(turno);
			}
			
		}
		
		
	}

}
