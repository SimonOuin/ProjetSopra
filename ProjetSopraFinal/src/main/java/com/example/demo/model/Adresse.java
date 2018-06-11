package com.example.demo.model;

import javax.persistence.Embeddable;

import com.example.demo.jsonview.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;

@Embeddable
public class Adresse {
	
	private Integer numero;
	private String rue;
	private Integer cp;
	private String ville;
	private String pays;
	
	
	public Adresse() {

	}


	@JsonView(JsonViews.Common.class)
	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	@JsonView(JsonViews.Common.class)
	public String getRue() {
		return rue;
	}


	public void setRue(String rue) {
		this.rue = rue;
	}


	@JsonView(JsonViews.Common.class)
	public Integer getCp() {
		return cp;
	}


	public void setCp(Integer cp) {
		this.cp = cp;
	}


	@JsonView(JsonViews.Common.class)
	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	@JsonView(JsonViews.Common.class)
	public String getPays() {
		return pays;
	}


	public void setPays(String pays) {
		this.pays = pays;
	}
	
	

}
