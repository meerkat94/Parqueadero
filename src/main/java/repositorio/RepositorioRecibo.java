package repositorio;

import java.util.List;

import dominio.ReciboDeServicioParqueadero;
import dominio.Vehiculo;
import persistencia.entidad.ReciboEntity;


public interface RepositorioRecibo {	
	
	Vehiculo obtenerVehiculoEnArqueaderoPorPlaca(String placa);
				
	ReciboDeServicioParqueadero obtenerPorPlaca(String placa);
	
	ReciboDeServicioParqueadero obtenerRecibo(String placa);

	void insertar(ReciboDeServicioParqueadero recibo);
	
	Long obtenerEspaciosOcupadosCarros(); 
	
	Long obtenerEspaciosOcupadosMotos(); 
	
	ReciboEntity obtenerReciboEntityPorPlaca(String placa);

	void actualizarRecibo(ReciboDeServicioParqueadero recibo);

	List<ReciboDeServicioParqueadero> obtenerListaVehiculosEnParqueadero();	
	

	
}
