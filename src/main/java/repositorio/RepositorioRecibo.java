package repositorio;

import java.util.List;
import dominio.ReciboDeServicioParqueadero;
import dominio.Vehiculo;


public interface RepositorioRecibo {	
	
	Vehiculo obtenerVehiculoEnArqueaderoPorPlaca(String placa);
				
	ReciboDeServicioParqueadero obtenerPorPlaca(String placa);
	
	List<ReciboDeServicioParqueadero> obtenerListaRecibos();

	void insertar(ReciboDeServicioParqueadero recibo);

	
}
