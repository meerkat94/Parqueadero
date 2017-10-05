package dominio;

public class Moto extends Vehiculo{
	
	private  int cilindraje;
	

	public Moto(String placa, int cilindraje) {
		super(placa);
		this.cilindraje = cilindraje;
	}
	public Moto() {
	
	}

	public int getCilindraje() {
		return cilindraje;
	}

	
	
}
