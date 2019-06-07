package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.ConversorEurosPesetas;
import Vista.InterfazVista;

public class ControlConversor implements ActionListener {
	public InterfazVista vista;
	public ConversorEurosPesetas modelo;

	public ControlConversor(InterfazVista vista, ConversorEurosPesetas modelo) {
		this.vista = vista;
		this.modelo = modelo;
	}

	public void actionPerformed(ActionEvent evento) {
		double cantidad = vista.getCantidad();
		if (evento.getActionCommand().equals(InterfazVista.AEUROS)) {
			vista.escribeCambio(cantidad + " pesetas son: " + modelo.pesetasAeuros(cantidad) + " euros");
		} else if (evento.getActionCommand().equals(InterfazVista.APESETAS)) {
			vista.escribeCambio(cantidad + " euros son: " + modelo.eurosApesetas(cantidad) + " pesetas");
		} else
			vista.escribeCambio("ERROR");
	}
}
