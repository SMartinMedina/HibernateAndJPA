package com.novellius.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novellius.domain.Imagen;
import com.novellius.repository.ImagenRepository;

@Service
public class ImagenService {

	@Autowired
	private ImagenRepository imagenRepository;
	
	public void save(Imagen imagen){
		imagenRepository.save(imagen);
	}
}
