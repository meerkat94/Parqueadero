package repositorio;

import dominio.Vehiculo;
import persistencia.entidad.VehiculoEntity;


public interface RepositorioVehiculo {	
	
	Vehiculo obtenerVehiculoPorPlaca(String placa);
	VehiculoEntity obtenerVehiculoEntityPorPlaca(String placa);	
	void insertar(Vehiculo vehiculo);

}
