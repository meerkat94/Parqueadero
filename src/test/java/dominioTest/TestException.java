package dominioTest;

import static org.junit.Assert.fail;

import org.junit.Assert;

import dominio.Moto;
import dominio.excepcion.ServicioParqueoException;

public class TestException {

	public void probar(Accion act, String mensaje) {

		try {
			act.execute();
			fail();
		} catch (Exception e) {
			Assert.assertEquals(mensaje, e.getMessage());
		}
	}

}
