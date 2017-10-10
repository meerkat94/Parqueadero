package dominio;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dominio.excepcion.ServicioParqueoException;
import dominio.reglas.ReglaCobro;
import dominio.reglas.ReglasEgresoParqueadero;
import dominio.reglas.ReglasIngresoParqueadero;
import repositorio.RepositorioRecibo;
import repositorio.RepositorioVehiculo;

public class Vigilante {

	@Autowired
	RepositorioRecibo repositorioRecibo;
	@Autowired
	RepositorioVehiculo repositorioVehiculo;
	private List<ReglasIngresoParqueadero> reglasingreso;
	private Parqueadero parqueadero;
	Calendar fechaSalida ;

	 public Vigilante(List<ReglasIngresoParqueadero>
	 reglasIngreso,List<ReglasEgresoParqueadero> reglasEgreso ,Parqueadero
	 parqueadero,RepositorioVehiculo repositorioVehiculo,RepositorioRecibo
	 repositorioRecibo) {
	 super();
	 this.reglasingreso = reglasIngreso;
	 this.parqueadero = parqueadero;
	 this.repositorioRecibo=repositorioRecibo;
	 this.repositorioVehiculo=repositorioVehiculo;
		 }

	public ReciboDeServicioParqueadero ingresarUnVehiculo(Vehiculo vehiculo) {
		Calendar fechaActual = Calendar.getInstance();
		validarReglasIngreso(vehiculo);
		insertarVehiculo(vehiculo);
		ReciboDeServicioParqueadero recibo = new ReciboDeServicioParqueadero(vehiculo, fechaActual);		
		if (repositorioRecibo.obtenerVehiculoEnArqueaderoPorPlaca(vehiculo.getPlaca()) == null) {			
			repositorioRecibo.insertar(recibo);
			return recibo;
		} else
			throw new ServicioParqueoException("El Vehiculo Ya Se Encuetra En El Parqueadero");
	}

	private void insertarVehiculo(Vehiculo vehiculo) {
		if(repositorioVehiculo.obtenerVehiculoPorPlaca(vehiculo.getPlaca())==null){
			repositorioVehiculo.insertar(vehiculo);
		}
		
	}

	private void validarReglasIngreso(Vehiculo vehiculo) {
		for (ReglasIngresoParqueadero regla : reglasingreso) {
			regla.validar(vehiculo, parqueadero);
		}
	}

	 public ReciboDeServicioParqueadero darSalidaAvehiculo(Vehiculo vehiculo) {	
		 fechaSalida=Calendar.getInstance();
		 ReglaCobro reglacobro= new ReglaCobro();
		 ReciboDeServicioParqueadero recibo = repositorioRecibo.obtenerRecibo(vehiculo.getPlaca());
		 recibo.setFechaegreso(fechaSalida);
		 recibo.setValor(reglacobro.calcular(recibo.getVehiculo(), recibo.getFechaingreso(), recibo.getFechaegreso() ));
		 repositorioRecibo.actualizarRecibo(recibo);
		 return recibo;
	 }
}

