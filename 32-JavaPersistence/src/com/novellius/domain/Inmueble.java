package com.novellius.domain;

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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Inmueble")
public class Inmueble {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idInm;
	
	private String tipoInm;
	private String domInm;
	
//	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
//	@JoinTable(name = "InmuebleImagenMap",
//				joinColumns = { @JoinColumn(name = "idInm") },
//				inverseJoinColumns = { @JoinColumn(name = "idImg") }
//			)
//	private List<Imagen> imagenes = new ArrayList<>();
	
	@OneToMany(fetch = FetchType.LAZY,
			   mappedBy = "pk.inmueble",
			   cascade = CascadeType.ALL
			  )
	private Set<InmuebleImagen> inmuebleImagenSet = new HashSet<>();
	

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

	public Set<InmuebleImagen> getInmuebleImagenSet() {
		return inmuebleImagenSet;
	}

	public void setInmuebleImagenSet(Set<InmuebleImagen> inmuebleImagenSet) {
		this.inmuebleImagenSet = inmuebleImagenSet;
	}

	

	

	
	
	

}
