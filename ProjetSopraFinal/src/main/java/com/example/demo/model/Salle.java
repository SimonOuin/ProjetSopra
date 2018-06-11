package com.example.demo.model;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("S")
public class Salle extends Materiel {

	private Integer nbDePersonnes;
	private Set<Module> modules;

	public Salle() {
	}

	public Integer getNbDePersonnes() {
		return nbDePersonnes;
	}

	public void setNbDePersonnes(Integer nbDePersonnes) {
		this.nbDePersonnes = nbDePersonnes;
	}

	@OneToMany (mappedBy = "salle")
	public Set<Module> getModules() {
		return modules;
	}

	public void setModules(Set<Module> modules) {
		this.modules = modules;
	}
	
	
	
}
