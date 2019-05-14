package Test;

import Turnero.Servicios;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Turnero.AdministrarAsesor;
import Turnero.AdministrarPrioridad;
import Turnero.AdministrarServicios;
import Turnero.Prioridad;
 


public class AdministrarTest {
	 @Test
	    public void test_Servicios()
	    {//Este test me permite validar el ingreso de un dato a la lista y verificar que esta en la posicion correcta
		 AdministrarServicios nuevoServicio =new AdministrarServicios();
		 Servicios list= new Servicios();
		 nuevoServicio.AgregarServicio("Ser1");
		 nuevoServicio.AgregarServicio("Ser2");
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
	    public void test_Asesor()
	    {
	    }
	
}