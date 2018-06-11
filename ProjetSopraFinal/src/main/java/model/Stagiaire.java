package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
@DiscriminatorValue("S")
public class Stagiaire extends RessourceHumaine {
	
	private Ordinateur ordinateur;
	private Formation formation;

	public Stagiaire() {
		super();
	}

	@OneToOne
	public Ordinateur getOrdinateur() {
		return ordinateur;
	}

	public void setOrdinateur(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
	}

	@ManyToOne
	@JoinColumn (name = "formation")
	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	
	

}
