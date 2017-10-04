package dominioTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import dominio.Carro;
import dominio.Parqueadero;
import dominio.Vehiculo;
import dominio.Vigilante;
import dominio.reglas.ReglaCapacidadDelParqueadero;
import dominio.reglas.ReglaPrimerLetraDeLaPlaca;
import dominio.reglas.ReglasParqueadero;
import repositorio.RepositorioRecibo;
import repositorio.RepositorioVehiculo;

public class VigilanteTest {
		
	
	@Autowired
	RepositorioRecibo repositorioRecibo;
	@Autowired
	RepositorioVehiculo repositorioVehiculo;
	
	private Parqueadero parqueadero=new Parqueadero(20, 10);
	private List<ReglasParqueadero> reglasIngreso=new ArrayList<>();
	private Vigilante vigilante = new Vigilante(anadirreglas(),parqueadero,repositorioVehiculo,repositorioRecibo);
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
		vigilante.ingresarUnVehiculo(vehiculo); 
		//assert
		Assert.assertNotNull(repositorioRecibo.obtenerPorPlaca(vehiculo.getPlaca()));
		
	}
}