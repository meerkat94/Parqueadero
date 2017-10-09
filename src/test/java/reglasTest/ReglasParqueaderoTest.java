package reglasTest;
 
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.parqueadero.parqueadero.ParqueaderoApplication;

import dominio.Carro;
import dominio.Moto;
import dominio.Parqueadero;
import dominio.Vehiculo;
import dominio.excepcion.ServicioParqueoException;
import dominio.reglas.ReglaCapacidadDelParqueadero;
import dominio.reglas.ReglaMotoDeAltoCilindraje;
import dominio.reglas.ReglaPrimerLetraDeLaPlaca;
import repositorio.RepositorioRecibo;
import testdatabuilder.ParqueaderoTestDataBuilder;


@RunWith(SpringRunner.class)
@SpringBootTest(classes={ParqueaderoApplication.class})
@DataJpaTest
public class ReglasParqueaderoTest {	
@Autowired 
RepositorioRecibo repositorioRecibo;
	Parqueadero parqueadero =new ParqueaderoTestDataBuilder().build();
	@Test
	public void esMotoDeAltoCilindrajeTest() {
		//Arrange
		ReglaMotoDeAltoCilindraje reglaMotoAltoCilindraje=new  ReglaMotoDeAltoCilindraje();
		Moto moto=Mockito.mock(Moto.class);
		//Act
		Mockito.when(moto.getCilindraje()).thenReturn(999);	
		//Assert
		assertTrue(reglaMotoAltoCilindraje.validar(moto, parqueadero));
	}
	@Test
	public void noEsMotoDeAltoCilindrajeTest() {
		//Arrange
		ReglaMotoDeAltoCilindraje reglaMotoAltoCilindraje=new  ReglaMotoDeAltoCilindraje();
		Moto moto=Mockito.mock(Moto.class);
		//Act
		Mockito.when(moto.getCilindraje()).thenReturn(500);		
		//Assert
		assertFalse(reglaMotoAltoCilindraje.validar(moto, parqueadero));
	}
	
	@Test
	public void laPrimerLetraEsATest() {
		//Arrange
		ReglaPrimerLetraDeLaPlaca reglaPrimerLetraDeLaPlaca=new  ReglaPrimerLetraDeLaPlaca();
		Vehiculo vehiculo=Mockito.mock(Moto.class);
		//Act
		Mockito.when(vehiculo.getPlaca()).thenReturn("ABC123");
		//Assert
		try {
			reglaPrimerLetraDeLaPlaca.validar(vehiculo,parqueadero);
			fail();

		} catch (ServicioParqueoException e) {			
			Assert.assertEquals("No Puede Ingresar El Dia De Hoy", e.getMessage());
		}
	}
	@Test
	public void laPrimerLetraNoEsATest() {
		//Arrange
		ReglaPrimerLetraDeLaPlaca reglaPrimerLetraDeLaPlaca=new  ReglaPrimerLetraDeLaPlaca();
		Vehiculo vehiculo=Mockito.mock(Carro.class);
		//Act			
		Mockito.when(vehiculo.getPlaca()).thenReturn("GBC123");
		//Assert
		assertTrue(reglaPrimerLetraDeLaPlaca.validar(vehiculo, parqueadero));
		
	}
	
	
	@Test
	public void hayCapacidadEnelParqueaderoDeCarrosTest() {
		//Arrange
		ReglaCapacidadDelParqueadero reglaCapacidadDelParqueadero=new ReglaCapacidadDelParqueadero(repositorioRecibo);		
		Vehiculo carro=new Carro("FCD012");
		//Act //Assert
		assertTrue(reglaCapacidadDelParqueadero.validar(carro, parqueadero));
	}
	
	@Test
	public void noHayCapacidadEnelParqueaderoDeCarrosTest() {
		//Arrange
		Parqueadero parqueadero =new ParqueaderoTestDataBuilder().concapacidadCarros(0).build();
		ReglaCapacidadDelParqueadero reglaCapacidadDelParqueadero=new ReglaCapacidadDelParqueadero(repositorioRecibo);		
		Vehiculo carro=new Carro("FCD012");
		try {
			reglaCapacidadDelParqueadero.validar(carro,parqueadero);
			fail();

		} catch (ServicioParqueoException e) {			
			Assert.assertEquals("No Hay Capacidad Para carros", e.getMessage());
		}
	}
	
	@Test
	public void hayCapacidadEnelParqueaderoDeMotosTest() {
		//Arrange
		Parqueadero parqueadero =new ParqueaderoTestDataBuilder().concapacidadMotos(10).build();
		ReglaCapacidadDelParqueadero reglaCapacidadDelParqueadero=new ReglaCapacidadDelParqueadero(repositorioRecibo);		
		Vehiculo moto=new Moto("FCD012",200);
		//Act //Assert
		assertTrue(reglaCapacidadDelParqueadero.validar(moto, parqueadero));
	}
	
	@Test
	public void noHayCapacidadEnelParqueaderoDeMotosTest() {
		//Arrange
		Parqueadero parqueadero =new ParqueaderoTestDataBuilder().concapacidadMotos(0).build();
		ReglaCapacidadDelParqueadero reglaCapacidadDelParqueadero=new ReglaCapacidadDelParqueadero(repositorioRecibo);		
		Vehiculo moto=new Moto("FCD012",500);
		//Act //Assert
		try {
			reglaCapacidadDelParqueadero.validar(moto,parqueadero);
			fail();

		} catch (ServicioParqueoException e) {			
			Assert.assertEquals("No Hay Capacidad Para Motos", e.getMessage());
		}
	}
}