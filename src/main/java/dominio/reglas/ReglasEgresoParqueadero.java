package dominio.reglas;

import java.util.Calendar;

import dominio.Vehiculo;

public interface ReglasEgresoParqueadero {
	public double calcular(Vehiculo vehiculo,Calendar fechaEntrada, Calendar fechaSalida);

}
