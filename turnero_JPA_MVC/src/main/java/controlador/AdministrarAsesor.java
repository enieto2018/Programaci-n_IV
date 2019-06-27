package controlador;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Asesor;
import modelo.Servicios;

public class AdministrarAsesor{
	private EntityManagerFactory emf= Persistence.createEntityManagerFactory("persistence");
	private EntityManager manager ; 

	List<Asesor> asesores = new ArrayList<Asesor>();

	public List<Asesor> getAsesores() {
		return asesores;
	}

	public void setAsesores(List<Asesor> asesores) {
		this.asesores = asesores;
	}
	
	public void agregarAsesor(String nombre, String identificacion,boolean estado) {
		Asesor newAsesor= new Asesor(identificacion, nombre, estado);
		asesores.add(newAsesor);
		
		abrirEntityManager();
		
		manager.getTransaction().begin();
		manager.merge(newAsesor);
		manager.getTransaction().commit();
		cerrarEntityManager();
		
	}
	
	//TODO Preguntar por esto
	public void cerrarEntityManager () {
		if(manager.isOpen()) 
			manager.close();			
	}
	
	public void abrirEntityManager () {
		if(manager == null || !manager.isOpen()) 
			manager = emf.createEntityManager();		
	}
	
	
    public Asesor obtenerAsesor(String identificacion) {
    	for(Asesor asesor:asesores) {
			if(identificacion==asesor.getIdentificacion()) {
				return asesor;
			}
    	}
    	return null;
    }
    
    public void listarAsesor() {
    	for(Asesor asesor:asesores) {
			System.out.println(asesor.getNombre()+"-"+asesor.getIdentificacion());
    	}
    	
    }

	public void agregarServicioAsesor(String identificacion, List<Servicios> servicios) {
		for(Asesor asesor:asesores) {
			if(identificacion==asesor.getIdentificacion()) {
				asesor.setServicios(servicios);
			}
				
		}
	}
}