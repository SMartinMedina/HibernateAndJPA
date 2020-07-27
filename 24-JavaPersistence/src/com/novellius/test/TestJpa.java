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
//		Tramite tramite = new Tramite("Remodelación", time);
//		Tramite tramite2 = new Tramite("Proyecto", time);
//		
//		List<Tramite> tramites = new ArrayList<>();
//		tramites.add(tramite);
//		tramites.add(tramite2);
//		
		TramiteService tramiteService = context.getBean(TramiteService.class);
//		
//		tramiteService.save(tramites);
		
//		System.out.println(tramiteService.findAll().toString());
		System.out.println(tramiteService.exists(1));
		System.out.println(tramiteService.exists(100));
		
		((ClassPathXmlApplicationContext)context).close();

	}

}
