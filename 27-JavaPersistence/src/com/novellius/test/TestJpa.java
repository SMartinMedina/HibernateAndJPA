package com.novellius.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.novellius.domain.DiarioCliente;
import com.novellius.domain.Tramite;
import com.novellius.service.DiarioClienteService;
import com.novellius.service.TramiteService;

public class TestJpa {

	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");
		
		TramiteService tramiteService = context.getBean(TramiteService.class);
		DiarioClienteService diarioClienteService = context.getBean(DiarioClienteService.class);
		
//		List<DiarioCliente> results = diarioClienteService.findByTramite(tramiteService.findOne(1));
//		System.out.println("results: " + results.size());
//		System.out.println(results);
		List<DiarioCliente> results = diarioClienteService.findByTipoTram("Crédito");
		System.out.println("results: " + results.size());
		System.out.println(results);
		
		
		((ClassPathXmlApplicationContext)context).close();

	}

}
