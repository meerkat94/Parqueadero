package repositorio;

import java.util.List;


import dominio.Vehiculo;
import persistencia.entidad.VehiculoEntity;


public interface RepositorioVehiculo {
	
	Vehiculo obtenerPorPlaca(String placa);
    List<Vehiculo> obtenerListaVehiculos();
    VehiculoEntity obtenerVehiculoEntityPorPlaca(String placa);
	void insertar(Vehiculo vehiculo);

}
