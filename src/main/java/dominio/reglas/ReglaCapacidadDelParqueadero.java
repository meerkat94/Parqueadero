package dominio.reglas;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import dominio.Carro;
import dominio.Moto;
import dominio.Parqueadero;
import dominio.Vehiculo;
import dominio.excepcion.ServicioParqueoException;
import repositorio.RepositorioRecibo;

@EnableAutoConfiguration
public class ReglaCapacidadDelParqueadero implements ReglasIngresoParqueadero {

	private static final int CANTIDAD_MINIMA = 0;
	@Autowired
	RepositorioRecibo repositorioRecibo;
	public ReglaCapacidadDelParqueadero(RepositorioRecibo repositorioRecibo){
		this.repositorioRecibo=repositorioRecibo;
	}
	@Override
	public boolean validar(Vehiculo vehiculo, Parqueadero parqueadero) {		
		if(validarSiEsCarroYhaNoyCapacidad(vehiculo, parqueadero)){
			throw new ServicioParqueoException("No Hay Capacidad Para carros");			
		}
		else if(validarSiEsMotoYhaNoyCapacidad(vehiculo, parqueadero)){
			throw new ServicioParqueoException("No Hay Capacidad Para Motos");			
		}	
		return true;
		
	} 
	
	private boolean validarSiEsCarroYhaNoyCapacidad(Vehiculo vehiculo, Parqueadero parqueadero) {
		int celdasocupadascarro=obtenerEspaciosOcupadosCarro();
		int celdasdisponiblescarro=obtenerEspaciosDisponiblesCarro(parqueadero, celdasocupadascarro);
		return vehiculo instanceof Carro && celdasdisponiblescarro==CANTIDAD_MINIMA;
	}
	
	private int obtenerEspaciosDisponiblesCarro(Parqueadero parqueadero, int celdasocupadascarro) {
		return parqueadero.getCapacidadCarros()-celdasocupadascarro;
	}
	
	private int obtenerEspaciosOcupadosCarro() {
		return repositorioRecibo.obtenerEspaciosOcupadosCarros().intValue();
	}

	
	private boolean validarSiEsMotoYhaNoyCapacidad(Vehiculo vehiculo, Parqueadero parqueadero) {
		
		int celdasocupadasmoto=obtenerEspaciosOcupadosMoto();
		int celdasdisponiblesmoto=obtenerEspaciosDisponiblesMoto(parqueadero, celdasocupadasmoto);
		return vehiculo instanceof Moto && celdasdisponiblesmoto==CANTIDAD_MINIMA;
	}
	private int obtenerEspaciosDisponiblesMoto(Parqueadero parqueadero, int celdasocupadasmoto) {
		return parqueadero.getCapacidadMotos()-celdasocupadasmoto;
	}
	private int obtenerEspaciosOcupadosMoto() {
		return repositorioRecibo.obtenerEspaciosOcupadosMotos().intValue();
	}
	

}
