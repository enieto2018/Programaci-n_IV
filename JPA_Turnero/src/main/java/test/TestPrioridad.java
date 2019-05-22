package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Prioridad;

public class TestPrioridad {
	//@PersistenceContext(unitName = "Persistencia")
	private static EntityManager manager;
	private static EntityManagerFactory emf;

	
	public static void main(String[] args) {
		// Creando el gestor de Persistencia (EM).
		emf = Persistence.createEntityManagerFactory("Persistencia");
		manager = emf.createEntityManager();
		
		Prioridad p1 = new Prioridad("1");
		Prioridad p2 = new Prioridad("2");
		Prioridad p3 = new Prioridad("3");
		
		manager.getTransaction().begin();
		manager.persist(p1);
		
		manager.persist(p2);
		
		manager.persist(p3);
		
		manager.getTransaction().commit();
		
	
				
		imprimirTodo();
		
	}
	
	
	private static void imprimirTodo() {
		List<Prioridad> prioridad = (List<Prioridad>) manager.createQuery("FROM Prioridad").getResultList();
		System.out.println("En esta Base de Datos hay " + prioridad.size() + " prioridad.");
		for(Prioridad priorid : prioridad) {
			System.out.println(priorid.toString());
		}
	}

}
