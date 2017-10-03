package dominio.reglas;

import dominio.Moto;
import dominio.Parqueadero;
import dominio.Vehiculo;

public class ReglaMotoDeAltoCilindraje implements ReglasParqueadero {

	@Override
	public boolean validar(Vehiculo vehiculo, Parqueadero parqueadero) {
		if(vehiculo instanceof Moto){
			Moto moto =(Moto)vehiculo;
			int limiteCilindraje=500;
			return(moto.getCilindraje()>limiteCilindraje);
		}
		return false;
	}

}
