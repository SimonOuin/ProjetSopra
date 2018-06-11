package com.example.demo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

import com.example.demo.jsonview.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Matiere {
	private Long id;
	private String titre;
	private Integer dureeProg;
	private String objectif;
	private String prerequis;
	private String contenu;
	
	private Set<Competence> competences;
	private Set<Module> modules;
	
	private int version;
	
	public Matiere() {
		super();
	}

	@JsonView(JsonViews.Common.class)
	@Id
	@SequenceGenerator(name = "matiereSeq", sequenceName = "matiere_seq", allocationSize = 1, initialValue = 10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "matiereSeq")
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}


	@JsonView(JsonViews.Common.class)
	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	@JsonView(JsonViews.Common.class)
	public Integer getDureeProg() {
		return dureeProg;
	}


	public void setDureeProg(Integer dureeProg) {
		this.dureeProg = dureeProg;
	}


	@JsonView(JsonViews.Common.class)
	public String getObjectif() {
		return objectif;
	}


	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}


	@JsonView(JsonViews.Common.class)
	public String getPrerequis() {
		return prerequis;
	}


	public void setPrerequis(String prerequis) {
		this.prerequis = prerequis;
	}


	@JsonView(JsonViews.Common.class)
	public String getContenu() {
		return contenu;
	}


	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	@JsonView(JsonViews.Common.class)
	@OneToMany (mappedBy = "key.matiere")
	public Set<Competence> getCompetences() {
		return competences;
	}


	public void setCompetences(Set<Competence> competences) {
		this.competences = competences;
	}
	
	@JsonView(JsonViews.Common.class)
	@OneToMany (mappedBy = "matiere")
	public Set<Module> getModules() {
		return modules;
	}

	public void setModules(Set<Module> modules) {
		this.modules = modules;
	}

	@JsonView(JsonViews.Common.class)
	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Matiere other = (Matiere) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
