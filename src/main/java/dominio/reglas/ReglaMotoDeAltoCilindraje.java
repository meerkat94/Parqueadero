package dominio.reglas;

import dominio.Moto;
import dominio.Parqueadero;
import dominio.Vehiculo;

public class ReglaMotoDeAltoCilindraje implements ReglasParqueadero {

	private static final int LIMITE_CILINDRAJE = 500;

	@Override
	public boolean validar(Vehiculo vehiculo, Parqueadero parqueadero) {
			Moto moto =(Moto)vehiculo;
			int limiteCilindraje=LIMITE_CILINDRAJE;
			return(moto.getCilindraje()>limiteCilindraje);	
	}

}
