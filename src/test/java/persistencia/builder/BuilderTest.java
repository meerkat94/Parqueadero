package persistencia.builder;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import dominio.ReciboDeServicioParqueadero;
import dominio.Vehiculo;
import persistencia.entidad.ReciboEntity;
import persistencia.entidad.VehiculoEntity;

public class BuilderTest {

	@Test
	public void ConvertirVehiculoEntityADominioTest(){
		//arrange
		VehiculoEntity vehiculoentity=new VehiculoEntity();	
		//act//assert
		Vehiculo vehiculo=VehiculoBuilder.convertirADominio(vehiculoentity);
		assertNotNull(vehiculo);
		assertTrue(vehiculo instanceof Vehiculo);
	
	}
	@Test
	public void ConvertirReciboEntityADominioTest(){
		//arrange
		ReciboEntity reciboentity=new ReciboEntity();		
		//act
		ReciboDeServicioParqueadero recibo=ReciboBuilder.convertirADominio(reciboentity);
		//assert
		assertNotNull(recibo);
		assertTrue(recibo instanceof ReciboDeServicioParqueadero);
	
	}
	
	@Test
	public void ConvertirVehiculoAEntityTest(){
		//arrange
		Vehiculo vehiculo=new Vehiculo("der456");
		//act 
		VehiculoEntity vehiculoentity=VehiculoBuilder.convertirAEntity(vehiculo);
		//assert
		assertNotNull(vehiculoentity);
		assertTrue(vehiculoentity instanceof VehiculoEntity);
		
	}
	
	@Test
	public void ConvertirReciboAEntityTest(){
		//arrange
		Vehiculo vehiculo=new Vehiculo("der456");
		ReciboDeServicioParqueadero recibo=new ReciboDeServicioParqueadero(vehiculo,Calendar.getInstance());
		//act 
		ReciboEntity reciboentity=ReciboBuilder.convertirAEntity(recibo);
		//assert
		assertNotNull(reciboentity);
		assertTrue(reciboentity instanceof ReciboEntity);
		
	}

}
