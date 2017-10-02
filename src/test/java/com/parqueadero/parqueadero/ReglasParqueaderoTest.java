package com.parqueadero.parqueadero;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;
import dominio.Moto;
import dominio.Vehiculo;
import dominio.reglas.ReglaMotoDeAltoCilindraje;
import dominio.reglas.ReglaPrimerLetraDeLaPlaca;


public class ReglasParqueaderoTest {

	@Test
	public void esMotoDeAltoCilindrajeTest() {
		ReglaMotoDeAltoCilindraje reglaMotoAltoCilindraje=new  ReglaMotoDeAltoCilindraje();
		Moto moto=Mockito.mock(Moto.class);
		Mockito.when(moto.getCilindraje()).thenReturn(501);		
		assertTrue(reglaMotoAltoCilindraje.validar(moto));
	}
	@Test
	public void noEsMotoDeAltoCilindrajeTest() {
		ReglaMotoDeAltoCilindraje reglaMotoAltoCilindraje=new  ReglaMotoDeAltoCilindraje();
		Moto moto=Mockito.mock(Moto.class);
		Mockito.when(moto.getCilindraje()).thenReturn(100);		
		assertFalse(reglaMotoAltoCilindraje.validar(moto));
	}
	
	@Test
	public void laPrimerLetraEsATest() {
		ReglaPrimerLetraDeLaPlaca reglaPrimerLetraDeLaPlaca=new  ReglaPrimerLetraDeLaPlaca();
		Vehiculo vehiculo=Mockito.mock(Moto.class);
		Mockito.when(vehiculo.getPlaca()).thenReturn("ABC123");		
		assertTrue(reglaPrimerLetraDeLaPlaca.validar(vehiculo));
	}
	@Test
	public void laPrimerLetraNoEsATest() {
		ReglaPrimerLetraDeLaPlaca reglaPrimerLetraDeLaPlaca=new  ReglaPrimerLetraDeLaPlaca();
		Vehiculo vehiculo=Mockito.mock(Moto.class);
		Mockito.when(vehiculo.getPlaca()).thenReturn("dBC123");		
		assertFalse(reglaPrimerLetraDeLaPlaca.validar(vehiculo));
	}
}
