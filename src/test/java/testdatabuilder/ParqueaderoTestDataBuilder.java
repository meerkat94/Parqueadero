package testdatabuilder;

import dominio.Parqueadero;
public class ParqueaderoTestDataBuilder {
	
		private final int CAPACIDAD_PARA_CARR0S = 20;
		private final int CAPACIDAD_PARA_MOTOS = 10;
		
		private int capacidadCarros;
		private int capacidadMotos;
		
		public ParqueaderoTestDataBuilder() {
			this.capacidadCarros = CAPACIDAD_PARA_CARR0S;	
			this.capacidadMotos=CAPACIDAD_PARA_MOTOS;
		}

		public ParqueaderoTestDataBuilder concapacidadCarros(int capacidadCarros) {
			this.capacidadCarros = capacidadCarros;			
			return this;
		}
		public ParqueaderoTestDataBuilder concapacidadMotos(int capacidadMotos) {
			this.capacidadMotos = capacidadMotos;			
			return this;
		}		
		public Parqueadero build(){
			return new Parqueadero(this.capacidadCarros,this.capacidadMotos);
		}
	}

