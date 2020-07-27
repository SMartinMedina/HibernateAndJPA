package com.novellius.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.novellius.domain.Tramite;
import com.novellius.service.TramiteService;

public class TestJpa {

	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");
		
//		Timestamp time = new Timestamp(new Date().getTime());
//		
//		List<Tramite> tramites = new ArrayList<>();
//		tramites.add(new Tramite("Proyecto", time));
//		tramites.add(new Tramite("Proyecto 2", time));
//		tramites.add(new Tramite("Proyecto 3", time));
//		tramites.add(new Tramite("Remodelación", time));
//		tramites.add(new Tramite("Crédito", time));
//		tramites.add(new Tramite("crédito 2", time));

		TramiteService tramiteService = context.getBean(TramiteService.class);
		
//		tramiteService.save(tramites);

//		List<Tramite> results = tramiteService.findByTipoTramLike("Proyecto");
//		List<Tramite> results = tramiteService.findByFhcTramLessThan("2016-08-18 15:24:31");
//		System.out.println("resultados: " + results.size());
//		System.out.println(results.toString());
		
		tramiteService.deleteByTipoTram("Proyecto");
		
		((ClassPathXmlApplicationContext)context).close();

	}

}
