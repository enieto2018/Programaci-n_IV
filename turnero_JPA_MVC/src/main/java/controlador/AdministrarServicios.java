package controlador;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Servicios;

public class AdministrarServicios{
	
	public static List<Servicios> servicios;

	private EntityManagerFactory emf= Persistence.createEntityManagerFactory("persistence");
	private EntityManager manager ; 
	
	public AdministrarServicios() {
		servicios = new ArrayList<Servicios>();
	}
	
	public List<Servicios> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicios> servicios) {
		this.servicios = servicios;
	}

	public void AgregarServicio(String nombre) {
		
		Servicios newServicio= new Servicios();
		newServicio.setNombre(nombre);
		servicios.add(newServicio);
		
		abrirEntityManager();
		
		manager.getTransaction().begin();
		manager.merge(newServicio);
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
	
	
	

}
