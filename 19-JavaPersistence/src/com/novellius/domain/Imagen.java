package com.novellius.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Imagen")
public class Imagen {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idImg;
	private String urlImg;
	private Timestamp fhcImg;
	
	@ManyToMany(mappedBy = "imagenes")
	private List<Inmueble> inmuebles = new ArrayList<>();
	
	public Imagen() {
	}

	public Imagen(String urlImg, Timestamp fhcImg) {
		this.urlImg = urlImg;
		this.fhcImg = fhcImg;
	}

	public int getIdImg() {
		return idImg;
	}

	public void setIdImg(int idImg) {
		this.idImg = idImg;
	}

	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

	public Timestamp getFhcImg() {
		return fhcImg;
	}

	public void setFhcImg(Timestamp fhcImg) {
		this.fhcImg = fhcImg;
	}

	public List<Inmueble> getInmuebles() {
		return inmuebles;
	}

	public void setInmuebles(List<Inmueble> inmuebles) {
		this.inmuebles = inmuebles;
	}

	@Override
	public String toString() {
		return "Imagen [idImg=" + idImg + ", urlImg=" + urlImg + ", fhcImg=" + fhcImg + "]";
	}

	

	
	
	

}
