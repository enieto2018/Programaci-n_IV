package Test;

import controlador.AdministrarAsesor;
import controlador.AdministrarPrioridad;
import controlador.AdministrarPuntoAtencion;
import controlador.AdministrarServicios;
import modelo.Asesor;
import modelo.Prioridad;
import modelo.PuntoAtencion;
import modelo.Servicios;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
 
public class AdministrarTest {
	 @Test
	    public void test_Servicios()
	    {//Este test me permite validar el ingreso de un dato a la lista y verificar que esta en la posicion correcta
		 AdministrarServicios nuevoServicio =new AdministrarServicios();
		 nuevoServicio.AgregarServicio("Ser1");
		 nuevoServicio.AgregarServicio("Ser2");
		 Servicios list= new Servicios();
		 list=nuevoServicio.getServicios().get(0);
		 assertEquals("Ser1", list.getNombre());
	    }
	 @Test
	    public void test_Prioridad()
	    {//Este test me permite validar el ingreso de un dato a la lista y verificar que esta en la posicion correcta
		 AdministrarPrioridad nuevoPrioridad =new AdministrarPrioridad();
		 Prioridad list= new Prioridad();
		 nuevoPrioridad.AgregarPrioridad("Embarazada");
		 nuevoPrioridad.AgregarPrioridad("Ninguna");
		 nuevoPrioridad.AgregarPrioridad("Tercera Edad");
		 nuevoPrioridad.AgregarPrioridad("Limitaciones Fisicas");
		 list=nuevoPrioridad.getPrioridad().get(0);
		 assertEquals("Embarazada", list.getNombre());
	    }
	 @Test
	 public void test_Asesor(){//Ingresar Asesor
		 AdministrarAsesor nuevoAsesor= new AdministrarAsesor();
		 nuevoAsesor.agregarAsesor("jj", "123",true);
		 Asesor list = nuevoAsesor.getAsesores().get(0);
		 assertEquals("jj",list.getNombre());
		  
		 List<Servicios> servicios =new ArrayList<Servicios>();
		 Servicios servicio = new Servicios();
	     Servicios servicio1 = new Servicios();
		 servicio.setNombre("Ser1");
		 servicio1.setNombre("Ser2");
		 servicios.add(servicio);
		 servicios.add(servicio1);
		
		 nuevoAsesor.agregarServicioAsesor("123", servicios); 
	 }
	 @Test
	    public void test_PuntoAtencion()
	    {
		 AdministrarPuntoAtencion nuevoPunto= new AdministrarPuntoAtencion();
		 AdministrarAsesor nuevoAsesor= new AdministrarAsesor();
		 nuevoAsesor.agregarAsesor("jj", "123",true);
		 nuevoPunto.AgregarPuntoAtencion(nuevoAsesor.getAsesores().get(0), true);
	    }
	
}