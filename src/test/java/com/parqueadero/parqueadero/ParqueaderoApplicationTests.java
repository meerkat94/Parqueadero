package com.parqueadero.parqueadero;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import dominio.Parqueadero;
import testdatabuilder.ParqueaderoTestDataBuilder;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=ParqueaderoApplication.class)

public class ParqueaderoApplicationTests {
	Parqueadero parqueadero=new ParqueaderoTestDataBuilder().build();

	@Test
	public void contextLoads() {
	}
	
	
}


