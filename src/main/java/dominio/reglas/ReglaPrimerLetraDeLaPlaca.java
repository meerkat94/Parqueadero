package dominio.reglas;

import dominio.Vehiculo;

public class ReglaPrimerLetraDeLaPlaca implements ReglasParqueadero {

	@Override
	public boolean validar(Vehiculo vehiculo) {
		String placa = vehiculo.getPlaca(); 
		char[] placaEnChar = placa.toCharArray();		
		return (placaEnChar[0]==('A') );
	}

}
