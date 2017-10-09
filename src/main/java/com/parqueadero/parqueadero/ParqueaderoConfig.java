package com.parqueadero.parqueadero;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dominio.Parqueadero;
import dominio.Vigilante;
import dominio.reglas.ReglaCapacidadDelParqueadero;
import dominio.reglas.ReglaPrimerLetraDeLaPlaca;
import dominio.reglas.ReglasEgresoParqueadero;
import dominio.reglas.ReglasIngresoParqueadero;
import repositorio.RepositorioRecibo;
import repositorio.RepositorioVehiculo;


@Configuration
public class ParqueaderoConfig {
	
	private static final int MAXIMO_CARROS = 20;
	private static final int MAXIMO_MOTOS = 10;
	@Bean
		public Parqueadero crearParqueadero(){		
			return new Parqueadero(MAXIMO_CARROS,MAXIMO_MOTOS);
		}	

	
	@Bean
	public Vigilante crearVigilante(RepositorioVehiculo repositorioVehiculo,RepositorioRecibo repositorioRecibo){		
		return new Vigilante(crearReglasIngreso(repositorioRecibo),crearReglasEgreso(),new Parqueadero(MAXIMO_CARROS,MAXIMO_MOTOS),repositorioVehiculo,repositorioRecibo);
	}
	
	@Bean
	public List<ReglasIngresoParqueadero> crearReglasIngreso(RepositorioRecibo repositorioRecibo){
	List<ReglasIngresoParqueadero> reglas =new ArrayList<>();
	reglas.add(new ReglaCapacidadDelParqueadero(repositorioRecibo));
	reglas.add(new ReglaPrimerLetraDeLaPlaca());
	return reglas;
	}
	@Bean
	public List<ReglasEgresoParqueadero> crearReglasEgreso(){
	List<ReglasEgresoParqueadero> reglas =new ArrayList<>();
	return reglas;
	}

}
