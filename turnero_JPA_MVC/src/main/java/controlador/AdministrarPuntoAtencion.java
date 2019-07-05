package controlador;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Asesor;
import modelo.PuntoAtencion;

public class AdministrarPuntoAtencion 
{
	private EntityManagerFactory emf= Persistence.createEntityManagerFactory("persistence");
	private EntityManager manager ; 
	
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
	public void AgregarPuntoAtencion(Asesor asesor,boolean disponible, String nombre) {
		if (listaPuntoAtencion.size()<=10) {
			PuntoAtencion newPuntoAte=new PuntoAtencion();
			newPuntoAte.setAsesor(asesor);
			listaPuntoAtencion.add(newPuntoAte);
			
			abrirEntityManager();
			
			manager.getTransaction().begin();
			manager.merge(newPuntoAte);
			manager.getTransaction().commit();
			cerrarEntityManager();
			
		}
	}
		
		public void cerrarEntityManager () {
			if(manager.isOpen()) 
				manager.close();			
		}
		
		public void abrirEntityManager () {
			if(manager == null || !manager.isOpen()) 
				manager = emf.createEntityManager();		
		}
}
