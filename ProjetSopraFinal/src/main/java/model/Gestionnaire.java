package model;

import java.util.Set;
import javax.persistence.OneToMany;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("G")
public class Gestionnaire extends RessourceHumaine {

	private Set<Formation> formations;

	public Gestionnaire() {

	}

	@OneToMany(mappedBy = "gestionnaire")
	public Set<Formation> getFormations() {
		return formations;
	}

	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}
	
	
}
