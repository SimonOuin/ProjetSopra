package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.demo.jsonview.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;

@Embeddable
public class CompetencePk implements Serializable {
	
	@ManyToOne
	@JoinColumn(name = "formateur_id")
	private Formateur formateur;
	
	@ManyToOne
	@JoinColumn(name = "matiere_id")
	private Matiere matiere;

	public CompetencePk() {

	}

	@JsonView(JsonViews.Common.class)
	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	@JsonView(JsonViews.Common.class)
	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((formateur == null) ? 0 : formateur.hashCode());
		result = prime * result + ((matiere == null) ? 0 : matiere.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompetencePk other = (CompetencePk) obj;
		if (formateur == null) {
			if (other.formateur != null)
				return false;
		} else if (!formateur.equals(other.formateur))
			return false;
		if (matiere == null) {
			if (other.matiere != null)
				return false;
		} else if (!matiere.equals(other.matiere))
			return false;
		return true;
	}
	
	

}
