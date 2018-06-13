package com.example.demo.model;

import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.example.demo.jsonview.JsonViews;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonView;


@JsonTypeInfo(
	      use = JsonTypeInfo.Id.NAME, 
	      include = As.PROPERTY, 
	      property = "type")
	    @JsonSubTypes({
	        @JsonSubTypes.Type(value = Gestionnaire.class, name = "gestionnaire"),
	        @JsonSubTypes.Type(value = Technicien.class, name = "technicien"),
	        @JsonSubTypes.Type(value = Formateur.class, name = "formateur"),
	        @JsonSubTypes.Type(value = Stagiaire.class, name = "stagiaire")
	    })
@Entity
@Table(name = "ressources_humaines")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING, length = 1)
public abstract class RessourceHumaine {

	private Long id;
	private String nom;
	private String prenom;
	private Integer tel;
	private String email;
	private String login;
	private String mdp;

	private Adresse adresse;

	private Set<RessourceHumaineRole> roles;

	private int version;

	public RessourceHumaine() {

	}

	public RessourceHumaine(RessourceHumaine rh) {
		this.id = rh.id;
		this.login=rh.login;
		this.mdp=rh.mdp;
	}

	@JsonView(JsonViews.Common.class)
	@Id
	@SequenceGenerator(name = "rhSeq", sequenceName = "rh_seq", allocationSize = 1, initialValue = 10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rhSeq")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonView(JsonViews.Common.class)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@JsonView(JsonViews.Common.class)
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@JsonView(JsonViews.Common.class)
	public Integer getTel() {
		return tel;
	}

	public void setTel(Integer tel) {
		this.tel = tel;
	}

	@JsonView(JsonViews.Common.class)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@JsonView(JsonViews.Common.class)
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@JsonView(JsonViews.Common.class)
	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	@JsonView(JsonViews.Common.class)
	@Embedded
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@JsonView(JsonViews.Common.class)
	@OneToMany(mappedBy = "ressourceHumaine", fetch = FetchType.EAGER)
	public Set<RessourceHumaineRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<RessourceHumaineRole> roles) {
		this.roles = roles;
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
		RessourceHumaine other = (RessourceHumaine) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
