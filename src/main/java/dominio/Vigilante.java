package dominio;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dominio.excepcion.ServicioParqueoException;
import dominio.reglas.ReglasParqueadero;
import repositorio.RepositorioRecibo;
import repositorio.RepositorioVehiculo;

public class Vigilante {
	@Autowired
	RepositorioRecibo repositorioRecibo;
	@Autowired
	RepositorioVehiculo repositorioVehiculo;
	private List<ReglasParqueadero> reglasingreso;
	// private List<ReglasParqueadero> reglasEgreso;
	private Parqueadero parqueadero;
	Calendar fechaActual = Calendar.getInstance();

	public Vigilante(List<ReglasParqueadero> reglas, Parqueadero parqueadero, RepositorioVehiculo repositorioVehiculo,
			RepositorioRecibo repositorioRecibo) {
		super();
		this.reglasingreso = reglas;
		this.parqueadero = parqueadero;

	}
	// public Vigilante(List<ReglasParqueadero>
	// reglasIngreso,List<ReglasParqueadero> reglasEgreso ,Parqueadero
	// parqueadero,RepositorioVehiculo repositorioVehiculo,RepositorioRecibo
	// repositorioRecibo) {
	// super();
	// this.reglasingreso = reglasIngreso;
	// this.reglasEgreso = reglasEgreso;
	// this.parqueadero = parqueadero;
	//
	// }

	public ReciboDeServicioParqueadero ingresarUnVehiculo(Vehiculo vehiculo) {
		for (ReglasParqueadero regla : reglasingreso) {
			regla.validar(vehiculo, parqueadero);
		}
		if (vehiculo instanceof Carro) {
			parqueadero.setCapacidadCarros(parqueadero.getCapacidadCarros() - 1);
		}
		if (vehiculo instanceof Moto) {
			parqueadero.setCapacidadMotos(parqueadero.getCapacidadMotos() - 1);
		}

		ReciboDeServicioParqueadero recibo = new ReciboDeServicioParqueadero(vehiculo, fechaActual);
		if (repositorioRecibo.obtenerVehiculoEnArqueaderoPorPlaca(vehiculo.getPlaca()) == null) {
			repositorioVehiculo.insertar(vehiculo);
			repositorioRecibo.insertar(recibo);
			return recibo;
		} else
			throw new ServicioParqueoException("El Vehiculo Ya Se Encuetra En El Parqueadero");

	}

	// public void darSalidaAcarro(Vehiculo vehiculo) {
	// repositorioRecibo.obtenerPorPlaca(vehiculo.getPlaca());
	// for (ReglasParqueadero regla : reglasEgreso) {
	// regla.validar(vehiculo,parqueadero);
	// }

}
