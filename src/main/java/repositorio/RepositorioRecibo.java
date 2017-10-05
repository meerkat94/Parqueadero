package repositorio;

import dominio.ReciboDeServicioParqueadero;
import dominio.Vehiculo;


public interface RepositorioRecibo {	
	
	Vehiculo obtenerVehiculoEnArqueaderoPorPlaca(String placa);
				
	ReciboDeServicioParqueadero obtenerPorPlaca(String placa);

	void insertar(ReciboDeServicioParqueadero recibo);

	
}
