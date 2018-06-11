package com.example.demo.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

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


	public String getProcesseur() {
		return processeur;
	}


	public void setProcesseur(String processeur) {
		this.processeur = processeur;
	}


	public Integer getRam() {
		return ram;
	}


	public void setRam(Integer ram) {
		this.ram = ram;
	}


	public Integer getDisqueDur() {
		return disqueDur;
	}


	public void setDisqueDur(Integer disqueDur) {
		this.disqueDur = disqueDur;
	}


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
