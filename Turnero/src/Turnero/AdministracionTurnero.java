package Turnero;

import java.util.List;

public class AdministracionTurnero {

	
	AdministrarAsesor administrarAsesor = new AdministrarAsesor();
	AdministrarPrioridad administrarPrioridad =new AdministrarPrioridad();
	public static AdministrarServicios administrarServicios =new AdministrarServicios();
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
	
	
	public AdministrarAsesor getAdministrarAsesor() {
		return administrarAsesor;
	}
	public void setAdministrarAsesor(AdministrarAsesor administrarAsesor) {
		this.administrarAsesor = administrarAsesor;
	}
	public AdministrarPrioridad getAdministrarPrioridad() {
		return administrarPrioridad;
	}
	public void setAdministrarPrioridad(AdministrarPrioridad administrarPrioridad) {
		this.administrarPrioridad = administrarPrioridad;
	}
	public AdministrarServicios getAdministrarServicios() {
		return administrarServicios;
	}
	public void setAdministrarServicios(AdministrarServicios administrarServicios) {
		this.administrarServicios = administrarServicios;
	}
	public AdministrarPuntoAtencion getAdministrarPunto() {
		return administrarPunto;
	}
	public void setAdministrarPunto(AdministrarPuntoAtencion administrarPunto) {
		this.administrarPunto = administrarPunto;
	}
	
	

}
