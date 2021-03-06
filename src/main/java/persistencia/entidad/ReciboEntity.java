package persistencia.entidad;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import persistencia.entidad.VehiculoEntity;

@Entity(name = "Recibo")
@NamedQueries({
		@NamedQuery(name = "Recibo.findByPlaca", query = "SELECT recibo from Recibo recibo where recibo.vehiculo.placa = :placa AND recibo.fechaEgreso IS NULL"),
		@NamedQuery(name = "Recibo.findAll", query = "SELECT recibo from Recibo recibo") ,
		@NamedQuery(name = "Recibo.findCellsCars", query = "SELECT COUNT(*) from Recibo recibo where recibo.vehiculo.tipo = :tipo_carro AND recibo.fechaEgreso IS NULL"),
		@NamedQuery(name = "Recibo.findCellsBikes", query = "SELECT COUNT(*) from Recibo recibo where recibo.vehiculo.tipo = :tipo_moto AND recibo.fechaEgreso IS NULL"),
		@NamedQuery(name = "Recibo.findByAll", query = "SELECT recibo from Recibo recibo where recibo.fechaEgreso IS NULL" ),
		})

public class ReciboEntity {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;	
	
	@ManyToOne
	@JoinColumn(name = "id_Vehiculo", referencedColumnName = "id")
	private VehiculoEntity vehiculo;
	
	@Column(name = "fechaIngreso")
	private Calendar fechaIngreso;
	
	@Column(name = "fechaEgreso")
	private Calendar fechaEgreso;
	
	@Column(name = "valor")
	private double valor;
	
	
	public VehiculoEntity getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(VehiculoEntity vehiculo) {
		this.vehiculo = vehiculo;
	}
	public Calendar getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Calendar fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Calendar getFechaEgreso() {
		return fechaEgreso;
	}
	public void setFechaEgreso(Calendar fechaEgreso) {
		this.fechaEgreso = fechaEgreso;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
	
}


