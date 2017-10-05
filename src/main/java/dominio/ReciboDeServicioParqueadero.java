package dominio;

import java.util.Calendar;

public class ReciboDeServicioParqueadero {
	private Vehiculo vehiculo;
	private Calendar fechaingreso;
	private Calendar fechaegreso;
	private double valor;
	
	
	
	public ReciboDeServicioParqueadero(Vehiculo vehiculo, Calendar fechaingreso) {
		super();
		this.vehiculo = vehiculo;
		this.fechaingreso = fechaingreso;
		
	}
	
	public ReciboDeServicioParqueadero(Vehiculo vehiculo, Calendar fechaingreso, Calendar fechaegreso, double valor) {
		super();
		this.vehiculo = vehiculo;
		this.fechaingreso = fechaingreso;
		this.fechaegreso = fechaegreso;
		this.valor = valor;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public Calendar getFechaingreso() {
		return fechaingreso;
	}
	public Calendar getFechaegreso() {
		return fechaegreso;
	}
	public double getValor() {
		return valor;
	}



	
	
}
