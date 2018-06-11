package com.example.demo.model;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.example.demo.jsonview.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("F")
public class Formateur extends RessourceHumaine{
	
	private Set<Module> modules;
	private Set<Competence> competences;

	public Formateur() {

	}

	@JsonView(JsonViews.Common.class)
	@OneToMany (mappedBy = "formateur")
	public Set<Module> getModules() {
		return modules;
	}

	public void setModules(Set<Module> modules) {
		this.modules = modules;
	}

	@JsonView(JsonViews.Common.class)
	@OneToMany(mappedBy = "key.formateur")
	public Set<Competence> getCompetences() {
		return competences;
	}

	public void setCompetences(Set<Competence> competences) {
		this.competences = competences;
	}
	
	
	
}
