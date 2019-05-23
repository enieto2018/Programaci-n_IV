package Turnero;

import java.util.List;

public class Administracion_Turnero {
	
	List<Turno>Llegada;
	AdministrarAsesor administrarAsesor = new AdministrarAsesor();
	AdministrarPrioridad administrarPrioridad =new AdministrarPrioridad();
	AdministrarServicios administrarServicios =new AdministrarServicios();
	AdministrarPuntoAtencion administrarPunto= new AdministrarPuntoAtencion();
	
	public void agregarAsesor(String nombre, int identificacion,boolean estado) {
		administrarAsesor.AgregarAsesor(nombre, identificacion, estado);
	}
	public void agregarServicioAsesor(int identificacion, List<Servicios> servicios) {
		administrarAsesor.agregarServicioAsesor(identificacion, servicios);	
	}                                                         
	public void agregarPrioridad (String nombre) {
		administrarPrioridad.AgregarPrioridad(nombre);
	}
	public void agregarServicio(String nombre) {
		administrarServicios.AgregarServicio(nombre);
	}
	public void agregarPunto(Asesor asesor,boolean disponible) {
		administrarPunto.AgregarPuntoAtencion(asesor, disponible);
	}

}
