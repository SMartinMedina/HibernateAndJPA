package com.novellius.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class InmuebleImagenId implements Serializable {

	private static final long serialVersionUID = -1193697384656663409L;

	private Imagen imagen;
	private Inmueble inmueble;

	@ManyToOne
	public Imagen getImagen() {
		return imagen;
	}

	public void setImagen(Imagen imagen) {
		this.imagen = imagen;
	}

	@ManyToOne
	public Inmueble getInmueble() {
		return inmueble;
	}

	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}
}
