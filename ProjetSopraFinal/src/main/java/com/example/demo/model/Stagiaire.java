package com.example.demo.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.example.demo.jsonview.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;


@Entity
@DiscriminatorValue("S")
public class Stagiaire extends RessourceHumaine {
	
	private Ordinateur ordinateur;
	private Formation formation;

	public Stagiaire() {
		super();
	}

	@JsonView(JsonViews.Common.class)
	@OneToOne
	public Ordinateur getOrdinateur() {
		return ordinateur;
	}

	public void setOrdinateur(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
	}

	@JsonView(JsonViews.Common.class)
	@ManyToOne
	@JoinColumn (name = "formation")
	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	
	

}
