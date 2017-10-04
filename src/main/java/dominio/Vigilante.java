package dominio;

import java.util.Calendar;
import java.util.List;
import dominio.reglas.ReglasParqueadero;
import repositorio.RepositorioRecibo;
import repositorio.RepositorioVehiculo;

public class Vigilante {	
	private List<ReglasParqueadero> reglasingreso;	
	private Parqueadero parqueadero;

	
	public Vigilante(List<ReglasParqueadero> reglas, Parqueadero parqueadero,RepositorioVehiculo repositorioVehiculo,RepositorioRecibo repositorioRecibo) {
		super();
		this.reglasingreso = reglas;
		this.parqueadero = parqueadero;
		
	}	
	
	public ReciboDeServicioParqueadero ingresarUnVehiculo(Vehiculo vehiculo) {		
		Calendar fecha=Calendar.getInstance();		
		for (ReglasParqueadero regla : reglasingreso) {
			 regla.validar(vehiculo,parqueadero);			 
		}
		return new ReciboDeServicioParqueadero(vehiculo,fecha);
		
		
	}
	
	

	
	

	


}
