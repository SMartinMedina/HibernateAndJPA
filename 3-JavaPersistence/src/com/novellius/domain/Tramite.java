package com.novellius.domain;

import java.sql.Timestamp;

public class Tramite {
	
	private int idTram;
	private String tipoTram;
	private Timestamp fhcTram;
	
	public Tramite(){
		
	}
	
	public Tramite(String tipoTram, Timestamp fhcTram) {
		this.tipoTram = tipoTram;
		this.fhcTram = fhcTram;
	}

	public int getIdTram() {
		return idTram;
	}
	public void setIdTram(int idTram) {
		this.idTram = idTram;
	}
	public String getTipoTram() {
		return tipoTram;
	}
	public void setTipoTram(String tipoTram) {
		this.tipoTram = tipoTram;
	}
	public Timestamp getFhcTram() {
		return fhcTram;
	}
	public void setFhcTram(Timestamp fhcTram) {
		this.fhcTram = fhcTram;
	}
	
	
	

}
