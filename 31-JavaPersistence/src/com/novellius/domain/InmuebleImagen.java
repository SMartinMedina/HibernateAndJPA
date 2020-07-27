package com.novellius.domain;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "InmuebleImagenMap")
@AssociationOverrides({
	@AssociationOverride(name = "pk.imagen", joinColumns = @JoinColumn(name = "idImg")),
	@AssociationOverride(name = "pk.inmueble", joinColumns = @JoinColumn(name = "idInm"))
})
public class InmuebleImagen {

	private InmuebleImagenId pk = new InmuebleImagenId();
	// Campos extras :)
	private String status;

	@EmbeddedId
	public InmuebleImagenId getPk() {
		return pk;
	}

	public void setPk(InmuebleImagenId pk) {
		this.pk = pk;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Transient
	public Inmueble getInmueble() {
		return getPk().getInmueble();
	}

	public void setInmueble(Inmueble inmueble) {
		getPk().setInmueble(inmueble);
	}

	@Transient
	public Imagen getImagen() {
		return getPk().getImagen();
	}

	public void setImagen(Imagen imagen) {
		getPk().setImagen(imagen);
	}

}
