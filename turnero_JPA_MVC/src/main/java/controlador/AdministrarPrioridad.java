package controlador;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Prioridad;

public class AdministrarPrioridad {
	
	List<Prioridad> Prioridad;
	
	private EntityManagerFactory emf= Persistence.createEntityManagerFactory("persistence");
	private EntityManager manager ; 
	
	public AdministrarPrioridad() {
		Prioridad = new ArrayList<Prioridad>();
	}

	public List<Prioridad> getPrioridad() {
		return Prioridad;
	}

	public void setPrioridad(List<Prioridad> prioridad) {
		Prioridad = prioridad;
	}


	public void AgregarPrioridad(String nombre) {
		Prioridad newPrioridad= new Prioridad();
		newPrioridad.setNombre(nombre);
		Prioridad.add(newPrioridad);
		 
		abrirEntityManager();
		
		manager.getTransaction().begin();
		manager.merge(newPrioridad);
		manager.getTransaction().commit();
		cerrarEntityManager();
		
	}
	public void cerrarEntityManager () {
		if(manager.isOpen()) 
			manager.close();			
	}
	
	public void abrirEntityManager () {
		if(manager == null || !manager.isOpen()) 
			manager = emf.createEntityManager();		
	}
	
	public void listarPrioridades() {
		abrirEntityManager();
		List<Prioridad> prioridad = (List<Prioridad>) manager.createQuery("FROM Prioridad").getResultList();
		
		for (Prioridad pri : prioridad) {
			System.out.print(pri.getNombre()+"\n");
		}
		System.out.println("Total Prioridades: " + prioridad.size());
		
		cerrarEntityManager();
	}
	
	
	public Prioridad obtenerPrioridad(String nombre) {
		List<Prioridad> listaPrioridad = (List<Prioridad>) manager.createQuery("FROM Prioridad").getResultList();
		for (Prioridad pri : listaPrioridad) {
			if(nombre.equals(pri.getNombre())) {
				return pri;
			}
		}
		return null;
	}
}
