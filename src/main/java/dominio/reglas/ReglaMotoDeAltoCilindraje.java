package dominio.reglas;

import dominio.Moto;
import dominio.Parqueadero;
import dominio.Vehiculo;

public class ReglaMotoDeAltoCilindraje  {

	private static final int LIMITE_CILINDRAJE = 500;

	public boolean validar(Vehiculo vehiculo, Parqueadero parqueadero) {
			Moto moto =(Moto)vehiculo;
			int limiteCilindraje=LIMITE_CILINDRAJE;
			return(moto.getCilindraje()>limiteCilindraje);	
	}

}
