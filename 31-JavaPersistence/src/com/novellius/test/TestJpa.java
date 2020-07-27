package com.novellius.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;

import com.novellius.domain.DiarioCliente;
import com.novellius.domain.Imagen;
import com.novellius.domain.Inmueble;
import com.novellius.domain.InmuebleImagen;
import com.novellius.domain.Tramite;
import com.novellius.service.DiarioClienteService;
import com.novellius.service.ImagenService;

public class TestJpa {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");
		
		
		
		((ClassPathXmlApplicationContext)context).close();
	}
}
