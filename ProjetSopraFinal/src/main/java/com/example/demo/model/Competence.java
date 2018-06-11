package com.example.demo.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Version;

import com.example.demo.jsonview.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Competence {
	
	private Niveau niveau;
	private int version;

	@EmbeddedId
	private CompetencePk key;

	public Competence() {

	}

	@JsonView(JsonViews.Common.class)
	@Enumerated (EnumType.STRING)
	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	@JsonView(JsonViews.Common.class)
	public CompetencePk getKey() {
		return key;
	}

	public void setKey(CompetencePk key) {
		this.key = key;
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
		result = prime * result + ((key == null) ? 0 : key.hashCode());
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
		Competence other = (Competence) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
	
	
}
