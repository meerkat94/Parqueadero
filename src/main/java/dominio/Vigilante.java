package dominio;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dominio.excepcion.ServicioParqueoException;
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
	
	public ReciboDeServicioParqueadero ingresarUnVehiculo(Vehiculo vehiculo) {		
		Calendar fecha=Calendar.getInstance();		
		for (ReglasParqueadero regla : reglasingreso) {
			 regla.validar(vehiculo,parqueadero);			 
		}
		if(vehiculo instanceof Carro){
			 parqueadero.setCapacidadCarros(parqueadero.getCapacidadCarros()-1);			 
		 }
		if(vehiculo instanceof Moto){
			 parqueadero.setCapacidadMotos(parqueadero.getCapacidadMotos()-1);			 
		 }
		
		ReciboDeServicioParqueadero recibo =new ReciboDeServicioParqueadero(vehiculo, fecha);	
		if(repositorioRecibo.obtenerVehiculoEnArqueaderoPorPlaca(vehiculo.getPlaca())==null){		
		repositorioVehiculo.insertar(vehiculo);
		repositorioRecibo.insertar(recibo);		
		return recibo;
		}
		else throw new ServicioParqueoException("El Vehiculo Ya Se Encuetra En El Parqueadero");
			
	
					
	}
	
	

	
	

	


}
