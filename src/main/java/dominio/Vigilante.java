package dominio;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dominio.excepcion.ServicioParqueoException;
import dominio.reglas.ReglaCobro;
import dominio.reglas.ReglasEgresoParqueadero;
import dominio.reglas.ReglasIngresoParqueadero;
import javassist.expr.Instanceof;
import persistencia.builder.ReciboBuilder;
import persistencia.builder.VehiculoBuilder;
import persistencia.entidad.ReciboEntity;
import repositorio.RepositorioRecibo;
import repositorio.RepositorioVehiculo;
import util.CalendarUtil;

public class Vigilante {

	@Autowired
	RepositorioRecibo repositorioRecibo;
	@Autowired
	RepositorioVehiculo repositorioVehiculo;
	private List<ReglasIngresoParqueadero> reglasingreso;
	private List<ReglasEgresoParqueadero> reglasEgreso;
	private Parqueadero parqueadero;
	Calendar fechaSalida ;

	 public Vigilante(List<ReglasIngresoParqueadero>
	 reglasIngreso,List<ReglasEgresoParqueadero> reglasEgreso ,Parqueadero
	 parqueadero,RepositorioVehiculo repositorioVehiculo,RepositorioRecibo
	 repositorioRecibo) {
	 super();
	 this.reglasingreso = reglasIngreso;
	 this.reglasEgreso = reglasEgreso;
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
		 ReciboEntity reciboentity=repositorioRecibo.obtenerReciboEntityPorPlaca(vehiculo.getPlaca());	
		 reciboentity.setFechaEgreso(fechaSalida);	 	
		 ReglaCobro reglacobro= new ReglaCobro();
		 Vehiculo vehiculo2 = VehiculoBuilder.convertirADominio(reciboentity.getVehiculo());
		 reciboentity.setValor(reglacobro.calcular(vehiculo2, reciboentity.getFechaIngreso(), reciboentity.getFechaEgreso()));
		 return ReciboBuilder.convertirADominio(reciboentity);
			
	 }

	

}

