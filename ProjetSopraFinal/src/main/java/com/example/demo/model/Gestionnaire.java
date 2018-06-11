package com.example.demo.model;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.example.demo.jsonview.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("G")
public class Gestionnaire extends RessourceHumaine {

	private Set<Formation> formations;

	public Gestionnaire() {

	}

	@JsonView(JsonViews.Common.class)
	@OneToMany(mappedBy = "gestionnaire")
	public Set<Formation> getFormations() {
		return formations;
	}

	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}
	
	
}
