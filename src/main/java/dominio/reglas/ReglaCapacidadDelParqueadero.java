package dominio.reglas;


import dominio.Carro;
import dominio.Moto;
import dominio.Parqueadero;
import dominio.Vehiculo;
import dominio.excepcion.ServicioParqueoException;

public class ReglaCapacidadDelParqueadero implements ReglasParqueadero {

	private static final int CANTIDAD_MINIMA = 0;

	@Override
	public boolean validar(Vehiculo vehiculo, Parqueadero parqueadero) {		
		if(validarSiEsCarroYhaNoyCapacidad(vehiculo, parqueadero)){
			throw new ServicioParqueoException("No Hay Capacidad Para carros");			
		}
		else if(vehiculo instanceof Moto && parqueadero.getCapacidadMotos()==CANTIDAD_MINIMA){
			throw new ServicioParqueoException("No Hay Capacidad Para Motos");
		}	
		
		return true;
	}

	private boolean validarSiEsCarroYhaNoyCapacidad(Vehiculo vehiculo, Parqueadero parqueadero) {
		return vehiculo instanceof Carro && parqueadero.getCapacidadCarros()==CANTIDAD_MINIMA;
	}

	

}
