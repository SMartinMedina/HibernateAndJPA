package com.novellius.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Inmueble")
public class Inmueble {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idInm;
	
	private String tipoInm;
	private String domInm;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	@JoinTable(name = "InmuebleImagenMap",
				joinColumns = { @JoinColumn(name = "idInm") },
				inverseJoinColumns = { @JoinColumn(name = "idImg") }
			)
	private List<Imagen> imagenes = new ArrayList<>();
	

	public Inmueble() {
	}

	public Inmueble(String tipoInm, String domInm) {
		this.tipoInm = tipoInm;
		this.domInm = domInm;
	}

	public int getIdInm() {
		return idInm;
	}

	public void setIdInm(int idInm) {
		this.idInm = idInm;
	}

	public String getTipoInm() {
		return tipoInm;
	}

	public void setTipoInm(String tipoInm) {
		this.tipoInm = tipoInm;
	}

	public String getDomInm() {
		return domInm;
	}

	public void setDomInm(String domInm) {
		this.domInm = domInm;
	}

	public List<Imagen> getImagenes() {
		return imagenes;
	}

	public void setImagenes(List<Imagen> imagenes) {
		this.imagenes = imagenes;
	}

	@Override
	public String toString() {
		return "Inmueble [idInm=" + idInm + ", tipoInm=" + tipoInm + ", domInm=" + domInm + ", imagenes=" + imagenes
				+ "]";
	}
	
	
	
	

}
