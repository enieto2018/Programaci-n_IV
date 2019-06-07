package Turnero;

import java.util.ArrayList;
import java.util.List;

public class Turnero {
	
	List<Turno>listaLlegada;
	List<Turno>listaAtendidos;
	List<Servicios> listaServicios;
	
	public Turnero() {
		listaLlegada = new ArrayList<Turno>();
		listaAtendidos = new ArrayList<Turno>();
		listaServicios = AdministrarServicios.servicios;
	}
	
	public void enturnar(String identificacion,String nombre,Servicios servicio,Prioridad prioridad) {

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
	
	public void atender(String identificacion) {
		listaServicios = AdministrarServicios.servicios;
		
		
	}

}
