package com.parqueadero.parqueadero;


import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import dominio.Carro;
import dominio.Moto;
import dominio.Vehiculo;
import dominio.Vigilante;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=ParqueaderoApplication.class)
public class ParqueaderoApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void esUnCarroTest(){
	Vehiculo vehiculo=new Carro("FCM308");
	Vigilante vigilante =new Vigilante();
	assertTrue(vigilante.esUnCarro(vehiculo));	
	}
	@Test
	public void noEsUnCarroTest(){
	Vehiculo vehiculo=new Vehiculo("FCM308");
	Vigilante vigilante =new Vigilante();
	assertFalse(vigilante.esUnCarro(vehiculo));	
    }

	@Test
	public void esUnaMotoTest(){
	Vehiculo vehiculo=new Moto("FCM308",1200);
	Vigilante vigilante =new Vigilante();
	assertTrue(vigilante.esUnaMoto(vehiculo));	
   }
	@Test
	public void noEsUnaMotoTest(){
	Vehiculo vehiculo=new Carro("FCM308");
	Vigilante vigilante =new Vigilante();
	assertFalse(vigilante.esUnaMoto(vehiculo));	
   }
	
	
		
	
}


