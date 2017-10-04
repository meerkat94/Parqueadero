package dominio;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dominio.reglas.ReglasParqueadero;
import repositorio.RepositorioRecibo;
import repositorio.RepositorioVehiculo;

public class Vigilante {	
	@Autowired
	RepositorioRecibo repositorioRecibo;
	@Autowired
	RepositorioVehiculo repositorioVehiculo;
	private List<ReglasParqueadero> reglasingreso;	
	private Parqueadero parqueadero;

	
	public Vigilante(List<ReglasParqueadero> reglas, Parqueadero parqueadero,RepositorioVehiculo repositorioVehiculo,RepositorioRecibo repositorioRecibo) {
		super();
		this.reglasingreso = reglas;
		this.parqueadero = parqueadero;
		
	}	
	
	public void ingresarUnVehiculo(Vehiculo vehiculo) {		
		Calendar fecha=Calendar.getInstance();		
		for (ReglasParqueadero regla : reglasingreso) {
			 regla.validar(vehiculo,parqueadero);			 
		}
		ReciboDeServicioParqueadero recibo =new ReciboDeServicioParqueadero(vehiculo, fecha);		
		repositorioVehiculo.insertar(vehiculo);
		repositorioRecibo.insertar(recibo);
		
					
	}
	
	

	
	

	


}
