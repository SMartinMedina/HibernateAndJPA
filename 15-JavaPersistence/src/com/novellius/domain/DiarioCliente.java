package com.novellius.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DiarioCliente")
public class DiarioCliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDiario;

	private String entradaDiario;
	private Timestamp fhcDiario;

	@ManyToOne
	@JoinColumn(name = "Tramite_idTram")
	private Tramite tramite;

	public DiarioCliente() {
	}

	public DiarioCliente(String entradaDiario, Timestamp fhcDiario) {
		this.entradaDiario = entradaDiario;
		this.fhcDiario = fhcDiario;
	}

	public int getIdDiario() {
		return idDiario;
	}

	public void setIdDiario(int idDiario) {
		this.idDiario = idDiario;
	}

	public String getEntradaDiario() {
		return entradaDiario;
	}

	public void setEntradaDiario(String entradaDiario) {
		this.entradaDiario = entradaDiario;
	}

	public Timestamp getFhcDiario() {
		return fhcDiario;
	}

	public void setFhcDiario(Timestamp fhcDiario) {
		this.fhcDiario = fhcDiario;
	}

	public Tramite getTramite() {
		return tramite;
	}

	public void setTramite(Tramite tramite) {
		this.tramite = tramite;
	}

}
