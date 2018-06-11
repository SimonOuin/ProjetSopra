package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.jsonview.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="ressource_humaine_roles")
public class RessourceHumaineRole {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Enumerated(EnumType.STRING)
	private Role role;
	@ManyToOne
	@JoinColumn(name="login")
	private RessourceHumaine ressourceHumaine;
	
	public RessourceHumaineRole() {
		// TODO Auto-generated constructor stub
	}

	@JsonView(JsonViews.Common.class)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JsonView(JsonViews.Common.class)
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@JsonView(JsonViews.Common.class)
	public RessourceHumaine getRessourceHumaine() {
		return ressourceHumaine;
	}

	public void setRessourceHumaine(RessourceHumaine ressourceHumaine) {
		this.ressourceHumaine = ressourceHumaine;
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
		RessourceHumaineRole other = (RessourceHumaineRole) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
