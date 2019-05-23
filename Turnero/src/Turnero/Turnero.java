package Turnero;

import java.util.List;

public class Turnero {
	
	public void enturnar(int identificacion,String nombre,Servicios servicio,Prioridad prioridad) {
		
		Turno turno =new Turno();
		turno.setUsuario(new Usuario(identificacion, nombre));
		
		
	}

}
