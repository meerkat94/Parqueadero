package dominio.reglas;

import dominio.Parqueadero;
import dominio.Vehiculo;

public interface  ReglasParqueadero {
	
	public boolean validar(Vehiculo vehiculo, Parqueadero parqueadero);

}
