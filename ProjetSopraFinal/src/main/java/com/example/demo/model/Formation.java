package com.example.demo.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
public class Formation {
	private Long id;
	private Set<Stagiaire> stagiaires;
	private Set<Module> modules;
	private Date dateDebut;
	private Date dateFin;
	
	private Gestionnaire gestionnaire;
	
	private int version;
	
	public Formation() {

	}
	
	
	@Id
	@SequenceGenerator(name = "formationSeq", sequenceName = "formation_seq", allocationSize = 1, initialValue = 10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "formationSeq")
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}


	@OneToMany (mappedBy = "formation")
	public Set<Stagiaire> getStagiaires() {
		return stagiaires;
	}


	public void setStagiaires(Set<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}

	@OneToMany (mappedBy = "formation")
	public Set<Module> getModules() {
		return modules;
	}


	public void setModules(Set<Module> modules) {
		this.modules = modules;
	}

	@Temporal (TemporalType.DATE)
	public Date getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	@Temporal (TemporalType.DATE)
	public Date getDateFin() {
		return dateFin;
	}


	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	@ManyToOne
	@JoinColumn (name = "gestionnaire")
	public Gestionnaire getGestionnaire() {
		return gestionnaire;
	}


	public void setGestionnaire(Gestionnaire gestionnaire) {
		this.gestionnaire = gestionnaire;
	}

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
		Formation other = (Formation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
