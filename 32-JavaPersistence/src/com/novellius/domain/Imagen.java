package com.novellius.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "Imagen")
public class Imagen {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idImg;
	private String urlImg;
	private Timestamp fhcImg;
	
//	@ManyToMany(mappedBy = "imagenes")
//	private List<Inmueble> inmuebles = new ArrayList<>();
	
	@OneToMany(fetch = FetchType.LAZY,
			   mappedBy = "pk.imagen",
			   cascade = CascadeType.ALL
			  )
	private Set<InmuebleImagen> inmuebleImagenSet = new HashSet<>();
	
	
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

	public Set<InmuebleImagen> getInmuebleImagenSet() {
		return inmuebleImagenSet;
	}

	public void setInmuebleImagenSet(Set<InmuebleImagen> inmuebleImagenSet) {
		this.inmuebleImagenSet = inmuebleImagenSet;
	}

	



	
	
	

}
