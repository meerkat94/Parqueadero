package repositorio;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import dominio.Vehiculo;
import persistencia.repositorio.RepositorioReciboPersistente;

public class RepositorioReciboTest {
@Autowired
RepositorioReciboPersistente repositorioRecibo;
	
	@Test
	public void obtenerVehiculoEnParqueaderPorPlacaTest() {
		Vehiculo vehiculo=new Vehiculo("FCM308");	
		RepositorioReciboPersistente repositorio=Mockito.mock(RepositorioReciboPersistente.class);
		Mockito.when(repositorio.obtenerVehiculoEnArqueaderoPorPlaca(vehiculo.getPlaca())).thenReturn(vehiculo);			
		assertNotNull(vehiculo);	
			
	}

}
