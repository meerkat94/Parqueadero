package dominio.reglas;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;

import dominio.Carro;
import dominio.Moto;
import dominio.Parqueadero;
import dominio.Vehiculo;
import repositorio.RepositorioRecibo;
import util.CalendarUtil;

public class ReglaCobro implements ReglasEgresoParqueadero {

private static final int RECARGO_MOTO_ALTO_CILINDRAJE = 2000;
private static final int CANTIDAD_DE_HORAS_QUE_TIENE_UN_DIA = 9;
private static final int VALOR_DIA_PARQUEADERO_MOTO = 600;
private static final int VALOR_HORA_PARQUEADERO_MOTO = 500;
private static final int VALOR_DIA_PARQUEADERO_CARRO = 8000;
private static final int VALOR_HORA_PARQUEADERO_CARRO = 1000;
@Autowired
RepositorioRecibo repositorioRecibo;
CalendarUtil calendario=new CalendarUtil();
@Autowired
Parqueadero parqueadero ;
ReglaMotoDeAltoCilindraje  reglamoto=new ReglaMotoDeAltoCilindraje();

	@Override
	public double calcular(Vehiculo vehiculo, Calendar fechaEntrada, Calendar fechaSalida) {
			
		 double horas=calendario.calcularDiferenciaHoras(fechaEntrada,fechaSalida);	
		 int totalApagar=0;
			if (vehiculo instanceof Moto) {				
				int dias = (int)Math.floor((horas/CANTIDAD_DE_HORAS_QUE_TIENE_UN_DIA));
				totalApagar += VALOR_DIA_PARQUEADERO_MOTO*dias;
				totalApagar += (horas%CANTIDAD_DE_HORAS_QUE_TIENE_UN_DIA)*VALOR_HORA_PARQUEADERO_MOTO;				
				if(reglamoto.validar(vehiculo, parqueadero)){
					totalApagar+=RECARGO_MOTO_ALTO_CILINDRAJE;
				}
			}	
			if(vehiculo instanceof Carro){
				totalApagar += (int)(horas/CANTIDAD_DE_HORAS_QUE_TIENE_UN_DIA)*VALOR_DIA_PARQUEADERO_CARRO;
				totalApagar += (horas%CANTIDAD_DE_HORAS_QUE_TIENE_UN_DIA)*VALOR_HORA_PARQUEADERO_CARRO;	
			}
			return totalApagar;
	}

}
