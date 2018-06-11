package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("VP")
public class VideoProjecteur extends Materiel {

	private Module module;

	public VideoProjecteur() {

	}

	@OneToOne
	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}
	
	
	
}
