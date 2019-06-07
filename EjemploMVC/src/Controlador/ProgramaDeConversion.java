package Controlador;

import Modelo.ConversorEurosPesetas;
import Vista.InterfazVista;
import Vista.VentanaConversor;

public class ProgramaDeConversion {
	public static void main(String[] args) {

		ConversorEurosPesetas modelo = new ConversorEurosPesetas();

		InterfazVista vista = new VentanaConversor();

		ControlConversor control = new ControlConversor(vista, modelo);

		vista.setControlador(control);

		vista.arranca();
	}
}
