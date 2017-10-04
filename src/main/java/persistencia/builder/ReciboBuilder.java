package persistencia.builder;

import dominio.ReciboDeServicioParqueadero;
import dominio.Vehiculo;
import persistencia.entidad.ReciboEntity;
import persistencia.entidad.VehiculoEntity;

public class ReciboBuilder {
	
private ReciboBuilder() {}
	
	public static ReciboDeServicioParqueadero convertirADominio(ReciboEntity reciboEntity) {
		ReciboDeServicioParqueadero recibo = null;
		if(reciboEntity != null) {
			Vehiculo vehiculo=VehiculoBuilder.convertirADominio(reciboEntity.getVehiculo());
			recibo = new ReciboDeServicioParqueadero(vehiculo,reciboEntity.getFechaIngreso(),reciboEntity.getFechaEgreso(),reciboEntity.getValor());
		}
		return recibo;
	}
	
	public static ReciboEntity convertirAEntity(ReciboDeServicioParqueadero recibo) {
		VehiculoEntity vehiculo=VehiculoBuilder.convertirAEntity(recibo.getVehiculo());
 		ReciboEntity reciboEntity = new ReciboEntity();
		reciboEntity.setVehiculo(vehiculo);
		reciboEntity.setFechaIngreso(recibo.getFechaingreso());
		reciboEntity.setFechaEgreso(recibo.getFechaegreso());
		reciboEntity.setValor(recibo.getValor());
		return reciboEntity;
	}

}
