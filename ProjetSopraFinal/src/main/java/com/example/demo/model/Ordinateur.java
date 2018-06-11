package com.example.demo.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.example.demo.jsonview.JsonViews;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("O")
public class Ordinateur extends Materiel {
	
	private String processeur;
	private Integer ram;
	private Integer disqueDur;
	private Integer annee;
	
	private Stagiaire stagiaire;
	
	
	public Ordinateur() {

	}

	@JsonView(JsonViews.Common.class)
	public String getProcesseur() {
		return processeur;
	}


	public void setProcesseur(String processeur) {
		this.processeur = processeur;
	}

	@JsonView(JsonViews.Common.class)
	public Integer getRam() {
		return ram;
	}


	public void setRam(Integer ram) {
		this.ram = ram;
	}

	@JsonView(JsonViews.Common.class)
	public Integer getDisqueDur() {
		return disqueDur;
	}


	public void setDisqueDur(Integer disqueDur) {
		this.disqueDur = disqueDur;
	}

	@JsonView(JsonViews.Common.class)
	public Integer getAnnee() {
		return annee;
	}


	public void setAnnee(Integer annee) {
		this.annee = annee;
	}

	@OneToOne
	public Stagiaire getStagiaire() {
		return stagiaire;
	}


	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}
	
	

}
