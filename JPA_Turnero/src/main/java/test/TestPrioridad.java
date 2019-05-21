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
		
		insertarInicial();
				
		imprimirTodo();
		
	}
	private static void insertarInicial() {
		Prioridad a = new Prioridad("Maria");
		Prioridad b = new Prioridad("Jose");
		Prioridad c = new Prioridad("Perez");
		
		manager.getTransaction().begin();
		manager.persist(a);
		a.setNombre("Jefer");	// Con set se puede reescribir (modificar) la información.
		
		manager.persist(b);
		
		manager.persist(c);
		
		manager.getTransaction().commit();
	}
	@SuppressWarnings("unchecked")
	private static void imprimirTodo() {
		List<Prioridad> prioridad = (List<Prioridad>) manager.createQuery("FROM Prioridad").getResultList();
		System.out.println("En esta Base de Datos hay " + prioridad.size() + " prioridad.");
		for(Prioridad priorid : prioridad) {
			System.out.println(priorid.toString());
		}
	}

}
