package dominio;

public class Parqueadero {	

	private int capacidadCarros ;
	private int capacidadMotos;
	
	
	public int getCapacidadCarros() {
		return capacidadCarros;
	}
	public  int getCapacidadMotos() {
		return capacidadMotos;
	}
	public Parqueadero(int capacidadCarros, int capacidadMotos) {
		super();
		this.capacidadCarros = capacidadCarros;
		this.capacidadMotos = capacidadMotos;
	}
	public void setCapacidadCarros(int capacidadCarros) {
		this.capacidadCarros = capacidadCarros;
	}
	public void setCapacidadMotos(int capacidadMotos) {
		this.capacidadMotos = capacidadMotos;
	}
	
	
	
	

}
