package controlador;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Prioridad;

public class AdministrarPrioridad {
	
	List<Prioridad> Prioridad;
	private EntityManager manager;
	private EntityManagerFactory emf;
	
	public AdministrarPrioridad() {
		Prioridad = new ArrayList<Prioridad>();
		emf = Persistence.createEntityManagerFactory("persistence");
		manager = emf.createEntityManager();
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
		
		manager.getTransaction().begin();
		manager.persist(newPrioridad);
		manager.getTransaction().commit();
	}
	
	public void listarPrioridades() {
		List<Prioridad> prioridad = (List<Prioridad>) manager.createQuery("FROM Prioridad").getResultList();
		
		for (Prioridad pri : prioridad) {
			System.out.print(pri.getNombre()+"\n");
		}
		System.out.println("Total Prioridades: " + prioridad.size());
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
