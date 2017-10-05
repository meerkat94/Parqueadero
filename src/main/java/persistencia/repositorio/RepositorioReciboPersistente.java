package persistencia.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dominio.ReciboDeServicioParqueadero;
import dominio.Vehiculo;
import dominio.excepcion.ServicioParqueoException;
import persistencia.builder.VehiculoBuilder;
import persistencia.entidad.ReciboEntity;
import persistencia.entidad.VehiculoEntity;
import repositorio.RepositorioRecibo;
import repositorio.RepositorioVehiculo;

@Repository
public class RepositorioReciboPersistente implements RepositorioRecibo {

	private static final String PLACA = "placa";
	private static final String RECIBO_BY_PLACA = "Recibo.findByPlaca";
	
	
	private EntityManager entityManager;
	@Autowired
	 RepositorioVehiculo repositorioVehiculo;
	
	
	public RepositorioReciboPersistente(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	@Override
	public Vehiculo obtenerVehiculoEnArqueaderoPorPlaca(String placa) {
		ReciboEntity reciboEntity = obtenerReciboEntityPorPlaca(placa);
		return VehiculoBuilder.convertirADominio(reciboEntity != null ? reciboEntity.getVehiculo() : null);
	}
	@SuppressWarnings("rawtypes")
	private ReciboEntity obtenerReciboEntityPorPlaca(String placa) {
		Query query = entityManager.createNamedQuery(RECIBO_BY_PLACA);
		query.setParameter(PLACA, placa);		
		List listarecibos = query.getResultList();
		return !listarecibos.isEmpty() ? (ReciboEntity) listarecibos.get(0) : null;
	}
	

	@Override
	public ReciboDeServicioParqueadero obtenerPorPlaca(String placa) {
		ReciboEntity reciboEntity = obtenerReciboEntityPorPlaca(placa);
		try {				
			return new ReciboDeServicioParqueadero(VehiculoBuilder.convertirADominio(reciboEntity.getVehiculo()),reciboEntity.getFechaIngreso(),
			reciboEntity.getFechaEgreso(),reciboEntity.getValor());
		
		} catch (Exception e) {
			throw new ServicioParqueoException("el vehiculo no se encuentra ingresado");
		}
	}




	@Override
	public void insertar(ReciboDeServicioParqueadero recibo) {
		ReciboEntity reciboEntity=buildReciboEntity(recibo);
		entityManager.persist(reciboEntity);
		
	}

	private ReciboEntity buildReciboEntity(ReciboDeServicioParqueadero recibo) {
		 
         VehiculoEntity vehiculo=repositorioVehiculo.obtenerVehiculoEntityPorPlaca(recibo.getVehiculo().getPlaca());       
		 ReciboEntity reciboEntity=new ReciboEntity();
		 reciboEntity.setVehiculo(vehiculo);
		 reciboEntity.setFechaIngreso(recibo.getFechaingreso());
		 reciboEntity.setFechaEgreso(recibo.getFechaegreso());
		 reciboEntity.setValor(recibo.getValor());
		return reciboEntity;
	}
	
}
