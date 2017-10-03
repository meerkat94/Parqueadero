package dominio.reglas;

import java.util.Calendar;

import dominio.Parqueadero;
import dominio.Vehiculo;
import dominio.excepcion.ServicioParqueoException;

public class ReglaPrimerLetraDeLaPlaca implements ReglasParqueadero {

	@Override
	public boolean validar(Vehiculo vehiculo, Parqueadero parqueadero) {
		String placa = vehiculo.getPlaca();
		char[] placaEnChar = placa.toCharArray();
		Calendar fechaActual = Calendar.getInstance();
		if (placaEnChar[0] == ('A') && ((fechaActual.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY)
				|| (fechaActual.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY))) {			
				throw new  ServicioParqueoException("No Puede Ingresar El Dia De Hoy");
		}
		return true;

	}

}
