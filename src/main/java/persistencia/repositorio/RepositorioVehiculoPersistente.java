package persistencia.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dominio.Moto;
import dominio.Parqueadero;
import dominio.Vehiculo;
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
		return (VehiculoEntity) query.getSingleResult();
	}

	@Override
	public void insertar(Vehiculo vehiculo) {		
		VehiculoEntity vehiculoEntity=buildVehiculoEntity(vehiculo);		
		entityManager.persist(vehiculoEntity);
		
	}
	
	private VehiculoEntity buildVehiculoEntity(Vehiculo vehiculo) {
		               
		 VehiculoEntity vehiculoEntity=new VehiculoEntity();
		 vehiculoEntity.setPlaca(vehiculo.getPlaca());	
		 vehiculoEntity.setCilindraje(0);
		 if(vehiculo instanceof Moto){
			 vehiculoEntity.setCilindraje(((Moto) vehiculo).getCilindraje());
			 vehiculoEntity.setTipo("Moto");
			 parqueadero.setCapacidadMotos(parqueadero.getCapacidadMotos()-1);			 
		 }
		 vehiculoEntity.setTipo("Carro");			
		return vehiculoEntity;
	}

	
	
}
