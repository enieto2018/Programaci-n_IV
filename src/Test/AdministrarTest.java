package Test;

import Turnero.Servicios;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import Turnero.AdministrarAsesor;
import Turnero.AdministrarPrioridad;
import Turnero.AdministrarPuntoAtencion;
import Turnero.AdministrarServicios;
import Turnero.Asesor;
import Turnero.Prioridad;
import Turnero.PuntoAtencion;
 
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
		 nuevoAsesor.AgregarAsesor("jj", 123,true);
		 Asesor list=new Asesor(0, null, false);
		 list=nuevoAsesor.getAsesores().get(0);
		 assertEquals("jj",list.getNombre());
		 //Agregar Servicio Asesor
		 AdministrarServicios nuevoServicio =new AdministrarServicios();
		 nuevoServicio.AgregarServicio("Ser1");
		 nuevoServicio.AgregarServicio("Ser2");
		
	 }
	 @Test
	    public void test_PuntoAtencion()
	    {
		 AdministrarPuntoAtencion nuevoPunto= new AdministrarPuntoAtencion(null, false);
		 PuntoAtencion list=new PuntoAtencion();
		/* nuevoPunto.AgregarPuntoAtencion(asesor, true);
		 list=nuevoPunto.getPuntoAtencion().
		 assertEquals("jj",list.getNombre());*/
	    }
	
}