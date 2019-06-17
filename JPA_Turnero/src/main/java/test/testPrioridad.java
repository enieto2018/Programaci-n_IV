package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Prioridad;

public class testPrioridad {
	
	private static EntityManager manager;
	private static EntityManagerFactory emf;

	public static void main(String[] args) {
		/* Crear el gestor de persistencia */
		emf = Persistence.createEntityManagerFactory("persistence");
		manager = emf.createEntityManager();
		
		Prioridad p = new Prioridad("1");
		Prioridad p1 = new Prioridad("2");
		Prioridad p2 = new Prioridad("3");
		
		manager.getTransaction().begin();
		manager.persist(p);
		manager.persist(p1);
		manager.persist(p2);
		manager.getTransaction().commit();
		
		

		imprimirTodo();
	}

	private static void imprimirTodo() {
		List<Prioridad> prioridad = (List<Prioridad>) manager.createQuery("FROM Prioridad").getResultList();
		System.out.print("HOY " + prioridad.size() + "prioridades en el sistema \n");
		for (Prioridad pri : prioridad) {
			System.out.print(pri.toString()+"\n");
		}
	}

}
