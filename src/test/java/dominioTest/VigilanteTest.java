package dominioTest;

import static org.junit.Assert.fail;

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
import dominio.Vehiculo;
import dominio.Vigilante;
import dominio.excepcion.ServicioParqueoException;
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
	@Test
	public void ingresarUnCarroParqueadoTest() {
		//Arrange	
		vehiculo =new Carro("FCM308");		
		//assert		
		vigilante.ingresarUnVehiculo(vehiculo); 
		try {
			vigilante.ingresarUnVehiculo(vehiculo);
			fail();
		} catch (ServicioParqueoException e) {		
			Assert.assertEquals("El Vehiculo Ya Se Encuetra En El Parqueadero", e.getMessage());
		}		
	}	

	@Test
	public void ingresarUnaMotoTest() {
		//Arrange	
		vehiculo =new Moto("FCM308",1500);
		vigilante.ingresarUnVehiculo(vehiculo); 
		//assert
		Assert.assertNotNull(repositorioRecibo.obtenerPorPlaca(vehiculo.getPlaca()));
		
	}
	@Test
	public void ingresarUnaMotoParqueadoTest() {
		//Arrange	
		vehiculo =new Moto("FCM308",1500);		
		//assert		
		vigilante.ingresarUnVehiculo(vehiculo); 
		try {
			vigilante.ingresarUnVehiculo(vehiculo);
			fail();
		} catch (ServicioParqueoException e) {		
			Assert.assertEquals("El Vehiculo Ya Se Encuetra En El Parqueadero", e.getMessage());
		}		
	}
//	@Test
//	public void  darSAlidarAcarroParqueadoTest() {
//		//Arrange	
//		vehiculo =new Carro("FCM308");				
//		vigilante.darSalidaAcarro(vehiculo);
//		Assert.assertNotNull(repositorioRecibo.obtenerPorPlaca(vehiculo.getPlaca()));
//				
//		
//	}
}