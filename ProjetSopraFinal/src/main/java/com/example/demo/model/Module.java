package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.example.demo.jsonview.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Module {
	
	private Long id;
	private Salle salle;
	private Formateur formateur;
	private Matiere matiere;
	private VideoProjecteur videoProjecteur;
	private Date dateDebut;
	private Formation formation;
	
	private int version;
	
	public Module() {

	}

	@JsonView(JsonViews.Common.class)
	@Id
	@SequenceGenerator(name = "moduleSeq", sequenceName = "module_seq", allocationSize = 1, initialValue = 10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "moduleSeq")
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}


	@JsonView(JsonViews.Common.class)
	@OneToOne
	public Salle getSalle() {
		return salle;
	}


	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	@JsonView(JsonViews.Common.class)
	@ManyToOne
	@JoinColumn (name = "formateur")
	public Formateur getFormateur() {
		return formateur;
	}


	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	@JsonView(JsonViews.Common.class)
	@ManyToOne
	@JoinColumn (name = "matiere")
	public Matiere getMatiere() {
		return matiere;
	}


	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	@JsonView(JsonViews.Common.class)
	@OneToOne
	public VideoProjecteur getVideoProjecteur() {
		return videoProjecteur;
	}


	public void setVideoProjecteur(VideoProjecteur videoProjecteur) {
		this.videoProjecteur = videoProjecteur;
	}

	@JsonView(JsonViews.Common.class)
	@Temporal (TemporalType.DATE)
	public Date getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
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
		Module other = (Module) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
