package Modelo;

public class ConversorEuros {
	private double cambio;

	public ConversorEuros(double valorCambio) {
		this.cambio = valorCambio;
	}

	public double eurosAmoneda(double cantidad) {
		return this.cambio * cantidad;
	}

	public double monedaAeuros(double cantidad) {
		return cantidad / this.cambio;
	}

}
