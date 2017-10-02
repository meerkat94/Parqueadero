package dominio;

import java.util.List;

import dominio.reglas.ReglasParqueadero;


public class Vigilante {	
	private List<ReglasParqueadero> reglas;

	public boolean esUnCarro(Vehiculo vehiculo) {
		return(vehiculo instanceof Carro);			
	}

	public boolean esUnaMoto(Vehiculo vehiculo) {
		return(vehiculo instanceof Moto);
	}

	

	


}
