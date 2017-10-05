package serviciosrest;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dominio.Carro;
import dominio.Moto;
import dominio.ReciboDeServicioParqueadero;
import dominio.Vehiculo;
import dominio.Vigilante;
import repositorio.RepositorioRecibo;
import repositorio.RepositorioVehiculo;

@EnableAutoConfiguration
@Transactional
@RestController
public class Vigilanterest {
	
	@Autowired
	Vigilante vigilante;
	@Autowired
	RepositorioRecibo repositorioRecibo;
	@Autowired
	RepositorioVehiculo repositorioVehiculo;

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "PARQUEADERO";
	}
	
	@RequestMapping(value = "/Ingreso/Carro", method = RequestMethod.POST)
	@ResponseBody
	public ReciboDeServicioParqueadero servicioIngresarCarro(@RequestBody Carro carro) {
		Vehiculo vehiculo=carro;
		return vigilante.ingresarUnVehiculo(vehiculo);						
	}
	
	@RequestMapping(value = "/Ingreso/Moto", method = RequestMethod.POST)
	@ResponseBody
	public ReciboDeServicioParqueadero servicioIngresarMoto(@RequestBody Moto moto) {
		Vehiculo vehiculo=moto;
		return vigilante.ingresarUnVehiculo(vehiculo);						
	}
}
