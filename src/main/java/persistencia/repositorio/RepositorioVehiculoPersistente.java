package persistencia.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dominio.Moto;
import dominio.Parqueadero;
import dominio.Vehiculo;
import persistencia.builder.VehiculoBuilder;
import persistencia.entidad.VehiculoEntity;
import repositorio.RepositorioVehiculo;
@Repository
public class RepositorioVehiculoPersistente implements RepositorioVehiculo {

	private static final String PLACA = "placa";
	private static final String VEHICULO_FIND_BY_PLACA = "Vehiculo.findByPlaca";
	
	@Autowired
	Parqueadero parqueadero;
	
	private EntityManager entityManager;

	public RepositorioVehiculoPersistente(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	@Override
	public VehiculoEntity obtenerVehiculoEntityPorPlaca(String placa) {
		 Query query=entityManager.createNamedQuery(VEHICULO_FIND_BY_PLACA);
		 query.setParameter(PLACA, placa);
		 @SuppressWarnings("rawtypes")
		List listaCarros = query.getResultList();
		 return  listaCarros.isEmpty() ? null : (VehiculoEntity)listaCarros.get(0);
	}

	@Override
	public void insertar(Vehiculo vehiculo) {		
		VehiculoEntity vehiculoEntity=buildVehiculoEntity(vehiculo);
		entityManager.persist(vehiculoEntity);
		
	}
	
	private VehiculoEntity buildVehiculoEntity(Vehiculo vehiculo) {
		               
		 VehiculoEntity vehiculoEntity=new VehiculoEntity();
		 vehiculoEntity.setPlaca(vehiculo.getPlaca());
		 if(vehiculo instanceof Moto){
			 vehiculoEntity.setCilindraje(((Moto) vehiculo).getCilindraje());
			 vehiculoEntity.setTipo("Moto");
		 }
		 else{
			 vehiculoEntity.setCilindraje(0);
			 vehiculoEntity.setTipo("Carro");		
		 }
		return vehiculoEntity;
	}

	@Override
	public Vehiculo obtenerVehiculoPorPlaca(String placa) {
		VehiculoEntity vehiculoentity = obtenerVehiculoEntityPorPlaca(placa);
		return vehiculoentity!=null ? VehiculoBuilder.convertirADominio(vehiculoentity):null;
		
		
	}

	
	
}
