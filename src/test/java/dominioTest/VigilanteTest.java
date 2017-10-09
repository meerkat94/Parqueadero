package dominioTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.parqueadero.parqueadero.ParqueaderoApplication;

import dominio.Carro;
import dominio.Moto;
import dominio.Parqueadero;
import dominio.ReciboDeServicioParqueadero;
import dominio.Vehiculo;
import dominio.Vigilante;
import repositorio.RepositorioRecibo;
import repositorio.RepositorioVehiculo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { ParqueaderoApplication.class })
@DataJpaTest
public class VigilanteTest {
	@Autowired
	Vigilante vigilante;
	@Autowired
	RepositorioRecibo repositorioRecibo;
	@Autowired
	RepositorioVehiculo repositorioVehiculo;
	@Autowired
	Parqueadero parqueadero;
	private Vehiculo vehiculo;

	@Test
	public void ingresarUnCarroTest() {
		// Arrange
		vehiculo = new Carro("FCM308");
		vigilante.ingresarUnVehiculo(vehiculo);
		// assert
		Assert.assertNotNull(repositorioRecibo.obtenerPorPlaca(vehiculo.getPlaca()));

	}

	@Test
	public void ingresarUnCarroParqueadoTest() {
		// Arrange
		vehiculo = new Carro("FCM308");
		// assert
		vigilante.ingresarUnVehiculo(vehiculo);

		TestException testException = new TestException();

		testException.probar(() -> vigilante.ingresarUnVehiculo(vehiculo),
				"El Vehiculo Ya Se Encuetra En El Parqueadero");
		
	}

	@Test
	public void ingresarUnaMotoTest() {
		// Arrange
		vehiculo = new Moto("FCM308", 900);
		vigilante.ingresarUnVehiculo(vehiculo);
		// assert
		Assert.assertNotNull(repositorioRecibo.obtenerPorPlaca(vehiculo.getPlaca()));

	}

	@Test
	public void ingresarUnaMotoParqueadoTest() {
		// Arrange
		vehiculo = new Moto("FCM308", 900);
		// assert
		vigilante.ingresarUnVehiculo(vehiculo);

		TestException testException = new TestException();

		testException.probar(() -> vigilante.ingresarUnVehiculo(vehiculo),
				"El Vehiculo Ya Se Encuetra En El Parqueadero");

	}
	
	 @Test
	 public void ingresarYRetirarVehiculoMoto(){
		 vehiculo = new Moto("FCM30A", 900);
		 vigilante.ingresarUnVehiculo(vehiculo);
		 ReciboDeServicioParqueadero recibo = vigilante.darSalidaAvehiculo(vehiculo);
		 Assert.assertEquals(recibo.getVehiculo().getPlaca(), "FCM30A");
		 
	 }
}