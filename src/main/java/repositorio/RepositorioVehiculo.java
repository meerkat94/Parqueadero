package repositorio;

import dominio.Vehiculo;
import persistencia.entidad.VehiculoEntity;


public interface RepositorioVehiculo {	
	
	VehiculoEntity obtenerVehiculoEntityPorPlaca(String placa);	
	void insertar(Vehiculo vehiculo);

}
