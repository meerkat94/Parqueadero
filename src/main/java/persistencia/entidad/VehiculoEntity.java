package persistencia.entidad;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity(name = "Vehiculo")
@NamedQueries({
		@NamedQuery(name = "Vehiculo.findByPlaca", query = "SELECT vehiculo FROM Vehiculo vehiculo WHERE vehiculo.placa = :placa"),
		@NamedQuery(name = "Vehiculo.findAll", query = "SELECT vehiculo FROM Vehiculo vehiculo ") })
public class VehiculoEntity {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable = false)
	private String placa;

	@Column(nullable = false)
	private String tipo;

	@Column(nullable = false)
	private Integer cilindraje;

	

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	

	public void setCilindraje(Integer cilindraje) {
		this.cilindraje = cilindraje;
	}

	

	public String getPlaca() {
		return placa;
	}

	public String getTipo() {
		return tipo;
	}

	public Integer getCilindraje() {
		return cilindraje;
	}	
	
	

	
}
