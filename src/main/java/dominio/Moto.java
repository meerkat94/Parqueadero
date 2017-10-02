package dominio;

public class Moto extends Vehiculo{
	
	public final int cilindraje;
	

	public Moto(String placa, int cilindraje) {
		super(placa);
		this.cilindraje = cilindraje;
	}


	public int getCilindraje() {
		return this.cilindraje;
	}

	
	
}
