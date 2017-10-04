package persistencia.repositorio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.stereotype.Repository;

import dominio.Carro;
import dominio.Moto;
import dominio.ReciboDeServicioParqueadero;
import dominio.Vehiculo;
import dominio.excepcion.ServicioParqueoException;
import persistencia.builder.VehiculoBuilder;
import persistencia.entidad.ReciboEntity;
import persistencia.entidad.VehiculoEntity;
import repositorio.RepositorioVehiculo;
@Repository
public class RepositorioVehiculoPersistente implements RepositorioVehiculo {

	private static final String PLACA = "placa";
	private static final String VEHICULO_FIND_BY_PLACA = "Vehiculo.findByPlaca";
	private static final String VEHICULOS_FIND = "Vehiculo.findAll";

	private EntityManager entityManager;

	public RepositorioVehiculoPersistente(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public Vehiculo obtenerPorPlaca(String placa) {
		VehiculoEntity vehiculoEntity=obtenerVehiculoEntityPorPlaca(placa);
		return VehiculoBuilder.convertirADominio(vehiculoEntity);
	}

	@Override
	
	public List<Vehiculo> obtenerListaVehiculos() {
		List<VehiculoEntity>listaEntity=listarVehiculos();
		List<Vehiculo>listaVehiculos=new ArrayList<>();
		if(!listaEntity.isEmpty()){
			for(int i=0;i<listaEntity.size();i++){
				Vehiculo vehiculo=VehiculoBuilder.convertirADominio(listaEntity.get(i));
				listaVehiculos.add(vehiculo);
			}
			return listaVehiculos;
		}
		else throw new ServicioParqueoException("No hay ningun vehiculo");
	}	

	private List<VehiculoEntity> listarVehiculos() {
	Query query=entityManager.createNamedQuery(VEHICULOS_FIND);
	List<VehiculoEntity>listaEntity=query.getResultList();
	return !listaEntity.isEmpty()? listaEntity:null;		
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
		 }
		 vehiculoEntity.setTipo("Carro");
		return vehiculoEntity;
	}

	
	
}
