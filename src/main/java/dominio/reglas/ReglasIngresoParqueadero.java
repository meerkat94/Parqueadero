package dominio.reglas;

import dominio.Parqueadero;
import dominio.Vehiculo;

public interface  ReglasIngresoParqueadero {
	
	public boolean validar(Vehiculo vehiculo, Parqueadero parqueadero);

}
