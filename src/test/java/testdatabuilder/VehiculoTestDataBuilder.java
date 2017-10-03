package testdatabuilder;

import dominio.Vehiculo;

public class VehiculoTestDataBuilder {

	private static final String PLACA = "FCM308";
	private String placa;
	
	public VehiculoTestDataBuilder() {
		this.placa = PLACA;		
	}

	public VehiculoTestDataBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}
	
	public Vehiculo build(){
		return new Vehiculo(this.placa);
	}
}
