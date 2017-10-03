package dominioTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import dominio.Carro;
import dominio.Parqueadero;
import dominio.ReciboDeServicioParqueadero;
import dominio.Vehiculo;
import dominio.Vigilante;
import dominio.reglas.ReglaCapacidadDelParqueadero;
import dominio.reglas.ReglaPrimerLetraDeLaPlaca;
import dominio.reglas.ReglasParqueadero;



public class VigilanteTest {
		
//	@Autowired
//	ReglasParqueadero reglas;
//	@Autowired
//	Vigilante vigilante;
//	
	
	private Parqueadero parqueadero=new Parqueadero(20, 10);
	private List<ReglasParqueadero> reglasIngreso=new ArrayList<>();
	private Vigilante vigilante = new Vigilante(anadirreglas(),parqueadero);
	private Vehiculo vehiculo;	
	
	private List<ReglasParqueadero> anadirreglas() {
		reglasIngreso.add(new ReglaCapacidadDelParqueadero());
		reglasIngreso.add(new ReglaPrimerLetraDeLaPlaca());
	return reglasIngreso;
	}
	@Test
	public void ingresarUnCarroTest() {
		//Arrange		
		vehiculo =new Carro("FCM308");					
		ReciboDeServicioParqueadero recibo=vigilante.ingresarUnVehiculo(vehiculo);
		Assert.assertEquals(vehiculo.getPlaca(), recibo.getVehiculo().getPlaca());		
	}
}