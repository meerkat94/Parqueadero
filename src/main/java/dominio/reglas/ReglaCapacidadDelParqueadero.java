package dominio.reglas;


import dominio.Carro;
import dominio.Moto;
import dominio.Parqueadero;
import dominio.Vehiculo;
import dominio.excepcion.ServicioParqueoException;

public class ReglaCapacidadDelParqueadero implements ReglasParqueadero {

	@Override
	public boolean validar(Vehiculo vehiculo, Parqueadero parqueadero) {		
		if(vehiculo instanceof Carro && parqueadero.getCapacidadCarros()==0){
			throw new ServicioParqueoException("No Hay Capacidad Para carros");			
		}
		else if(vehiculo instanceof Moto && parqueadero.getCapacidadMotos()==0){
			throw new ServicioParqueoException("No Hay Capacidad Para Motos");
		}	
		
		return true;
	}

	

}
