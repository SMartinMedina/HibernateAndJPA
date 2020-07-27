package com.novellius.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;

import com.novellius.domain.DiarioCliente;
import com.novellius.domain.Tramite;
import com.novellius.service.DiarioClienteService;
import com.novellius.service.TramiteService;

public class TestJpa {

	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");
		
		TramiteService tramiteService = context.getBean(TramiteService.class);
		
		int index = 1;
		Page<Tramite> page = tramiteService.findByTipoTramLike(index - 1, "%Crédito%");
		
		System.out.println("Página: " + index);
		System.out.println("Total de elementos: " + page.getTotalElements());
		System.out.println("Total páginas: " + page.getTotalPages());
		System.out.println("Contenido: " + page.getContent());
		
		((ClassPathXmlApplicationContext)context).close();

	}

}
