package dominio;

import java.util.Calendar;
import java.util.List;
import dominio.reglas.ReglasParqueadero;

public class Vigilante {	
	private List<ReglasParqueadero> reglasingreso;
	private List<ReglasParqueadero> reglasegreso;
	private Parqueadero parqueadero;

	
	public Vigilante(List<ReglasParqueadero> reglas, Parqueadero parqueadero) {
		super();
		this.reglasingreso = reglas;
		this.parqueadero = parqueadero;
	}

	
	public Vigilante(List<ReglasParqueadero> reglasingreso, List<ReglasParqueadero> reglasegreso,
			Parqueadero parqueadero) {
		super();
		this.reglasingreso = reglasingreso;
		this.reglasegreso = reglasegreso;
		this.parqueadero = parqueadero;
	}

	public boolean esUnCarro(Vehiculo vehiculo) {
		return(vehiculo instanceof Carro);			
	}

	public boolean esUnaMoto(Vehiculo vehiculo) {
		return(vehiculo instanceof Moto);
	}

	
	public ReciboDeServicioParqueadero ingresarUnVehiculo(Vehiculo vehiculo) {		
		Calendar fecha=Calendar.getInstance();		
		for (ReglasParqueadero regla : reglasingreso) {
			 regla.validar(vehiculo,parqueadero);			 
		}
		return new ReciboDeServicioParqueadero(vehiculo,fecha);
		
		
	}
	
	

	
	

	


}
