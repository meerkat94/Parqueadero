package persistencia.builder;

import dominio.Carro;
import dominio.Moto;
import dominio.Vehiculo;
import persistencia.entidad.VehiculoEntity;

public class VehiculoBuilder {

	private VehiculoBuilder() {
	}


	public static Vehiculo convertirADominio(VehiculoEntity vehiculoEntity) {
		if (vehiculoEntity == null) {
			return null;
		}
		Vehiculo vehiculo = null;
		if (vehiculoEntity.getTipo() .equals("Carro")) {
			vehiculo = new Carro(vehiculoEntity.getPlaca());
		} else {
			vehiculo = new Moto(vehiculoEntity.getPlaca(), vehiculoEntity.getCilindraje());
		}
		return vehiculo;
	}

	public static VehiculoEntity convertirAEntity(Vehiculo vehiculo) {
		VehiculoEntity vehiculoEntity = new VehiculoEntity();
		vehiculoEntity.setPlaca(vehiculo.getPlaca());
		if (vehiculo instanceof Carro){
			vehiculoEntity.setTipo("Carro");
		}
		if (vehiculo instanceof Moto){
			vehiculoEntity.setTipo("Moto");
		}
		return vehiculoEntity;
	}

}
