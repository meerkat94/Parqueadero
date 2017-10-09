package dominio.reglas;

import java.util.Calendar;

import dominio.Parqueadero;
import dominio.Vehiculo;
import dominio.excepcion.ServicioParqueoException;

public class ReglaPrimerLetraDeLaPlaca implements ReglasIngresoParqueadero {

	@Override
	public boolean validar(Vehiculo vehiculo, Parqueadero parqueadero) {
		String placa = vehiculo.getPlaca();
		Calendar fechaActual = Calendar.getInstance();
		if (placaIniciaPorA(placa) && noEsUnDiaHabil(fechaActual)) {			
				throw new  ServicioParqueoException("No Puede Ingresar El Dia De Hoy");
		}
		return true;
	}

	private boolean noEsUnDiaHabil(Calendar fechaActual) {
		return (fechaActual.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY)
				|| (fechaActual.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY);
	}

	private boolean placaIniciaPorA(String placa) {
		char[] placaEnChar = placa.toCharArray();
		return placaEnChar[0] == ('A');
	}

}
