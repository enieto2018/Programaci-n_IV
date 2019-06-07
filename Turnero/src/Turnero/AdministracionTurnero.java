package Turnero;

import java.util.List;

import controlador.AdministrarAsesor;
import modelo.Asesor;

public class AdministracionTurnero {

	
	AdministrarAsesor administrarAsesor = new AdministrarAsesor();
	AdministrarPrioridad administrarPrioridad =new AdministrarPrioridad();
	public static AdministrarServicios administrarServicios =new AdministrarServicios();
	AdministrarPuntoAtencion administrarPunto= new AdministrarPuntoAtencion();
	Turnero administrarTurno= new Turnero ();
	
	public void agregarAsesor(String nombre, String identificacion,boolean estado) {
		administrarAsesor.agregarAsesor(nombre, identificacion, estado);
	}
	public void agregarServicioAsesor(String identificacion, List<Servicios> servicios) {
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
	public void enturnar(String identificacion,String nombre,Servicios servicio,Prioridad prioridad) {
		administrarTurno.enturnar(identificacion, nombre, servicio, prioridad);
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
	public Turnero getAdministrarTurno() {
		return administrarTurno;
	}
	public void setAdministrarTurno(Turnero administrarTurno) {
		this.administrarTurno = administrarTurno;
	}
	
	

}
