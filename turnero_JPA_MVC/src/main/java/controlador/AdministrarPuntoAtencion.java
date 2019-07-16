package controlador;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Asesor;
import modelo.Prioridad;
import modelo.PuntoAtencion;

public class AdministrarPuntoAtencion {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
	private EntityManager manager;

	List<PuntoAtencion> listaPuntoAtencion;

	public List<PuntoAtencion> getListaPuntoAtencion() {
		return listaPuntoAtencion;
	}

	public void setListaPuntoAtencion(List<PuntoAtencion> listaPuntoAtencion) {
		this.listaPuntoAtencion = listaPuntoAtencion;
	}

	public AdministrarPuntoAtencion() {
		listaPuntoAtencion = new ArrayList<PuntoAtencion>();
	}

	public void AgregarPuntoAtencion(Asesor asesor, boolean disponible, String nombre) {
		if (listaPuntoAtencion.size() <= 10) {
			PuntoAtencion newPuntoAte = new PuntoAtencion();
			newPuntoAte.setAsesor(asesor);
			newPuntoAte.setNombre(nombre);
			newPuntoAte.setDisponible(disponible);
			
			abrirEntityManager();
			manager.getTransaction().begin();
			manager.merge(newPuntoAte);
			manager.getTransaction().commit();
			cerrarEntityManager();

		}
	}
	
	public List<PuntoAtencion> listarPuntosAtencion() {
		abrirEntityManager();
		List<PuntoAtencion> listaPuntoAtencion = (List<PuntoAtencion>) manager.createQuery("FROM PuntoAtencion").getResultList();
		cerrarEntityManager();
		
		return listaPuntoAtencion;
	}

	public void cerrarEntityManager() {
		if (manager.isOpen())
			manager.close();
	}

	public void abrirEntityManager() {
		if (manager == null || !manager.isOpen())
			manager = emf.createEntityManager();
	}
	
	
	public void actualizarPuntoAtencion(PuntoAtencion puntoAtencion) {
		abrirEntityManager();
		manager.getTransaction().begin();
		manager.merge(puntoAtencion);
		manager.getTransaction().commit();
		cerrarEntityManager();
	}
	
	
	public void eliminarPuntoAtencion(Integer idPuntoAtencion) {
		abrirEntityManager();
		manager.getTransaction().begin();
		PuntoAtencion puntoAtencion = manager.find(PuntoAtencion.class, idPuntoAtencion);
		manager.remove(puntoAtencion);
		manager.getTransaction().commit();
		cerrarEntityManager();
	}
}
