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
import dominio.Vehiculo;
import dominio.Vigilante;
import repositorio.RepositorioRecibo;
import repositorio.RepositorioVehiculo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={ParqueaderoApplication.class})
@DataJpaTest
public class VigilanteTest {	
	@Autowired
	Vigilante vigilante;
	@Autowired
	RepositorioRecibo repositorioRecibo;
	@Autowired
	RepositorioVehiculo repositorioVehiculo;
	
	private Vehiculo vehiculo;	
	

	@Test
	public void ingresarUnCarroTest() {
		//Arrange	
		vehiculo =new Carro("FCM308");
		vigilante.ingresarUnVehiculo(vehiculo); 
		//assert
		Assert.assertNotNull(repositorioRecibo.obtenerPorPlaca(vehiculo.getPlaca()));
		
	}
}