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
import com.novellius.service.InmuebleService;
import com.novellius.service.TramiteService;

public class TestJpa {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");
		
		ImagenService imagenService = context.getBean(ImagenService.class);
		InmuebleService inmuebleService = context.getBean(InmuebleService.class);
		
		Timestamp ts = new Timestamp(new Date().getTime());
		
		Inmueble inmueble = new Inmueble("Terreno", "Hidalgo #200");
		
		Imagen imagen1 = new Imagen("www.drive...", ts);
		Imagen imagen2 = new Imagen("www.mega...", ts);
		
		imagenService.save(imagen1);
		imagenService.save(imagen2);
		
		InmuebleImagen inmuebleImagen = new InmuebleImagen();
		inmuebleImagen.setImagen(imagen1);
		inmuebleImagen.setInmueble(inmueble);
		// Campos extra :)
		inmuebleImagen.setStatus("ACTIVO");
		
		InmuebleImagen inmuebleImagen2 = new InmuebleImagen();
		inmuebleImagen2.setImagen(imagen2);
		inmuebleImagen2.setInmueble(inmueble);
		inmuebleImagen2.setStatus("SUSPENDIDO");
		
		inmueble.getInmuebleImagenSet().add(inmuebleImagen);
		inmueble.getInmuebleImagenSet().add(inmuebleImagen2);
		
		inmuebleService.save(inmueble);
		
		
		
		((ClassPathXmlApplicationContext)context).close();
	}
}
