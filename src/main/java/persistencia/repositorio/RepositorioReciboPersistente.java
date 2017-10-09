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
	private static final String TIPO_CARRO = "tipo_carro";
	private static final String RECIBO_BY_PLACA = "Recibo.findByPlaca";
	private static final String ESPACIOS_CARRO_DISPONIBLES = "Recibo.findCellsCars";
	private static final String TIPO_MOTO = "tipo_moto";
	private static final String ESPACIOS_MOTO_DISPONIBLES = "Recibo.findCellsBikes";
	
	
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
	public ReciboEntity obtenerReciboEntityPorPlaca(String placa) {
		Query query = entityManager.createNamedQuery(RECIBO_BY_PLACA);
		query.setParameter(PLACA, placa);		
		List listarecibos = query.getResultList();
		return !listarecibos.isEmpty() ? (ReciboEntity) listarecibos.get(0) : null;
	}
	
	
	public Long obtenerEspaciosOcupadosCarros() {
		Query query = entityManager.createNamedQuery(ESPACIOS_CARRO_DISPONIBLES);
		query.setParameter(TIPO_CARRO,"Carro");		
		return (Long) (query.getSingleResult());		
	}
	public Long obtenerEspaciosOcupadosMotos() {
		Query query = entityManager.createNamedQuery(ESPACIOS_MOTO_DISPONIBLES);
		query.setParameter(TIPO_MOTO,"Moto");		
		return (Long) (query.getSingleResult());		
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
