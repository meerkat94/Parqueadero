package serviciosrest;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dominio.Carro;
import dominio.ReciboDeServicioParqueadero;
import dominio.Vigilante;


@Transactional
@RestController
public class Vigilanterest {
	
	@Autowired
	Vigilante vigilante;
	

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Parqueadero";
	}

	@RequestMapping(value = "/IngresoCarro", method = RequestMethod.POST)
	@ResponseBody
	public ReciboDeServicioParqueadero servicioIngresarCarro(@RequestBody Carro carro) {
			return(vigilante.ingresarUnVehiculo(carro));
			
	}
}
